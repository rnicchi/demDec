
/**
 * DocConverterServiceServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */

    package it.mef.bilancio.demdec.servizi.docconverter;

    /**
     *  DocConverterServiceServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DocConverterServiceServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DocConverterServiceServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DocConverterServiceServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for toPDFA method
            * override this method for handling normal response from toPDFA operation
            */
           public void receiveResulttoPDFA(
        		   it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.ToPDFAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from toPDFA operation
           */
            public void receiveErrortoPDFA(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isPDFA method
            * override this method for handling normal response from isPDFA operation
            */
           public void receiveResultisPDFA(
        		   it.mef.bilancio.demdec.servizi.docconverter.DocConverterServiceServiceStub.IsPDFAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isPDFA operation
           */
            public void receiveErrorisPDFA(java.lang.Exception e) {
            }
                


    }
    