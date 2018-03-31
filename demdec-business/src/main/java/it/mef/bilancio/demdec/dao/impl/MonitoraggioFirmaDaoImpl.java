package it.mef.bilancio.demdec.dao.impl;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import it.almavivaitalia.bilancio.commons.bo.MonitoraggioFirmaBO;
import it.almavivaitalia.bsn.sh.bo.AbstractBO;
import it.mef.bilancio.demdec.dao.MonitoraggioFirmaDao;
import it.mef.bilancio.demdec.to.MonitoraggioFirmaTO;

public class MonitoraggioFirmaDaoImpl extends AbstractDemDaoImpl<MonitoraggioFirmaBO> implements MonitoraggioFirmaDao {

	@Override
	public void delete(AbstractBO bo) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractBO saveOrUpdate(AbstractBO o) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends AbstractBO> T loadById(Class<T> cls, Number id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends AbstractBO> T loadById(Class<T> cls, Serializable id)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends AbstractBO> void update(T bo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSysdate() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonitoraggioFirmaBO> findByExample(MonitoraggioFirmaTO monitoraggioTO) throws Throwable {
		
		Criteria cri = getSession().createCriteria(MonitoraggioFirmaBO.class);
		addCreateEq(cri, "descSigla", monitoraggioTO.getDescSigla());
		addCreateEq(cri, "numeNumDecreto", monitoraggioTO.getNumeNumDecreto());
		addCreateEq(cri, "annoEse", monitoraggioTO.getAnnoEse());
		addCreateEq(cri,"descFirmato", monitoraggioTO.getDescFirmato());
		addCreateEq(cri,"descInFirma", monitoraggioTO.getDescInFirma());
		addCreateEq(cri,"statStato", monitoraggioTO.getStatStato());
		addCreateEq(cri,"numeTipoDecreto", monitoraggioTO.getNumeTipoDecreto());
		
		List<MonitoraggioFirmaBO> l = cri.list();
		return l;
	}

	
	protected void addCreateEq(Criteria cri, String nomeProperty, Object value){
		if (value != null){
			cri.add(Restrictions.eq(nomeProperty, value));
		}
	}
}
