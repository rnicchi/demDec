
/**
 * Richiesta_searchFascicoliRaccolteProvvisorie_type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1;
            

            /**
            *  Richiesta_searchFascicoliRaccolteProvvisorie_type bean class
            */
        
        public  class Richiesta_searchFascicoliRaccolteProvvisorie_type
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = richiesta_searchFascicoliRaccolteProvvisorie_type
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
                        * field for TipoEstrazioneFascicolo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type localTipoEstrazioneFascicolo ;
                                

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type getTipoEstrazioneFascicolo(){
                               return localTipoEstrazioneFascicolo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoEstrazioneFascicolo
                               */
                               public void setTipoEstrazioneFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type param){
                            
                                            this.localTipoEstrazioneFascicolo=param;
                                    

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
                        * field for IdentificativoRaccoltaProvvisoria
                        */

                        
                                    protected java.lang.String localIdentificativoRaccoltaProvvisoria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdentificativoRaccoltaProvvisoriaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdentificativoRaccoltaProvvisoria(){
                               return localIdentificativoRaccoltaProvvisoria;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentificativoRaccoltaProvvisoria
                               */
                               public void setIdentificativoRaccoltaProvvisoria(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIdentificativoRaccoltaProvvisoriaTracker = true;
                                       } else {
                                          localIdentificativoRaccoltaProvvisoriaTracker = false;
                                              
                                       }
                                   
                                            this.localIdentificativoRaccoltaProvvisoria=param;
                                    

                               }
                            

                        /**
                        * field for Descrizione
                        */

                        
                                    protected java.lang.String localDescrizione ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescrizioneTracker = false ;
                           

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
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDescrizioneTracker = true;
                                       } else {
                                          localDescrizioneTracker = false;
                                              
                                       }
                                   
                                            this.localDescrizione=param;
                                    

                               }
                            

                        /**
                        * field for StatoFascicoloRaccoltaProvvisoria
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type localStatoFascicoloRaccoltaProvvisoria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatoFascicoloRaccoltaProvvisoriaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type getStatoFascicoloRaccoltaProvvisoria(){
                               return localStatoFascicoloRaccoltaProvvisoria;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StatoFascicoloRaccoltaProvvisoria
                               */
                               public void setStatoFascicoloRaccoltaProvvisoria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStatoFascicoloRaccoltaProvvisoriaTracker = true;
                                       } else {
                                          localStatoFascicoloRaccoltaProvvisoriaTracker = false;
                                              
                                       }
                                   
                                            this.localStatoFascicoloRaccoltaProvvisoria=param;
                                    

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
                        * field for UfficioCreatoreRED
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localUfficioCreatoreRED ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUfficioCreatoreREDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type getUfficioCreatoreRED(){
                               return localUfficioCreatoreRED;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UfficioCreatoreRED
                               */
                               public void setUfficioCreatoreRED(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUfficioCreatoreREDTracker = true;
                                       } else {
                                          localUfficioCreatoreREDTracker = false;
                                              
                                       }
                                   
                                            this.localUfficioCreatoreRED=param;
                                    

                               }
                            

                        /**
                        * field for TipoFlusso
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoFlusso_type localTipoFlusso ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTipoFlussoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoFlusso_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoFlusso_type getTipoFlusso(){
                               return localTipoFlusso;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TipoFlusso
                               */
                               public void setTipoFlusso(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoFlusso_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTipoFlussoTracker = true;
                                       } else {
                                          localTipoFlussoTracker = false;
                                              
                                       }
                                   
                                            this.localTipoFlusso=param;
                                    

                               }
                            

                        /**
                        * field for Protocollo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ProtocolloSearch_type localProtocollo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProtocolloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ProtocolloSearch_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ProtocolloSearch_type getProtocollo(){
                               return localProtocollo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Protocollo
                               */
                               public void setProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ProtocolloSearch_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localProtocolloTracker = true;
                                       } else {
                                          localProtocolloTracker = false;
                                              
                                       }
                                   
                                            this.localProtocollo=param;
                                    

                               }
                            

                        /**
                        * field for DataProtocollo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type localDataProtocollo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataProtocolloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type getDataProtocollo(){
                               return localDataProtocollo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataProtocollo
                               */
                               public void setDataProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataProtocolloTracker = true;
                                       } else {
                                          localDataProtocolloTracker = false;
                                              
                                       }
                                   
                                            this.localDataProtocollo=param;
                                    

                               }
                            

                        /**
                        * field for UtenteCreatore
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type localUtenteCreatore ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUtenteCreatoreTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type getUtenteCreatore(){
                               return localUtenteCreatore;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UtenteCreatore
                               */
                               public void setUtenteCreatore(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUtenteCreatoreTracker = true;
                                       } else {
                                          localUtenteCreatoreTracker = false;
                                              
                                       }
                                   
                                            this.localUtenteCreatore=param;
                                    

                               }
                            

                        /**
                        * field for DataCreazioneFascicolo
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type localDataCreazioneFascicolo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataCreazioneFascicoloTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type getDataCreazioneFascicolo(){
                               return localDataCreazioneFascicolo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataCreazioneFascicolo
                               */
                               public void setDataCreazioneFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataCreazioneFascicoloTracker = true;
                                       } else {
                                          localDataCreazioneFascicoloTracker = false;
                                              
                                       }
                                   
                                            this.localDataCreazioneFascicolo=param;
                                    

                               }
                            

                        /**
                        * field for DataAggiornamento
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type localDataAggiornamento ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDataAggiornamentoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type getDataAggiornamento(){
                               return localDataAggiornamento;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DataAggiornamento
                               */
                               public void setDataAggiornamento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDataAggiornamentoTracker = true;
                                       } else {
                                          localDataAggiornamentoTracker = false;
                                              
                                       }
                                   
                                            this.localDataAggiornamento=param;
                                    

                               }
                            

                        /**
                        * field for DocumentCriteria
                        */

                        
                                    protected it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CriteriaDocumentiRaccoltaProvvisoria_type localDocumentCriteria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDocumentCriteriaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CriteriaDocumentiRaccoltaProvvisoria_type
                           */
                           public  it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CriteriaDocumentiRaccoltaProvvisoria_type getDocumentCriteria(){
                               return localDocumentCriteria;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DocumentCriteria
                               */
                               public void setDocumentCriteria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CriteriaDocumentiRaccoltaProvvisoria_type param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDocumentCriteriaTracker = true;
                                       } else {
                                          localDocumentCriteriaTracker = false;
                                              
                                       }
                                   
                                            this.localDocumentCriteria=param;
                                    

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
                       Richiesta_searchFascicoliRaccolteProvvisorie_type.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":richiesta_searchFascicoliRaccolteProvvisorie_type",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "richiesta_searchFascicoliRaccolteProvvisorie_type",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localTipoEstrazioneFascicolo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneFascicolo cannot be null!!");
                                            }
                                           localTipoEstrazioneFascicolo.serialize(new javax.xml.namespace.QName("","TipoEstrazioneFascicolo"),
                                               factory,xmlWriter);
                                        
                                            if (localTipoEstrazioneElenco==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneElenco cannot be null!!");
                                            }
                                           localTipoEstrazioneElenco.serialize(new javax.xml.namespace.QName("","TipoEstrazioneElenco"),
                                               factory,xmlWriter);
                                         if (localIdentificativoRaccoltaProvvisoriaTracker){
                                    namespace = "";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IdentificativoRaccoltaProvvisoria", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IdentificativoRaccoltaProvvisoria");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IdentificativoRaccoltaProvvisoria");
                                    }
                                

                                          if (localIdentificativoRaccoltaProvvisoria==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IdentificativoRaccoltaProvvisoria cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdentificativoRaccoltaProvvisoria);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDescrizioneTracker){
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
                             } if (localStatoFascicoloRaccoltaProvvisoriaTracker){
                                            if (localStatoFascicoloRaccoltaProvvisoria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("StatoFascicoloRaccoltaProvvisoria cannot be null!!");
                                            }
                                           localStatoFascicoloRaccoltaProvvisoria.serialize(new javax.xml.namespace.QName("","StatoFascicoloRaccoltaProvvisoria"),
                                               factory,xmlWriter);
                                        } if (localRagioneriaTracker){
                                            if (localRagioneria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                            }
                                           localRagioneria.serialize(new javax.xml.namespace.QName("","Ragioneria"),
                                               factory,xmlWriter);
                                        } if (localAmministrazioneTracker){
                                            if (localAmministrazione==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                            }
                                           localAmministrazione.serialize(new javax.xml.namespace.QName("","Amministrazione"),
                                               factory,xmlWriter);
                                        } if (localUfficioCreatoreREDTracker){
                                            if (localUfficioCreatoreRED==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UfficioCreatoreRED cannot be null!!");
                                            }
                                           localUfficioCreatoreRED.serialize(new javax.xml.namespace.QName("","UfficioCreatoreRED"),
                                               factory,xmlWriter);
                                        } if (localTipoFlussoTracker){
                                            if (localTipoFlusso==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TipoFlusso cannot be null!!");
                                            }
                                           localTipoFlusso.serialize(new javax.xml.namespace.QName("","TipoFlusso"),
                                               factory,xmlWriter);
                                        } if (localProtocolloTracker){
                                            if (localProtocollo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Protocollo cannot be null!!");
                                            }
                                           localProtocollo.serialize(new javax.xml.namespace.QName("","Protocollo"),
                                               factory,xmlWriter);
                                        } if (localDataProtocolloTracker){
                                            if (localDataProtocollo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DataProtocollo cannot be null!!");
                                            }
                                           localDataProtocollo.serialize(new javax.xml.namespace.QName("","DataProtocollo"),
                                               factory,xmlWriter);
                                        } if (localUtenteCreatoreTracker){
                                            if (localUtenteCreatore==null){
                                                 throw new org.apache.axis2.databinding.ADBException("UtenteCreatore cannot be null!!");
                                            }
                                           localUtenteCreatore.serialize(new javax.xml.namespace.QName("","UtenteCreatore"),
                                               factory,xmlWriter);
                                        } if (localDataCreazioneFascicoloTracker){
                                            if (localDataCreazioneFascicolo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DataCreazioneFascicolo cannot be null!!");
                                            }
                                           localDataCreazioneFascicolo.serialize(new javax.xml.namespace.QName("","DataCreazioneFascicolo"),
                                               factory,xmlWriter);
                                        } if (localDataAggiornamentoTracker){
                                            if (localDataAggiornamento==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DataAggiornamento cannot be null!!");
                                            }
                                           localDataAggiornamento.serialize(new javax.xml.namespace.QName("","DataAggiornamento"),
                                               factory,xmlWriter);
                                        } if (localDocumentCriteriaTracker){
                                            if (localDocumentCriteria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DocumentCriteria cannot be null!!");
                                            }
                                           localDocumentCriteria.serialize(new javax.xml.namespace.QName("","DocumentCriteria"),
                                               factory,xmlWriter);
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
                                                                      "TipoEstrazioneFascicolo"));
                            
                            
                                    if (localTipoEstrazioneFascicolo==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneFascicolo cannot be null!!");
                                    }
                                    elementList.add(localTipoEstrazioneFascicolo);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoEstrazioneElenco"));
                            
                            
                                    if (localTipoEstrazioneElenco==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoEstrazioneElenco cannot be null!!");
                                    }
                                    elementList.add(localTipoEstrazioneElenco);
                                 if (localIdentificativoRaccoltaProvvisoriaTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "IdentificativoRaccoltaProvvisoria"));
                                 
                                        if (localIdentificativoRaccoltaProvvisoria != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdentificativoRaccoltaProvvisoria));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("IdentificativoRaccoltaProvvisoria cannot be null!!");
                                        }
                                    } if (localDescrizioneTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "Descrizione"));
                                 
                                        if (localDescrizione != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescrizione));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Descrizione cannot be null!!");
                                        }
                                    } if (localStatoFascicoloRaccoltaProvvisoriaTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "StatoFascicoloRaccoltaProvvisoria"));
                            
                            
                                    if (localStatoFascicoloRaccoltaProvvisoria==null){
                                         throw new org.apache.axis2.databinding.ADBException("StatoFascicoloRaccoltaProvvisoria cannot be null!!");
                                    }
                                    elementList.add(localStatoFascicoloRaccoltaProvvisoria);
                                } if (localRagioneriaTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Ragioneria"));
                            
                            
                                    if (localRagioneria==null){
                                         throw new org.apache.axis2.databinding.ADBException("Ragioneria cannot be null!!");
                                    }
                                    elementList.add(localRagioneria);
                                } if (localAmministrazioneTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Amministrazione"));
                            
                            
                                    if (localAmministrazione==null){
                                         throw new org.apache.axis2.databinding.ADBException("Amministrazione cannot be null!!");
                                    }
                                    elementList.add(localAmministrazione);
                                } if (localUfficioCreatoreREDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "UfficioCreatoreRED"));
                            
                            
                                    if (localUfficioCreatoreRED==null){
                                         throw new org.apache.axis2.databinding.ADBException("UfficioCreatoreRED cannot be null!!");
                                    }
                                    elementList.add(localUfficioCreatoreRED);
                                } if (localTipoFlussoTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TipoFlusso"));
                            
                            
                                    if (localTipoFlusso==null){
                                         throw new org.apache.axis2.databinding.ADBException("TipoFlusso cannot be null!!");
                                    }
                                    elementList.add(localTipoFlusso);
                                } if (localProtocolloTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "Protocollo"));
                            
                            
                                    if (localProtocollo==null){
                                         throw new org.apache.axis2.databinding.ADBException("Protocollo cannot be null!!");
                                    }
                                    elementList.add(localProtocollo);
                                } if (localDataProtocolloTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataProtocollo"));
                            
                            
                                    if (localDataProtocollo==null){
                                         throw new org.apache.axis2.databinding.ADBException("DataProtocollo cannot be null!!");
                                    }
                                    elementList.add(localDataProtocollo);
                                } if (localUtenteCreatoreTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "UtenteCreatore"));
                            
                            
                                    if (localUtenteCreatore==null){
                                         throw new org.apache.axis2.databinding.ADBException("UtenteCreatore cannot be null!!");
                                    }
                                    elementList.add(localUtenteCreatore);
                                } if (localDataCreazioneFascicoloTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataCreazioneFascicolo"));
                            
                            
                                    if (localDataCreazioneFascicolo==null){
                                         throw new org.apache.axis2.databinding.ADBException("DataCreazioneFascicolo cannot be null!!");
                                    }
                                    elementList.add(localDataCreazioneFascicolo);
                                } if (localDataAggiornamentoTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DataAggiornamento"));
                            
                            
                                    if (localDataAggiornamento==null){
                                         throw new org.apache.axis2.databinding.ADBException("DataAggiornamento cannot be null!!");
                                    }
                                    elementList.add(localDataAggiornamento);
                                } if (localDocumentCriteriaTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DocumentCriteria"));
                            
                            
                                    if (localDocumentCriteria==null){
                                         throw new org.apache.axis2.databinding.ADBException("DocumentCriteria cannot be null!!");
                                    }
                                    elementList.add(localDocumentCriteria);
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
        public static Richiesta_searchFascicoliRaccolteProvvisorie_type parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Richiesta_searchFascicoliRaccolteProvvisorie_type object =
                new Richiesta_searchFascicoliRaccolteProvvisorie_type();

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
                    
                            if (!"richiesta_searchFascicoliRaccolteProvvisorie_type".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Richiesta_searchFascicoliRaccolteProvvisorie_type)org.xmlsoap.schemas.soap.envelope.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoEstrazioneFascicolo").equals(reader.getName())){
                                
                                                object.setTipoEstrazioneFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoEstrazione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IdentificativoRaccoltaProvvisoria").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdentificativoRaccoltaProvvisoria(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
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
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","StatoFascicoloRaccoltaProvvisoria").equals(reader.getName())){
                                
                                                object.setStatoFascicoloRaccoltaProvvisoria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.StatoFascicoloDocumentale_type.Factory.parse(reader));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Amministrazione").equals(reader.getName())){
                                
                                                object.setAmministrazione(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","UfficioCreatoreRED").equals(reader.getName())){
                                
                                                object.setUfficioCreatoreRED(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TipoFlusso").equals(reader.getName())){
                                
                                                object.setTipoFlusso(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.TipoFlusso_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","Protocollo").equals(reader.getName())){
                                
                                                object.setProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.ProtocolloSearch_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataProtocollo").equals(reader.getName())){
                                
                                                object.setDataProtocollo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","UtenteCreatore").equals(reader.getName())){
                                
                                                object.setUtenteCreatore(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CodiceDescrizione_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataCreazioneFascicolo").equals(reader.getName())){
                                
                                                object.setDataCreazioneFascicolo(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DataAggiornamento").equals(reader.getName())){
                                
                                                object.setDataAggiornamento(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.DataRange_type.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DocumentCriteria").equals(reader.getName())){
                                
                                                object.setDocumentCriteria(it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.CriteriaDocumentiRaccoltaProvvisoria_type.Factory.parse(reader));
                                              
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
           
          