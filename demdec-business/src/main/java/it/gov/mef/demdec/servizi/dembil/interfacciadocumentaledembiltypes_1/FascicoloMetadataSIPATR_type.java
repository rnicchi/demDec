
/**
 * FascicoloMetadataSIPATR_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  FascicoloMetadataSIPATR_type bean class
            */
        
        public  class FascicoloMetadataSIPATR_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = fascicoloMetadataSIPATR_type
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
                        * field for IdentificativoSIPATR
                        */

                        
                                    protected java.lang.String localIdentificativoSIPATR ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdentificativoSIPATR(){
                               return localIdentificativoSIPATR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentificativoSIPATR
                               */
                               public void setIdentificativoSIPATR(java.lang.String param){
                            
                                            this.localIdentificativoSIPATR=param;
                                    

                               }
                            

                        /**
                        * field for Amministrazione
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localAmministrazione ;
                                

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
                            
                                            this.localAmministrazione=param;
                                    

                               }
                            

                        /**
                        * field for Ragioneria
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localRagioneria ;
                                

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
                            
                                            this.localRagioneria=param;
                                    

                               }
                            

                        /**
                        * field for Titolo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localTitolo ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type getTitolo(){
                               return localTitolo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Titolo
                               */
                               public void setTitolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type param){
                            
                                            this.localTitolo=param;
                                    

                               }
                            

                        /**
                        * field for StatoFascicoloSIPATR
                        */

                        
                                    protected java.lang.String localStatoFascicoloSIPATR ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStatoFascicoloSIPATR(){
                               return localStatoFascicoloSIPATR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatoFascicoloSIPATR
                               */
                               public void setStatoFascicoloSIPATR(java.lang.String param){
                            
                                            this.localStatoFascicoloSIPATR=param;
                                    

                               }
                            

                        /**
                        * field for DataChiusuraFascicoloSIPATR
                        */

                        
                                    protected java.util.Date localDataChiusuraFascicoloSIPATR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataChiusuraFascicoloSIPATRTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getDataChiusuraFascicoloSIPATR(){
                               return localDataChiusuraFascicoloSIPATR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataChiusuraFascicoloSIPATR
                               */
                               public void setDataChiusuraFascicoloSIPATR(java.util.Date param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataChiusuraFascicoloSIPATRTracker = true;
                                       } else {
                                          localDataChiusuraFascicoloSIPATRTracker = false;
                                              
                                       }
                                   
                                            this.localDataChiusuraFascicoloSIPATR=param;
                                    

                               }
                            

                        /**
                        * field for Metadata
                        */

                        
                                    protected javax.activation.DataHandler localMetadata ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMetadataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getMetadata(){
                               return localMetadata;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Metadata
                               */
                               public void setMetadata(javax.activation.DataHandler param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMetadataTracker = true;
                                       } else {
                                          localMetadataTracker = false;
                                              
                                       }
                                   
                                            this.localMetadata=param;
                                    

                               }
                            

                        /**
                        * field for VersioneMetadata
                        */

                        
                                    protected java.lang.String localVersioneMetadata ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVersioneMetadataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVersioneMetadata(){
                               return localVersioneMetadata;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VersioneMetadata
                               */
                               public void setVersioneMetadata(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVersioneMetadataTracker = true;
                                       } else {
                                          localVersioneMetadataTracker = false;
                                              
                                       }
                                   
                                            this.localVersioneMetadata=param;
                                    

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
                       FascicoloMetadataSIPATR_type.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":fascicoloMetadataSIPATR_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "fascicoloMetadataSIPATR_type",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IdentificativoSIPATR", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IdentificativoSIPATR");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IdentificativoSIPATR");
                                    }
                                

                                          if (localIdentificativoSIPATR==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IdentificativoSIPATR cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdentificativoSIPATR);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localAmministrazione==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                            }
                                           localAmministrazione.serialize(new javax.xml.namespace.QName("","Amministrazione"),
                                               factory,xmlWriter);
                                        
                                            if (localRagioneria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                            }
                                           localRagioneria.serialize(new javax.xml.namespace.QName("","Ragioneria"),
                                               factory,xmlWriter);
                                        
                                            if (localTitolo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Titolo cannot be null!!");
                                            }
                                           localTitolo.serialize(new javax.xml.namespace.QName("","Titolo"),
                                               factory,xmlWriter);
                                        
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"StatoFascicoloSIPATR", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"StatoFascicoloSIPATR");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("StatoFascicoloSIPATR");
                                    }
                                

                                          if (localStatoFascicoloSIPATR==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("StatoFascicoloSIPATR cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStatoFascicoloSIPATR);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDataChiusuraFascicoloSIPATRTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataChiusuraFascicoloSIPATR", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataChiusuraFascicoloSIPATR");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataChiusuraFascicoloSIPATR");
                                    }
                                

                                          if (localDataChiusuraFascicoloSIPATR==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataChiusuraFascicoloSIPATR cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataChiusuraFascicoloSIPATR));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMetadataTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Metadata", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Metadata");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Metadata");
                                    }
                                
                                        
                                    if (localMetadata!=null)
                                    {
                                       xmlWriter.writeDataHandler(localMetadata);
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             } if (localVersioneMetadataTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"VersioneMetadata", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"VersioneMetadata");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("VersioneMetadata");
                                    }
                                

                                          if (localVersioneMetadata==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("VersioneMetadata cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVersioneMetadata);
                                            
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
                                                                      "IdentificativoSIPATR"));
                                 
                                        if (localIdentificativoSIPATR != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdentificativoSIPATR));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("IdentificativoSIPATR cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Amministrazione"));
                            
                            
                                    if (localAmministrazione==null){
                                         throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                    }
                                    elementList.add(localAmministrazione);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ragioneria"));
                            
                            
                                    if (localRagioneria==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                    }
                                    elementList.add(localRagioneria);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Titolo"));
                            
                            
                                    if (localTitolo==null){
                                         throw new org.apache.axis2.databinding.ADBException("Titolo cannot be null!!");
                                    }
                                    elementList.add(localTitolo);
                                
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "StatoFascicoloSIPATR"));
                                 
                                        if (localStatoFascicoloSIPATR != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatoFascicoloSIPATR));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("StatoFascicoloSIPATR cannot be null!!");
                                        }
                                     if (localDataChiusuraFascicoloSIPATRTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataChiusuraFascicoloSIPATR"));
                                 
                                        if (localDataChiusuraFascicoloSIPATR != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataChiusuraFascicoloSIPATR));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataChiusuraFascicoloSIPATR cannot be null!!");
                                        }
                                    } if (localMetadataTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "Metadata"));
                                
                            elementList.add(localMetadata);
                        } if (localVersioneMetadataTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "VersioneMetadata"));
                                 
                                        if (localVersioneMetadata != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVersioneMetadata));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("VersioneMetadata cannot be null!!");
                                        }
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
        public static FascicoloMetadataSIPATR_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            FascicoloMetadataSIPATR_type object =
                new FascicoloMetadataSIPATR_type();

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
                    
                            if (!"fascicoloMetadataSIPATR_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FascicoloMetadataSIPATR_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdentificativoSIPATR").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdentificativoSIPATR(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Amministrazione").equals(reader.getName())){
                                
                                                object.setAmministrazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Ragioneria").equals(reader.getName())){
                                
                                                object.setRagioneria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Titolo").equals(reader.getName())){
                                
                                                object.setTitolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","StatoFascicoloSIPATR").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStatoFascicoloSIPATR(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataChiusuraFascicoloSIPATR").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataChiusuraFascicoloSIPATR(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Metadata").equals(reader.getName())){
                                reader.next();
                                    if (isReaderMTOMAware(reader)
                                            &&
                                            java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_BINARY)))
                                    {
                                        //MTOM aware reader - get the datahandler directly and put it in the object
                                        object.setMetadata(
                                                (javax.activation.DataHandler) reader.getProperty(org.apache.axiom.om.OMConstants.DATA_HANDLER));
                                    } else {
                                        if (reader.getEventType() == javax.xml.stream.XMLStreamConstants.START_ELEMENT && reader.getName().equals(new javax.xml.namespace.QName(org.apache.axiom.om.impl.MTOMConstants.XOP_NAMESPACE_URI, org.apache.axiom.om.impl.MTOMConstants.XOP_INCLUDE)))
                                        {
                                            java.lang.String id = org.apache.axiom.om.util.ElementHelper.getContentID(reader, "UTF-8");
                                            object.setMetadata(((org.apache.axiom.soap.impl.builder.MTOMStAXSOAPModelBuilder) ((org.apache.axiom.om.impl.llom.OMStAXWrapper) reader).getBuilder()).getDataHandler(id));
                                            reader.next();
                                            
                                                reader.next();
                                            
                                        } else if(reader.hasText()) {
                                            //Do the usual conversion
                                            java.lang.String content = reader.getText();
                                            object.setMetadata(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(content));
                                            
                                                reader.next();
                                            
                                        }
                                    }

                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","VersioneMetadata").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVersioneMetadata(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
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
           
          