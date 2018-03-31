package it.mef.bilancio.demdec.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.mef.bilancio.demdec.dao.DocumentiDao;
import it.mef.bilancio.demdec.to.DocumentiViewTO;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;


public class DocumentiDaoImpl extends AbstractDemDaoImpl<DocumentiBO> implements DocumentiDao{

	public DocumentiDaoImpl(){
		super(DocumentiBO.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentiViewTO> loadADToSignByLoggedUser(Utente utente)
			throws Throwable {
		
		Query query=getNamedQuery("DocumentiBO.loadAllDocumentsToSignByLoggedUser");
		query.setParameter("profile", utente.getProfiloInUso().getCodiProfilo());
		query.setParameter("stp", utente.getUtenteProfiloInUso().getAnagAmminDem()!=null?utente.getUtenteProfiloInUso().getAnagAmminDem().getId().getNumeStp():0);
		query.setParameter("app", utente.getUtenteProfiloInUso().getAnagAmminDem()!=null?utente.getUtenteProfiloInUso().getAnagAmminDem().getId().getNumeApp():0);
		query.setParameter("uff", utente.getUtenteProfiloInUso().getAnagUffici()!=null?utente.getUtenteProfiloInUso().getAnagUffici().getId():"");
		List<DocumentiViewTO> listAttoDecreto = query.setResultTransformer(Transformers.aliasToBean(DocumentiViewTO.class )).setCacheMode(CacheMode.GET).list();
		
		return listAttoDecreto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentiViewTO> loadADToSignOrVerifyByLoggedUser(Utente utente, String signOrVerify) 
			throws Throwable {
		
		Query query=getNamedQuery("DocumentiBO.loadAllDocumentsToSignOrVerifyByLoggedUser");
//		query.setParameter("user", utente.getUtente().getId());
		query.setParameter("profile", utente.getProfiloInUso().getCodiProfilo());
		query.setParameter("stp", utente.getUtenteProfiloInUso().getAnagAmminDem()!=null?utente.getUtenteProfiloInUso().getAnagAmminDem().getId().getNumeStp():0);
		query.setParameter("app", utente.getUtenteProfiloInUso().getAnagAmminDem()!=null?utente.getUtenteProfiloInUso().getAnagAmminDem().getId().getNumeApp():0);
		query.setParameter("uff", utente.getUtenteProfiloInUso().getAnagUffici()!=null?utente.getUtenteProfiloInUso().getAnagUffici().getId():"");
		query.setParameter("signOrVerify", signOrVerify);
		List<DocumentiViewTO> listAttoDecreto = query.setResultTransformer(Transformers.aliasToBean(DocumentiViewTO.class )).setCacheMode(CacheMode.GET).list();
		
		return listAttoDecreto;
	}
	
	@Override
	public Long createNextIdDocumento(Long numFasc){
	  Query q = createQuery("select nvl(max(d.id.numeIdDocumento),0) + 1 from DocumentiBO d where  d.id.fkNumeIdFascicolo= :numFasc ");
	  q.setLong("numFasc", numFasc);
	  return (Long)q.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentiBO> findDocumentiByTipoFascicolo(String tipo , Long idFasc)	throws Throwable {
		String q=
				" from DocumentiBO bo "+
						" where tipoDocumento.id = :tipo and fascicoli.id= :idFasc  "
						+ "order by fascicoli.id";

		Query query = createQuery(q);
		query.setString("tipo", tipo);
		query.setLong("idFasc", idFasc);
		return (List<DocumentiBO> ) query.list();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentiBO> getDocumentiByIdFadFlgVisCdc( Long idFasc, Long flgVisibilitaCdc)	throws Throwable {
		String q=
				" from DocumentiBO bo "+
						" where  fascicoli.id= :idFasc  and flagVisibilitaCdc01= :flgVisibilitaCdc "
						+ " order by fascicoli.id ";

		Query query = createQuery(q);
		
		query.setLong("idFasc", idFasc);
		query.setLong("flgVisibilitaCdc", flgVisibilitaCdc);
		
		return (List<DocumentiBO> ) query.list();
	}
	
/*	@SuppressWarnings("unchecked")
	@Override
	public List<DescDocumentoBO> getDescDocumentiByTipoDocumento(String tipoDocumento) throws Throwable{
		String q=
				" from DescDocumentoBO bo "+
						" where  codiTipoDocumento = :tipoDocumento " +
						"   and  id <> :codiCorte " +
						" order by textDescrizione";

		Query query = createQuery(q);
		
		query.setString("tipoDocumento", tipoDocumento);
		query.setString("codiCorte", Constants.DESC_DOC_CORTE);
		
		return (List<DescDocumentoBO> ) query.list();
	}*/
	
/*	public DescDocumentoBO getVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable
	{
		
		Criteria cri = getSession().createCriteria(DescDocumentoBO.class);
		cri.add(Restrictions.eq("id", codiDescDocumento));

		return (DescDocumentoBO) cri.uniqueResult();
		
		
		String q=
				" from DescDocumentoBO bo "+
						" where  id = :codiDescDocumento " +
						" order by textDescrizione";

		Query query = createQuery(q);
		
		query.setParameter("codiDescDocumento", codiDescDocumento);
		
		DescDocumentoBO bo = (DescDocumentoBO) query.uniqueResult();
		
		DescDocumentoBO bo = loadById(DescDocumentoBO.class, codiDescDocumento);
		
		
		return bo;
		
	}*/
	

	
	
/*	public List<DescDocumentoBO> getVisibilitaDocumentoByCodiDescDocumento(String codiDescDocumento) throws Throwable
	{
		String q=
				" from DescDocumentoBO bo "+
						" where  id = :codiDescDocumento " +
						" order by textDescrizione";

		Query query = createQuery(q);
		
		query.setString("codiDescDocumento", codiDescDocumento);
		
		return (List<DescDocumentoBO> ) query.list();
	}
	*/

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentiViewTO> loadSignedOrVerifyedADByLoggedUser(Utente utente, String signOrVerify) throws Throwable {
		
		Query query=getNamedQuery("DocumentiBO.loadAllSignedOrVerifyedADByLoggedUser");
//		query.setParameter("profile", utente.getProfiloInUso().getCodiProfilo());
		query.setParameter("signOrVerify", signOrVerify);
		query.setParameter("username", utente.getUtente().getCodiUtente());
		List<DocumentiViewTO> listSignedAD = query.setResultTransformer(Transformers.aliasToBean(DocumentiViewTO.class )).setCacheMode(CacheMode.GET).list();
		
		return listSignedAD;
	}

}