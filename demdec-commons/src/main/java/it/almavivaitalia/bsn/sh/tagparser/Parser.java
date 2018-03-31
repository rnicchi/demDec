package it.almavivaitalia.bsn.sh.tagparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

	private List<Type> types;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	/*END LOCM*/
	
	public void addType(Type type){
		types.add(type);
	}
	
	private Type newLine=null;
	
	public void setNewLine(Type type){
		this.newLine=type;
	}
	public Parser(Type newLine) {
		super();
		this.types=new ArrayList<Type>();
		this.newLine=newLine;
	}
	

	public Type getNewLine() {
		return newLine;
	}
	private static int[] findFirstTypeRange(String source, Type type) throws Throwable{
		
		int[] range=null;
		
		int start = source.toUpperCase().indexOf(type.getMarkerStart().toUpperCase());
		int stop=-1;
		boolean typeFound=false;
		boolean newIteration=(start>=0);
		
		while(newIteration){
			boolean again=true;
			int startMarkerClosed=start+type.getMarkerStart().length();
			int startMarkerOpen=startMarkerClosed;
			while(again){
				// ricerca fine tag a partire da inizio tag
				stop = source.toUpperCase().indexOf(type.getMarkerStop().toUpperCase(), startMarkerClosed);
				if (stop>=0){
					// ricerca eventuale nuovo inizio tag
					int start2 = source.toUpperCase().indexOf(type.getMarkerStart().toUpperCase(), startMarkerOpen);
					// se non esiste un nuovo start tag o se il nuovo start tag è successivo
					// al fine tag, allora ho trovato due delimitatori corretti
					if ((start2<0) || (start2>stop)){
						typeFound=true;
						again=false;
					}else {
						// in questo caso la fine tag va cercata oltre
						startMarkerOpen=start2+type.getMarkerStart().length();
						startMarkerClosed=stop+type.getMarkerStop().length();
					}
				}else {
					again=false;
				}
			}
			
			if (!typeFound){
				int offset=start+type.getMarkerStart().length();
				start = source.toUpperCase().indexOf(type.getMarkerStart().toUpperCase(), offset);
				newIteration=(start>=0);
			}else {
				newIteration=false;
			}
		}
		
		if (typeFound){
			range=new int[2];
			range[0]=start;
			range[1]=stop;
		}
		
		
		return range;
	}
	
	public Element parse(String source) throws Throwable{
		Element element=null;
		if (source==null){
			element=new Element(Types.TYPE_NONE, "");
		}else {
			element=new Element(Types.TYPE_NONE, source);
		}
		split(element);
		return element;
	}
	
	private void split(Element elem) throws Throwable{
		String source = elem.getText();
		boolean typeFound=false;
		Type type=null;
		int[] range=null;
		
		Map<Integer, Type> candidates = new HashMap<Integer, Type>();
		List<Integer> candidatesIndexes= new ArrayList<Integer>();
		for(int i=0; i<types.size(); i++){
			type = types.get(i);
			int startPosition  =source.toUpperCase().indexOf(type.getMarkerStart().toUpperCase());
			candidates.put(new Integer(startPosition), type);
			candidatesIndexes.add(new Integer(startPosition));
		}
		
		
		Collections.sort(candidatesIndexes);
		
		List<Type> sortedCandidates= new ArrayList<Type>();
		for (Integer pos : candidatesIndexes) {
			if (pos>=0){
				sortedCandidates.add(candidates.get(pos));
			}
		}
		
		for(int i=0; (i<sortedCandidates.size())&&!typeFound; i++){
			type = sortedCandidates.get(i);
			range = findFirstTypeRange(source, type);
			typeFound= (range!=null);
		}
		if (typeFound){
			if (range[0]>0){
				Element el1 = new Element(Types.TYPE_NONE, source.substring(0, range[0]));
				split(el1);
				elem.addElement(el1);
			}
			Element el2 = new Element(type, source.substring(range[0]+type.getMarkerStart().length(), range[1]));
			split(el2);
			elem.addElement(el2);
			
			if (range[1]+type.getMarkerStop().length()<source.length()){
				Element el3 = new Element(Types.TYPE_NONE, source.substring(range[1]+type.getMarkerStop().length(), source.length()));
				split(el3);
				elem.addElement(el3);
			}
			//System.out.println(elem);
		}else {
			String text = new String(source);
			if (newLine!=null){
				int start = text.toUpperCase().indexOf(newLine.getMarkerStart().toUpperCase());
				while(start>=0){
					if (start>0){
						Element el = new Element(Types.TYPE_NONE, text.substring(0, start));
						elem.addElement(el);
					}
					elem.addElement(new Element(newLine, ""));
					text = text.substring(start+newLine.getMarkerStart().length(), text.length());
					start = text.toUpperCase().indexOf(newLine.getMarkerStart().toUpperCase());
				}
			}
			if (!text.equals("")){
				Element el = new Element(Types.TYPE_NONE, text);
				elem.addElement(el);
			}
		}
	}
	

	public static void main(String[] args){
		try {
		

		}catch (Throwable th) {
			th.printStackTrace();
		}
	}

}
