package it.mef.bilancio.demdec.manager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bsn.sh.manager.AbstractManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;

public interface UploadDecManager extends AbstractManager {
	public void caricaPdf(String originalFilename, InputStream is /*CommonsMultipartFile file ,JProspettiTO selected*/) throws Throwable;

	String checkGuessedFileType(ArrayList<String> allowedContentType,
			String originalFilename, InputStream is) throws Throwable;

//	String renameToMatchingFileExt(
//			HashMap<String, String> contentTypeExtensions, String contentType,
//			String originalFilename) throws Throwable;

	List<FascicoliTO> findFascicoliFadStatusZero()
			throws Throwable;

	FascicoliTO findFascicoliById(Long id) throws Throwable;

	TipoDocumentoTO loadTipoDocById(String id) throws Throwable;

	ResponseDEMBILClient uploadDocumento(DocumentTO to, AnagAmminDemTO amm,
			FascicoliTO fascicoloTO, String tipoOperazione) throws Throwable;
	
	ResponseDEMBILClient uploadDocumentoAttoDecreto(DocumentTO to, AnagAmminDemTO amm,
			FascicoliTO fascicoloTO, FascicoliTO fascicoloTODelete, String tipoOperazione) throws Throwable;

	List<DocumentiTO> findDocumentiByTipoFascicolo(String tipo,
			Long idFascicolo) throws Throwable;

}
