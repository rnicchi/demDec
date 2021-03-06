package it.almavivaitalia.bilancio.commons.to;


import java.util.ArrayList;
import java.util.List;






/**
 * Utente generated by hbm2java
 */
public class UtenteTO extends AbstractCommonTO implements java.io.Serializable {

	private Integer id;
	private String codiUtente;
	private String persCognome;
	private String persNome;
	private String indiEmail;
	private String codiUtenteNsbf;
	private String codiCodiceFiscale;
	private String codiCodiceFisFirma;
	private String codiPinFirma;
	private boolean multiProfilo;
	private List<UtenteProfiloTO> utenteProfiloList = new ArrayList<UtenteProfiloTO>(0);
 	

	public UtenteTO() {
	}

	public UtenteTO(String codiUtente) {
		this.codiUtente = codiUtente;
	}

	public UtenteTO(String codiUtente, String persCognome, String persNome,
			String indiEmail, List<UtenteProfiloTO> utenteProfiloList) {
		this.codiUtente = codiUtente;
		this.persCognome = persCognome;
		this.persNome = persNome;
		this.indiEmail = indiEmail;
		this.utenteProfiloList = utenteProfiloList;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiUtente() {
		return this.codiUtente;
	}

	public void setCodiUtente(String codiUtente) {
		this.codiUtente = codiUtente;
	}

	public String getPersCognome() {
		return this.persCognome;
	}

	public void setPersCognome(String persCognome) {
		this.persCognome = persCognome;
	}

	public String getPersNome() {
		return this.persNome;
	}

	public void setPersNome(String persNome) {
		this.persNome = persNome;
	}

	public String getIndiEmail() {
		return this.indiEmail;
	}

	public void setIndiEmail(String indiEmail) {
		this.indiEmail = indiEmail;
	}

	public String getCodiUtenteNsbf() {
		return codiUtenteNsbf;
	}

	public void setCodiUtenteNsbf(String codiUtenteNsbf) {
		this.codiUtenteNsbf = codiUtenteNsbf;
	}

	public String getCodiCodiceFiscale() {
		return codiCodiceFiscale;
	}

	public void setCodiCodiceFiscale(String codiCodiceFiscale) {
		this.codiCodiceFiscale = codiCodiceFiscale;
	}

	public String getCodiCodiceFisFirma() {
		return codiCodiceFisFirma;
	}

	public void setCodiCodiceFisFirma(String codiCodiceFisFirma) {
		this.codiCodiceFisFirma = codiCodiceFisFirma;
	}

	public String getCodiPinFirma() {
		return codiPinFirma;
	}

	public void setCodiPinFirma(String codiPinFirma) {
		this.codiPinFirma = codiPinFirma;
	}

	public List<UtenteProfiloTO> getUtenteProfiloList() {
		return this.utenteProfiloList;
	}

	public void setUtenteProfiloList(List<UtenteProfiloTO> utenteProfiloList) {
		this.utenteProfiloList = utenteProfiloList;
	}

	public boolean isMultiProfilo() {
		this.multiProfilo = !isEmpty(utenteProfiloList)?utenteProfiloList.size()>1:false;
		return multiProfilo;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@")
				.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("codiUtente").append("='").append(getCodiUtente())
				.append("' ");
		buffer.append("persCognome").append("='").append(getPersCognome())
				.append("' ");
		buffer.append("persNome").append("='").append(getPersNome())
				.append("' ");
		buffer.append("indiEmail").append("='").append(getIndiEmail())
				.append("' ");
		buffer.append("codiUtenteNsbf").append("='")
				.append(getCodiUtenteNsbf())
				.append("' ");
		buffer.append("codiCodiceFiscale").append("='")
				.append(getCodiCodiceFiscale())
				.append("' ");
		buffer.append("codiCodiceFisFirma").append("='")
				.append(getCodiCodiceFisFirma())
				.append("' ");
		buffer.append("codiPinFirma").append("='")
				.append(getCodiPinFirma())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UtenteTO))
			return false;
		UtenteTO castOther = (UtenteTO) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCodiUtente() == castOther.getCodiUtente()) || (this
						.getCodiUtente() != null
						&& castOther.getCodiUtente() != null && this
						.getCodiUtente().equals(castOther.getCodiUtente())))
				&& ((this.getPersCognome() == castOther.getPersCognome()) || (this
						.getPersCognome() != null
						&& castOther.getPersCognome() != null && this
						.getPersCognome().equals(castOther.getPersCognome())))
				&& ((this.getPersNome() == castOther.getPersNome()) || (this
						.getPersNome() != null
						&& castOther.getPersNome() != null && this
						.getPersNome().equals(castOther.getPersNome())))
				&& ((this.getIndiEmail() == castOther.getIndiEmail()) || (this
						.getIndiEmail() != null
						&& castOther.getIndiEmail() != null && this
						.getIndiEmail().equals(castOther.getIndiEmail())))
				&& ((this.getCodiUtenteNsbf() == castOther.getCodiUtenteNsbf()) || (this
						.getCodiUtenteNsbf() != null
						&& castOther.getCodiUtenteNsbf() != null && this
						.getCodiUtenteNsbf().equals(castOther.getCodiUtenteNsbf())))
				&& ((this.getCodiCodiceFiscale() == castOther.getCodiCodiceFiscale()) || (this
						.getCodiCodiceFiscale() != null
						&& castOther.getCodiCodiceFiscale() != null && this
						.getCodiCodiceFiscale().equals(castOther.getCodiCodiceFiscale())))
				&& ((this.getCodiCodiceFisFirma() == castOther.getCodiCodiceFisFirma()) || (this
						.getCodiCodiceFisFirma() != null
						&& castOther.getCodiCodiceFisFirma() != null && this
						.getCodiCodiceFisFirma().equals(castOther.getCodiCodiceFisFirma())))
				&& ((this.getCodiPinFirma() == castOther.getCodiPinFirma()) || (this
						.getCodiPinFirma() != null
						&& castOther.getCodiPinFirma() != null && this
						.getCodiPinFirma().equals(castOther.getCodiPinFirma())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCodiUtente() == null ? 0 : this.getCodiUtente()
						.hashCode());
		result = 37
				* result
				+ (getPersCognome() == null ? 0 : this.getPersCognome()
						.hashCode());
		result = 37 * result
				+ (getPersNome() == null ? 0 : this.getPersNome().hashCode());
		result = 37 * result
				+ (getIndiEmail() == null ? 0 : this.getIndiEmail().hashCode());
		result = 37
				* result
				+ (getCodiUtenteNsbf() == null ? 0 : this.getCodiUtenteNsbf()
						.hashCode());
		result = 37
				* result
				+ (getCodiCodiceFiscale() == null ? 0 : this.getCodiCodiceFiscale()
						.hashCode());
		result = 37
				* result
				+ (getCodiCodiceFisFirma() == null ? 0 : this.getCodiCodiceFisFirma()
						.hashCode());
		result = 37
				* result
				+ (getCodiPinFirma() == null ? 0 : this.getCodiPinFirma()
						.hashCode());

		return result;
	}


	public ProfiloTO getProfiloPrincipale(){
		for(UtenteProfiloTO to:utenteProfiloList){
			if (to.getFlagDefault01()==1){
				return to.getProfilo();
			}
		}
		return utenteProfiloList.get(0).getProfilo();
	}
	
	public UtenteProfiloTO getUtenteProfiloPrincipale(){
		for(UtenteProfiloTO to:utenteProfiloList){
			if (to.getFlagDefault01()==1){
				return to;
			}
		}
		return utenteProfiloList.get(0);
	}

	public ProfiloTO getProfilo(String codiProfilo){
		for(UtenteProfiloTO to:utenteProfiloList){
			if (to.getProfilo().getCodiProfilo().equalsIgnoreCase(codiProfilo)){
				return to.getProfilo();
			}
		}
		return utenteProfiloList.get(0).getProfilo();
	}


	public UtenteProfiloTO getUtenteProfilo(String codiProfilo){
		for(UtenteProfiloTO to:utenteProfiloList){
			if (to.getId().getCodiProfilo().equalsIgnoreCase(codiProfilo)){
				return to;
			}
		}
		return utenteProfiloList.get(0);
	}

	
  // The following is extra code specified in the hbm.xml files
private static final long serialVersionUID = 1L;
  // end of extra code specified in the hbm.xml files

}


