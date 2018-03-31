package it.mef.bilancio.demdec.manager;

import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;

import java.util.List;

public interface ConsFADCdcManager extends AbstractDemManager {

	List<FascicoliTO> getFascicoliFadCdc(FascicoliFadSearhTO to) throws Throwable;

	List<DocumentiTO> getDocumentiByIdFadFlgVisCdc(Long idFad, Long flgVisibilitaCdc) throws Throwable;

	List<SottoFascicoliRedTO> getSottoFascicoliRedByIdFad(Long idFad) throws Throwable;

	boolean salvaDatiProtEntrataCdc(FascicoliTO fascicoloTo) throws Throwable;

	boolean salvaDatiProtUscitaCdc(FascicoliTO fascicoloTo) throws Throwable;

	boolean salvaDataPresaCaricoCdc(FascicoliTO fascicoloTo) throws Throwable;

	boolean salvaDatiRegistrazioneCdc(FascicoliTO fascicoloTo) throws Throwable;
 
}
