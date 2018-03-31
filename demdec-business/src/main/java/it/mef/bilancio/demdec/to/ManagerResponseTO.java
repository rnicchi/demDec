package it.mef.bilancio.demdec.to;

import it.almavivaitalia.bilancio.commons.to.AbstractCommonTO;
import it.mef.bilancio.demdec.enums.TipoResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManagerResponseTO<T extends AbstractCommonTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoResponse codice;
	private String descrizione;
	private List<AbstractCommonTO> listaTo;


	public ManagerResponseTO(TipoResponse codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	public ManagerResponseTO(TipoResponse codice, String descrizione, T to) {
		this.codice = codice;
		this.descrizione = descrizione;
		listaTo = new ArrayList<AbstractCommonTO>();
		listaTo.add(to);
	}
	public ManagerResponseTO(TipoResponse codice, String descrizione, List<T> listaTO) {
		this.codice = codice;
		this.descrizione = descrizione;
		listaTo = new ArrayList<AbstractCommonTO>(listaTO);
	}

	//getters & setters
	public TipoResponse getCodice() {
		return codice;
	}
	public void setCodice(TipoResponse codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<AbstractCommonTO> getListaTo() {
		return listaTo;
	}
	public void setListaTo(List<AbstractCommonTO> listaTo) {
		this.listaTo = listaTo;
	}
}
