package it.mef.bilancio.demdec.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import it.almavivaitalia.bilancio.commons.bo.PecMessaggiInviatiBO;
import it.mef.bilancio.demdec.dao.PecMessaggiInviatiDao;

public class PecMessaggiInviatiDaoImpl extends AbstractDemDaoImpl<PecMessaggiInviatiBO> implements PecMessaggiInviatiDao {
	
	
	@Override
	public PecMessaggiInviatiBO findMessaggioInviatoByMessageId(String id) {
		Query q = createQuery("from PecMessaggiInviatiBO msg where msg.id = :id");
		q.setParameter("id", id);
		PecMessaggiInviatiBO msg = (PecMessaggiInviatiBO) q.uniqueResult();
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PecMessaggiInviatiBO> listaMessaggiInviati() throws Throwable {
		Query q = createQuery("from PecMessaggiInviatiBO msg WHERE msg.dataInvio =:dataOdierna ORDER BY msg.dataInvio DESC");
		q.setParameter("dataOdierna", new Date());
		List<PecMessaggiInviatiBO> listaMessaggiInviati = q.list();
		return listaMessaggiInviati;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PecMessaggiInviatiBO> listSentMessageBydate(Date dataInvio) throws Throwable {
		
		Query q = createQuery("from PecMessaggiInviatiBO msg  WHERE msg.dataInvio >= :dataInvio ORDER BY msg.dataInvio ASC");
		q.setParameter("dataInvio", dataInvio);
		List<PecMessaggiInviatiBO> listSentMessage = q.list();
		return listSentMessage;
	}
}
