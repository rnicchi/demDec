package it.mef.bilancio.demdec.servizi.client;

import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;

public class ResponseOpeDocuClient implements DEMBILConstants{
	public ResponseOpeDocuClient(String esito1,String descrizioneEsito1){
		
		esitoTo = new EsitoTO(esito1, descrizioneEsito1);
			
	}
	private AbstractDemTO outputTO;
	private EsitoTO esitoTo;
	
	
	public AbstractDemTO getOutputTO() {
		return outputTO;
	}
	public void setOutputTO(AbstractDemTO outputTO) {
		this.outputTO = outputTO;
	}
	public EsitoTO getEsitoTo() {
		return esitoTo;
	}
	public void setEsitoTo(EsitoTO esitoTo) {
		this.esitoTo = esitoTo;
	}


}
