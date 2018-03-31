package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.to.DocumentiViewTO;

import java.util.List;

public interface DocumentiDao extends AbstractDemDao<DocumentiBO> {
	
	public List<DocumentiViewTO> loadADToSignByLoggedUser(Utente utente) throws Throwable;
	public List<DocumentiViewTO> loadADToSignOrVerifyByLoggedUser(Utente utente, String signOrVerify) throws Throwable;
	public Long createNextIdDocumento(Long numFasc);
	public List<DocumentiBO> findDocumentiByTipoFascicolo(String tipo, Long idFasc) throws Throwable;
	public List<DocumentiBO> getDocumentiByIdFadFlgVisCdc(Long idFasc, Long flgVisibilitaCdc) throws Throwable;
//	public List<DescDocumentoBO> getDescDocumentiByTipoDocumento(String tipoDocumento) throws Throwable;
	//public List<DescDocumentoBO> getVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable;
//	public DescDocumentoBO getVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable;

	
	
	public List<DocumentiViewTO> loadSignedOrVerifyedADByLoggedUser(Utente utente, String signOrVerify) throws Throwable;
}
