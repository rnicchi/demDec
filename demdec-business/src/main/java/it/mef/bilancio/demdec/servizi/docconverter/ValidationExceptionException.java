
/**
 * ValidationExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */

package it.mef.bilancio.demdec.servizi.docconverter;

public class ValidationExceptionException extends java.lang.Exception{
    
    private it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.ValidationException faultMessage;

    
        public ValidationExceptionException() {
            super("ValidationExceptionException");
        }

        public ValidationExceptionException(java.lang.String s) {
           super(s);
        }

        public ValidationExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ValidationExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.ValidationException msg){
       faultMessage = msg;
    }
    
    public it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.ValidationException getFaultMessage(){
       return faultMessage;
    }
}
    