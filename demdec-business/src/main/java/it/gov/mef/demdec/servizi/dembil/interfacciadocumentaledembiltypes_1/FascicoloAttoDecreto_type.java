
/**
 * FascicoloAttoDecreto_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  FascicoloAttoDecreto_type bean class
            */
        
        public  class FascicoloAttoDecreto_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = fascicoloAttoDecreto_type
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
                        * field for IdFascicoloAttoDecreto
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid localIdFascicoloAttoDecreto ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid getIdFascicoloAttoDecreto(){
                               return localIdFascicoloAttoDecreto;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdFascicoloAttoDecreto
                               */
                               public void setIdFascicoloAttoDecreto(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid param){
                            
                                            this.localIdFascicoloAttoDecreto=param;
                                    

                               }
                            

                        /**
                        * field for IdFascicoloAttoDecretoParent
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid localIdFascicoloAttoDecretoParent ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdFascicoloAttoDecretoParentTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid getIdFascicoloAttoDecretoParent(){
                               return localIdFascicoloAttoDecretoParent;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdFascicoloAttoDecretoParent
                               */
                               public void setIdFascicoloAttoDecretoParent(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIdFascicoloAttoDecretoParentTracker = true;
                                       } else {
                                          localIdFascicoloAttoDecretoParentTracker = false;
                                              
                                       }
                                   
                                            this.localIdFascicoloAttoDecretoParent=param;
                                    

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

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type localDatiFascicolo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDatiFascicoloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type getDatiFascicolo(){
                               return localDatiFascicolo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DatiFascicolo
                               */
                               public void setDatiFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDatiFascicoloTracker = true;
                                       } else {
                                          localDatiFascicoloTracker = false;
                                              
                                       }
                                   
                                            this.localDatiFascicolo=param;
                                    

                               }
                            

                        /**
                        * field for Documenti
                        * This was an Array!
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[] localDocumenti ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocumentiTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[]
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[] getDocumenti(){
                               return localDocumenti;
                           }

                           
                        


                               
                              /**
                               * validate the array for Documenti
                               */
                              protected void validateDocumenti(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Documenti
                              */
                              public void setDocumenti(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[] param){
                              
                                   validateDocumenti(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localDocumentiTracker = true;
                                          } else {
                                             localDocumentiTracker = false;
                                                 
                                          }
                                      
                                      this.localDocumenti=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type
                             */
                             public void addDocumenti(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type param){
                                   if (localDocumenti == null){
                                   localDocumenti = new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[]{};
                                   }

                            
                                 //update the setting tracker
                                localDocumentiTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localDocumenti);
                               list.add(param);
                               this.localDocumenti =
                             (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[])list.toArray(
                            new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[list.size()]);

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
                        * field for AllegatiDecretoIGB
                        * This was an Array!
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[] localAllegatiDecretoIGB ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAllegatiDecretoIGBTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[]
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[] getAllegatiDecretoIGB(){
                               return localAllegatiDecretoIGB;
                           }

                           
                        


                               
                              /**
                               * validate the array for AllegatiDecretoIGB
                               */
                              protected void validateAllegatiDecretoIGB(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param AllegatiDecretoIGB
                              */
                              public void setAllegatiDecretoIGB(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[] param){
                              
                                   validateAllegatiDecretoIGB(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localAllegatiDecretoIGBTracker = true;
                                          } else {
                                             localAllegatiDecretoIGBTracker = false;
                                                 
                                          }
                                      
                                      this.localAllegatiDecretoIGB=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type
                             */
                             public void addAllegatiDecretoIGB(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type param){
                                   if (localAllegatiDecretoIGB == null){
                                   localAllegatiDecretoIGB = new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[]{};
                                   }

                            
                                 //update the setting tracker
                                localAllegatiDecretoIGBTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localAllegatiDecretoIGB);
                               list.add(param);
                               this.localAllegatiDecretoIGB =
                             (it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[])list.toArray(
                            new it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[list.size()]);

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
                        * field for DataAggiornamentoAttoDecreto
                        */

                        
                                    protected java.util.Calendar localDataAggiornamentoAttoDecreto ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDataAggiornamentoAttoDecreto(){
                               return localDataAggiornamentoAttoDecreto;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataAggiornamentoAttoDecreto
                               */
                               public void setDataAggiornamentoAttoDecreto(java.util.Calendar param){
                            
                                            this.localDataAggiornamentoAttoDecreto=param;
                                    

                               }
                            

                        /**
                        * field for DataAggiornamentoSIPATR
                        */

                        
                                    protected java.util.Calendar localDataAggiornamentoSIPATR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataAggiornamentoSIPATRTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDataAggiornamentoSIPATR(){
                               return localDataAggiornamentoSIPATR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataAggiornamentoSIPATR
                               */
                               public void setDataAggiornamentoSIPATR(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataAggiornamentoSIPATRTracker = true;
                                       } else {
                                          localDataAggiornamentoSIPATRTracker = false;
                                              
                                       }
                                   
                                            this.localDataAggiornamentoSIPATR=param;
                                    

                               }
                            

                        /**
                        * field for DataAggiornamentoFascicoloIGB
                        */

                        
                                    protected java.util.Calendar localDataAggiornamentoFascicoloIGB ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataAggiornamentoFascicoloIGBTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getDataAggiornamentoFascicoloIGB(){
                               return localDataAggiornamentoFascicoloIGB;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataAggiornamentoFascicoloIGB
                               */
                               public void setDataAggiornamentoFascicoloIGB(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataAggiornamentoFascicoloIGBTracker = true;
                                       } else {
                                          localDataAggiornamentoFascicoloIGBTracker = false;
                                              
                                       }
                                   
                                            this.localDataAggiornamentoFascicoloIGB=param;
                                    

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
                       FascicoloAttoDecreto_type.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":fascicoloAttoDecreto_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "fascicoloAttoDecreto_type",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localIdFascicoloAttoDecreto==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IdFascicoloAttoDecreto cannot be null!!");
                                            }
                                           localIdFascicoloAttoDecreto.serialize(new javax.xml.namespace.QName("","IdFascicoloAttoDecreto"),
                                               factory,xmlWriter);
                                         if (localIdFascicoloAttoDecretoParentTracker){
                                            if (localIdFascicoloAttoDecretoParent==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IdFascicoloAttoDecretoParent cannot be null!!");
                                            }
                                           localIdFascicoloAttoDecretoParent.serialize(new javax.xml.namespace.QName("","IdFascicoloAttoDecretoParent"),
                                               factory,xmlWriter);
                                        }
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
                                        } if (localDocumentiTracker){
                                       if (localDocumenti!=null){
                                            for (int i = 0;i < localDocumenti.length;i++){
                                                if (localDocumenti[i] != null){
                                                 localDocumenti[i].serialize(new javax.xml.namespace.QName("","Documenti"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("Documenti cannot be null!!");
                                        
                                    }
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
                                 } if (localAllegatiDecretoIGBTracker){
                                       if (localAllegatiDecretoIGB!=null){
                                            for (int i = 0;i < localAllegatiDecretoIGB.length;i++){
                                                if (localAllegatiDecretoIGB[i] != null){
                                                 localAllegatiDecretoIGB[i].serialize(new javax.xml.namespace.QName("","AllegatiDecretoIGB"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("AllegatiDecretoIGB cannot be null!!");
                                        
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

                                            xmlWriter.writeStartElement(prefix,"DataAggiornamentoAttoDecreto", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataAggiornamentoAttoDecreto");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataAggiornamentoAttoDecreto");
                                    }
                                

                                          if (localDataAggiornamentoAttoDecreto==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoAttoDecreto cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoAttoDecreto));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDataAggiornamentoSIPATRTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataAggiornamentoSIPATR", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataAggiornamentoSIPATR");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataAggiornamentoSIPATR");
                                    }
                                

                                          if (localDataAggiornamentoSIPATR==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoSIPATR cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoSIPATR));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDataAggiornamentoFascicoloIGBTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DataAggiornamentoFascicoloIGB", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DataAggiornamentoFascicoloIGB");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DataAggiornamentoFascicoloIGB");
                                    }
                                

                                          if (localDataAggiornamentoFascicoloIGB==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoFascicoloIGB cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoFascicoloIGB));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDataChiusuraTracker){
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
                                                                      "IdFascicoloAttoDecreto"));
                            
                            
                                    if (localIdFascicoloAttoDecreto==null){
                                         throw new org.apache.axis2.databinding.ADBException("IdFascicoloAttoDecreto cannot be null!!");
                                    }
                                    elementList.add(localIdFascicoloAttoDecreto);
                                 if (localIdFascicoloAttoDecretoParentTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IdFascicoloAttoDecretoParent"));
                            
                            
                                    if (localIdFascicoloAttoDecretoParent==null){
                                         throw new org.apache.axis2.databinding.ADBException("IdFascicoloAttoDecretoParent cannot be null!!");
                                    }
                                    elementList.add(localIdFascicoloAttoDecretoParent);
                                }
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
                                } if (localDocumentiTracker){
                             if (localDocumenti!=null) {
                                 for (int i = 0;i < localDocumenti.length;i++){

                                    if (localDocumenti[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "Documenti"));
                                         elementList.add(localDocumenti[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("Documenti cannot be null!!");
                                    
                             }

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

                        } if (localAllegatiDecretoIGBTracker){
                             if (localAllegatiDecretoIGB!=null) {
                                 for (int i = 0;i < localAllegatiDecretoIGB.length;i++){

                                    if (localAllegatiDecretoIGB[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "AllegatiDecretoIGB"));
                                         elementList.add(localAllegatiDecretoIGB[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("AllegatiDecretoIGB cannot be null!!");
                                    
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
                                                                      "DataAggiornamentoAttoDecreto"));
                                 
                                        if (localDataAggiornamentoAttoDecreto != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoAttoDecreto));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoAttoDecreto cannot be null!!");
                                        }
                                     if (localDataAggiornamentoSIPATRTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataAggiornamentoSIPATR"));
                                 
                                        if (localDataAggiornamentoSIPATR != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoSIPATR));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoSIPATR cannot be null!!");
                                        }
                                    } if (localDataAggiornamentoFascicoloIGBTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataAggiornamentoFascicoloIGB"));
                                 
                                        if (localDataAggiornamentoFascicoloIGB != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDataAggiornamentoFascicoloIGB));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DataAggiornamentoFascicoloIGB cannot be null!!");
                                        }
                                    } if (localDataChiusuraTracker){
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
        public static FascicoloAttoDecreto_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            FascicoloAttoDecreto_type object =
                new FascicoloAttoDecreto_type();

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
                    
                            if (!"fascicoloAttoDecreto_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FascicoloAttoDecreto_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list5 = new java.util.ArrayList();
                    
                        java.util.ArrayList list6 = new java.util.ArrayList();
                    
                        java.util.ArrayList list7 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdFascicoloAttoDecreto").equals(reader.getName())){
                                
                                                object.setIdFascicoloAttoDecreto(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdFascicoloAttoDecretoParent").equals(reader.getName())){
                                
                                                object.setIdFascicoloAttoDecretoParent(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Guid.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
                                
                                                object.setDatiFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloMetadataAttoDecreto_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Documenti").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list5.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone5 = false;
                                                        while(!loopDone5){
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
                                                                loopDone5 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","Documenti").equals(reader.getName())){
                                                                    list5.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone5 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setDocumenti((it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAttoDecreto_type.class,
                                                                list5));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FascicoliSIPATR").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list6.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone6 = false;
                                                        while(!loopDone6){
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
                                                                loopDone6 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","FascicoliSIPATR").equals(reader.getName())){
                                                                    list6.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone6 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setFascicoliSIPATR((it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.FascicoloSIPATR_type.class,
                                                                list6));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AllegatiDecretoIGB").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list7.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone7 = false;
                                                        while(!loopDone7){
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
                                                                loopDone7 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","AllegatiDecretoIGB").equals(reader.getName())){
                                                                    list7.add(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone7 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setAllegatiDecretoIGB((it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DocumentoFascicoloAllegatoDecretoIGB_type.class,
                                                                list7));
                                                            
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataAggiornamentoAttoDecreto").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataAggiornamentoAttoDecreto(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataAggiornamentoSIPATR").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataAggiornamentoSIPATR(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataAggiornamentoFascicoloIGB").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDataAggiornamentoFascicoloIGB(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
           
          