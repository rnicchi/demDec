
/**
 * SecurityFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package it.gov.mef.demdec.servizi.dembil;

public class SecurityFault extends java.lang.Exception{
    
    private it.gov.mef.demdec.servizi.dembil.common.SecurityFault faultMessage;

    
        public SecurityFault() {
            super("SecurityFault");
        }

        public SecurityFault(java.lang.String s) {
           super(s);
        }

        public SecurityFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SecurityFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(it.gov.mef.demdec.servizi.dembil.common.SecurityFault msg){
       faultMessage = msg;
    }
    
    public it.gov.mef.demdec.servizi.dembil.common.SecurityFault getFaultMessage(){
       return faultMessage;
    }
}
    