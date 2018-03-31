package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.dao.IntCronologicoDao;
import it.mef.bilancio.demdec.manager.IntCronologicoManager;
import it.mef.bilancio.demdec.to.CronologicoSearchTO;
import it.mef.bilancio.demdec.to.CronologicoTO;
import it.mef.bilancio.demdec.to.CronologicoTransExcelTO;
import it.mef.bilancio.demdec.to.CronologicoTransTO;
import it.mef.bilancio.demdec.to.CronologicoValoriTO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class IntCronologicoManagerImpl  extends AbstractDemManagerImpl implements IntCronologicoManager  {
	// DAO //
	@Autowired
	private IntCronologicoDao intCronologicoDao;
	// FINE DAO //
	// UTENTE //
	public List<CodeDescriptionTO> loadUtente() throws Throwable {
		return intCronologicoDao.loadUtente();
	}
	// APPLICATION //
	public List<CronologicoSearchTO> loadApplication() throws Throwable {
	    return intCronologicoDao.loadApplication();
	}
	// APPLICATION //
	public List<CronologicoSearchTO> loadCategoria(Integer idAppl) throws Throwable {
	    return intCronologicoDao.loadCategoria(idAppl);
	}
	// FUNZIONE //
	public List<CronologicoSearchTO> loadFunzione(Integer idAppl,Integer idCat) throws Throwable {
	    return intCronologicoDao.loadFunzione(idAppl,idCat);
	}
	// Load Capitoli //
	public List<CronologicoTO> loadCapitoli(Short annoCap) throws Throwable {
	   return intCronologicoDao.loadCapitoli(annoCap);
	}
	// Load Strumento //
	public List<CronologicoTO> loadStrumenti() throws Throwable {
	   return intCronologicoDao.loadStrumento();
	}
	// Load SottoStrumento //
	public List<CronologicoTO> loadSottoStrumenti() throws Throwable {
	   return intCronologicoDao.loadSottoStrumento();
	}
	// Load Autor //
	public List<CronologicoTO> loadAutor() throws Throwable {
	   return intCronologicoDao.loadAutor();
	}
	// Carica Risultati //
	public List<CronologicoTransTO> caricaRisultati(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable{
	  List<CronologicoTransTO> list = intCronologicoDao.caricaRisultati(to, dataA, oraDa, oraA);	
	  if (list.size()>0){
        for (CronologicoTransTO riga: list){		
  		  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		  String data=df1.format(riga.getDataOpraz());
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		  Date convertedDate = dateFormat.parse(data);	
		  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		  data = df.format(convertedDate);
		  riga.setDataOprazFormatted(data);
		  /* ora */
		  riga.setOrarOperazFormatted(riga.getOrarOperaz());
         }
	   }
      return list;
	}
	public List<CronologicoValoriTO> loadValori (BigDecimal code,BigDecimal trans) throws Throwable{
		return intCronologicoDao.loadValori(code, trans);
	}
	// Carica Risultati Excel //
	public List<CronologicoTransExcelTO> caricaRisultatiExcel(CronologicoTO to,Date dataA,String oraDa,String oraA) throws Throwable{
	    List<CronologicoTransExcelTO> list = intCronologicoDao.caricaExcel(to, dataA, oraDa, oraA);
	    
	    if (list.size()>0){
	      Integer vCodiId = 0;	
          for (CronologicoTransExcelTO riga: list){		
  			  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			  String data=df1.format(riga.getDataOpraz());
			  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		      Date convertedDate = dateFormat.parse(data);	
		      SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		      data = df.format(convertedDate);
		      riga.setDataOprazFormatted(data);
		      /* ora */
		      riga.setOrarOperazFormatted(riga.getOrarOperaz());
		      if (riga.getCodiId().equals(vCodiId)){
		    	 riga.setDescDescr(" "); 
		    	 riga.setDescDescrTrans(" ");		    	 
		    	 riga.setDescUtente(" ");
		      }else{
		    	  vCodiId =  riga.getCodiId(); 	  
		      }
          }
	    }
        return list;
	}
}
