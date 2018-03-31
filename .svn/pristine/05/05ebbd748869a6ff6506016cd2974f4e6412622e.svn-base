package it.mef.bilancio.demdec.web.spring.controller.export;

import it.almavivaitalia.bilancio.commons.utils.DateUtil;
import it.almavivaitalia.bilancio.commons.web.spring.controller.AbstractCommonFormController;
import it.almavivaitalia.web.sh.export.TableFileExport;
import it.almavivaitalia.web.sh.export.TableModel;
import it.almavivaitalia.web.sh.export.excel.XlsReportFileExport;
import it.almavivaitalia.web.sh.export.pdf.PdfReportFileExport;
import it.almavivaitalia.web.sh.export.pdf.PdfTableFileExport;
import it.almavivaitalia.web.sh.utils.Context;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.ExportConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = ConstantsRequestMapping.FILE_EXPORT)
public class FileExportController extends AbstractCommonFormController {

	@Override
	public String startController(Context context) throws Throwable {
		List<TableModel> tableModel = context.getModel(LIST_FILE_EXPORT);
		String type = context.getModel(OBJECT_FILE_EXPORT_TYPE);
		TableFileExport tfe = null;
		//String fileName = ExportConstants.NAME_FILE_STAMPA + DateUtil.getSysDate(ExportConstants.SEPARATORE_STAMPA);
		String fileName = context.getModel(NAME_FILE_EXPORT) + DateUtil.getSysDate(ExportConstants.SEPARATORE_STAMPA);
		if (type.equals(SessionAttributes.EXPORT_GENERIC_PDF)) {
			tfe = new PdfTableFileExport();
			fileName += ExportConstants.PDF_EXTENSION;
		} else if (type.equals(SessionAttributes.EXPORT_GENERIC_EXCEL)) {
			tfe = new ExcelFormTableFileExport();
			fileName += ExportConstants.XLS_EXTENSION;
		} else if (type.equals(SessionAttributes.EXPORT_KEYS_PDF)) {
			tfe = new PdfReportFileExport();
		} else if (type.equals(SessionAttributes.EXPORT_KEYS_EXCEL)) {
			tfe = new XlsReportFileExport();
		}
		tfe.setParameters(tableModel);
		tfe.setMessageSource(getMessageSource());
		context.setResponseContentType(tfe.getMimeType(), fileName);
		tfe.doExport(context.getOutputStream());

		return null;
	}

}
