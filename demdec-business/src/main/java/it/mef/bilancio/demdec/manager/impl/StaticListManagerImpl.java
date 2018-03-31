package it.mef.bilancio.demdec.manager.impl;

import java.util.ArrayList;
import java.util.List;

import it.almavivaitalia.bilancio.commons.to.CodeDescriptionTO;
import it.mef.bilancio.demdec.manager.StaticListManager;

public class StaticListManagerImpl extends AbstractDemManagerImpl implements StaticListManager {
/*
	
	@Override
	public List<CodeDescriptionTitleTO> loadSubAutList() throws Throwable {
		List<CodeDescriptionTitleTO> list = new ArrayList<CodeDescriptionTitleTO>();
		list.add(new CodeDescriptionTitleTO("0",  " ", " "));
		return list;
	}

	public static HashMap<String, String> getSubMap(){
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("0",  "0");
		result.put("1",  "primum");
		return result;
	}
*/

	@Override
	public List<CodeDescriptionTO> loadVisibilitaCdc() throws Throwable {
		List<CodeDescriptionTO> list = new ArrayList<CodeDescriptionTO>();
		list.add(new CodeDescriptionTO("0",  "Non Visibile"));
		list.add(new CodeDescriptionTO("1",  "Visibile"));
		return list;
	}
}
