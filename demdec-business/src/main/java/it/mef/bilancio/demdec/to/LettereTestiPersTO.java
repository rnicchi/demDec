package it.mef.bilancio.demdec.to;


public class LettereTestiPersTO extends AbstractDemTO implements java.io.Serializable {

	private static final long serialVersionUID = 7431443310853482400L;

	private LettereTestiPersTOId id;
	private FascicoliTO fascicoli;
	 private String textContenuto;  

	public LettereTestiPersTOId getId() {
		return id;
	}

	public void setId(LettereTestiPersTOId id) {
		this.id = id;
	}

	public String getTextContenuto() {
		return textContenuto;
	}

	public void setTextContenuto(String textContenuto) {
		this.textContenuto = textContenuto;
	}

	public FascicoliTO getFascicoli() {
		return fascicoli;
	}

	public void setFascicoli(FascicoliTO fascicoli) {
		this.fascicoli = fascicoli;
	}
	
	
	
}
