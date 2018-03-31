package it.mef.bilancio.demdec.dao;

public interface LettereTestiDao extends AbstractDemDao  {

	String[] getLettereTestiByTipo(String tipoLettera) throws Throwable ;

	String[] getLettereTestiByTipoBalanced(String tipoLettera) throws Throwable;
	
	
}
