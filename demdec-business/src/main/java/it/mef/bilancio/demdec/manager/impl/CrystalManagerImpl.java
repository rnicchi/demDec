package it.mef.bilancio.demdec.manager.impl;


import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import static it.almavivaitalia.commons.crystal.utils.SearchUtilities.search;
import it.almavivaitalia.bsn.sh.manager.exception.ObjectNotFoundException;
import it.almavivaitalia.commons.crystal.utils.CrystalConstants;
import it.almavivaitalia.commons.crystal.utils.CrystalReportQueryBuilder;
import it.almavivaitalia.commons.crystal.utils.Query;
import it.almavivaitalia.commons.crystal.utils.SearchUtilities;
import it.almavivaitalia.commons.crystal.utils.Utilities;
import it.mef.bilancio.demdec.crystal.CrystalReport;
import it.mef.bilancio.demdec.crystal.CrystalReportObjectTO;
import it.mef.bilancio.demdec.manager.CrystalManager;

import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.crystaldecisions.sdk.occa.infostore.CePropertyID;
import com.crystaldecisions.sdk.occa.infostore.IInfoObject;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import com.crystaldecisions.sdk.plugin.desktop.common.IReportParameter;
import com.crystaldecisions.sdk.plugin.desktop.report.IReport;
import com.crystaldecisions.sdk.properties.IProperties;
import com.crystaldecisions.sdk.properties.IProperty;

public class CrystalManagerImpl extends AbstractDemManagerImpl implements CrystalManager {

	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 1L;
	
	
	@Override
	public ReportClientDocument openDocumentById(int idCr, CrystalReport crystalObject) throws Throwable {
		IInfoObject selectedReport=SearchUtilities.getReportById(crystalObject.getiStore(), String.valueOf(idCr));
		ReportClientDocument reportClientDoc = crystalObject.getReportAppFactory().openDocument(selectedReport,0, java.util.Locale.US);	
		return reportClientDoc; 
	}

	@Override
	public ReportClientDocument openDocumentByName(String codiReportCr,	CrystalReport crystalObject) throws Throwable {
		ReportClientDocument reportClientDoc=null;
		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_BY_REPORT_NAME).setParam("reportName", codiReportCr);
		List<IInfoObject> reports=search(crystalObject.getiStore(), cqb.buildQueryString());
		if(reports!=null&&reports.size()>0){
			IInfoObject report=reports.get(0);
			reportClientDoc = crystalObject.getReportAppFactory().openDocument(report,0, java.util.Locale.US);	
		}		
		return reportClientDoc; 
	}
	
	@Override
	public void scheduleReport(	String codiReportCr, CrystalReport crystalObject) throws Throwable {
		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_BY_REPORT_NAME).setParam("reportName", codiReportCr);
		List<IInfoObject> reports=search(crystalObject.getiStore(), cqb.buildQueryString());

		if(reports!=null&&!reports.isEmpty()){
				Utilities.scheduleReport((IReport)(reports.get(0)));
		}else{
			throw new ObjectNotFoundException(null, 1/*ErrorCode.ERROR_REPORT_SU_CR_INESISTENTE*/);
		}	

	}

	@Override
	public void scheduleReportWithParameters(String codiReportCr,	Map<String, String> parameters, CrystalReport crystalObject) throws Throwable {		
		//verifico se i parametri forniti dall'utente sono presenti sul report
		Map<String, Object> reportParameters=SearchUtilities.getReportParameters(crystalObject.getiStore(), codiReportCr);
		
		for(Map.Entry<String, String> reportParameter:parameters.entrySet()){
			if(!reportParameters.containsKey(reportParameter.getKey())){
				throw new ObjectNotFoundException(reportParameter.getKey(), 2/*ErrorCode.ERROR_PARAMETRO_INESISTENTE*/);
			}
		}
		
		//cancello le schedulazioni precedenti se i parametri sono gli stessi
		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_INSTANCE_BY_REPORT_NAME).setParam("reportName", codiReportCr);
		List<IInfoObject> instanceReports=search(crystalObject.getiStore(), cqb.buildQueryString());
		if(!isEmpty(instanceReports)){
			
			for(IInfoObject report:instanceReports){
				boolean delete =true;
				
				if (report.properties().size()>0) {
					
					IProperties properties= report.properties();
					
					for(Map.Entry<String,String> parameter:parameters.entrySet()){
						String propertiesValue=String.valueOf(properties.get(CrystalConstants.parameterFieldPrefix+parameter.getKey()+CrystalConstants.parameterFieldSuffix));				
						if(!propertiesValue.equals(parameter.getValue())){	
							delete=false;
							break;
						}
					}				
				}						
				if(delete){
					deleteReport(report.getID(),crystalObject);
				}				
			}
		}
		List<IInfoObject> reports=search(crystalObject.getiStore(), CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_BY_REPORT_NAME).setParam("reportName", codiReportCr).buildQueryString());
		if(reports!=null&&!reports.isEmpty()){
			Utilities.scheduleReportWithParameters(crystalObject.getiStore(), parameters, String.valueOf(reports.get(0).getID()), parameters.size()+"");			
		}else{
			throw new ObjectNotFoundException(null, 3/*ErrorCode.ERROR_REPORT_SU_CR_INESISTENTE*/);
		}			
	}	
	
	@Override
	public void scheduleReport(	String codiReportCr, Map<String, String> parameters, CrystalReport crystalObject)
			throws Throwable {
		
		if(parameters!=null&&!parameters.isEmpty()){
			scheduleReportWithParameters(codiReportCr, parameters, crystalObject);
		}else{
			scheduleReport(codiReportCr, crystalObject);
		}	
	}

	@Override
	public void deleteReport(int idCr, CrystalReport crystalObject)	throws Throwable {
		Utilities.deleteReport(crystalObject.getiStore(),String.valueOf(idCr));		
	}
	
	/* Il metodo searchScheduledReportByParentId recupera la schedulazione piu' recente relativa
	 * ad un determinato prospetto/occhiello. Leggere Commento all'interno del corpo del metodo
	 * per maggiori dettagli.
	 */
	@Override
	public CrystalReportObjectTO searchScheduledReportByParentId(CrystalReport crystalObject, Map<String,String> inputParameters, String parentId) throws Throwable 
	{	
		// LOGICA DEL METODO:
		// Il metodo searchScheduledReportByParentId recupera la schedulazione piu' recente relativa
		// ad un determinato prospetto/occhiello. 
		// L'individuazione della schedulazione viene effettuata a partire dal parentId. Cio' significa
		// che all'inizio vengono reperite tutte quelle schedulazioni afferenti lo stesso template.
		// Se il template non richiede parametri di input, una schedulazione vale l'altra.
		// Al contrario, se il template di riferimento richiede parametri di input, per individuare le 
		// schedulazioni effettivamente relative al prospetto/occhiello di interesse, occorre confrontare
		// i valori dei parametri di input con cui e' stata lanciata la schedulazione con i valori
		// degli stessi parametri di input associati al prospetto/occhiello in trattazione, valori 
		// quest'ultimi rappresentati dalla Map<String, String> inputParamters in input al metodo:
		// solo a fronte di uguaglianza di tali dati siamo certi che la schedulazione individuata
		// si riferisce al prospetto/occhiello in questione. 
		// Piu' nel dettaglio, delle eventuali N schedulazioni afferenti il prospetto/occhiello
		// di interesse, si considera la prima che si incontra in quanto, per l'ordinamento DESC della
		// data di schedulazione imposto nella query, rappresenta la piu' recente. I suoi dati
		// saranno sfruttati per creare l'istanza di CrystalReportObjectTO restituita in output.
		
		CrystalReportObjectTO to = new CrystalReportObjectTO();

		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_INSTANCE_SELECTIVE_BY_PARENT_ID).setParam("parentId", String.valueOf((parentId)));
		List<IInfoObject> listReports=search(crystalObject.getiStore(), cqb.buildQueryString());
		
		if  (	listReports != null
				&& !listReports.isEmpty()
			)	
		{
			skip:
			for (int j=0; j<listReports.size(); j++ )
			{	
				IInfoObject report = (IInfoObject)listReports.get(j);
				
				//Individuazione delle istanze avente i parametri passati dall'utente:
				//di queste si considera solo la prima...
				if (	((IReport)report).getReportParameters().size()>0
						&&!isEmpty(inputParameters)
					)
				{	
					for (int i=0; i<((IReport)report).getReportParameters().size(); i++) 
					{
						IReportParameter reportParameter = (IReportParameter) ((IReport) report).getReportParameters().get(i);
						String parameterName = reportParameter.getParameterName();
						
						if (!inputParameters.containsKey(parameterName))
						{
							//continue skip;
							continue;
						}	
						else
						{
							String valoreSchedulazione = null;
							String valoreDaRicercare = null;
							
							try
							{	//valoreSchedulazione = reportParameter.getValueDisplayString(Locale.ITALIAN);
								//in AbstractSearchUtilitues.getDefaultValues() c'e' LOCALE.US
								valoreSchedulazione = reportParameter.getValueDisplayString(Locale.US);
							}
							catch(Exception e)
							{	}	
								
							valoreDaRicercare = (String)inputParameters.get(parameterName);

							//Verifica che la schedulazione in esame sia relativa al 
							//prospetto/occhiello di interesse: se per un parametro di input
							//del template il dato passato in fase di lancio della schedulazione
							//e' uguale a quello che passerebbe il prospetto/occhiello per lo
							//stesso parametro ==> la scedulazione potrebbe essere relativa al
							//prospetto/occhiello medesimo ('potrebbe' perche' l'uguaglianza va
							//verificata per tutte le possibili coppie <paramtero,valore>), 
							//altrimenti (se cioe' i dua dati sono diversi) si e' certi che la
							//schedulazione in questione non riguarda il propsetto/occhiello
							//di interesse per cui, richiamando l'etichetta 'skip', si passa ad
							//esaminare l'eventuale altra schedulazione della lista su cui si 
							//ripetono i medesimi test...
							if (	valoreDaRicercare == null 
									&& valoreSchedulazione == null
								)
							{
								continue;
							}	
							else if ( 		(valoreDaRicercare == null && valoreSchedulazione != null )
										|| 	(valoreDaRicercare != null && valoreSchedulazione == null )
									)
							{
								continue skip;
							}	
							else if(!valoreSchedulazione.equals(valoreDaRicercare))
							{	
								continue skip;
							}							
						}//else di if (!inputParameters.containsKey(parameterName))	

					}//for (int i=0; i<((IReport)report).getReportParameters().size(); i++) 		
				
				}//	if (	((IReport)report).getReportParameters().size()>0

				
				to = buildCrystalReportObjectTO(report);
				
				break;
				
			}//for (int j=0; j<listReports.size(); j++ )	
		
		}	
		
		return to;		

	}	
	
	
	@Override
	public List<CrystalReportObjectTO> searchScheduledReport(CrystalReport crystalObject, Map<String,String> parameters, String codiReport)
			throws Throwable {		

		List<CrystalReportObjectTO> listTO=new ArrayList<CrystalReportObjectTO>();
		
		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_INSTANCE_BY_REPORT_NAME).setParam("reportName", codiReport);
		List<IInfoObject> reports=search(crystalObject.getiStore(), cqb.buildQueryString());
	
		if(reports!=null&&reports.size()>0){
			skip:
			for(IInfoObject report:reports){				
				//recupero solo l'istanza avente i parametri passati dall'utente
				if (report.properties().size()>0&&!isEmpty(parameters)) {
					
					IProperties properties= report.properties();
					
					for(Map.Entry<String,String> parameter:parameters.entrySet()){
						String propertiesValue=String.valueOf(properties.get(CrystalConstants.parameterFieldPrefix+parameter.getKey()+CrystalConstants.parameterFieldSuffix));				
						if(!propertiesValue.equals(parameter.getValue())){	
							continue skip;
						}
					}				
				}	
				
				CrystalReportObjectTO to = buildCrystalReportObjectTO(report);
				
				listTO.add(to);
			}
		}
		return listTO;

	}
	
	
	
	/**
	 * Metodo creato per centralizzare la creazione di un'istanza di CrystalReportObjectTO a partire da:
	 * -- un'istanza di IInfoObject;
	 * Generalmente l'istanza di IInfoObject rappresenta una schedulazione di un report recuperato
	 * dal server CR.
	 * buildCrystalReportObjectTO() e' stato realizzato per centralizzare la generazione di un'istanza
	 * di CrystalReportObjectTO in quanto passo presente su diversi metodi (quali ad esempio
	 * searchScheduledReportByParentId, searchScheduledReport,...)
	 * */
	protected CrystalReportObjectTO buildCrystalReportObjectTO(IInfoObject report) throws Throwable 
	{	CrystalReportObjectTO to = new CrystalReportObjectTO();
	
		to.setDescrReport(report.getTitle());
		to.setIdCr(report.getID());				
		
		IProperty siScheduleStatus = report.properties().getProperty(CePropertyID.SI_SCHEDULE_STATUS);
		if(siScheduleStatus!=null)
		{
			to.setStato(siScheduleStatus.getValue().toString());
			to.setDescStato(Utilities.decodeStatus(((Integer)siScheduleStatus.getValue()).intValue()));
		}
		
		IProperty siCreationTime = report.properties().getProperty(CePropertyID.SI_CREATION_TIME);
		if(siCreationTime!=null)
		{
			DateFormat df=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ITALY);
			to.setDataEsecuzione(df.format((Date)siCreationTime.getValue()));
		}
		return to;
	}
	
	
	

	public boolean isReportConfigured(String codiReportCr, CrystalReport crystalObject){
		boolean configured=false;
		CrystalReportQueryBuilder cqb=CrystalReportQueryBuilder.getInstance(Query.SELECT_REPORT_BY_REPORT_NAME).setParam("reportName", codiReportCr);
		List<IInfoObject> masterReports=search(crystalObject.getiStore(), cqb.buildQueryString());
		if(!isEmpty(masterReports)){
			configured=true;
		}			
		return configured;
	}
	
	@Override
	public InputStream makeFileForExport(CrystalReport crystalObject, String idCr, ReportExportFormat exportFormat) throws Throwable {
		InputStream inpStr =null;
		IInfoObject selectedReport=SearchUtilities.getReportById(crystalObject.getiStore(), idCr);
		ReportClientDocument reportClientDoc = crystalObject.getReportAppFactory().openDocument(selectedReport,0, java.util.Locale.US);
		if (reportClientDoc.getRowsetController().getRowset(null , null).getTotalRecordCount() > 0 ||
				reportClientDoc.getDatabaseController().getDatabase().getTables().size() == 0 )
		inpStr = makeFileForExport(reportClientDoc, exportFormat) ;
		reportClientDoc.close();
		return inpStr;
	}
	
	@Override
	public InputStream makeFileForExport(ReportClientDocument reportClientDoc, ReportExportFormat exportFormat) throws Throwable {
		InputStream is=null;	
		if(ReportExportFormat.MSWord==exportFormat){
			is=Utilities.exportRTFEditable(reportClientDoc);
		}
		else if(ReportExportFormat.RTF==exportFormat){
			is=Utilities.exportRTFEditable(reportClientDoc);
		}
		else if(ReportExportFormat.MSExcel==exportFormat){ 
			is=Utilities.exportExcel(reportClientDoc);
		}
		else if(ReportExportFormat.PDF==exportFormat){
			is=Utilities.exportPDF(reportClientDoc);
		}	
		return is;
	}
	

	@Override
	public void saveAndPrintListReport(List<Integer> listReportDaStampare, CrystalReport crystalObject, String printQueue) throws Throwable {
		// LOGICA DEL METODO:
		// Il metodo saveAndPrintListReport prende in un input una lista di identificativi Crystal
		// corrispondenti a esecuzioni di report, li esporta in formato pdf, li concatena in un unico pdf e salva il 
		// pdf  su file system
		// Il file pdf viene inviato in stampa su una stampante di sistema (printQueue)  e successivamente cancellato 
		
	}	

}
