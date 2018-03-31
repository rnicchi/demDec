package it.mef.bilancio.demdec.web.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.getInputStreamFromClasspath;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.web.spring.controller.AbstractMultiActionController;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;
import it.almavivaitalia.web.sh.utils.PageMessages;
import it.almavivaitalia.web.sh.utils.PropertyKey;
import it.almavivaitalia.web.sh.utils.Util;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;
import it.mef.bilancio.demdec.manager.InitManager;
import it.mef.bilancio.demdec.manager.ListManager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContextAware;

public class InitController extends AbstractMultiActionController implements
		ApplicationContextAware, WebConstants, SessionAttributes {

	private InitManager initManager;
	@SuppressWarnings("unused")
	private ListManager listManager;

	public void setInitManager(InitManager initManager) {
		this.initManager = initManager;
	}

	public void init() throws Throwable {
		setServletContextAttribute(
				BaseSessionAttributes.PATH_HELP_APP,
				initManager
						.searchPropertyValueFromTabServ(BaseSessionAttributes.PATH_HELP_APP));
		initMessageSourceDependencies();
		initStaticList();
		initFieldFormatterMaps();
		evaluateHelpVersion();
		initEsercizi();
	}

	/*
	 * Metodo per l'inizializzazione di liste statiche
	 */
	private void initStaticList() throws Throwable {
//		setServletContextAttribute(CommonsList.LIST_TIPO_SUB_AUT, 	listManager.loadSubAutList());
	}

	private void setServletContextAttribute(String key, Object attribute) {
		getServletContext().setAttribute(key, attribute);

	}

	/*
	 * Caricamento file per esport
	 * 
	 * Per ogni formatter aggiungere un'istruzione del tipo map.put(String
	 * nomeFileSenzaEstensione, getFieldFormatterMap(String
	 * nomeFileSenzaEstensione)); come ad esempio:
	 * map.put("risultatiCompetenzaFormatter",
	 * getFieldFormatterMap("risultatiCompetenzaFormatter"));
	 */
	private void initFieldFormatterMaps() throws Throwable {
		Map<String, LinkedHashMap<PropertyKey, FieldFormatter>> map = new HashMap<String, LinkedHashMap<PropertyKey, FieldFormatter>>();
		// map.put("DicitureFirmeFormatter",
		// getFieldFormatterMap("DicitureFirmeFormatter"));
		map.put("EserciziFormatter",getFieldFormatterMap("EserciziFormatter"));
		/*
		map.put("StrumentiFormatter",getFieldFormatterMap("StrumentiFormatter"));	
		map.put("CapitoliFormatter",getFieldFormatterMap("CapitoliFormatter"));
		map.put("PigFormatter",getFieldFormatterMap("PigFormatter"));
		map.put("AttiFormatter",getFieldFormatterMap("AttiFormatter"));
		map.put("AutorFormatter",getFieldFormatterMap("AutorFormatter"));
		map.put("CapAutFormatter",getFieldFormatterMap("CapAutFormatter"));
		map.put("IntGestOrizExportFormatter",getFieldFormatterMap("IntGestOrizExportFormatter"));
		map.put("IntGestVertExportFormatter",getFieldFormatterMap("IntGestVertExportFormatter"));
		map.put("IntGestOrizExportExcelFormatter",getFieldFormatterMap("IntGestOrizExportExcelFormatter"));
		map.put("IntGestVertExportExcelFormatter",getFieldFormatterMap("IntGestVertExportExcelFormatter"));
		map.put("SottoStrumentiPlbFormatter",getFieldFormatterMap("SottoStrumentiPlbFormatter"));
		map.put("AmminFormatter",getFieldFormatterMap("AmminFormatter"));
		map.put("CodeDescriptionFormatter",getFieldFormatterMap("CodeDescriptionFormatter"));
		map.put("CodeDescriptionAmminFormatter",getFieldFormatterMap("CodeDescriptionAmminFormatter"));
		map.put("CodeDescriptionSottostrumentiFormatter",getFieldFormatterMap("CodeDescriptionSottostrumentiFormatter"));
		map.put("IntPartiteExportFormatter",getFieldFormatterMap("IntPartiteExportFormatter"));
		map.put("TipoStrumentiFormatter",getFieldFormatterMap("TipoStrumentiFormatter"));
		*/
		setServletContextAttribute(MAP_FIELD_FORMATTER_MAPS, map);
	}

	private void evaluateHelpVersion() throws Throwable {
		setServletContextAttribute(
				it.mef.bilancio.demdec.web.spring.utils.SessionAttributes.FLAG_IS_NEW_HELP_VERSION,
				Boolean.TRUE);
	}

	private void initMessageSourceDependencies() {
		PageMessages pageMessages = new PageMessages(getMessageSource());
		setServletContextAttribute(OBJECT_PAGE_MESSAGES, pageMessages);
		
		setServletContextAttribute(DEFAULT_MESSAGE_SOURCE, getMessageSource());
	}

	private static LinkedHashMap<PropertyKey, FieldFormatter> getFieldFormatterMap(
			String xmlName) throws Throwable {
		return Util
				.unMarshallFieldFormatterMap(getInputStreamFromClasspath(FIELD_FORMATTER_PATH
						+ xmlName + ".xml"));
	}

	private void initEsercizi() throws Throwable {
		List<EserciziTO> esercizi = initManager.loadEsercizi();

		if (esercizi != null && !esercizi.isEmpty()) {
			for (EserciziTO to : esercizi) {
				if (to.getStatTipoEse().equals(STAT_TIPO_ESE_GESTIONE)) {
					setServletContextAttribute(ESERCIZIO_NUOVA_GESTIONE,
							to.getId());
					setServletContextAttribute(FENG, to.getStatStatus());
				} else if (to.getStatTipoEse().equals(STAT_TIPO_ESE_FORMAZIONE)
						|| (to.getStatTipoEse().equals(STAT_TIPO_ESE_GESTIONE) && to
								.getStatStatus().equals(
										STAT_STATUS_ENG_ESE_PROVVISORIO))) {
					setServletContextAttribute(ESERCIZIO_BILANCIO_FORMAZIONE,
							to.getId());
					setServletContextAttribute(FEBF, to.getStatStatus());
				} else if (to.getStatTipoEse().equals(STAT_TIPO_ESE_CONSUNTIVO)) {
					setServletContextAttribute(ESERCIZIO_VECCHIA_GESTIONE,
							to.getId());
					setServletContextAttribute(FEVG, to.getStatStatus());
				}
			}
		}

	}

	public void setListManager(ListManager listManager) {
		this.listManager = listManager;
	}

}
