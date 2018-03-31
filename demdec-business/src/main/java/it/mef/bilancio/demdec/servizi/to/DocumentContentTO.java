package it.mef.bilancio.demdec.servizi.to;

import java.util.Arrays;


public class DocumentContentTO extends DocumentFileTO implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errore;
	
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DocumentContentTO [content=" + Arrays.toString(content) + "]";
	}

	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	
	
	

}
