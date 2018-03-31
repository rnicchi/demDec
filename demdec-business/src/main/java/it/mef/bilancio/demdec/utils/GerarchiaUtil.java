package it.mef.bilancio.demdec.utils;

import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GerarchiaUtil {

	private static final String[] classeOrdinaria = {"odd", "even"};

	private static final String[] classegruppo = {"bg_colgroup_1", "bg_colgroup_2", "bg_colgroup_3", "bg_colgroup_4"};

	public static List<DocumentTO> ordinaGerarchia(List<DocumentTO> lista){
		ArrayList<DocumentTO> result = new ArrayList<DocumentTO>();
		HashMap<String, List<DocumentTO>> mappa = new HashMap<String, List<DocumentTO>>();
		ArrayList<DocumentTO> padri = new ArrayList<DocumentTO>();
		for(DocumentTO to:lista){
			if (StringUtil.isEmpty(to.getDocumentoFileOrigine())){
				padri.add(to);
			} else {
				if (mappa.containsKey(to.getDocumentoFileOrigine().getIdDocumento())){
					List<DocumentTO> figli = mappa.get(to.getDocumentoFileOrigine().getIdDocumento());
					figli.add(to);
//					mappa.put(to.getDocumentoFileOrigine().getIdDocumento(), figli);
				} else {
					ArrayList<DocumentTO> figli = new ArrayList<DocumentTO>();
					figli.add(to);
					mappa.put(to.getDocumentoFileOrigine().getIdDocumento(), figli);
				}
			}
			if(!mappa.containsKey(to.getIdDocumentoRaccoltaProvvisoria())){
				ArrayList<DocumentTO> figli = new ArrayList<DocumentTO>();
				mappa.put(to.getIdDocumentoRaccoltaProvvisoria(), figli);
			}
		}
		int i=0;
		for(DocumentTO to:padri){
			List<DocumentTO> figli = mappa.get(to.getIdDocumentoRaccoltaProvvisoria());
			String rowClassStyle = figli.isEmpty()?classeOrdinaria[i%2]:classegruppo[i%4];
			to.setRowClassStyle(rowClassStyle);
			result.add(to);
			result.addAll(caricaFigli(rowClassStyle ,mappa, to.getIdDocumentoRaccoltaProvvisoria()));
		}
		return result;
	}
	
	public static List<DocumentTO> caricaFigli(String rowClassStyle, HashMap<String, List<DocumentTO>> mappa,String key){
		ArrayList<DocumentTO> result = new ArrayList<DocumentTO>();
		List<DocumentTO> figli = mappa.get(key);
		for(DocumentTO to: figli){
			to.setRowClassStyle(rowClassStyle);
			result.add(to);
			result.addAll(caricaFigli(rowClassStyle,mappa, to.getIdDocumentoRaccoltaProvvisoria()));
		}
		return result;
	}
}
