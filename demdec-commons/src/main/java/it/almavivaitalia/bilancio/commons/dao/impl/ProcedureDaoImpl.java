package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.dao.ProcedureDao;



public class ProcedureDaoImpl extends AbstractCommonDaoImpl implements
		ProcedureDao {
	
	@Override
	public void caricaAttoDovuDlsQuadra(String pCassa, String pArrotondamento) throws Throwable {
		getNamedQuery("QuadraDlfBO.caricaAttoDovuDlsQuadra")
				.setString("p_cassa", pCassa)
				.setString("p_arr", pArrotondamento)
				.executeUpdate();

	}
}
