package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.bo.SospesiRedBO;
import it.mef.bilancio.demdec.servizi.to.ProtocolloTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;

import java.io.Serializable;

public class SospesiRedTO extends AbstractDemTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;		//codiGuidRed
	private String codiIdRed;
	private String codiOperazione;
	private String statEsito;
	private ProtocolloTO protocollo;


	public SospesiRedTO(SospesiRedBO bo) {

		id = bo.getId();
		codiIdRed = bo.getCodiIdRed();
		codiOperazione = bo.getCodiOperazione();
		statEsito = bo.getStatEsito();
		protocollo = new ProtocolloTO(bo.getCodiAooProtocollo(), bo.getDataProtocollo(), bo.getDescTipoProtocollo(), bo.getNumeProtocollo());
	}

	public SospesiRedTO(RaccoltaProvvisoriaRedTO to) {

		id = to.getIdFascicoloRaccoltaProvvisoria();
		codiIdRed = to.getIdentificativoRaccoltaProvvisoria();
		codiOperazione = "C";
		statEsito = null;
		if (to.getProtocollo() != null)
			protocollo = new ProtocolloTO(
								to.getProtocollo().getAoo(),
								to.getProtocollo().getData(),
								to.getProtocollo().getTipo(),
								to.getProtocollo().getNumeroProtocollo()
			);
	}


	//getters & setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodiIdRed() {
		return codiIdRed;
	}
	public void setCodiIdRed(String codiIdRed) {
		this.codiIdRed = codiIdRed;
	}
	public String getCodiOperazione() {
		return codiOperazione;
	}
	public void setCodiOperazione(String codiOperazione) {
		this.codiOperazione = codiOperazione;
	}
	public ProtocolloTO getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(ProtocolloTO protocollo) {
		this.protocollo = protocollo;
	}
	public String getStatEsito() {
		return statEsito;
	}
	public void setStatEsito(String statEsito) {
		this.statEsito = statEsito;
	}
	@Override
	public String toString() {
		return "SospesiRedTO [id=" + id + ", codiIdRed=" + codiIdRed
				+ ", codiOperazione=" + codiOperazione + ", statEsito="
				+ statEsito + ", protocollo=" + protocollo + "]";
	}
}
