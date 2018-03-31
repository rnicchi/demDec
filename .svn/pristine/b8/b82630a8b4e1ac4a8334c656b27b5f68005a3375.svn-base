
/**
 * InterfacciaOperazioniDocumentaliStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package it.gov.mef.demdec.servizi.dembil;

        

        /*
        *  InterfacciaOperazioniDocumentaliStub java implementation
        */

        
        public class InterfacciaOperazioniDocumentaliStub extends org.apache.axis2.client.Stub
        implements InterfacciaOperazioniDocumentali{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("InterfacciaOperazioniDocumentali" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "convertiDocumento"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public InterfacciaOperazioniDocumentaliStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public InterfacciaOperazioniDocumentaliStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public InterfacciaOperazioniDocumentaliStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost/DEMBILExternalServicesWS/internal/SIPATR/v1/InterfacciaOperazioniDocumentali" );
                
    }

    /**
     * Default Constructor
     */
    public InterfacciaOperazioniDocumentaliStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost/DEMBILExternalServicesWS/internal/SIPATR/v1/InterfacciaOperazioniDocumentali" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public InterfacciaOperazioniDocumentaliStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaOperazioniDocumentali#convertiDocumento
                     * @param richiesta_convertiDocumento126
                    
                     * @param accessoApplicativo127
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento convertiDocumento(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento richiesta_convertiDocumento126,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo127)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:convertiDocumento");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_convertiDocumento126,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "convertiDocumento")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo127!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo127 = toOM(accessoApplicativo127, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "convertiDocumento")));
                                                    addHeader(omElementaccessoApplicativo127,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);
System.out.println("Request servizio convertiDocumento: " + env);
        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
System.out.println("Response servizio convertiDocumento: " + _returnEnv);                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof it.gov.mef.demdec.servizi.dembil.GenericFault){
                          throw (it.gov.mef.demdec.servizi.dembil.GenericFault)ex;
                        }
                        
                        if (ex instanceof it.gov.mef.demdec.servizi.dembil.SecurityFault){
                          throw (it.gov.mef.demdec.servizi.dembil.SecurityFault)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost/DEMBILExternalServicesWS/internal/SIPATR/v1/InterfacciaOperazioniDocumentali
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.common.GenericFault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.common.GenericFault.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.common.SecurityFault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.common.SecurityFault.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_convertiDocumento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_convertiDocumento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.common.GenericFault.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.common.GenericFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.common.SecurityFault.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.common.SecurityFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   