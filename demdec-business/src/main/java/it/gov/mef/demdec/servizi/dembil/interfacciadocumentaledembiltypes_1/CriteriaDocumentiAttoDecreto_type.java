
/**
 * CriteriaDocumentiAttoDecreto_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  CriteriaDocumentiAttoDecreto_type bean class
            */
        
        public  class CriteriaDocumentiAttoDecreto_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = criteriaDocumentiAttoDecreto_type
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
                        * field for TipoEstrazioneElenco
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type localTipoEstrazioneElenco ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type getTipoEstrazioneElenco(){
                               return localTipoEstrazioneElenco;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoEstrazioneElenco
                               */
                               public void setTipoEstrazioneElenco(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type param){
                            
                                            this.localTipoEstrazioneElenco=param;
                                    

                               }
                            

                        /**
                        * field for TipoElenco
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoElenco_type localTipoElenco ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoElenco_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoElenco_type getTipoElenco(){
                               return localTipoElenco;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoElenco
                               */
                               public void setTipoElenco(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoElenco_type param){
                            
                                            this.localTipoElenco=param;
                                    

                               }
                            

                        /**
                        * field for TipoDocumento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoDocumento_type localTipoDocumento ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTipoDocumentoTracker = false ;
                           

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
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTipoDocumentoTracker = true;
                                       } else {
                                          localTipoDocumentoTracker = false;
                                              
                                       }
                                   
                                            this.localTipoDocumento=param;
                                    

                               }
                            

                        /**
                        * field for Amministrazione
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localAmministrazione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAmministrazioneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type getAmministrazione(){
                               return localAmministrazione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Amministrazione
                               */
                               public void setAmministrazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAmministrazioneTracker = true;
                                       } else {
                                          localAmministrazioneTracker = false;
                                              
                                       }
                                   
                                            this.localAmministrazione=param;
                                    

                               }
                            

                        /**
                        * field for Ragioneria
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localRagioneria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRagioneriaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type getRagioneria(){
                               return localRagioneria;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ragioneria
                               */
                               public void setRagioneria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRagioneriaTracker = true;
                                       } else {
                                          localRagioneriaTracker = false;
                                              
                                       }
                                   
                                            this.localRagioneria=param;
                                    

                               }
                            

                        /**
                        * field for DataCreazione
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type localDataCreazione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataCreazioneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type getDataCreazione(){
                               return localDataCreazione;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataCreazione
                               */
                               public void setDataCreazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataCreazioneTracker = true;
                                       } else {
                                          localDataCreazioneTracker = false;
                                              
                                       }
                                   
                                            this.localDataCreazione=param;
                                    

                               }
                            

                        /**
                        * field for DataDocumento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type localDataDocumento ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataDocumentoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type getDataDocumento(){
                               return localDataDocumento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataDocumento
                               */
                               public void setDataDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataDocumentoTracker = true;
                                       } else {
                                          localDataDocumentoTracker = false;
                                              
                                       }
                                   
                                            this.localDataDocumento=param;
                                    

                               }
                            

                        /**
                        * field for Protocollo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type localProtocollo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProtocolloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type getProtocollo(){
                               return localProtocollo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Protocollo
                               */
                               public void setProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localProtocolloTracker = true;
                                       } else {
                                          localProtocolloTracker = false;
                                              
                                       }
                                   
                                            this.localProtocollo=param;
                                    

                               }
                            

                        /**
                        * field for ShowPreview
                        */

                        
                                    protected boolean localShowPreview =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("false");
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShowPreviewTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getShowPreview(){
                               return localShowPreview;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShowPreview
                               */
                               public void setShowPreview(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localShowPreviewTracker = false;
                                              
                                       } else {
                                          localShowPreviewTracker = true;
                                       }
                                   
                                            this.localShowPreview=param;
                                    

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
                       CriteriaDocumentiAttoDecreto_type.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":criteriaDocumentiAttoDecreto_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "criteriaDocumentiAttoDecreto_type",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localTipoEstrazioneElenco==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneElenco cannot be null!!");
                                            }
                                           localTipoEstrazioneElenco.serialize(new javax.xml.namespace.QName("","TipoEstrazioneElenco"),
                                               factory,xmlWriter);
                                        
                                            if (localTipoElenco==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoElenco cannot be null!!");
                                            }
                                           localTipoElenco.serialize(new javax.xml.namespace.QName("","TipoElenco"),
                                               factory,xmlWriter);
                                         if (localTipoDocumentoTracker){
                                            if (localTipoDocumento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoDocumento cannot be null!!");
                                            }
                                           localTipoDocumento.serialize(new javax.xml.namespace.QName("","TipoDocumento"),
                                               factory,xmlWriter);
                                        } if (localAmministrazioneTracker){
                                            if (localAmministrazione==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                            }
                                           localAmministrazione.serialize(new javax.xml.namespace.QName("","Amministrazione"),
                                               factory,xmlWriter);
                                        } if (localRagioneriaTracker){
                                            if (localRagioneria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                            }
                                           localRagioneria.serialize(new javax.xml.namespace.QName("","Ragioneria"),
                                               factory,xmlWriter);
                                        } if (localDataCreazioneTracker){
                                            if (localDataCreazione==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DataCreazione cannot be null!!");
                                            }
                                           localDataCreazione.serialize(new javax.xml.namespace.QName("","DataCreazione"),
                                               factory,xmlWriter);
                                        } if (localDataDocumentoTracker){
                                            if (localDataDocumento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DataDocumento cannot be null!!");
                                            }
                                           localDataDocumento.serialize(new javax.xml.namespace.QName("","DataDocumento"),
                                               factory,xmlWriter);
                                        } if (localProtocolloTracker){
                                            if (localProtocollo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Protocollo cannot be null!!");
                                            }
                                           localProtocollo.serialize(new javax.xml.namespace.QName("","Protocollo"),
                                               factory,xmlWriter);
                                        } if (localShowPreviewTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ShowPreview", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ShowPreview");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ShowPreview");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ShowPreview cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowPreview));
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
                                                                      "TipoEstrazioneElenco"));
                            
                            
                                    if (localTipoEstrazioneElenco==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneElenco cannot be null!!");
                                    }
                                    elementList.add(localTipoEstrazioneElenco);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoElenco"));
                            
                            
                                    if (localTipoElenco==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoElenco cannot be null!!");
                                    }
                                    elementList.add(localTipoElenco);
                                 if (localTipoDocumentoTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoDocumento"));
                            
                            
                                    if (localTipoDocumento==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoDocumento cannot be null!!");
                                    }
                                    elementList.add(localTipoDocumento);
                                } if (localAmministrazioneTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Amministrazione"));
                            
                            
                                    if (localAmministrazione==null){
                                         throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                    }
                                    elementList.add(localAmministrazione);
                                } if (localRagioneriaTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ragioneria"));
                            
                            
                                    if (localRagioneria==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                    }
                                    elementList.add(localRagioneria);
                                } if (localDataCreazioneTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataCreazione"));
                            
                            
                                    if (localDataCreazione==null){
                                         throw new org.apache.axis2.databinding.ADBException("DataCreazione cannot be null!!");
                                    }
                                    elementList.add(localDataCreazione);
                                } if (localDataDocumentoTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataDocumento"));
                            
                            
                                    if (localDataDocumento==null){
                                         throw new org.apache.axis2.databinding.ADBException("DataDocumento cannot be null!!");
                                    }
                                    elementList.add(localDataDocumento);
                                } if (localProtocolloTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Protocollo"));
                            
                            
                                    if (localProtocollo==null){
                                         throw new org.apache.axis2.databinding.ADBException("Protocollo cannot be null!!");
                                    }
                                    elementList.add(localProtocollo);
                                } if (localShowPreviewTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "ShowPreview"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowPreview));
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
        public static CriteriaDocumentiAttoDecreto_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            CriteriaDocumentiAttoDecreto_type object =
                new CriteriaDocumentiAttoDecreto_type();

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
                    
                            if (!"criteriaDocumentiAttoDecreto_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CriteriaDocumentiAttoDecreto_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoEstrazioneElenco").equals(reader.getName())){
                                
                                                object.setTipoEstrazioneElenco(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoElenco").equals(reader.getName())){
                                
                                                object.setTipoElenco(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoElenco_type.Factory.parse(reader));
                                              
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
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Amministrazione").equals(reader.getName())){
                                
                                                object.setAmministrazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ragioneria").equals(reader.getName())){
                                
                                                object.setRagioneria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataCreazione").equals(reader.getName())){
                                
                                                object.setDataCreazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataDocumento").equals(reader.getName())){
                                
                                                object.setDataDocumento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Protocollo").equals(reader.getName())){
                                
                                                object.setProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Protocollo_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ShowPreview").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShowPreview(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
           
          