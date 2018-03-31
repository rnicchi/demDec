package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.bo.SospesiRedBO;
import it.mef.bilancio.demdec.dao.SospesoRedDao;
import it.mef.bilancio.demdec.manager.RicercaRedManager;
import it.mef.bilancio.demdec.manager.RicercaRedSospesiManager;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SospesiRedTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;



public class RicercaRedSospesiManagerImpl extends AbstractDemManagerImpl implements RicercaRedSospesiManager{
	
	@Autowired
	private SospesoRedDao sospesoRedDao;
	@Autowired
	private RicercaRedManager ricercaRedManager;
	@Autowired
	private CronologicoManager cronologicoManager;

	@Override
	public ResponseDEMBILClient wsRicercaRed(ParametriInput paramInput,
			RicercaRedTO ricercaRedTO) throws Throwable {

		return ricercaRedManager.wsRicercaRed(ricercaRedTO);
	}

	@Override
	public ResponseDEMBILClient wsDocumentiFascicolo(ParametriInput paramInput,
			RaccoltaProvvisoriaRedTO to) throws Throwable {

		return ricercaRedManager.wsDocumentiFascicolo(to);
	}

	@Override
	public void saveSospesiRed(Collection<SospesiRedTO> listaSospesiRed) throws Throwable {

		List<SospesiRedBO> listaSospesiRedBO = new ArrayList<SospesiRedBO>();
		for (SospesiRedTO to: listaSospesiRed) {
			SospesiRedBO bo = new SospesiRedBO();
			bo.setId(to.getId());
			bo.setCodiIdRed(to.getCodiIdRed());
			bo.setCodiOperazione(to.getCodiOperazione());
			bo.setStatEsito(to.getStatEsito());
			//protocollo
			bo.setCodiAooProtocollo(to.getProtocollo().getAoo());
			bo.setNumeProtocollo(to.getProtocollo().getNumeroProtocollo());
			bo.setDescTipoProtocollo(to.getProtocollo().getTipo());
			bo.setDataProtocollo(to.getProtocollo().getData());

			copyAudit(to, bo);
			listaSospesiRedBO.add(bo);
			salvaNelCronologico(CroTransTO.CRO_TRANS_INSERIMENTO_SOSPESI_RED, null, bo);
		}
		sospesoRedDao.saveSospesiRed(listaSospesiRedBO);
	}
	
	@Override
	 public Collection<SospesiRedTO> getListaSospesiRed() throws Throwable {
		Collection<SospesiRedTO> listaTO = new ArrayList<SospesiRedTO>();
		for (SospesiRedBO bo: sospesoRedDao.getListaSospesiRed()) {
			SospesiRedTO to = new SospesiRedTO(bo);
			listaTO.add(to);
		}
		return listaTO;
	 }


	@Override
	public void deleteSospesiRed(Collection<String> listaIdSospesiRed) throws Throwable {
		for (String idSospesoRed: listaIdSospesiRed) {
			SospesiRedBO sospesoRedBO = sospesoRedDao.loadById(SospesiRedBO.class, idSospesoRed);
			sospesoRedDao.delete(sospesoRedBO);
			salvaNelCronologico(CroTransTO.CRO_TRANS_CANCELLAZIONE_SOSPESI_RED, sospesoRedBO, null);
		}
	}


	private void salvaNelCronologico(Short croTrans, AbstractCommonBO oldBo, AbstractCommonBO newBo) throws Throwable {

		cronologicoManager.salvaCronologico(
				oldBo, 
				newBo,
				null,
				null,
				croTrans,
				(oldBo != null)? 
						oldBo.getRowUpdatedForm() != null ? oldBo.getRowUpdatedForm() : oldBo.getRowCreatedForm()
						:
						newBo.getRowUpdatedForm() != null ? newBo.getRowUpdatedForm() : newBo.getRowCreatedForm(),
				(oldBo != null)? 
						oldBo.getRowUpdatedUser() != null ? oldBo.getRowUpdatedUser() : oldBo.getRowCreatedUser()
						:
						newBo.getRowUpdatedUser() != null ? newBo.getRowUpdatedUser() : newBo.getRowCreatedUser()
		);

	}
	
	 @Override
	 public ResponseDEMBILClient wsDownloadDocumento(ParametriInput paramInput,  String idFascicolo, String idDocumento) throws Throwable {
		
		 	RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
		 	
			requestDEMBILClient.setIdFascicolo(idFascicolo);
			requestDEMBILClient.setIdDocumento(idDocumento);

			InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
			ResponseDEMBILClient resp= client.downloadDocumentoRaccoltaProvvisoria(requestDEMBILClient);
		
			return resp;
		
	}
}
