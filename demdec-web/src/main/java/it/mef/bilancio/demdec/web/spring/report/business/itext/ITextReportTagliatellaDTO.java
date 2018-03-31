package it.mef.bilancio.demdec.web.spring.report.business.itext;

//import it.consip.pat.common.model.ReportBollettino;

import java.util.List;
import java.util.Map;

import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.web.spring.form.PredTagliatellaForm;


/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class ITextReportTagliatellaDTO extends  ITextReportDTO{


	private PredTagliatellaForm form;
	private FascicoliTO fascicolo;
	private List<RiepilogoAdDemTO> listaRiepilogo;
	private String testoLegge;
	//private String pathImages;
	
	public PredTagliatellaForm getForm() {
		return form;
	}
	public void setForm(PredTagliatellaForm form) {
		this.form = form;
	}
	public FascicoliTO getFascicolo() {
		return fascicolo;
	}
	public void setFascicolo(FascicoliTO fascicolo) {
		this.fascicolo = fascicolo;
	}
	public List<RiepilogoAdDemTO> getListaRiepilogo() {
		return listaRiepilogo;
	}
	public void setListaRiepilogo(List<RiepilogoAdDemTO> listaRiepilogo) {
		this.listaRiepilogo = listaRiepilogo;
	}
	public String getTestoLegge() {
		return testoLegge;
	}
	public void setTestoLegge(String testoLegge) {
		this.testoLegge = testoLegge;
	}
	/*public String getPathImages() {
		return pathImages;
	}
	public void setPathImages(String pathImages) {
		this.pathImages = pathImages;
	}
	*/
	
	
	
}
