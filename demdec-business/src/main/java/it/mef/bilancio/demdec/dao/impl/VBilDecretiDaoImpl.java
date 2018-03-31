package it.mef.bilancio.demdec.dao.impl;

import org.hibernate.Query;

import it.almavivaitalia.bsn.sh.dao.impl.AbstractDaoImpl;
import it.mef.bilancio.demdec.dao.VBilDecretiDao;

public class VBilDecretiDaoImpl extends AbstractDaoImpl implements VBilDecretiDao {

	@Override
	public String findGuidSiPatrBynumPatr(Integer numPatr, Integer annoDec){
		String queryString= "SELECT  a.nume_id_dec_dembil "+
					  "FROM u_patrimonio_vpd.v_bil_decreti a"+
					  " where a.nume_decreto=:numPatr and a.anno_ese_decreto= :annoDec";
		
	  Query q = createSQLQuery(queryString);
	  q.setLong("numPatr", numPatr);
	  q.setLong("annoDec", annoDec);
	  return (String)q.uniqueResult();
	}
	
	
	
}
