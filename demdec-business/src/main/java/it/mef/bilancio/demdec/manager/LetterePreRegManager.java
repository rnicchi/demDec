package it.mef.bilancio.demdec.manager;


import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;
import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.IterFirmaDecretoTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.LettereTestiPersTO;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LetterePreRegManager extends AbstractDemManager {
//	List<Decreto> findDecreti(Decreto decreto);
//	List<Decreto> findByDecreto(Decreto decreto);
	List<AnagAmminDemTO> findAmministrazioniByIdFascicolo(Long idFascicolo)  throws Throwable;
	
	 void aggiornaLettere(LettereIgbTO lettera, Blob binaIntLettera, List<LettereTestiPersTO> listLetterePers) throws Throwable;
	/*	List<CentroResponsabilita> findCentriResponsabilita(Long idDecrAmm, Long annoEse);
	Long[] findNumeriFascicoli(Long idDecreto) ;
    String[] getTestiLettere(String tipoLettera);
   // boolean inserisciLettera(Long annoEse, Long idAmm, Date dataLettera, Long numeProgLettera, char statusLettera, byte[] pdf);
    void aggiornaLettere(LetteraIgb lettera, PatUser user, String funzione) throws ParseException;
    List<LetteraIgb> getLettere() throws ParseException;
	List<LetteraIgb> findByLettera(LetteraIgb lettera) throws ParseException;
	List<Amministrazione> findAmmInDecByAnnoEse(String annoEsercizio);
	
	
	List<String> getAnnoEseLettereIgb(PatUser utenteInSessione, String minRangeAnno);
	Long getIdLetteraByAmmDecr(Long idAmm, Long idDecr);
	*/

	String[] getLettereTestiByTipo(String string)  throws Throwable;

	List<LettereIgbTO> findByLettera(LettereIgbTO lettera) throws Throwable;

	LettereIgbTO getLetteraById(Long idLettera) throws Throwable;

	Blob getBlobByIdLettera(BigDecimal id)  throws Throwable;

	String[] getLettereTestiByTipoBalanced(String tipoLettera) throws Throwable;	

	LettereIgbBO findByUK(LettereIgbTO lettera);

	List<FascicoliTO> findFascicoliFadLetterePreReg(FascicoliFadSearhTO to) throws Throwable;

	void deleteLettera(LettereIgbTO lettera, String tipoLettera) throws Throwable;

	List<LettereIgbTO> findLettereByIdDecreto(Long idDecreto) throws Throwable;

	void modificaDatiPersELettera(LettereIgbTO lettera, String tipoLettera, FascicoliTO fascicolo, List<LettereTestiPersTO> listLetterePers, Long idAmm, String dest,
			String realPath) throws Throwable;

	void inserisciDatiPersELettera(LettereIgbTO lettera, String tipoLettera, FascicoliTO fascicolo, List<LettereTestiPersTO> listLetterePers,
			Long idAmm, String dest, String realPath) throws Throwable;

	void invioAllefirme(List<LettereIgbTO> listaLettere, String user, String nomeFunzione) throws Throwable;

	List<LettereIgbTO> findLettereByCodiUfficioAndStatus(String codiUfficio, String status) throws Throwable;

//	ResponseDEMBILClient wsUpdateLetteraDocument(DocumentTO dcTO, LettereIgbTO letteraTo) throws Throwable;

	LettereIgbTO firmaLettera(LettereIgbTO letteraTo, String tkPin,Utente utenteInSessione, String nomeFunzione, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Integer maxTranSize) throws Throwable;

	String findDestinatariMailPec(BigDecimal id) throws Throwable;

	List<LettereIgbTO> findLettereByStatus(String status) throws Throwable ;

	LettereIgbBO aggiornaStatusLettera(BigDecimal idLettera, String status, String user, String funzione) throws Throwable;

//	Integer cambiaStatoLettera(BigDecimal idLettera, String status) throws Throwable;

	
}
