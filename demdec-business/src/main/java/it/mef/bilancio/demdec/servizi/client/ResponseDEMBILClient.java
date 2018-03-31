package it.mef.bilancio.demdec.servizi.client;

import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

import java.util.List;

public class ResponseDEMBILClient implements DEMBILConstants{
	public ResponseDEMBILClient(String esito1,String descrizioneEsito1){
		
		esitoTo = new EsitoTO(esito1, descrizioneEsito1);
			
	}
	private AbstractDemTO outputTO;
	private List<AbstractDemTO> listoutputTO;
	private EsitoTO esitoTo;
	
	
	public AbstractDemTO getOutputTO() {
		return outputTO;
	}
	public void setOutputTO(AbstractDemTO outputTO) {
		this.outputTO = outputTO;
	}
	public List<AbstractDemTO> getListoutputTO() {
		return listoutputTO;
	}
	public void setListoutputTO(List<AbstractDemTO> listoutputTO) {
		this.listoutputTO = listoutputTO;
	}

	public EsitoTO getEsitoTo() {
		return esitoTo;
	}
	public void setEsitoTo(EsitoTO esitoTo) {
		this.esitoTo = esitoTo;
	}


}
