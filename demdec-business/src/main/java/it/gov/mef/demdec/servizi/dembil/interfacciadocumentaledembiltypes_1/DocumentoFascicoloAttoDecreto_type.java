
/**
 * DocumentoFascicoloAttoDecreto_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  DocumentoFascicoloAttoDecreto_type bean class
            */
        
        public  class DocumentoFascicoloAttoDecreto_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = documentoFascicoloAttoDecreto_type
                Namespace URI = http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBILTypes_1
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBILTypes_1")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for IdDocumento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid localIdDocumento ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid getIdDocumento(){
                               return localIdDocumento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdDocumento
                               */
                               public void setIdDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid param){
                            
                                            this.localIdDocumento=param;
                                    

                               }
                            

                        /**
                        * field for TipoDocumento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type localTipoDocumento ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type getTipoDocumento(){
                               return localTipoDocumento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoDocumento
                               */
                               public void setTipoDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type param){
                            
                                            this.localTipoDocumento=param;
                                    

                               }
                            

                        /**
                        * field for Descrizione
                        */

                        
                                    protected java.lang.String localDescrizione ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescrizione(){
                               return localDescrizione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Descrizione
                               */
                               public void setDescrizione(java.lang.String param){
                            
                                            this.localDescrizione=param;
                                    

                               }
                            

                        /**
                        * field for DataCreazione
                        */

                        
                                    protected java.util.Date localDataCreazione ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getDataCreazione(){
                               return localDataCreazione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataCreazione
                               */
                               public void setDataCreazione(java.util.Date param){
                            
                                            this.localDataCreazione=param;
                                    

                               }
                            

                        /**
                        * field for MetadatiDocumento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type localMetadatiDocumento ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMetadatiDocumentoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type getMetadatiDocumento(){
                               return localMetadatiDocumento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MetadatiDocumento
                               */
                               public void setMetadatiDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMetadatiDocumentoTracker = true;
                                       } else {
                                          localMetadatiDocumentoTracker = false;
                                              
                                       }
                                   
                                            this.localMetadatiDocumento=param;
                                    

                               }
                            

                        /**
                        * field for FileName
                        */

                        
                                    protected java.lang.String localFileName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFileName(){
                               return localFileName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FileName
                               */
                               public void setFileName(java.lang.String param){
                            
                                            this.localFileName=param;
                                    

                               }
                            

                        /**
                        * field for Hash
                        */

                        
                                    protected javax.activation.DataHandler localHash ;
                                

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getHash(){
                               return localHash;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hash
                               */
                               public void setHash(javax.activation.DataHandler param){
                            
                                            this.localHash=param;
                                    

                               }
                            

                        /**
                        * field for MimeType
                        */

                        
                                    protected java.lang.String localMimeType ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMimeType(){
                               return localMimeType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MimeType
                               */
                               public void setMimeType(java.lang.String param){
                            
                                            this.localMimeType=param;
                                    

                               }
                            

                        /**
                        * field for Length
                        */

                        
                                    protected long localLength ;
                                

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getLength(){
                               return localLength;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Length
                               */
                               public void setLength(long param){
                            
                                            this.localLength=param;
                                    

                               }
                            

                        /**
                        * field for TipoCompressione
                        */

                        
                                    protected java.lang.String localTipoCompressione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTipoCompressioneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTipoCompressione(){
                               return localTipoCompressione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoCompressione
                               */
                               public void setTipoCompressione(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTipoCompressioneTracker = true;
                                       } else {
                                          localTipoCompressioneTracker = false;
                                              
                                       }
                                   
                                            this.localTipoCompressione=param;
                                    

                               }
                            

                        /**
                        * field for Firmato
                        */

                        
                                    protected boolean localFirmato ;
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getFirmato(){
                               return localFirmato;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Firmato
                               */
                               public void setFirmato(boolean param){
                            
                                            this.localFirmato=param;
                                    

                               }
                            

                        /**
                        * field for ValidazioneFirma
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ValidazioneFirma_type localValidazioneFirma ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localValidazioneFirmaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ValidazioneFirma_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ValidazioneFirma_type getValidazioneFirma(){
                               return localValidazioneFirma;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ValidazioneFirma
                               */
                               public void setValidazioneFirma(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ValidazioneFirma_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localValidazioneFirmaTracker = true;
                                       } else {
                                          localValidazioneFirmaTracker = false;
                                              
                                       }
                                   
                                            this.localValidazioneFirma=param;
                                    

                               }
                            

                        /**
                        * field for Condivisibile
                        */

                        
                                    protected boolean localCondivisibile =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("true");
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getCondivisibile(){
                               return localCondivisibile;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Condivisibile
                               */
                               public void setCondivisibile(boolean param){
                            
                                            this.localCondivisibile=param;
                                    

                               }
                            

                        /**
                        * field for Attivo
                        */

                        
                                    protected boolean localAttivo =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("true");
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getAttivo(){
                               return localAttivo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Attivo
                               */
                               public void setAttivo(boolean param){
                            
                                            this.localAttivo=param;
                                    

                               }
                            

                        /**
                        * field for SistemaProduttore
                        */

                        
                                    protected java.lang.String localSistemaProduttore ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSistemaProduttore(){
                               return localSistemaProduttore;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SistemaProduttore
                               */
                               public void setSistemaProduttore(java.lang.String param){
                            
                                            this.localSistemaProduttore=param;
                                    

                               }
                            

                        /**
                        * field for IsDocumentoOriginale
                        */

                        
                                    protected boolean localIsDocumentoOriginale =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("true");
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsDocumentoOriginale(){
                               return localIsDocumentoOriginale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsDocumentoOriginale
                               */
                               public void setIsDocumentoOriginale(boolean param){
                            
                                            this.localIsDocumentoOriginale=param;
                                    

                               }
                            

                        /**
                        * field for IsDocumentoTrattato
                        */

                        
                                    protected boolean localIsDocumentoTrattato =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("true");
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsDocumentoTrattato(){
                               return localIsDocumentoTrattato;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsDocumentoTrattato
                               */
                               public void setIsDocumentoTrattato(boolean param){
                            
                                            this.localIsDocumentoTrattato=param;
                                    

                               }
                            

                        /**
                        * field for DocumentoOrigine
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type localDocumentoOrigine ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocumentoOrigineTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type getDocumentoOrigine(){
                               return localDocumentoOrigine;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DocumentoOrigine
                               */
                               public void setDocumentoOrigine(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDocumentoOrigineTracker = true;
                                       } else {
                                          localDocumentoOrigineTracker = false;
                                              
                                       }
                                   
                                            this.localDocumentoOrigine=param;
                                    

                               }
                            

                        /**
                        * field for Operazione
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type localOperazione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperazioneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type getOperazione(){
                               return localOperazione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Operazione
                               */
                               public void setOperazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOperazioneTracker = true;
                                       } else {
                                          localOperazioneTracker = false;
                                              
                                       }
                                   
                                            this.localOperazione=param;
                                    

                               }
                            

                        /**
                        * field for TicketArchiviazione
                        */

                        
                                    protected java.lang.String localTicketArchiviazione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTicketArchiviazioneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTicketArchiviazione(){
                               return localTicketArchiviazione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TicketArchiviazione
                               */
                               public void setTicketArchiviazione(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTicketArchiviazioneTracker = true;
                                       } else {
                                          localTicketArchiviazioneTracker = true;
                                              
                                       }
                                   
                                            this.localTicketArchiviazione=param;
                                    

                               }
                            

                        /**
                        * field for PreviewPng
                        */

                        
                                    protected javax.activation.DataHandler localPreviewPng ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPreviewPngTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getPreviewPng(){
                               return localPreviewPng;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PreviewPng
                               */
                               public void setPreviewPng(javax.activation.DataHandler param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPreviewPngTracker = true;
                                       } else {
                                          localPreviewPngTracker = false;
                                              
                                       }
                                   
                                            this.localPreviewPng=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       DocumentoFascicoloAttoDecreto_type.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://mef.gov.it.v1.demdec.internal/servizi/InterfacciaDocumentaleDEMBILTypes_1");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":documentoFascicoloAttoDecreto_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "documentoFascicoloAttoDecreto_type",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localIdDocumento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IdDocumento cannot be null!!");
                                            }
                                           localIdDocumento.serialize(new javax.xml.namespace.QName("","IdDocumento"),
                                               factory,xmlWriter);
                                        
                                            if (localTipoDocumento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoDocumento cannot be null!!");
                                            }
                                           localTipoDocumento.serialize(new javax.xml.namespace.QName("","TipoDocumento"),
                                               factory,xmlWriter);
                                        
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Descrizione", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Descrizione");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Descrizione");
                                    }
                                

                                          if (localDescrizione==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Descrizione cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescrizione);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataCreazione", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataCreazione");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataCreazione");
                                    }
                                

                                          if (localDataCreazione==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataCreazione cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataCreazione));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMetadatiDocumentoTracker){
                                            if (localMetadatiDocumento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("MetadatiDocumento cannot be null!!");
                                            }
                                           localMetadatiDocumento.serialize(new javax.xml.namespace.QName("","MetadatiDocumento"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"FileName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"FileName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("FileName");
                                    }
                                

                                          if (localFileName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFileName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Hash", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Hash");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Hash");
                                    }
                                
                                        
                                    if (localHash!=null)
                                    {
                                       xmlWriter.writeDataHandler(localHash);
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MimeType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MimeType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MimeType");
                                    }
                                

                                          if (localMimeType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MimeType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMimeType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Length", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Length");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Length");
                                    }
                                
                                               if (localLength==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Length cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLength));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localTipoCompressioneTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"TipoCompressione", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"TipoCompressione");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("TipoCompressione");
                                    }
                                

                                          if (localTipoCompressione==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("TipoCompressione cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTipoCompressione);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Firmato", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Firmato");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Firmato");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Firmato cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirmato));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localValidazioneFirmaTracker){
                                            if (localValidazioneFirma==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ValidazioneFirma cannot be null!!");
                                            }
                                           localValidazioneFirma.serialize(new javax.xml.namespace.QName("","ValidazioneFirma"),
                                               factory,xmlWriter);
                                        }
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Condivisibile", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Condivisibile");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Condivisibile");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Condivisibile cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCondivisibile));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Attivo", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Attivo");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Attivo");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Attivo cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAttivo));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SistemaProduttore", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SistemaProduttore");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SistemaProduttore");
                                    }
                                

                                          if (localSistemaProduttore==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SistemaProduttore cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSistemaProduttore);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsDocumentoOriginale", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsDocumentoOriginale");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsDocumentoOriginale");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsDocumentoOriginale cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsDocumentoOriginale));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsDocumentoTrattato", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsDocumentoTrattato");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsDocumentoTrattato");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsDocumentoTrattato cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsDocumentoTrattato));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDocumentoOrigineTracker){
                                            if (localDocumentoOrigine==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DocumentoOrigine cannot be null!!");
                                            }
                                           localDocumentoOrigine.serialize(new javax.xml.namespace.QName("","DocumentoOrigine"),
                                               factory,xmlWriter);
                                        } if (localOperazioneTracker){
                                            if (localOperazione==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Operazione cannot be null!!");
                                            }
                                           localOperazione.serialize(new javax.xml.namespace.QName("","Operazione"),
                                               factory,xmlWriter);
                                        } if (localTicketArchiviazioneTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"TicketArchiviazione", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"TicketArchiviazione");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("TicketArchiviazione");
                                    }
                                

                                          if (localTicketArchiviazione==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTicketArchiviazione);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPreviewPngTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PreviewPng", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PreviewPng");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PreviewPng");
                                    }
                                
                                        
                                    if (localPreviewPng!=null)
                                    {
                                       xmlWriter.writeDataHandler(localPreviewPng);
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IdDocumento"));
                            
                            
                                    if (localIdDocumento==null){
                                         throw new org.apache.axis2.databinding.ADBException("IdDocumento cannot be null!!");
                                    }
                                    elementList.add(localIdDocumento);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoDocumento"));
                            
                            
                                    if (localTipoDocumento==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoDocumento cannot be null!!");
                                    }
                                    elementList.add(localTipoDocumento);
                                
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Descrizione"));
                                 
                                        if (localDescrizione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescrizione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Descrizione cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataCreazione"));
                                 
                                        if (localDataCreazione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataCreazione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataCreazione cannot be null!!");
                                        }
                                     if (localMetadatiDocumentoTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "MetadatiDocumento"));
                            
                            
                                    if (localMetadatiDocumento==null){
                                         throw new org.apache.axis2.databinding.ADBException("MetadatiDocumento cannot be null!!");
                                    }
                                    elementList.add(localMetadatiDocumento);
                                }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "FileName"));
                                 
                                         elementList.add(localFileName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileName));
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "Hash"));
                                
                            elementList.add(localHash);
                        
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "MimeType"));
                                 
                                        if (localMimeType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMimeType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MimeType cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Length"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLength));
                             if (localTipoCompressioneTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoCompressione"));
                                 
                                        if (localTipoCompressione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTipoCompressione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("TipoCompressione cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Firmato"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirmato));
                             if (localValidazioneFirmaTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ValidazioneFirma"));
                            
                            
                                    if (localValidazioneFirma==null){
                                         throw new org.apache.axis2.databinding.ADBException("ValidazioneFirma cannot be null!!");
                                    }
                                    elementList.add(localValidazioneFirma);
                                }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Condivisibile"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCondivisibile));
                            
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Attivo"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAttivo));
                            
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "SistemaProduttore"));
                                 
                                        if (localSistemaProduttore != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSistemaProduttore));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SistemaProduttore cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "IsDocumentoOriginale"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsDocumentoOriginale));
                            
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "IsDocumentoTrattato"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsDocumentoTrattato));
                             if (localDocumentoOrigineTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DocumentoOrigine"));
                            
                            
                                    if (localDocumentoOrigine==null){
                                         throw new org.apache.axis2.databinding.ADBException("DocumentoOrigine cannot be null!!");
                                    }
                                    elementList.add(localDocumentoOrigine);
                                } if (localOperazioneTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Operazione"));
                            
                            
                                    if (localOperazione==null){
                                         throw new org.apache.axis2.databinding.ADBException("Operazione cannot be null!!");
                                    }
                                    elementList.add(localOperazione);
                                } if (localTicketArchiviazioneTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "TicketArchiviazione"));
                                 
                                         elementList.add(localTicketArchiviazione==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTicketArchiviazione));
                                    } if (localPreviewPngTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "PreviewPng"));
                                
                            elementList.add(localPreviewPng);
                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static DocumentoFascicoloAttoDecreto_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            DocumentoFascicoloAttoDecreto_type object =
                new DocumentoFascicoloAttoDecreto_type();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"documentoFascicoloAttoDecreto_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DocumentoFascicoloAttoDecreto_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdDocumento").equals(reader.getName())){
                                
                                                object.setIdDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoDocumento").equals(reader.getName())){
                                
                                                object.setTipoDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Descrizione").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescrizione(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataCreazione").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataCreazione(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MetadatiDocumento").equals(reader.getName())){
                                
                                                object.setMetadatiDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoMetadataAttoDecreto_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FileName").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFileName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Hash").equals(reader.getName())){
                                reader.next();
                                    if (isReaderMTOMAware(reader)
                                            &&
                                            java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_BINARY)))
                                    {
                                        //MTOM aware reader - get the datahandler directly and put it in the object
                                        object.setHash(
                                                (javax.activation.DataHandler) reader.getProperty(org.apache.axiom.om.OMConstants.DATA_HANDLER));
                                    } else {
                                        if (reader.getEventType() == javax.xml.stream.XMLStreamConstants.START_ELEMENT && reader.getName().equals(new javax.xml.namespace.QName(org.apache.axiom.om.impl.MTOMConstants.XOP_NAMESPACE_URI, org.apache.axiom.om.impl.MTOMConstants.XOP_INCLUDE)))
                                        {
                                            java.lang.String id = org.apache.axiom.om.util.ElementHelper.getContentID(reader, "UTF-8");
                                            object.setHash(((org.apache.axiom.soap.impl.builder.MTOMStAXSOAPModelBuilder) ((org.apache.axiom.om.impl.llom.OMStAXWrapper) reader).getBuilder()).getDataHandler(id));
                                            reader.next();
                                            
                                                reader.next();
                                            
                                        } else if(reader.hasText()) {
                                            //Do the usual conversion
                                            java.lang.String content = reader.getText();
                                            object.setHash(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(content));
                                            
                                                reader.next();
                                            
                                        }
                                    }

                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","MimeType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMimeType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Length").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLength(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoCompressione").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTipoCompressione(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Firmato").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFirmato(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ValidazioneFirma").equals(reader.getName())){
                                
                                                object.setValidazioneFirma(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ValidazioneFirma_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Condivisibile").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCondivisibile(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Attivo").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAttivo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SistemaProduttore").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSistemaProduttore(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IsDocumentoOriginale").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsDocumentoOriginale(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IsDocumentoTrattato").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsDocumentoTrattato(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DocumentoOrigine").equals(reader.getName())){
                                
                                                object.setDocumentoOrigine(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFile_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Operazione").equals(reader.getName())){
                                
                                                object.setOperazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.OperazioneDocumentale_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TicketArchiviazione").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTicketArchiviazione(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PreviewPng").equals(reader.getName())){
                                reader.next();
                                    if (isReaderMTOMAware(reader)
                                            &&
                                            java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_BINARY)))
                                    {
                                        //MTOM aware reader - get the datahandler directly and put it in the object
                                        object.setPreviewPng(
                                                (javax.activation.DataHandler) reader.getProperty(org.apache.axiom.om.OMConstants.DATA_HANDLER));
                                    } else {
                                        if (reader.getEventType() == javax.xml.stream.XMLStreamConstants.START_ELEMENT && reader.getName().equals(new javax.xml.namespace.QName(org.apache.axiom.om.impl.MTOMConstants.XOP_NAMESPACE_URI, org.apache.axiom.om.impl.MTOMConstants.XOP_INCLUDE)))
                                        {
                                            java.lang.String id = org.apache.axiom.om.util.ElementHelper.getContentID(reader, "UTF-8");
                                            object.setPreviewPng(((org.apache.axiom.soap.impl.builder.MTOMStAXSOAPModelBuilder) ((org.apache.axiom.om.impl.llom.OMStAXWrapper) reader).getBuilder()).getDataHandler(id));
                                            reader.next();
                                            
                                                reader.next();
                                            
                                        } else if(reader.hasText()) {
                                            //Do the usual conversion
                                            java.lang.String content = reader.getText();
                                            object.setPreviewPng(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(content));
                                            
                                                reader.next();
                                            
                                        }
                                    }

                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          