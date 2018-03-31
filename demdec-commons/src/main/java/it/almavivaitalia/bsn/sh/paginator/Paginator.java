package it.almavivaitalia.bsn.sh.paginator;

import java.util.List;

public interface Paginator {
	
	public final static int PAGE_RANGE_5 = 5;
	public final static int PAGE_RANGE_10 = 10;
	public final static int PAGE_RANGE_15 = 15;
	public final static int PAGE_SIZE_10 = 10;
	public final static int PAGE_SIZE_15 = 15;
	public final static int PAGE_SIZE_20 = 20;
	public final static String PARAMETER_PAGINATOR="paginator";
	public final static String PARAMETER_ENABLE_DISABLE_PAGIN="enableDisablePagin";
	public final static String PAGINATOR_NAME="paginator";	
	
	public abstract int getNumberOfElements();

	public abstract void setNumberOfElements(int numberOfElements);

	public abstract int getPageSize();

	public abstract int getCurrentPage();

	public abstract void setCurrentPage(int currentPage);

	public abstract int[] getCurrentPageRange() throws Throwable;

	public abstract int getFirstResultIndex();

	public abstract List<?> update() throws Throwable;

	public abstract int getNumberOfPages();
	public abstract int getPageRange();

	public abstract void setPageRange(int pageRange);
	
	public abstract void setNextPageRange() throws Throwable;
	public abstract void setPrevPageRange() throws Throwable;
	
	/**
	 * 
	 * Deve restituire il nome della var di sessione sfruttata per memorizzare
	 * la lista degli elementi visualizzati sull'interfaccia web
	 */
	public abstract String getNameSessionList() throws Throwable;
	
	
	/**
	 * Setter e getter per agire sul Boolean che indica se abilitare/disabilitare
	 * la Paginazione. In combinazione col valore del controllerCodeEnableDisablePagin
	 * regola la presenza del tasto per disabilitare la paginazione
	 * (caso in cui paginationEnabled vale true) o per abilitare la
	 * stessa (quando l'attributo in questione vale false).
	 * NB: 
	 * 1) Abilitare/Disabilitare la paginazione significa rispettivamente
	 *    presentare il risultato su piu' pagine (nel caso il numero degli
	 *    elementi superi il num max ammesso per singola pagina) o visualizzare
	 *    tutti gli elementi su una singola pagina, indipendentemente da quanti
	 *    essi siano.
	 */
	public abstract void setPaginationEnabled(Boolean paginationEnabled) throws Throwable;
	public abstract Boolean getPaginationEnabled() throws Throwable;
	
	
	/**
	 * Getter per agire sul campo bckInitialPageSize che mantiene memoria del max numero di
	 * elementi da visualizzare su una pagina. Il campo potrebbe sembrare una ripetizione data
	 * la presenza del campo pageSize, ma si rende utile quando ad esempio dopo la disabilitazione
	 * della Paginazione, si richiede nuovamente di impaginare il risultato. Come rimpostare la
	 * vecchia dimensione della pagina? Il campo bckInitialPageSize opportunamente impostato in fase
	 * di creazione dell'istanza del Paginator dovrebbe contenere il valore della vecchia dimensione della pagina. 
	*/
	public abstract int getBckInitialPageSize();

	
	
	/**
	 * Setter e getter per il Valore numerico che indica il numero di eventuali elementi fittizi 
	 * presenti nella lista degli oggetti presentati a video. In genere in effetti, specie 
	 * per le interfacce che offrono la possibilita' di aggiungere nuovi elementi, in testa
	 * alla lista degli elementi stessi, ne viene inserito uno fittizio
	 * il cui scopo e' quello di poter inserire un elemento vero e proprio
	 * come primo elementi della lista. Scopo di tale attributo e' quello di 
	 * poter indicare il numero di eventuali elementi fittizi in modo da
	 * non considerarli nel conteggio, e quindi di evitare di presentare a video
	 * informazioni errate. 
	*/
	public abstract void setNumberOfDummyElements(int numberOfDummyElements);
	public abstract int getNumberOfDummyElements();
	
	/**
	 * Agisce sul campo che indica se posizionarsi sull'ultima pagina della paginazione
	 * quando l'eventuale pagina da selezionare indicata non esiste
	 * (in caso contrario la pagina selezionata sara' la prima)
	 */
	public abstract void setGoToLastPageIfPageNotFound(Boolean goToLastPageIfPageNotFound);
	
}