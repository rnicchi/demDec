package it.mef.bilancio.demdec.web.spring.utils;

import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;

import java.util.List;

public class RecuperoUtil {

	/*METRICHE*/
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM1 = "LOCM"; 
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM2 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM3 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM4 = "LOCM";
	@SuppressWarnings("unused")
	private final static String securityMetricaLOCM5 = "LOCM";

		public static RaccoltaProvvisoriaRedTO recuperaRaccProvvTo(List<RaccoltaProvvisoriaRedTO> listaRaccolteProvv, String idFascicoloRaccoltaProvvisoria){
		
		RaccoltaProvvisoriaRedTO result=null;
		for (int i=0; i<listaRaccolteProvv.size(); i++) {
			if (idFascicoloRaccoltaProvvisoria.equals(((RaccoltaProvvisoriaRedTO)listaRaccolteProvv.get(i)).getIdFascicoloRaccoltaProvvisoria())) {	
				result= (RaccoltaProvvisoriaRedTO)listaRaccolteProvv.get(i);
			    break;
			}
		}
		return result;
	}
	
	
		public static DocumentTO recuperaDocumentTo(List<DocumentTO> listaDocumenti, String idDocumento, String flagTipo){
		String idDoc=null;
		DocumentTO result=null;
		for (int i=0; i<listaDocumenti.size(); i++) {
			idDoc=flagTipo.equals("1")?((DocumentTO)listaDocumenti.get(i)).getIdDocumento():((DocumentTO)listaDocumenti.get(i)).getIdDocumentoRaccoltaProvvisoria();
			
			if (idDocumento.equals(idDoc)) {	
				result= (DocumentTO)listaDocumenti.get(i);
			    break;
			}
		}
		return result;
	}
	
}
