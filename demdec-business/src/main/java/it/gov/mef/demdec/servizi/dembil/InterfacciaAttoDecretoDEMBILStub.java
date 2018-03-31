
/**
 * InterfacciaAttoDecretoDEMBILStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package it.gov.mef.demdec.servizi.dembil;

        

        /*
        *  InterfacciaAttoDecretoDEMBILStub java implementation
        */

        
        public class InterfacciaAttoDecretoDEMBILStub extends org.apache.axis2.client.Stub
        implements InterfacciaAttoDecretoDEMBIL{
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
     _service = new org.apache.axis2.description.AxisService("InterfacciaAttoDecretoDEMBIL" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[27];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloRaccoltaProvvisoria"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeDocumentoAllegatoDecretoIGB"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "searchFascicoliRaccolteProvvisorie"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "archiveFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getRisultatoOperazioneDocumento"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "addDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[7]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[8]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "updateContentDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[9]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[10]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloSIPATRAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[11]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "changeStatoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[12]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "changeStatoFascicoloRaccoltaProvvisoria"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[13]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "addDocumentoFascicoloAllegatoDecretoIGB"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[14]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloSIPATRAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[15]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "createFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[16]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloRaccoltaProvvisoria"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[17]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloSIPATRAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[18]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloRaccoltaProvvisoria"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[19]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[20]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[21]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[22]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[23]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloAllegatoDecretoIGB"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[24]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloAllegatoDecretoIGB"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[25]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "copyFascicoloAttoDecreto"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[26]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.GenericFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","GenericFault"),"it.gov.mef.demdec.servizi.dembil.common.GenericFault");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.SecurityFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/Common/HeaderFault","SecurityFault"),"it.gov.mef.demdec.servizi.dembil.common.SecurityFault");
           
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

    public InterfacciaAttoDecretoDEMBILStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public InterfacciaAttoDecretoDEMBILStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public InterfacciaAttoDecretoDEMBILStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost/FepaExternalServicesWS/internal/DEMBIL/v1/InterfacciaAttoDecretoDEMBIL" );
                
    }

    /**
     * Default Constructor
     */
    public InterfacciaAttoDecretoDEMBILStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost/FepaExternalServicesWS/internal/DEMBIL/v1/InterfacciaAttoDecretoDEMBIL" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public InterfacciaAttoDecretoDEMBILStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#downloadDocumentoFascicoloAttoDecreto
                     * @param richiesta_downloadDocumentoFascicoloAttoDecreto223
                    
                     * @param accessoApplicativo224
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto downloadDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto richiesta_downloadDocumentoFascicoloAttoDecreto223,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo224)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:downloadDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_downloadDocumentoFascicoloAttoDecreto223,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "downloadDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo224!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo224 = toOM(accessoApplicativo224, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo224,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio downloadDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio downloadDocumentoFascicoloAttoDecreto: " + _returnEnv);
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#downloadDocumentoFascicoloRaccoltaProvvisoria
                     * @param richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria226
                    
                     * @param accessoApplicativo227
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria downloadDocumentoFascicoloRaccoltaProvvisoria(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria226,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo227)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("urn:downloadDocumentoFascicoloRaccoltaProvvisoria");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria226,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "downloadDocumentoFascicoloRaccoltaProvvisoria")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo227!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo227 = toOM(accessoApplicativo227, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloRaccoltaProvvisoria")));
                                                    addHeader(omElementaccessoApplicativo227,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio downloadDocumentoFascicoloRaccoltaProvvisoria: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
System.out.println("Response servizio downloadDocumentoFascicoloRaccoltaProvvisoria: " + _returnEnv);
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#removeDocumentoAllegatoDecretoIGB
                     * @param richiesta_removeDocumentoFascicoloAllegatoDecretoIGB229
                    
                     * @param accessoApplicativo230
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB removeDocumentoAllegatoDecretoIGB(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB richiesta_removeDocumentoFascicoloAllegatoDecretoIGB229,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo230)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("urn:removeAllegatoDecretoIGB");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_removeDocumentoFascicoloAllegatoDecretoIGB229,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "removeDocumentoAllegatoDecretoIGB")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo230!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo230 = toOM(accessoApplicativo230, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeDocumentoAllegatoDecretoIGB")));
                                                    addHeader(omElementaccessoApplicativo230,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio removeDocumentoAllegatoDecretoIGB: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio removeDocumentoAllegatoDecretoIGB: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getFascicoloAttoDecreto
                     * @param richiesta_getFascicoloAttoDecreto232
                    
                     * @param accessoApplicativo233
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto getFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto richiesta_getFascicoloAttoDecreto232,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo233)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("urn:getFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getFascicoloAttoDecreto232,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo233!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo233 = toOM(accessoApplicativo233, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo233,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#searchFascicoliRaccolteProvvisorie
                     * @param richiesta_searchFascicoliRaccolteProvvisorie235
                    
                     * @param accessoApplicativo236
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie searchFascicoliRaccolteProvvisorie(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie richiesta_searchFascicoliRaccolteProvvisorie235,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo236)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("urn:searchFascicoliRaccolteProvvisorie");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_searchFascicoliRaccolteProvvisorie235,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "searchFascicoliRaccolteProvvisorie")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo236!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo236 = toOM(accessoApplicativo236, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "searchFascicoliRaccolteProvvisorie")));
                                                    addHeader(omElementaccessoApplicativo236,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

System.out.println("Request servizio searchFascicoliRaccolteProvvisorie: " + env);
        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
System.out.println("Response servizio searchFascicoliRaccolteProvvisorie: " + _returnEnv);
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#archiveFascicoloAttoDecreto
                     * @param richiesta_archiveFascicoloAttoDecreto238
                    
                     * @param accessoApplicativo239
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto archiveFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto richiesta_archiveFascicoloAttoDecreto238,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo239)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("urn:archiveFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_archiveFascicoloAttoDecreto238,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "archiveFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo239!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo239 = toOM(accessoApplicativo239, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "archiveFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo239,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio archiveFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
System.out.println("Response servizio archiveFascicoloAttoDecreto: " + _returnEnv);                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getRisultatoOperazioneDocumento
                     * @param richiesta_getRisultatoOperazioneDocumento241
                    
                     * @param accessoApplicativo242
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento getRisultatoOperazioneDocumento(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento richiesta_getRisultatoOperazioneDocumento241,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo242)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("urn:getRisultatoOperazioneDocumento");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getRisultatoOperazioneDocumento241,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getRisultatoOperazioneDocumento")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo242!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo242 = toOM(accessoApplicativo242, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getRisultatoOperazioneDocumento")));
                                                    addHeader(omElementaccessoApplicativo242,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getRisultatoOperazioneDocumento: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getRisultatoOperazioneDocumento: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#addDocumentoFascicoloAttoDecreto
                     * @param richiesta_addDocumentoFascicoloAttoDecreto244
                    
                     * @param accessoApplicativo245
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto addDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto richiesta_addDocumentoFascicoloAttoDecreto244,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo245)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("urn:addDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_addDocumentoFascicoloAttoDecreto244,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "addDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo245!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo245 = toOM(accessoApplicativo245, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "addDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo245,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio addDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                

System.out.println("Response servizio addDocumentoFascicoloAttoDecreto: " + _returnEnv);                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB
                     * @param richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB247
                    
                     * @param accessoApplicativo248
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB247,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo248)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
              _operationClient.getOptions().setAction("urn:modifyMetadatiAllegatoDecretoIGB");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB247,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo248!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo248 = toOM(accessoApplicativo248, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB")));
                                                    addHeader(omElementaccessoApplicativo248,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB: ");
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#updateContentDocumentoFascicoloAttoDecreto
                     * @param richiesta_updateContentDocumentoFascicoloAttoDecreto250
                    
                     * @param accessoApplicativo251
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto updateContentDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto richiesta_updateContentDocumentoFascicoloAttoDecreto250,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo251)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
              _operationClient.getOptions().setAction("urn:updateContentDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_updateContentDocumentoFascicoloAttoDecreto250,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "updateContentDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo251!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo251 = toOM(accessoApplicativo251, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "updateContentDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo251,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio updateContentDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio updateContentDocumentoFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#removeFascicoloAttoDecreto
                     * @param richiesta_removeFascicoloAttoDecreto253
                    
                     * @param accessoApplicativo254
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto removeFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto richiesta_removeFascicoloAttoDecreto253,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo254)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
              _operationClient.getOptions().setAction("urn:removeFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_removeFascicoloAttoDecreto253,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "removeFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo254!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo254 = toOM(accessoApplicativo254, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo254,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio removeFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio removeFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getDocumentoFascicoloSIPATRAttoDecreto
                     * @param richiesta_getDocumentoFascicoloSIPATRAttoDecreto256
                    
                     * @param accessoApplicativo257
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto getDocumentoFascicoloSIPATRAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto richiesta_getDocumentoFascicoloSIPATRAttoDecreto256,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo257)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
              _operationClient.getOptions().setAction("urn:getDocumentoFascicoloSIPATRAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getDocumentoFascicoloSIPATRAttoDecreto256,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getDocumentoFascicoloSIPATRAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo257!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo257 = toOM(accessoApplicativo257, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloSIPATRAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo257,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getDocumentoFascicoloSIPATRAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getDocumentoFascicoloSIPATRAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#changeStatoFascicoloAttoDecreto
                     * @param richiesta_changeStatoFascicoloAttoDecreto259
                    
                     * @param accessoApplicativo260
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto changeStatoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto richiesta_changeStatoFascicoloAttoDecreto259,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo260)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
              _operationClient.getOptions().setAction("urn:changeStatoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_changeStatoFascicoloAttoDecreto259,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "changeStatoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo260!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo260 = toOM(accessoApplicativo260, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "changeStatoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo260,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio changeStatoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio changeStatoFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#changeStatoFascicoloRaccoltaProvvisoria
                     * @param richiesta_changeStatoFascicoloRaccoltaProvvisoria262
                    
                     * @param accessoApplicativo263
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria changeStatoFascicoloRaccoltaProvvisoria(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria richiesta_changeStatoFascicoloRaccoltaProvvisoria262,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo263)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
              _operationClient.getOptions().setAction("urn:changeStatoFascicoloRaccoltaProvvisoria");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_changeStatoFascicoloRaccoltaProvvisoria262,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "changeStatoFascicoloRaccoltaProvvisoria")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo263!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo263 = toOM(accessoApplicativo263, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "changeStatoFascicoloRaccoltaProvvisoria")));
                                                    addHeader(omElementaccessoApplicativo263,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio changeStatoFascicoloRaccoltaProvvisoria: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio changeStatoFascicoloRaccoltaProvvisoria: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#addDocumentoFascicoloAllegatoDecretoIGB
                     * @param richiesta_addDocumentoFascicoloAllegatoDecretoIGB265
                    
                     * @param accessoApplicativo266
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB addDocumentoFascicoloAllegatoDecretoIGB(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB richiesta_addDocumentoFascicoloAllegatoDecretoIGB265,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo266)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[14].getName());
              _operationClient.getOptions().setAction("urn:addDocumentoFascicoloAllegatoDecretoIGB");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_addDocumentoFascicoloAllegatoDecretoIGB265,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "addDocumentoFascicoloAllegatoDecretoIGB")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo266!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo266 = toOM(accessoApplicativo266, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "addDocumentoFascicoloAllegatoDecretoIGB")));
                                                    addHeader(omElementaccessoApplicativo266,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio addDocumentoFascicoloAllegatoDecretoIGB: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio addDocumentoFascicoloAllegatoDecretoIGB: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getFascicoloSIPATRAttoDecreto
                     * @param richiesta_getFascicoloSIPATRAttoDecreto268
                    
                     * @param accessoApplicativo269
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto getFascicoloSIPATRAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto richiesta_getFascicoloSIPATRAttoDecreto268,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo269)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[15].getName());
              _operationClient.getOptions().setAction("urn:getFascicoloSIPATRAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getFascicoloSIPATRAttoDecreto268,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getFascicoloSIPATRAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo269!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo269 = toOM(accessoApplicativo269, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloSIPATRAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo269,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getFascicoloSIPATRAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getFascicoloSIPATRAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#createFascicoloAttoDecreto
                     * @param richiesta_createFascicoloAttoDecreto271
                    
                     * @param accessoApplicativo272
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto createFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto richiesta_createFascicoloAttoDecreto271,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo272)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[16].getName());
              _operationClient.getOptions().setAction("urn:createFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_createFascicoloAttoDecreto271,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "createFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo272!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo272 = toOM(accessoApplicativo272, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "createFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo272,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio createFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio createFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getDocumentoFascicoloRaccoltaProvvisoria
                     * @param richiesta_getDocumentoFascicoloRaccoltaProvvisoria274
                    
                     * @param accessoApplicativo275
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria getDocumentoFascicoloRaccoltaProvvisoria(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria richiesta_getDocumentoFascicoloRaccoltaProvvisoria274,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo275)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[17].getName());
              _operationClient.getOptions().setAction("urn:getDocumentoFascicoloRaccoltaProvvisoria");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getDocumentoFascicoloRaccoltaProvvisoria274,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getDocumentoFascicoloRaccoltaProvvisoria")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo275!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo275 = toOM(accessoApplicativo275, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloRaccoltaProvvisoria")));
                                                    addHeader(omElementaccessoApplicativo275,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getDocumentoFascicoloRaccoltaProvvisoria: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
 System.out.println("Response servizio getDocumentoFascicoloRaccoltaProvvisoria: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#downloadDocumentoFascicoloSIPATRAttoDecreto
                     * @param richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto277
                    
                     * @param accessoApplicativo278
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto downloadDocumentoFascicoloSIPATRAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto277,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo278)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[18].getName());
              _operationClient.getOptions().setAction("urn:downloadDocumentoFascicoloSIPATRAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto277,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "downloadDocumentoFascicoloSIPATRAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo278!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo278 = toOM(accessoApplicativo278, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloSIPATRAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo278,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio downloadDocumentoFascicoloSIPATRAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio downloadDocumentoFascicoloSIPATRAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getFascicoloRaccoltaProvvisoria
                     * @param richiesta_getFascicoloRaccoltaProvvisoria280
                    
                     * @param accessoApplicativo281
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria getFascicoloRaccoltaProvvisoria(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria richiesta_getFascicoloRaccoltaProvvisoria280,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo281)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[19].getName());
              _operationClient.getOptions().setAction("urn:getFascicoloRaccoltaProvvisoria");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getFascicoloRaccoltaProvvisoria280,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getFascicoloRaccoltaProvvisoria")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo281!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo281 = toOM(accessoApplicativo281, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getFascicoloRaccoltaProvvisoria")));
                                                    addHeader(omElementaccessoApplicativo281,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getFascicoloRaccoltaProvvisoria: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getFascicoloRaccoltaProvvisoria: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#modifyMetadatiDocumentoFascicoloAttoDecreto
                     * @param richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto283
                    
                     * @param accessoApplicativo284
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto modifyMetadatiDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto283,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo284)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[20].getName());
              _operationClient.getOptions().setAction("urn:modifyMetadatiDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto283,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "modifyMetadatiDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo284!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo284 = toOM(accessoApplicativo284, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo284,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Resquest servizio modifyMetadatiDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio modifyMetadatiDocumentoFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#removeDocumentoFascicoloAttoDecreto
                     * @param richiesta_removeDocumentoFascicoloAttoDecreto286
                    
                     * @param accessoApplicativo287
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto removeDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto richiesta_removeDocumentoFascicoloAttoDecreto286,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo287)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[21].getName());
              _operationClient.getOptions().setAction("urn:removeDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_removeDocumentoFascicoloAttoDecreto286,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "removeDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo287!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo287 = toOM(accessoApplicativo287, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "removeDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo287,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio removeDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio removeDocumentoFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#modifyMetadatiFascicoloAttoDecreto
                     * @param richiesta_modifyMetadatiFascicoloAttoDecreto289
                    
                     * @param accessoApplicativo290
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto modifyMetadatiFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto richiesta_modifyMetadatiFascicoloAttoDecreto289,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo290)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[22].getName());
              _operationClient.getOptions().setAction("urn:getFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_modifyMetadatiFascicoloAttoDecreto289,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "modifyMetadatiFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo290!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo290 = toOM(accessoApplicativo290, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "modifyMetadatiFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo290,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio modifyMetadatiFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio modifyMetadatiFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getDocumentoFascicoloAttoDecreto
                     * @param richiesta_getDocumentoFascicoloAttoDecreto292
                    
                     * @param accessoApplicativo293
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto getDocumentoFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto richiesta_getDocumentoFascicoloAttoDecreto292,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo293)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[23].getName());
              _operationClient.getOptions().setAction("urn:getDocumentoFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getDocumentoFascicoloAttoDecreto292,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getDocumentoFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo293!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo293 = toOM(accessoApplicativo293, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo293,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getDocumentoFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getDocumentoFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#getDocumentoFascicoloAllegatoDecretoIGB
                     * @param richiesta_getDocumentoFascicoloAllegatoDecretoIGB295
                    
                     * @param accessoApplicativo296
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB getDocumentoFascicoloAllegatoDecretoIGB(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB richiesta_getDocumentoFascicoloAllegatoDecretoIGB295,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo296)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[24].getName());
              _operationClient.getOptions().setAction("urn:getDocumentoFascicoloAllegatoDecretoIGB");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_getDocumentoFascicoloAllegatoDecretoIGB295,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "getDocumentoFascicoloAllegatoDecretoIGB")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo296!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo296 = toOM(accessoApplicativo296, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "getDocumentoFascicoloAllegatoDecretoIGB")));
                                                    addHeader(omElementaccessoApplicativo296,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio getDocumentoFascicoloAllegatoDecretoIGB: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio getDocumentoFascicoloAllegatoDecretoIGB: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#downloadDocumentoFascicoloAllegatoDecretoIGB
                     * @param richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB298
                    
                     * @param accessoApplicativo299
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB downloadDocumentoFascicoloAllegatoDecretoIGB(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB298,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo299)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[25].getName());
              _operationClient.getOptions().setAction("urn:downloadDocumentoAllegatoDecretoIGB");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB298,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "downloadDocumentoFascicoloAllegatoDecretoIGB")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo299!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo299 = toOM(accessoApplicativo299, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "downloadDocumentoFascicoloAllegatoDecretoIGB")));
                                                    addHeader(omElementaccessoApplicativo299,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio downloadDocumentoFascicoloAllegatoDecretoIGB: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio downloadDocumentoFascicoloAllegatoDecretoIGB: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB)object;
                                   
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
                     * Auto generated method signature
                     * 
                     * @see it.gov.mef.demdec.servizi.dembil.InterfacciaAttoDecretoDEMBIL#copyFascicoloAttoDecreto
                     * @param richiesta_copyFascicoloAttoDecreto301
                    
                     * @param accessoApplicativo302
                    
                     * @throws it.gov.mef.demdec.servizi.dembil.GenericFault : 
                     * @throws it.gov.mef.demdec.servizi.dembil.SecurityFault : 
                     */

                    

                            public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto copyFascicoloAttoDecreto(

                            it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto richiesta_copyFascicoloAttoDecreto301,it.gov.mef.demdec.servizi.dembil.common.AccessoApplicativo accessoApplicativo302)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,it.gov.mef.demdec.servizi.dembil.GenericFault
                        ,it.gov.mef.demdec.servizi.dembil.SecurityFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[26].getName());
              _operationClient.getOptions().setAction("urn:copyFascicoloAttoDecreto");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    richiesta_copyFascicoloAttoDecreto301,
                                                    optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL",
                                                    "copyFascicoloAttoDecreto")));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (accessoApplicativo302!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementaccessoApplicativo302 = toOM(accessoApplicativo302, optimizeContent(new javax.xml.namespace.QName("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBIL", "copyFascicoloAttoDecreto")));
                                                    addHeader(omElementaccessoApplicativo302,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

System.out.println("Request servizio copyFascicoloAttoDecreto: " + env);
        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
System.out.println("Response servizio copyFascicoloAttoDecreto: " + _returnEnv);
                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto)object;
                                   
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
     //http://localhost/FepaExternalServicesWS/internal/DEMBIL/v1/InterfacciaAttoDecretoDEMBIL
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto.MY_QNAME,
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
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto.MY_QNAME,factory));
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
        
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_searchFascicoliRaccolteProvvisorie.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_searchFascicoliRaccolteProvvisorie.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_archiveFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_archiveFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getRisultatoOperazioneDocumento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getRisultatoOperazioneDocumento.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_updateContentDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_updateContentDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_changeStatoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_changeStatoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_addDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_addDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_createFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_createFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloSIPATRAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getFascicoloRaccoltaProvvisoria.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_removeDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_removeDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_modifyMetadatiFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_modifyMetadatiFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_getDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_getDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_downloadDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_downloadDocumentoFascicoloAllegatoDecretoIGB.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Richiesta_copyFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto.class.equals(type)){
                
                           return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Risposta_copyFascicoloAttoDecreto.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
   