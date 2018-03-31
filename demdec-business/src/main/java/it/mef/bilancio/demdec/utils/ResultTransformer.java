package it.mef.bilancio.demdec.utils;

import org.hibernate.transform.AliasToBeanResultTransformer;

public class ResultTransformer extends AliasToBeanResultTransformer {

	public ResultTransformer(Class<?> type) {
		super(type);
	}
	
	public Object transformTuple(Object[] tuple, String[] aliases) {
		if(tuple!=null && tuple.length>0){
			boolean empty = true;
			for (Object ob : tuple) {
			  if (ob != null) {
			    empty = false;
			    break;
			  }
			}
			if(!empty){
				return super.transformTuple(tuple, aliases);
			}
		}
		return null;
	}	
	
	private static final long serialVersionUID = 1L;

}
