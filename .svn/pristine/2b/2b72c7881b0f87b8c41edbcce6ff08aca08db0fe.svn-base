package it.mef.bilancio.demdec.web.services;

import javax.xml.ws.WebFault;

/**
 * 
 * @author Bit
 *
 */

@WebFault(name = "NsbfGestioneFascicoliServiceFault", 
		targetNamespace = "http://services.demdec.bilancio.mef.it/")
public class NsbfGestioneFascicoliServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NsbfGestioneFascicoliServiceFault fault;

	public NsbfGestioneFascicoliServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param fault
	 */
	protected NsbfGestioneFascicoliServiceException(NsbfGestioneFascicoliServiceFault fault) {
		super(fault.getFaultDescription());
		this.fault = fault;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public NsbfGestioneFascicoliServiceException(String message, NsbfGestioneFascicoliServiceFault faultInfo) {
		super(message);
		this.fault = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public NsbfGestioneFascicoliServiceException(String message, NsbfGestioneFascicoliServiceFault faultInfo,
			Throwable cause) {
		super(message, cause);
		this.fault = faultInfo;
	}

	/**
	 * 
	 * @return
	 */
	public NsbfGestioneFascicoliServiceFault getFaultInfo() {
		return fault;
	}

	/**
	 * @param message
	 */
	public NsbfGestioneFascicoliServiceException(String message) {
		super(message);
	}

	/**
	 * @param message
	 */
	public NsbfGestioneFascicoliServiceException(String code, String message) {
		super(message);
		this.fault = new NsbfGestioneFascicoliServiceFault();
		this.fault.setFaultDescription(message);
		this.fault.setFaultCode(code);
	}

	/**
	 * @param cause
	 */
	public NsbfGestioneFascicoliServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NsbfGestioneFascicoliServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
