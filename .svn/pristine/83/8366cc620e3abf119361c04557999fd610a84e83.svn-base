package it.almavivaitalia.bsn.sh.paginator;

import java.util.List;


public abstract class AbstractPaginator extends AbstractParentPaginator implements Paginator{

		/*LOCM*/
		@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
		@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
		@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
		/*END LOCM*/
		
		
//		private int currentPage;
//		private int pageRange;
		private int pageSize;
//		private int numberOfElements;
//		
		//Valore numerico che indica il numero di eventuali	elementi fittizi presenti nella lista 
		//degli oggetti presentati a video. In genere in effetti, specie per le interfacce
		//che offrono la possibilita' di aggiungere nuovi elementi, in testa
		//alla lista degli elementi stessi, ne viene inserito uno fittizio
		//il cui scopo e' quello di poter inserire un elemento vero e proprio
		//come primo elementi della lista. Scopo di tale attributo e' quello di 
		//poter indicare il numero di eventuali elementi fittizi in modo da
		//non considerarli nel conteggio, e quindi di evitare di presentare a video
		//informazioni errate.  		
		private int numberOfDummyElements;
		
		//Con la possibilita' di abilitare/disabilitare la paginazione c'e' la necessita'
		//di mantenere memoria sull'oggetto Paginator della pageSize impostata in precedenza
		//ed eventualmente rimossa a fronte di una richiesta di rimozione della Paginazione.
		//Il campo bckInitialPageSize opportunamente impostato dal costruttore in fase di
		//creazione di un'istanza del paginator ha tale compito.
		private int bckInitialPageSize;
		
		//Boolean che indica se abilitare/disabilitare
		//la Paginazione. In combinazione col valore del controllerCodeEnableDisablePagin
		//regola la presenza del tasto per disabilitare la paginazione
		//(caso in cui paginationEnabled vale true) o per abilitare la
		//stessa (quando l'attributo in questione vale false).
		//NB: 
		//1) Abilitare/Disabilitare la paginazione significa rispettivamente
		//   presentare il risultato su piu' pagine (nel caso il numero degli
		//   elementi superi il num max ammesso per singola pagina) o visualizzare
		//   tutti gli elementi su una singola pagina, indipendentemente da quanti
		//   essi siano.
		private Boolean paginationEnabled;
//		
//		//Campo che prevede il nome della var di sessione sfruttata per memorizzare
//		//la lista degli elementi visualizzati sull'interfaccia web
//		private String nameSessionList;
//		
		//indica se posizionarsi sull'ultima pagina della paginazione
		//quando l'eventuale pagina da selezionare indicata non esiste
		//(in caso contrario la pagina selezionata sara' la prima)
		private Boolean goToLastPageIfPageNotFound;
		

		

		



		public AbstractPaginator(){
			super();
			paginationEnabled=Boolean.TRUE;
//			pageRange = PAGE_RANGE_10;
			pageSize = PAGE_SIZE_15;
			bckInitialPageSize = PAGE_SIZE_15;
			numberOfDummyElements = 0;
			paginationEnabled = Boolean.TRUE;
			goToLastPageIfPageNotFound = Boolean.FALSE;
		}
		

		public AbstractPaginator(int pageSize){
			this();
			this.pageSize = pageSize;
			this.bckInitialPageSize = pageSize;
		}
		
		
		/**
		 * Agisce sul campo che indica se posizionarsi sull'ultima pagina della paginazione
		 * quando l'eventuale pagina da selezionare indicata non esiste
		 * (in caso contrario la pagina selezionata sara' la prima)
		 */
		public void setGoToLastPageIfPageNotFound(Boolean goToLastPageIfPageNotFound){
			this.goToLastPageIfPageNotFound = goToLastPageIfPageNotFound;
		}
		
		/**
		 * Agisce sul campo che indica se posizionarsi sull'ultima pagina della paginazione
		 * quando l'eventuale pagina da selezionare indicata non esiste
		 * (in caso contrario la pagina selezionata sara' la prima)
		 */
		public Boolean getGoToLastPageIfPageNotFound(){
			if (goToLastPageIfPageNotFound==null)
			{
				goToLastPageIfPageNotFound = Boolean.FALSE;
			}	
			return this.goToLastPageIfPageNotFound;
		}		
		
		
		/**
		 * Getter del campo numerico che indica il numero di eventuali elementi fittizi 
		 * presenti nella lista degli oggetti presentati a video. In genere in effetti, specie 
		 * per le interfacce che offrono la possibilita' di aggiungere nuovi elementi, in testa
		 * alla lista degli elementi stessi, ne viene inserito uno fittizio
		 * il cui scopo e' quello di poter inserire un elemento vero e proprio
		 * come primo elementi della lista. Scopo di tale attributo e' quello di 
		 * poter indicare il numero di eventuali elementi fittizi in modo da
		 * non considerarli nel conteggio, e quindi di evitare di presentare a video
		 * informazioni errate. 
		*/
		public int getNumberOfDummyElements() {
			return numberOfDummyElements;
		}
		
		/**
		 * Setter del campo numerico che indica il numero di eventuali elementi fittizi 
		 * presenti nella lista degli oggetti presentati a video. In genere in effetti, specie 
		 * per le interfacce che offrono la possibilita' di aggiungere nuovi elementi, in testa
		 * alla lista degli elementi stessi, ne viene inserito uno fittizio
		 * il cui scopo e' quello di poter inserire un elemento vero e proprio
		 * come primo elementi della lista. Scopo di tale attributo e' quello di 
		 * poter indicare il numero di eventuali elementi fittizi in modo da
		 * non considerarli nel conteggio, e quindi di evitare di presentare a video
		 * informazioni errate. 
		*/
		public void setNumberOfDummyElements(int numberOfDummyElements) {
			this.numberOfDummyElements = numberOfDummyElements;
		}		
		
		
		/**
		 * Getter per agire sul campo bckInitialPageSize che mantiene memoria del max numero di
		 * elementi da visualizzare su una pagina. Il campo potrebbe sembrare una ripetizione data
		 * la presenza del campo pageSize, ma si rende utile quando ad esempio dopo la disabilitazione
		 * della Paginazione, si richiede nuovamente di impaginare il risultato. Come rimpostare la
		 * vecchia dimensione della pagina? Il campo bckInitialPageSize opportunamente impostato in fase
		 * di creazione dell'istanza del Paginator dovrebbe contenere il valore della vecchia dimensione della pagina. 
		*/
		public int getBckInitialPageSize() {
			return bckInitialPageSize;
		}
		

		
		
		
		/**
		 * Getter del Boolean che indica se abilitare/disabilitare
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
		public Boolean getPaginationEnabled() {
			if (paginationEnabled == null)
			{
				paginationEnabled = Boolean.TRUE;
			}	
			
			return paginationEnabled;
		}
		
		/**
		 * Setter del Boolean che indica se abilitare/disabilitare
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


	
		public int[] getCurrentPageRange() throws Throwable{
			
			int numberOfPages = getNumberOfPages();
			if ((getCurrentPage()>=numberOfPages) || getCurrentPage()<0){
				throw new Throwable("current page: "+getCurrentPage()+" out of bounds ["+0+", "+(numberOfPages-1)+"]");
			}else {
				int startPage =(-1)*getPageRange();
				int endPage=-1;
				boolean found = false;
				while(!found){
					startPage+=getPageRange();
					endPage+=getPageRange();
					if (endPage>=numberOfPages){
						endPage=numberOfPages-1;
					}
					found = (getCurrentPage()<=endPage) && (getCurrentPage()>=startPage);
				}
				int[] range = new int[2];
				range[0]=startPage;
				range[1]=endPage;
				return range;
			}
		}
		
	
		public int getFirstResultIndex(){
			return getCurrentPage()*pageSize;
		}
		
		
		public void checkValuePaginator(List<?> list)
		{
			//Distinguo paginazione abilitata/disabilitata
			if (!getPaginationEnabled().booleanValue())
			{	//paginazione disabilitata
				setCurrentPage(0);
				setPageSize(list.size());
			}	
			else
			{	//paginazione abilitata
				
				//Gestione PageSize qualora la Paginazione venga 
				//disabilitata e poi riabilitata
				if (getBckInitialPageSize()!= getPageSize())
				{	
					if ( getBckInitialPageSize()!=0 )
					{	
						setPageSize(getBckInitialPageSize());
					}
					else
					{
						setPageSize(PAGE_SIZE_15);
					}	
				}
				
				
				//Gestione Pagina Selezionata dato che questa potrebbe 
				//indicare un valore non contemplato, poiche' la pag 
				//da selezionare puo' essere impostata dall'esterno
				if (getCurrentPage() > (getNumberOfPages()-1))
				{
					if (getGoToLastPageIfPageNotFound().booleanValue())
					{	
						while (getCurrentPage() > (getNumberOfPages()-1))
						{
							setCurrentPage(getCurrentPage() - 1);
						}	
						setGoToLastPageIfPageNotFound(Boolean.FALSE);
					}	
					else
					{	
						setCurrentPage(0);
					}
				}	
			}			
		}	
		
		public void setPaginationEnabled(Boolean paginationEnabled) {
			this.paginationEnabled = paginationEnabled;
		}	
		
		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		
	
		/*public int getNumberOfPages(){
			if (getPageSize()>0){
				return (int)Math.ceil(((double)getNumberOfElements())/((double)getPageSize()));
			}else {
				return 0;
			}
		}*/


//		public void setNextPageRange() throws Throwable{
//			int[] currentPageRange=getCurrentPageRange();
//			if (currentPageRange[1]<getNumberOfPages()-1){
//				setCurrentPage(currentPageRange[1]+1);
//			}
//		}
//		public void setPrevPageRange() throws Throwable{
//			int[] currentPageRange=getCurrentPageRange();
//			if (currentPageRange[0]>0){
//				setCurrentPage(currentPageRange[0]-1);
//			}
//		}

	}
