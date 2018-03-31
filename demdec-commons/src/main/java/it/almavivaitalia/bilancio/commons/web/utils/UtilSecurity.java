package it.almavivaitalia.bilancio.commons.web.utils;

import it.almavivaitalia.bilancio.commons.utils.PropertyConfigurer;
import it.almavivaitalia.bilancio.commons.web.security.spring.SpringCommonBeanFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Security;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.castor.util.Base64Decoder;
import org.castor.util.Base64Encoder;
import org.springframework.util.Assert;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class UtilSecurity {
	
	public static String encode(String originale, byte[] key) throws Exception {

		byte[] rpsUcbCipher = null;
		String encoded = null;

		// Cifratura dei parametri
		rpsUcbCipher =
			SymmetricCipher.encrypt(
				originale.getBytes("UTF-8"),
				key);
		
		//	BASE64 consente di rappresentare
		// in formato testuale il contenuto di byte
	//	Base64Encoder encoder = new Base64Encoder();
		String encodedBase64 = new String(Base64Encoder.encode(rpsUcbCipher));

		// codifica una stringa nel formato URL
		encoded = URLEncoder.encode(encodedBase64, "UTF-8");
		

		
		return encoded;
		
	}
	public static String encode(String originale, String sKey) throws Exception {
		
		byte[] key = sKey.getBytes("UTF-8");
		byte[] rpsUcbCipher = null;
		String encoded = null;

		// Cifratura dei parametri
		rpsUcbCipher =
			SymmetricCipher.encrypt(
				originale.getBytes("UTF-8"),
				key);
		
		//	BASE64 consente di rappresentare
		// in formato testuale il contenuto di byte
	//	Base64Encoder encoder = new Base64Encoder();
		String encodedBase64 = new String(Base64Encoder.encode(rpsUcbCipher));

		// codifica una stringa nel formato URL
		encoded = URLEncoder.encode(encodedBase64, "UTF-8");
		

		
		return encoded;
		
	}
	
	public static String decode(String encodedBase64, byte[] key) throws Exception {

		String encoded = null;

		encoded = URLEncoder.encode(encodedBase64, "UTF-8");
		
		String decoded = URLDecoder.decode(encoded, "UTF-8");
		//riconverte i bytes da BASE64 a bytes standard da 8 bit
		byte[] originalCipher = Base64Decoder.decode(decoded);
		byte[] rpsUcbDecipher =
			SymmetricCipher.decrypt(
				originalCipher,
				key); 
		String finaleDecoded = new String(rpsUcbDecipher, "UTF-8");
		
		return finaleDecoded;
		
	}
	public static String decode(String encodedBase64, String sKey) throws Exception {
		
		byte[] key = sKey.getBytes("UTF-8");
		String encoded = null;

		encoded = URLEncoder.encode(encodedBase64, "UTF-8");
		
		String decoded = URLDecoder.decode(encoded, "UTF-8");
		//riconverte i bytes da BASE64 a bytes standard da 8 bit
		byte[] originalCipher = Base64Decoder.decode(decoded);
		byte[] rpsUcbDecipher =
			SymmetricCipher.decrypt(
				originalCipher,
				key); 
		String finaleDecoded = new String(rpsUcbDecipher, "UTF-8");
		
		return finaleDecoded;
		
	}
	
	
    
	//public static void readParameters(HttpServletRequest request) throws Throwable {
		public static Security readParameters(HttpServletRequest request) throws Throwable {
		PropertyConfigurer configurer = SpringCommonBeanFactory.getPropertyConfigurer();
	//	Map<String, String> valuer = configurer.getResolvedProps();

		Security securityTO = null;
		String sDateColl = request.getParameter(ConstantsSecurity.DATE_COLL);
		String utenteParam = request.getParameter(ConstantsSecurity.UTENTE);
		String utenteSbParam = request.getParameter(ConstantsSecurity.UTENTE_SB);
		String pswdSbParam = request.getParameter(ConstantsSecurity.PSWD_SB);
		Format formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);
		Date data = (Date) formatter.parseObject(sDateColl);
		Format formatterKey = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER_KEY);
		String formattedKey = formatterKey.format(data);
		
		Assert.notNull(utenteParam,"Utente o password non presente");
		Assert.notNull(utenteSbParam,"Utente o password non presente");
		Assert.notNull(pswdSbParam,"Utente o password non presente");
//		securityTO = new Security();
	//	securityTO.setDataCollegamento(sDateColl);
	//	Boolean bCifratura = new Boolean(valuer.get("sec.cipher"));
		
	//	if (bCifratura) {
	//			securityTO.setCodiUtenteSbfj(UtilSecurity.decode(utenteParam, formattedKey));
	//			securityTO.setPswdSb(UtilSecurity.decode(pswdSbParam, formattedKey));
	//			securityTO.setUtenteSb(UtilSecurity.decode(utenteSbParam,formattedKey));
	//		} else {
	//			securityTO.setCodiUtenteSbfj(utenteParam);
	//			securityTO.setPswdSb(pswdSbParam);
	//			securityTO.setUtenteSb(utenteSbParam);
	//		}

		return securityTO;
	}

	public static String gestisciUtente(HttpServletRequest request) throws Throwable{
		Security securityTO = readParameters(request);
	
		Assert.notNull(securityTO,"Si è verificato un errore di sistema");
		
//		boolean sCheck = checkSecurityParameters(securityTO);
		
//		Assert.notNull(sCheck,"Utente non autenticato");	
		
	//	return securityTO.getCodiUtenteSbfj();
		return "";
	}

//	private static boolean checkSecurityParameters(Security securityTO) throws Throwable {
//		PropertyConfigurer configurer = SpringCommonBeanFactory.getPropertyConfigurer();
//		Map<String, String> valuer = configurer.getResolvedProps();
//	    UtenteService service = SpringCommonBeanFactory.getUtenteService();
//		String sData = service.getSysDate();// utenteManager.getSystemDate();
//		Format formatter = new SimpleDateFormat(ConstantsSecurity.SIMPLE_DATE_FORMATTER);
//		Date dateLoc = (Date) formatter.parseObject(sData); // new Date();
//		String sInterval = valuer.get("sec.interval");
//		Date dateColl = (Date) formatter.parseObject(securityTO.getDataCollegamento());
//		
//		return
//			dateLoc.getTime() - dateColl.getTime() < new Integer(sInterval).longValue() 
//			&& securityTO.getUtenteSb().equals(valuer.get("sb.user"))
//			&& securityTO.getPswdSb().equals(valuer.get("sb.password"));
//	}
	
}
