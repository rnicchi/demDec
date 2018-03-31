package it.almavivaitalia.bsn.sh.utils;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public abstract class AbstractFlexibleQuery {
	
	private Query query;
	
	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	
		public Object uniqueResult() throws HibernateException {
	
			return query.uniqueResult();
		}

	public boolean equals(Object obj) {
	
		return query.equals(obj);
	}

	

	

}
