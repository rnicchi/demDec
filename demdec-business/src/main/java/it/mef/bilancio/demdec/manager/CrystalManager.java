package it.mef.bilancio.demdec.manager;


import it.mef.bilancio.demdec.crystal.CrystalReport;
import it.mef.bilancio.demdec.crystal.CrystalReportObjectTO;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;

public interface CrystalManager extends AbstractDemManager {
	
	public List<CrystalReportObjectTO> searchScheduledReport(CrystalReport crystalObject, Map<String,String> parameters, String codiReport) throws Throwable;
	
	public CrystalReportObjectTO searchScheduledReportByParentId(CrystalReport crystalObject, Map<String,String> parameters, String parentId) throws Throwable;		
	
	public ReportClientDocument openDocumentById(int idCr, CrystalReport crystalObject) throws Throwable;

	public ReportClientDocument openDocumentByName(String codiReportCr, CrystalReport crystalObject) throws Throwable;

	public void scheduleReport(String codiReportCr, CrystalReport crystalObject) throws Throwable;

	public void scheduleReportWithParameters(String codiReportCr, Map<String, String> parameters, CrystalReport crystalObject) throws Throwable;

	public void scheduleReport(String codiReportCr, Map<String, String> parameters, CrystalReport crystalObject) throws Throwable;
	
	public InputStream makeFileForExport(ReportClientDocument reportClientDoc, ReportExportFormat exportFormat) throws Throwable;
	
	public InputStream makeFileForExport(CrystalReport crystalObject, String idCr, ReportExportFormat exportFormat) throws Throwable;
	
	public void deleteReport(int idCr,CrystalReport crystalObject) throws Throwable;
	
	public void saveAndPrintListReport(List<Integer> listReportDaStampare, CrystalReport crystalObject, String printQueue)  throws Throwable;

}
