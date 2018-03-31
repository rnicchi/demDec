package it.almavivaitalia.bsn.sh.tagparser;

import java.util.ArrayList;
import java.util.List;

public class Element {

	
	
	private Type type;
	private List<Element> elements;
	private String text;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	public Element(Type type, String text){
		elements=new ArrayList<Element>();
		this.type=type;
		this.text=text;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void addElement(Element elem){
		elements.add(elem);
	}
	
	public Element getElementAt(int position){
		return elements.get(position);
	}
	public Type getType() {
		return type;
	}
	public int size(){
		return elements.size();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(text);
		sb.append("\n");
		int i=0;
		for (Element element : elements) {
			sb.append(i++);
			sb.append(":");
			sb.append(element);
			sb.append("\n");
		}
		
		
		return sb.toString();
	}
	
}
