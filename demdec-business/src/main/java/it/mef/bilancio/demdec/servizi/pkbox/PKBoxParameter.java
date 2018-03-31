package it.mef.bilancio.demdec.servizi.pkbox;

import java.io.Serializable;

public class PKBoxParameter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String pkBoxHandler;
	private String securePinFilePath;
	//attributi utilizzati per generazione OTP
	private String provider; 
	private String otpPropertiesFilePath;
	private String firmaBaseKey;
	private String firmaBaseKeyPin;
	
	
	/**
	 * Restituisce url pkbox handler. 
	 * @return pkBoxHandler 
	 * @see    String
	 */
	public String getPkBoxHandler() {
		return pkBoxHandler;
	}
	
	/**
	 * Imposta la url pkbox handler.
	 * @param  pkBoxHandler  url pkbox handler
	 * @return void
	 */
	public void setPkBoxHandler(String pkBoxHandler) {
		this.pkBoxHandler = pkBoxHandler;
	}
	
	/**
	 * Restituisce provider utilizzato per generazione OTP. 
	 * @return String 
	 */
	public String getProvider() {
		return provider;
	}
	
	/**
	 * Imposta il provider utilizzato per generazione OTP.
	 * @param  provider  provider utilizzato per generazione OTP.
	 * @return void
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	/**
	 * Restituisce path fisico (completo di nome file) dove risiede il certificato 
	 * di securePin. 
	 * @return securePinFilePath
	 * @see    String 
	 */
	public String getSecurePinFilePath() {
		return securePinFilePath;
	}
	
	/**
	 * Imposta il path relativo al certificato di securePin (completo di nome file).
	 * @param  securePinFilePath  path completo comprensivo di nome file.
	 * @return void
	 */
	public void setSecurePinFilePath(String securePinFilePath) {
		this.securePinFilePath = securePinFilePath;
	}
	
	/**
	 * Restituisce path fisico (completo di nome file) dove risiede il file di configurazione 
	 * per generazione OTP. 
	 * @return otpPropertiesFilePath
	 * @see    String 
	 */
	public String getOtpPropertiesFilePath() {
		return otpPropertiesFilePath;
	}
	
	/**
	 * Imposta path fisico (completo di nome file) dove risiede il file di configurazione 
	 * per generazione OTP. 
	 * @param  otpPropertiesFilePath  path completo comprensivo di nome file
	 * @return void
	 */
	public void setOtpPropertiesFilePath(String otpPropertiesFilePath) {
		this.otpPropertiesFilePath = otpPropertiesFilePath;
	}
	
	/**
	 * Restituisce FirmaBaseKey definito nel file otp.properties. 
	 * @return firmaBaseKey 
	 * @see    String
	 */
	public String getFirmaBaseKey() {
		return firmaBaseKey;
	}

	/**
	 * Imposta FirmaBaseKey definito nel file otp.properties. 
	 * @param  firmaBaseKey
	 * @return void
	 */
	public void setFirmaBaseKey(String firmaBaseKey) {
		this.firmaBaseKey = firmaBaseKey;
	}

	/**
	 * Restituisce FirmaBaseKeyPin definito nel file otp.properties. 
	 * @return firmaBaseKeyPin 
	 * @see    String
	 */
	public String getFirmaBaseKeyPin() {
		return firmaBaseKeyPin;
	}

	/**
	 * Imposta FirmaBaseKeyPin definito nel file otp.properties. 
	 * @param  firmaBaseKeyPin
	 * @return void
	 */
	public void setFirmaBaseKeyPin(String firmaBaseKeyPin) {
		this.firmaBaseKeyPin = firmaBaseKeyPin;
	}

	public String toString(){
		return  "pkBoxHandler: ["+this.pkBoxHandler+"] "+
				"securePin: ["+this.securePinFilePath+"] "+
				"provider: ["+this.provider+"] "+
				"firmaBaseKey: ["+this.firmaBaseKey+"]" +
				"firmaBaseKeyPin: ["+this.firmaBaseKeyPin+"]";
	}

}
