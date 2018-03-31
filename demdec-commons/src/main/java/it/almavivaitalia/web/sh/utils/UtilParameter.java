package it.almavivaitalia.web.sh.utils;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.castor.util.Base64Decoder;
import org.castor.util.Base64Encoder;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class UtilParameter {
	
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
}
