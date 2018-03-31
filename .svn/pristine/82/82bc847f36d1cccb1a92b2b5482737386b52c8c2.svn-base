package it.mef.bilancio.demdec.web.spring.utils;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.util.List;

public class TrasformUtil {

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

	// il metodo verifica se la lista
	// è stata valorizzata completamente
	// ritorna false se tutti gli elementi 
	// sono stati valorizzati
	// true se almeno un elemento della lista 
	// ridulta non valorizzato.
	public static boolean checkFull(List<String> lista) throws Throwable{
		boolean res=false;
		int elements=0;
		for (int i=0;i<lista.size();i++){
			if (!isEmpty(lista.get(i))){
				elements++;
			}
		}
		
		if (elements==lista.size()){
			res=true;
		}
		return res; 
	}
	
}
