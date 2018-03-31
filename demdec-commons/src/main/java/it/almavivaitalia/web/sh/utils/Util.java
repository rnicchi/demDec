package it.almavivaitalia.web.sh.utils;



import it.almavivaitalia.web.sh.export.FieldFormatter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;

import com.thoughtworks.xstream.XStream;


/**
 * Classe contenente metodi di utilità generale
 */
public class Util extends it.almavivaitalia.bsn.sh.utils.Util{
	
	
	public static byte[] marshallNavigatorNode(Object obj) throws Exception{
		
		String xml = getNavigatorXstream().toXML(obj);
		byte[] b = xml.getBytes();
		System.out.println();
		System.out.println("******");
		System.out.println("xstreamMarshallAttribute: \n"+new String(b));
		System.out.println("******");
		System.out.println();
		return b;
		
	}
	public static byte[] marshallFieldFormatterMap(Object obj) throws Exception{
		
		String xml = getFieldFormatterMapXstream().toXML(obj);
		byte[] b = xml.getBytes();
		System.out.println();
		System.out.println("******");
		System.out.println("xstreamMarshallAttribute: \n"+new String(b));
		System.out.println("******");
		System.out.println();
		return b;
		
	}
	
	public static XStream getNavigatorXstream(){
		XStream xstream = new XStream();
		xstream.omitField(it.almavivaitalia.web.sh.utils.navigator.NLink.class, "tree");
		xstream.omitField(it.almavivaitalia.web.sh.utils.navigator.NLink.class, "label");
		xstream.omitField(it.almavivaitalia.web.sh.utils.navigator.NLink.class, "parent");
		xstream.useAttributeFor("id", String.class);
		xstream.useAttributeFor("uri", String.class);
		xstream.alias("Node", it.almavivaitalia.web.sh.utils.navigator.NLink.class);
		xstream.aliasField("Nodes", it.almavivaitalia.web.sh.utils.navigator.NLink.class, "children");
		return xstream;
	}
	public static XStream getFieldFormatterMapXstream(){
		XStream xstream = new XStream();
		xstream.alias("FieldFormatterMap", LinkedHashMap.class);
		xstream.alias("FieldFormatter", FieldFormatter.class);
		xstream.useAttributeFor("width", Double.class);
		xstream.useAttributeFor("label", String.class);
		xstream.useAttributeFor("abbr", String.class);
		xstream.useAttributeFor("type", Integer.class);
		xstream.useAttributeFor("value", String.class);
		xstream.useAttributeFor("cssClass", String.class);
		
		xstream.alias("Property", PropertyKey.class);
		xstream.useAttributeFor("key", Boolean.class);
		xstream.useAttributeFor("descValue", String.class);
		return xstream;
	}
	
	public static void clearResult(Context context) throws Throwable{
		context.setDataModel(BaseSessionAttributes.CHECK_STAMPA, false);
		context.removeDataModel(BaseSessionAttributes.RISULTATO_INTERROGAZIONE);
		context.removeDataModel(BaseSessionAttributes.LABEL_PARAM);	
		context.removeDataModel(BaseSessionAttributes.IS_CHECKED);
	}
	
	@SuppressWarnings("unchecked")
	public static LinkedHashMap<PropertyKey, FieldFormatter> unMarshallFieldFormatterMap(InputStream is) throws Exception{
		return (LinkedHashMap<PropertyKey, FieldFormatter>)getFieldFormatterMapXstream().fromXML(is);
	}	
	public static Object unMarshallNavigatorNode(byte[] b) throws Exception{
		
		
		ByteArrayInputStream baIS = new ByteArrayInputStream(b);
		System.out.println();
		System.out.println("******");
		System.out.println("xstreamUnMarshallAttribute: \n"+new String(b));
		System.out.println("******");
		System.out.println();
		return getNavigatorXstream().fromXML(baIS);
	}
	public static Object unMarshallNavigatorNode(InputStream is) throws Exception{
		return getNavigatorXstream().fromXML(is);
	}	
	
	
}