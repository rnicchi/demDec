package it.mef.bilancio.demdec.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.getInputStreamFromClasspath;
import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.web.spring.controller.AbstractDemFormController;
import it.almavivaitalia.bsn.sh.paginator.StaticPaginatorImpl;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.TableModel;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PageMessages;
import it.almavivaitalia.web.sh.utils.PropertyKey;
import it.almavivaitalia.web.sh.utils.Util;
import it.mef.bilancio.demdec.manager.IntCronologicoManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.web.spring.form.IntCronologicoForm;
import it.mef.bilancio.demdec.to.CodeDescriptionTitleTO;
import it.mef.bilancio.demdec.to.CronologicoSearchTO;
import it.mef.bilancio.demdec.to.CronologicoTO;
import it.mef.bilancio.demdec.to.CronologicoTransExcelTO;
import it.mef.bilancio.demdec.to.CronologicoTransTO;
import it.mef.bilancio.demdec.to.CronologicoValoriTO;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping (value=ConstantsRequestMapping.INT_CRONOLOGICO)
public class IntCronologicoController extends  AbstractDemFormController implements WebConstants,SessionAttributes{
	// View //
	private String startView;
	// Manager //
	@Autowired
	private ListManager listManager; 
	@Autowired
	private IntCronologicoManager cronologicoManager;	
	// Start Controller //
	@Override
	public String startController(Context context) throws Throwable 
	{	
		context.setCurrentNode("DemDec.menu.IntCronologico");
		context.setDataModel(LIST_UTENTI, listManager.loadAllUtenti());
		context.setDataModel(LIST_FUNZIONI, listManager.loadFunzioni());
		
		PageMessages pageMessages = new PageMessages(getMessageSource());
		
		ContextHelper.setSessionModel(OBJECT_PAGE_MESSAGES, pageMessages, context.getRequest());
		
		return startView;
	}
	// BOTTONI DI RICERCA //
	public String onNuovaRicerca (Context context) throws Throwable {
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		form.reset();
		context.removeDataModel(SessionAttributes.SHOW_CAP_PG);
		context.removeDataModel(SessionAttributes.SHOW_AUTOR);
		context.removeDataModel(SessionAttributes.SHOW_STRUMENTO);
		context.removeDataModel(SessionAttributes.SHOW_SOTTO_STRUMENTO);
		context.removeDataModel(SessionAttributes.SHOW_PL);
		context.removeDataModel(SessionAttributes.SHOW_PARTITA);
		context.removeDataModel(SessionAttributes.SHOW_BUTTON_FILTRI);
		context.removeDataModel(SessionAttributes.SHOW_LABEL_FILTRI);
		context.removeDataModel(SessionAttributes.OBJECT_CRONOLOGICO);
		context.removeDataModel(SessionAttributes.CRONOLOGICO_VIEW_LIST);
		context.removeDataModel(SessionAttributes.OBJECT_PAGINATOR);			
		context.removeDataModel(SessionAttributes.LIST_TRANSAZIONI);
		context.removeDataModel(SessionAttributes.LIST_VALORI);
		context.removeDataModel(SessionAttributes.INT_SEL_ROW);
		return startView;
	}	
	public String onEseguiRicercaCrono (Context context) throws Throwable {
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		if (form.isValid()){
		  context.removeDataModel(SessionAttributes.CRONOLOGICO_VIEW_LIST);
		  context.removeDataModel(SessionAttributes.OBJECT_PAGINATOR);
		  context.removeDataModel(SessionAttributes.LIST_TRANSAZIONI);				
		  CronologicoTO to = context.getModel(SessionAttributes.OBJECT_CRONOLOGICO);
		  java.util.Date dataA = null;
		  String oraDa = null;
		  String oraA = null;
		  if (to == null){
  			  to = new CronologicoTO();
		  }
		  SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");		
		  if (!form.getDataDa().isEmpty()){
			  java.util.Date dataDa =  fromUser.parse(form.getDataDa());
			  to.setDataOperaz(dataDa);			
		  }
		  if (form.getOraDa() != ""){
		      oraDa = form.getOraDa();
		  }
		  if (!(form.getDataA().equals(""))){
			  dataA = fromUser.parse(form.getDataA());
		  }
		  if (!(form.getOraA().equals(""))){
			  oraA = form.getOraA();
		  }
		  to.setDescUtente(form.getUtente());	
		  to.setTraCodiCodice(ParseUtil.getInteger(form.getTraCodiCodice()));
		  List<CronologicoTransTO> toOut = cronologicoManager.caricaRisultati(to,dataA,oraDa,oraA);
  		  // Paginator //
		  if (toOut.size() > 0){
 		    context.setDataModel(SessionAttributes.INT_SEL_ROW, -1);
		    context.setDataModel(SessionAttributes.LIST_TRANSAZIONI, toOut);	
		    StaticPaginatorImpl paginator =  new StaticPaginatorImpl(toOut, CRONOLOGICO_VIEW_LIST,10);	
  		    paginator.setList(toOut);		
		    context.setDataModel(CRONOLOGICO_VIEW_LIST, paginator.update());		
		    context.setDataModel(OBJECT_PAGINATOR, paginator);
		   } else {
			  /*PageMessages pageMessages = new PageMessages(getMessageSource());
			  ContextHelper.setRequestModel(OBJECT_PAGE_MESSAGES, pageMessages,context.getRequest());*/
			  ContextHelper.addInfo(context.getRequest(),"info.noDataFound");			
		   }
		   // Fine Paginator //
		}
		context.setDataModel(SessionAttributes.OBJECT_FORM_CRONO,form);
		return startView;
	}
	// Paginator //
	public String onPaginator(Context context) throws Throwable { 
		context.removeDataModel(SessionAttributes.LIST_VALORI);
		context.removeDataModel(SessionAttributes.INT_SEL_ROW);		
		return super.onPaginator(context);
	}	
	public String onEnableDisablePagin(Context context) throws Throwable {
		context.removeDataModel(SessionAttributes.LIST_VALORI);
		context.removeDataModel(SessionAttributes.INT_SEL_ROW);
		return super.onEnableDisablePagin(context);
	}	
	// Fine Paginator //
	// Apertura Riga Transazione e visualizzazione Valori //
	public String onApriDettaglioCrono(Context context) throws Throwable {
		// Mi riprendo il form //
		IntCronologicoForm form = (IntCronologicoForm) context.getForm();
		IntCronologicoForm formCached = context.getModel(SessionAttributes.OBJECT_FORM_CRONO);		
		BeanUtils.copyProperties(formCached, form);
		// Mi prendo il record delle transazioni //
		List<CronologicoTransTO> lista= context.getModel(SessionAttributes.LIST_TRANSAZIONI);		
		String selectedRow = getParameter(context, WebConstants.DETTAGLIO_CRONOLOGICO); 		
		CronologicoTransTO to=lista.get(ParseUtil.getInteger(selectedRow));
		List<CronologicoValoriTO> list = cronologicoManager.loadValori(
				  ParseUtil.getBigDecimal(to.getCodiId()),
				  ParseUtil.getBigDecimal(to.getCodiTrans()));
		if (list.size() > 0){
			context.setDataModel(SessionAttributes.INT_SEL_ROW, selectedRow);
			context.setDataModel(SessionAttributes.LIST_VALORI, list);
		}
		return startView;
	}

	public String getStartView() {
		return startView;
	}
	public void setStartView(String startView) {
		this.startView = startView;
	}
	// EXPORT EXCEL LISTA //
	private List<CronologicoTransExcelTO> preparaExport(Context context) throws Throwable {
		// Mi riprendo il form //
    	IntCronologicoForm form = (IntCronologicoForm) context.getForm();
    	IntCronologicoForm formCached = context.getModel(SessionAttributes.OBJECT_FORM_CRONO);		
    	BeanUtils.copyProperties(formCached, form);    	
    	CronologicoTO to = context.getModel(SessionAttributes.OBJECT_CRONOLOGICO);
    	java.util.Date dataA = null;
    	String oraDa = null;
    	String oraA = null;
    	if (to == null){ to = new CronologicoTO(); }
    	SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");		
    	if (!form.getDataDa().isEmpty()){
    	  java.util.Date dataDa =  fromUser.parse(form.getDataDa());
    	  to.setDataOperaz(dataDa);			
    	}
    	if (form.getOraDa() != ""){ oraDa = form.getOraDa(); }
    	if (!(form.getDataA().equals(""))){ dataA = fromUser.parse(form.getDataA()); }
    	if (!(form.getOraA().equals(""))){  oraA = form.getOraA(); }
    	to.setDescUtente(form.getUtente());
    	to.setTraCodiCodice(ParseUtil.getInteger(form.getTraCodiCodice()));
    	return cronologicoManager.caricaRisultatiExcel(to,dataA,oraDa,oraA);
	}
    public String onExportExcel(Context context) throws Throwable {
    	List<CronologicoTransExcelTO> toOut = preparaExport(context); 
    	List<TableModel> tms = new ArrayList<TableModel>();
	    LinkedHashMap<PropertyKey, FieldFormatter> map = new LinkedHashMap<PropertyKey, FieldFormatter>();
	    map = getFieldFormatterMap("ExcelCronoFormatter");
	    TableModel tm = new TableModel((List<?>) toOut,map, "label.blank", "label.blank");
	    tms.add(tm);
	    return context.startExport(tms, SessionAttributes.EXPORT_GENERIC_EXCEL,"ExportCronologico_");
	}
    public String onExportPdf(Context context) throws Throwable {
    	List<CronologicoTransExcelTO> toOut = preparaExport(context); 
    	List<TableModel> tms = new ArrayList<TableModel>();
	    LinkedHashMap<PropertyKey, FieldFormatter> map = new LinkedHashMap<PropertyKey, FieldFormatter>();
	    map = getFieldFormatterMap("ExcelCronoFormatter");
	    TableModel tm = new TableModel((List<?>) toOut,map, "label.blank", "label.blank");
	    tms.add(tm);
	    return context.startExport(tms, SessionAttributes.EXPORT_GENERIC_PDF,"ExportCronologico_");
	}
	protected LinkedHashMap<PropertyKey, FieldFormatter> getFieldFormatterMap(
		String xmlName) throws Throwable {
		return Util.unMarshallFieldFormatterMap(getInputStreamFromClasspath(WebConstants.FIELD_FORMATTER_PATH+ xmlName + ".xml"));
	} 
} // FINE CLASSE
