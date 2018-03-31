package it.almavivaitalia.bilancio.commons.dao.impl;

import it.almavivaitalia.bilancio.commons.bo.AbstractCommonBO;
import it.almavivaitalia.bilancio.commons.dao.CroFunzCampiDao;
import it.almavivaitalia.bilancio.commons.to.CroFunzCampiTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.transform.Transformers;



public class CroFunzCampiDaoImpl extends AbstractCommonDaoImpl implements CroFunzCampiDao{
	
	@SuppressWarnings("unchecked")
	public List<CroFunzCampiTO> loadListByNomeFunzioneTableNameCroTrans(String codiAction, String tableName, String fkCroTrans) throws Throwable{
		
		String queryString="SELECT " +
				"codi_action as codiAction, " +
				"table_name as tableName, " +
				"field_name as fieldName, " +
				"fk_cro_codici as fkCroCodici, " +
				"fk_cro_trans as fkCroTrans, " +
				"check_equality as checkEquality, " +
				"nume_ordi_visu as numeOrdiVisu, " +
				"column_cro_dati as columnCroDati, " +
				"gruppo, " +
				"pattern_group as patternGroup, " +
				"sql_query_decode as sqlQueryDecode " +
				" from d_cro_funz_campi " +
				"where " +
				"codi_action=:codiAction " +
				"and table_name=:tableName " +
				"and fk_Cro_Trans=:fkCroTrans order by nume_ordi_visu";
		
		List<CroFunzCampiTO> view = null;
		
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		query.addScalar("codiAction", 	Hibernate.STRING)
		.addScalar("tableName", 		Hibernate.STRING)
		.addScalar("fieldName", 		Hibernate.STRING)
		.addScalar("fkCroCodici", 		Hibernate.INTEGER)
		.addScalar("fkCroTrans", 		Hibernate.INTEGER)
		.addScalar("checkEquality", 	Hibernate.STRING)
		.addScalar("numeOrdiVisu", 		Hibernate.SHORT)
		.addScalar("columnCroDati", 	Hibernate.STRING)
		.addScalar("gruppo", 			Hibernate.INTEGER)
		.addScalar("patternGroup", 		Hibernate.STRING)
		.addScalar("sqlQueryDecode", 	Hibernate.STRING);
		
		query.setString("codiAction", codiAction);
		query.setString("tableName", tableName);
		query.setString("fkCroTrans", fkCroTrans);
		
		view = (List<CroFunzCampiTO>) query.setResultTransformer(
				Transformers.aliasToBean(CroFunzCampiTO.class))
				.setCacheMode(CacheMode.GET).list();	
		
		return view;	
	}

	@Override
	public String decode(
			String queryString,
			String paramName, 
			String paramValue) throws Throwable {
		
		SQLQuery query= getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(queryString);
		
		query.setString(paramName, paramValue);
		
		return (String)query.uniqueResult();
	}		
	
	@Override
	public String getTableNameByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable {
		ClassMetadata hibernateMetadata = getHibernateTemplate().getSessionFactory().getClassMetadata(persistentClass);
		AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;

		if (hibernateMetadata != null && hibernateMetadata instanceof AbstractEntityPersister) {
			return persister.getTableName();
		}else{ 
			return null;
		}
		
	}
	
	@Override
	public List<String> getKeyColumnNamesByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable {
		ClassMetadata hibernateMetadata = getHibernateTemplate().getSessionFactory().getClassMetadata(persistentClass);

		if (hibernateMetadata != null && (hibernateMetadata instanceof AbstractEntityPersister)) {
			AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
			
			return Arrays.asList(persister.getKeyColumnNames());
		}else{
			return null;
		}
	}	

	@Override
	public List<String> getColumnNamesByClass(Class<? extends AbstractCommonBO> persistentClass) throws Throwable {
		List<String> columnNames=new ArrayList<String>();

		ClassMetadata hibernateMetadata = getHibernateTemplate().getSessionFactory().getClassMetadata(persistentClass);

		if (hibernateMetadata != null && hibernateMetadata instanceof AbstractEntityPersister) {
				AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;

				for (String propertyName : persister.getPropertyNames()) {
					if (persister.getPropertyColumnNames(propertyName).length > 0) {
						String appo=persister.getPropertyColumnNames(propertyName)[0];
						if(!Arrays.asList(persister.getKeyColumnNames()).contains(appo)){
							columnNames.add(appo);
						}
					}
				}
		}
		return columnNames;
	}
	

}
