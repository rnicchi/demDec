package it.mef.bilancio.demdec.utils;


import it.mef.bilancio.demdec.servizi.to.FadDemBilTO;

public class UtilityApplication {
	public static String creaIdentificativoAttoDecreto(FadDemBilTO fad){
		return ""+ fad.getAnnoDec()+"-"+fad.getTipoDec()+"-"+fad.getNumeroDec();
	}
}
