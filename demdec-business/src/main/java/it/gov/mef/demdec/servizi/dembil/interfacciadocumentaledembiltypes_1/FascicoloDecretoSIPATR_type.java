
/**
 * FascicoloDecretoSIPATR_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  FascicoloDecretoSIPATR_type bean class
            */
        
        public  class FascicoloDecretoSIPATR_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = fascicoloDecretoSIPATR_type
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
                        * field for IdFascicoloDecretoSIPATR
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid localIdFascicoloDecretoSIPATR ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid getIdFascicoloDecretoSIPATR(){
                               return localIdFascicoloDecretoSIPATR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdFascicoloDecretoSIPATR
                               */
                               public void setIdFascicoloDecretoSIPATR(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid param){
                            
                                            this.localIdFascicoloDecretoSIPATR=param;
                                    

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
                        * field for DatiFascicolo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataDecretoSIPATR_type localDatiFascicolo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDatiFascicoloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataDecretoSIPATR_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataDecretoSIPATR_type getDatiFascicolo(){
                               return localDatiFascicolo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DatiFascicolo
                               */
                               public void setDatiFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataDecretoSIPATR_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDatiFascicoloTracker = true;
                                       } else {
                                          localDatiFascicoloTracker = false;
                                              
                                       }
                                   
                                            this.localDatiFascicolo=param;
                                    

                               }
                            

                        /**
                        * field for FascicoliSIPATR
                        * This was an Array!
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[] localFascicoliSIPATR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFascicoliSIPATRTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[]
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[] getFascicoliSIPATR(){
                               return localFascicoliSIPATR;
                           }

                           
                        


                               
                              /**
                               * validate the array for FascicoliSIPATR
                               */
                              protected void validateFascicoliSIPATR(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param FascicoliSIPATR
                              */
                              public void setFascicoliSIPATR(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[] param){
                              
                                   validateFascicoliSIPATR(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localFascicoliSIPATRTracker = true;
                                          } else {
                                             localFascicoliSIPATRTracker = false;
                                                 
                                          }
                                      
                                      this.localFascicoliSIPATR=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type
                             */
                             public void addFascicoliSIPATR(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type param){
                                   if (localFascicoliSIPATR == null){
                                   localFascicoliSIPATR = new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[]{};
                                   }

                            
                                 //update the setting tracker
                                localFascicoliSIPATRTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localFascicoliSIPATR);
                               list.add(param);
                               this.localFascicoliSIPATR =
                             (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[])list.toArray(
                            new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[list.size()]);

                             }
                             

                        /**
                        * field for StatoFascicoloDocumentale
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type localStatoFascicoloDocumentale ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type getStatoFascicoloDocumentale(){
                               return localStatoFascicoloDocumentale;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatoFascicoloDocumentale
                               */
                               public void setStatoFascicoloDocumentale(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type param){
                            
                                            this.localStatoFascicoloDocumentale=param;
                                    

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
                        * field for DataAggiornamento
                        */

                        
                                    protected java.util.Calendar localDataAggiornamento ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDataAggiornamento(){
                               return localDataAggiornamento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataAggiornamento
                               */
                               public void setDataAggiornamento(java.util.Calendar param){
                            
                                            this.localDataAggiornamento=param;
                                    

                               }
                            

                        /**
                        * field for DataChiusura
                        */

                        
                                    protected java.util.Calendar localDataChiusura ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataChiusuraTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDataChiusura(){
                               return localDataChiusura;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataChiusura
                               */
                               public void setDataChiusura(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataChiusuraTracker = true;
                                       } else {
                                          localDataChiusuraTracker = false;
                                              
                                       }
                                   
                                            this.localDataChiusura=param;
                                    

                               }
                            

                        /**
                        * field for DaInviare
                        */

                        
                                    protected boolean localDaInviare =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("true");
                                

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getDaInviare(){
                               return localDaInviare;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DaInviare
                               */
                               public void setDaInviare(boolean param){
                            
                                            this.localDaInviare=param;
                                    

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
                       FascicoloDecretoSIPATR_type.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":fascicoloDecretoSIPATR_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "fascicoloDecretoSIPATR_type",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localIdFascicoloDecretoSIPATR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IdFascicoloDecretoSIPATR cannot be null!!");
                                            }
                                           localIdFascicoloDecretoSIPATR.serialize(new javax.xml.namespace.QName("","IdFascicoloDecretoSIPATR"),
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
                              if (localDatiFascicoloTracker){
                                            if (localDatiFascicolo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DatiFascicolo cannot be null!!");
                                            }
                                           localDatiFascicolo.serialize(new javax.xml.namespace.QName("","DatiFascicolo"),
                                               factory,xmlWriter);
                                        } if (localFascicoliSIPATRTracker){
                                       if (localFascicoliSIPATR!=null){
                                            for (int i = 0;i < localFascicoliSIPATR.length;i++){
                                                if (localFascicoliSIPATR[i] != null){
                                                 localFascicoliSIPATR[i].serialize(new javax.xml.namespace.QName("","FascicoliSIPATR"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("FascicoliSIPATR cannot be null!!");
                                        
                                    }
                                 }
                                            if (localStatoFascicoloDocumentale==null){
                                                 throw new org.apache.axis2.databinding.ADBException("StatoFascicoloDocumentale cannot be null!!");
                                            }
                                           localStatoFascicoloDocumentale.serialize(new javax.xml.namespace.QName("","StatoFascicoloDocumentale"),
                                               factory,xmlWriter);
                                        
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
                             
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataAggiornamento", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataAggiornamento");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataAggiornamento");
                                    }
                                

                                          if (localDataAggiornamento==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataAggiornamento cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamento));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDataChiusuraTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataChiusura", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataChiusura");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataChiusura");
                                    }
                                

                                          if (localDataChiusura==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataChiusura cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataChiusura));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DaInviare", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DaInviare");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DaInviare");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DaInviare cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDaInviare));
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
                                                                      "IdFascicoloDecretoSIPATR"));
                            
                            
                                    if (localIdFascicoloDecretoSIPATR==null){
                                         throw new org.apache.axis2.databinding.ADBException("IdFascicoloDecretoSIPATR cannot be null!!");
                                    }
                                    elementList.add(localIdFascicoloDecretoSIPATR);
                                
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Descrizione"));
                                 
                                        if (localDescrizione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescrizione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Descrizione cannot be null!!");
                                        }
                                     if (localDatiFascicoloTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DatiFascicolo"));
                            
                            
                                    if (localDatiFascicolo==null){
                                         throw new org.apache.axis2.databinding.ADBException("DatiFascicolo cannot be null!!");
                                    }
                                    elementList.add(localDatiFascicolo);
                                } if (localFascicoliSIPATRTracker){
                             if (localFascicoliSIPATR!=null) {
                                 for (int i = 0;i < localFascicoliSIPATR.length;i++){

                                    if (localFascicoliSIPATR[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "FascicoliSIPATR"));
                                         elementList.add(localFascicoliSIPATR[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("FascicoliSIPATR cannot be null!!");
                                    
                             }

                        }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "StatoFascicoloDocumentale"));
                            
                            
                                    if (localStatoFascicoloDocumentale==null){
                                         throw new org.apache.axis2.databinding.ADBException("StatoFascicoloDocumentale cannot be null!!");
                                    }
                                    elementList.add(localStatoFascicoloDocumentale);
                                
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataCreazione"));
                                 
                                        if (localDataCreazione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataCreazione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataCreazione cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataAggiornamento"));
                                 
                                        if (localDataAggiornamento != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamento));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataAggiornamento cannot be null!!");
                                        }
                                     if (localDataChiusuraTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataChiusura"));
                                 
                                        if (localDataChiusura != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataChiusura));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataChiusura cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DaInviare"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDaInviare));
                            
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
        public static FascicoloDecretoSIPATR_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            FascicoloDecretoSIPATR_type object =
                new FascicoloDecretoSIPATR_type();

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
                    
                            if (!"fascicoloDecretoSIPATR_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FascicoloDecretoSIPATR_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdFascicoloDecretoSIPATR").equals(reader.getName())){
                                
                                                object.setIdFascicoloDecretoSIPATR(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid.Factory.parse(reader));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DatiFascicolo").equals(reader.getName())){
                                
                                                object.setDatiFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataDecretoSIPATR_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FascicoliSIPATR").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list4.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","FascicoliSIPATR").equals(reader.getName())){
                                                                    list4.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setFascicoliSIPATR((it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","StatoFascicoloDocumentale").equals(reader.getName())){
                                
                                                object.setStatoFascicoloDocumentale(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type.Factory.parse(reader));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataAggiornamento").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataAggiornamento(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataChiusura").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataChiusura(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DaInviare").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDaInviare(
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
           
          