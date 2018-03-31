package it.almavivaitalia.bsn.sh.utils;

import it.almavivaitalia.bsn.sh.paginator.StaticPaginatorImpl;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;

import java.util.List;

public class PaginatorUtil {
	
	
	/**
	 * Gestendo la visualizzazione di un insieme di elementi tramite la Paginazione
	 * e con la classica tabella che mostra ciascun elemento su una riga, nelle funzioni
	 * che permettono l'inserimento di altri elementi subito dopo un determinato altro
	 * elemento, puo' essere utile individuare l'indice di riga e la pagina di appartenenza
	 * dei nuovi elementi inseriti in modo da poterli evidenziare rendendone l'individuazione
	 * da pèarte dell'utente piu' semplice. 
	 * Il metodo calculateRowAndPageSelected (int pageSize, int indSelBeforeIns, int numEleIns, int pageSelected)
	 * risponde proprio a questa esigenza restituendo in un array di stringhe di 2 elementi, con
	 * il primo che elenca gli indici di riga di interesse (separando ciascuno dal successivo con una virgola)
	 * ed il secondo che referenzia la pagina di appartenenza degli indici precedenti o, nel caso questi
	 * si sviluppino su piu' pagine, indicando la pagina contenente l'ultimo degli indici selezionati.
	 * Es. di output:
	 * out[0] = 1,2,3;
	 * out[1] = 1;
	 * che indica gli indici di riga 1, 2 e 3 della pagina 1.  
	 * Il metodo prevede in ingresso: 
	 * @param pageSize, max numero di elementi per ciascuna pagina;
	 * @param indSelBeforeIns, indice di riga dell'elemento al seguito del quale inserire gli altri oggetti;
	 * @param numEleIns, numero di elementi inseriti;
	 * @param pageSelected, pagina di appartenenza dell'elemento al seguito del quale inserire.
	 * @return
	 */
	public static String[] calculateRowAndPageSelected (int pageSize, int indSelBeforeIns, int numEleIns, int pageSelected)
	{
		String[] out = new String[2];
		
		int singleRowSel = indSelBeforeIns + numEleIns;
		if (singleRowSel > (pageSize - 1))
		{
			pageSelected++;
			singleRowSel = singleRowSel - pageSize;
		}	
		
		String appo = "";
		for (int k=0; k<numEleIns; k++)
		{
			appo = appo.trim().length() == 0? appo : appo + ",";
			appo = appo + String.valueOf(singleRowSel - k);
		}	
		
		out[0] = appo;
		out[1] = String.valueOf(pageSelected);
			
		return out;
	}
	
	public static void addPaginator(List<?> list, String sessionNameList, int pageRange, Context context) throws Throwable{
		PaginatorUtil.addPaginator(context, list, sessionNameList, pageRange, BaseSessionAttributes.OBJECT_PAGINATOR);
//		StaticPaginatorImpl paginator = new StaticPaginatorImpl(list, sessionNameList, pageRange);
//		paginator.setList(list);
//        context.setDataModel(sessionNameList, paginator.update());       
//        context.setDataModel(BaseSessionAttributes.OBJECT_PAGINATOR, paginator);
	}
	
	public static void removePaginator(Context context, String sessionNameList) throws Throwable{
		PaginatorUtil.removePaginator(context, sessionNameList, BaseSessionAttributes.OBJECT_PAGINATOR);
//		context.removeDataModel(sessionNameList);
//		context.removeDataModel(BaseSessionAttributes.OBJECT_PAGINATOR);
	}

	public static void addPaginator(Context context,List<?> list, String sessionNameList, int pageRange, String paginatorSessionName ) throws Throwable{
		StaticPaginatorImpl paginator = new StaticPaginatorImpl(list, sessionNameList, pageRange);
//		paginator.setList(list);
        context.setDataModel(sessionNameList, paginator.update());       
        context.setDataModel(paginatorSessionName, paginator);
	}
	
	public static void removePaginator(Context context, String sessionNameList, String paginatorSessionName) throws Throwable{
		context.removeDataModel(sessionNameList);
		context.removeDataModel(paginatorSessionName);
	}

}
