package it.mef.bilancio.demdec.servizi.pkbox;

import it.pkbox.client.PKBox;

import java.io.Serializable;

public class SignerParameter implements Serializable {

	private static final long serialVersionUID = 1L;
    private String name;
    private String pin;
    private String tokenPin;
    private String oTP;
    private String alias;
	private Integer returnCode;
	private String errorMessage;
	private String decodedErrorMessage;
	private byte[] fileToBeSigned;
	private byte[] signedFile;
	private String tag;
	private String signLayout;
	private String reason;
	private PKBoxParameter pkBoxParameter;
	private PKBox  pkBoxClient;
	
	
	
	public SignerParameter() {
		this.pkBoxParameter = new PKBoxParameter();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getTokenPin() {
		return tokenPin;
	}
	public void setTokenPin(String tokenPin) {
		this.tokenPin = tokenPin;
	}
	public String getoTP() {
		return oTP;
	}
	public void setoTP(String oTP) {
		this.oTP = oTP;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public byte[] getFileToBeSigned() {
		return fileToBeSigned;
	}
	public void setFileToBeSigned(byte[] fileToBeSigned) {
		this.fileToBeSigned = fileToBeSigned;
	}
	public byte[] getSignedFile() {
		return signedFile;
	}
	public void setSignedFile(byte[] signedFile) {
		this.signedFile = signedFile;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDecodedErrorMessage() {
		return decodedErrorMessage;
	}
	public void setDecodedErrorMessage(String decodedErrorMessage) {
		this.decodedErrorMessage = decodedErrorMessage;
	}
	public String getSignLayout() {
		return signLayout;
	}
	public void setSignLayout(String signLayout) {
		this.signLayout = signLayout;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public PKBox getPkBoxClient() {
		return pkBoxClient;
	}
	public void setPkBoxClient(PKBox pkBoxClient) {
		this.pkBoxClient = pkBoxClient;
	}
	public PKBoxParameter getPkBoxParameter() {
		return pkBoxParameter;
	}
	public void setPkBoxParameter(PKBoxParameter pkBoxParameter) {
		this.pkBoxParameter = pkBoxParameter;
	}
	public String toString(){
		return "name: ["+this.name+"] "+
			    "pin: ["+this.pin+"] "+
				"tokenPin: ["+this.tokenPin+"] "+
			    "alias: ["+this.alias+"] "+
				"tag: ["+this.tag+"] "+
			    "signLayout: ["+this.signLayout+"] "+
				"reason: ["+this.reason+"]";
	}
}
