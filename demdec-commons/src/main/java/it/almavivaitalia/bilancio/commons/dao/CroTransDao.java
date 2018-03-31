package it.almavivaitalia.bilancio.commons.dao;

import it.almavivaitalia.bilancio.commons.bo.CroTransBO;

import java.util.List;


public interface CroTransDao extends AbstractCommonDao{

	public List<CroTransBO> loadAll();

	public List<CroTransBO> loadAllOrdById();

	public CroTransBO existsCroTrans(Short id);
	
}
