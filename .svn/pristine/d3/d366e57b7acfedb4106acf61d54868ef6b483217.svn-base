package it.mef.bilancio.demdec.dao;

import it.almavivaitalia.bilancio.commons.bo.AnagStatoFascicoloBO;

import java.util.List;

public interface AnagStatoFascicoloDao extends AbstractDemDao<AnagStatoFascicoloBO>{
	List<AnagStatoFascicoloBO> loadStatiFascicoloRed();
	List<AnagStatoFascicoloBO> loadStatiFascicoloFad();
	List<AnagStatoFascicoloBO> loadStatiFascicoloMonitoraggio();
	List<AnagStatoFascicoloBO> loadStatiFascicolo(String tipoFascicolo);
	List<AnagStatoFascicoloBO> loadStatiFascicoloModifica(String tipoFascicolo);
	String loadDecStatiFascicoloFad(String id);
	String loadDescStatiFascicoloRed(String id);
}
