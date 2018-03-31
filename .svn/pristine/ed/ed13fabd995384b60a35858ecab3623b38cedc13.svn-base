package it.almavivaitalia.web.sh.spring.controller;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.TableModel;
import it.almavivaitalia.web.sh.form.ItemSelectorForm;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PropertyKey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;


public class ItemSelectorController extends AbstractFormController {

	private String view;
	public void setView(String view) {
		this.view = view;
	}
	
	public String getView() {
		return view;
	}

	@Override
	public String startController(Context nssbContext) throws Throwable {
//		return onInit(context);
		
		nssbContext.removeDataModel(OBJECT_SELECTOR_ITEM_SELECTED_INDEXES);
		List<Object> selected =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_SELECTED);
		
		if (!isEmpty(selected)){
			List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
			
			List<Integer> selectedIndexes = new ArrayList<Integer>();
			for (Object element : selected) {
				int index = list.indexOf(element);
				if (index >=0){
					selectedIndexes.add(new Integer(index));
				}
			}
			
			StringBuffer displayTableIndexes=new StringBuffer();
			String[] formIndexes = new String[selectedIndexes.size()];
			
			if (selectedIndexes.size()>0){
				for (int i=0; i<selectedIndexes.size(); i++) {
					Integer index = selectedIndexes.get(i);
					if (i>0){
						displayTableIndexes.append(",");
					}
					displayTableIndexes.append(index);
					formIndexes[i]=""+index;
				}	
				nssbContext.setDataModel(OBJECT_SELECTOR_ITEM_SELECTED_INDEXES, displayTableIndexes.toString());
			}
			
			
			ItemSelectorForm form = nssbContext.getForm();
			form.setRow(formIndexes);
		}
		
		return view;
	}
	
//	@SuppressWarnings("unchecked")
//	public String onInit(Context nssbContext) throws Throwable {
//		nssbContext.removeDataModel(OBJECT_SELECTOR_ITEM_SELECTED_INDEXES);
//		List<Object> selected =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_SELECTED);
//		
//		if (!isEmpty(selected)){
//			List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
//			
//			List<Integer> selectedIndexes = new ArrayList<Integer>();
//			for (Object element : selected) {
//				int index = list.indexOf(element);
//				if (index >=0){
//					selectedIndexes.add(new Integer(index));
//				}
//			}
//			
//			StringBuffer displayTableIndexes=new StringBuffer();
//			String[] formIndexes = new String[selectedIndexes.size()];
//			
//			if (selectedIndexes.size()>0){
//				for (int i=0; i<selectedIndexes.size(); i++) {
//					Integer index = selectedIndexes.get(i);
//					if (i>0){
//						displayTableIndexes.append(",");
//					}
//					displayTableIndexes.append(index);
//					formIndexes[i]=""+index;
//				}	
//				nssbContext.setDataModel(OBJECT_SELECTOR_ITEM_SELECTED_INDEXES, displayTableIndexes.toString());
//			}
//			
//			
//			ItemSelectorForm form = nssbContext.getForm();
//			form.setRow(formIndexes);
//		}
//		
//		return view;
//	}

	
	@SuppressWarnings("unchecked")
	public String onSelect(Context nssbContext) throws Throwable {
		//String row = nssbContext.getCommandParameter("select");
		String row = nssbContext.getMethodParameter();
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		List<Object> selected =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_SELECTED);
		Object element = list.get(Integer.parseInt(row));
		selected.add(element);
		return nssbContext.backItemSelector();
	}
	

	@SuppressWarnings("unchecked")
	public String onMultiSelect(Context nssbContext) throws Throwable {
		String[] rows = ((ItemSelectorForm)nssbContext.getForm()).getRow();
		List<Integer> selectedIndexes = new ArrayList<Integer>();
		if (rows!=null){
			for (int i=0; i<rows.length; i++){
				selectedIndexes.add(new Integer(rows[i]));
			}
		}
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		List<Object> selected =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_SELECTED);
		for (int i=0; i<list.size(); i++){
			Object element = list.get(i);
			if (selectedIndexes.contains(new Integer(i))){
				if (!selected.contains(element)){
					selected.add(element);
				}
			}else{
				selected.remove(element);
			}
		}
//		return onInit(nssbContext);
		return startController(nssbContext);
		
	}
	@SuppressWarnings("unchecked")
	public String onSelectAll(Context nssbContext) throws Throwable {
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		if (list!=null){
			List<Object> selected =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_SELECTED);
			for (int i=0; i<list.size(); i++){
				Object element = list.get(i);
				if (!selected.contains(element)){
					selected.add(element);
				}
			}
		}
//		return onInit(nssbContext);
		return startController(nssbContext);
	}
	public String onCancel(Context nssbContext) throws Throwable {
		return nssbContext.backItemSelector();
	}

	
	@SuppressWarnings("unchecked")
	public String onRemoveItems(Context nssbContext) throws Throwable {
		
		ItemSelectorForm form = (ItemSelectorForm)nssbContext.getForm();
		String[] rows = form.getRow();
		List<Integer> selectedIndexes = new ArrayList<Integer>();
		if (rows!=null){
			for (int i=0; i<rows.length; i++){
				selectedIndexes.add(new Integer(rows[i]));
			}
		}
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		List<Object> removed =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_REMOVED);
		
		for (int i=0; i<rows.length; i++){
			removed.add(list.get(Integer.parseInt(rows[i])));
		}
		for (Object itemSelectorElement : removed) {
			list.remove(itemSelectorElement);
		}
		form.setRow(null);
//		return onInit(nssbContext);
		return startController(nssbContext);
	}
	@SuppressWarnings("unchecked")
	public String onRemoveAll(Context nssbContext) throws Throwable {
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		if (list!=null){
			ItemSelectorForm form = (ItemSelectorForm)nssbContext.getForm();
			
			List<Object> removed =  (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM_REMOVED);
			
			for (int i=0; i<list.size(); i++){
				removed.add(list.get(i));
			}
			for (Object itemSelectorElement : removed) {
				list.remove(itemSelectorElement);
			}
			form.setRow(null);
		}
//		return onInit(nssbContext);
		return startController(nssbContext);
	}
	
	@SuppressWarnings("unchecked")
	public String onShiftUp(Context nssbContext) throws Throwable {
		//int row = Integer.parseInt(nssbContext.getCommandParameter("shiftUp"));
		int row = Integer.parseInt(nssbContext.getMethodParameter());
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		Object element = list.get(row);
		int rowPrev = (row==0)?list.size()-1:row-1;
		Object elementPrev = list.get(rowPrev);
		list.set(row, elementPrev);
		list.set(rowPrev, element);
		return view;
	}
	
	@SuppressWarnings("unchecked")
	public String onShiftDown(Context nssbContext) throws Throwable {
		//int row = Integer.parseInt(nssbContext.getCommandParameter("shiftDown"));
		int row = Integer.parseInt(nssbContext.getMethodParameter());
		List<Object> list = (List<Object>)nssbContext.getModel(LIST_SELECTOR_ITEM);
		Object element = list.get(row);
		int rowNext = (row==list.size()-1)?0:row+1;
		Object elementNext = list.get(rowNext);
		list.set(row, elementNext);
		list.set(rowNext, element);
		return view;
	}
	
	
	
	public String onExport(Context nssbContext) throws Throwable {
		//String param = nssbContext.getCommandParameter("export");
		String param = nssbContext.getMethodParameter();

		List<TableModel> tms = new ArrayList<TableModel>();
		LinkedHashMap<PropertyKey, FieldFormatter> formatters = null;
		
		List<Object> list = nssbContext.getModel(LIST_SELECTOR_ITEM);
		if (list!=null){
			/*
			Object first = list.get(0);
			LinkedHashMap<String, String> map = first.getPropertyLabelKeyMap();
			Set<Entry<String, String>> entries = map.entrySet();
			for (Entry<String, String> entry : entries) {
				String property = entry.getKey();
				String keyLabel = entry.getValue();
				formatters.put(new PropertyKey(property), new FieldFormatter(keyLabel));
			}
			*/
			formatters=nssbContext.getModel(OBJECT_FIELD_FORMATTER_MAP);
		}
		
		TableModel tm = new TableModel(list,formatters, "label.itemSelectorExportHeader", "label.itemSelectorExportFooter");
		tms.add(tm);
		
		return nssbContext.startExport(tms, param);
	}

	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable {
		return true;
	}
	
	
	@Override
	protected void setUserNameInLog(HttpServletRequest request){
		Utente o = getUtenteInSessione();
		if (!isEmpty(o)){
			//UtenteTO utente = (UtenteTO)o;
			MDC.put("userName",o.getUtente().getCodiUtente());
		}
	}
}
