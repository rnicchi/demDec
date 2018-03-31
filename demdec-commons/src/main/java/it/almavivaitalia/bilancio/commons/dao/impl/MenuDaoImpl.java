package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.MenuBO;
import it.almavivaitalia.bilancio.commons.dao.MenuDao;


import java.awt.Menu;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;


public class MenuDaoImpl extends AbstractCommonDaoImpl implements MenuDao{

	public MenuBO saveOrUpdate(MenuBO o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

	
	public MenuBO loadByPrimaryKey(Long id) {
		return (MenuBO)getHibernateTemplate().load(MenuBO.class, id);
	}

	@SuppressWarnings("unchecked")
	public Menu loadByPrimaryKey_old(Long id) {
		List<Menu> list = (List<Menu>)getHibernateTemplate().find("select menu from MenuBO menu join menu.items item join item.items left outer join item.action left outer join item.menu where menu.id=?", id);
		if (list!=null){
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<MenuBO> loadAllMenu(){
		List<MenuBO> l=null;
		try{
			l=getHibernateTemplate().loadAll(MenuBO.class);
		}catch(Throwable t){
			t.printStackTrace();
		}
		
		return l;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MenuBO> loadMenuByCodiMenu(String codiMenu) {
		String queryString=
					"SELECT m.CODI_MENU 					as codiMenu, "+ 
					"nvl(m.DESC_CODI_MENU,m.CODI_MENU)  	as descCodiMenu, "+
					"mm.FLAG_MENU_PRINCIPALE 				as flagMenuPrincipale, "+
					"mm.NUME_SEQUENCE 						as numeSequence " +
					"FROM D_J_MENU m, D_J_MM_MENU_MENU mm "+
					"where "+
					"upper(m.codi_menu)=upper(mm.codi_menu_2) "+
					"and upper(mm.CODI_MENU_1)=upper(:codiMenu) "+
					"order by mm.flag_menu_principale desc, mm.nume_sequence asc";
		
		Query query=getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(queryString)
				.addScalar("codiMenu", 				Hibernate.STRING)
				.addScalar("descCodiMenu", 			Hibernate.STRING)
				.addScalar("flagMenuPrincipale", 	Hibernate.STRING)
				.addScalar("numeSequence", 			Hibernate.STRING)
				.setString("codiMenu", codiMenu)
			.setResultTransformer(Transformers.aliasToBean(MenuBO.class));
			
			
		return query.list();		

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MenuBO> loadMenuByCodiMenu(String codiMenu, String idProfilo) {
		String queryString=
				"SELECT m.CODI_MENU 					as codiMenu, "+ 
				"nvl(m.DESC_CODI_MENU,m.CODI_MENU)  	as descCodiMenu " +
				"FROM D_J_MENU m "+
				"where "+
				"upper(m.codi_menu)=upper(:codiMenu) "+
				"and  EXISTS " +
				"( "+
				"SELECT " +
				" 	'x' " +
				"FROM " +
				"	D_J_MM_MENU_PROFILO p, D_J_MENU djm " +
				"WHERE " +
				"	p.SEQU_ID_PROFILO=:idProfilo " +
				"	AND upper(djm.CODI_MENU)=upper(:codiMenu) " +
				"	AND djm.SEQU_ID_MENU=p.SEQU_ID_MENU " +
				") ";
	
		Query query=getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(queryString)
				.addScalar("codiMenu", 				Hibernate.STRING)
				.addScalar("descCodiMenu", 			Hibernate.STRING)
				.setString("codiMenu", codiMenu)
				.setString("idProfilo", idProfilo)
			.setResultTransformer(Transformers.aliasToBean(MenuBO.class));
			
		return query.list();	
	}


	@Override
	public Boolean isUserEnabled(String codiMenu, String idProfilo) {
		
		String queryString=
							"SELECT 'true' as res							"+
							"FROM dual										"+
							"WHERE EXISTS									"+
							"  (SELECT 'a'									"+
							"  FROM D_J_MM_MENU_PROFILO p,					"+
							"    D_J_MENU djm								"+
							"  WHERE p.SEQU_ID_PROFILO =:idProfilo			"+
							"  AND upper(djm.CODI_MENU)=upper(:codiMenu)	"+
							"  AND djm.SEQU_ID_MENU    =p.SEQU_ID_MENU		"+
							"  )											"+
							"UNION											"+
							"SELECT 'false' as res							"+
							"FROM dual										"+
							"WHERE NOT EXISTS								"+
							"  (SELECT 'a'									"+
							"  FROM D_J_MM_MENU_PROFILO p,					"+
							"    D_J_MENU djm								"+
							"  WHERE p.SEQU_ID_PROFILO =:idProfilo			"+
							"  AND upper(djm.CODI_MENU)=upper(:codiMenu)	"+
							"  AND djm.SEQU_ID_MENU    =p.SEQU_ID_MENU		"+
							"  )    										";
		 
	
		Query query=getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString)
				.setString("codiMenu", codiMenu)
				.setString("idProfilo", idProfilo);
			
		return new Boolean((String)query.uniqueResult());	
	}
}
