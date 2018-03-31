package it.almavivaitalia.web.sh.utils.navigator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NLink implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2635928554497439983L;

	public String[] getLabelParams() {
		return labelParams;
	}
	private String id;
	private String label;
	private String uri;
	private NTree tree;
	
	
	
	private String[] labelParams;
	
	public void setLabelParams(String... labelParams) {
		this.labelParams = labelParams;
	}
	public NTree getTree() {
		return tree;
	}
	public void setTree(NTree tree) {
		this.tree = tree;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private List<NLink> children;
	
	private NLink parent;
	
	public NLink(String id, String label, String uri){
		this.id=id;
		this.label=label;
		this.uri=uri;
		children=new ArrayList<NLink>();
	}
	
	// costruttore valido per la root
	public NLink(String id, String label, String url, NTree tree){
		this.id=id;
		this.label=label;
		this.uri=url;
		children=new ArrayList<NLink>();
		this.tree=tree;
		tree.addNodeMap(this);
		
	}
	public List<NLink> getChildren() {
		return children;
	}
	public void setChildren(List<NLink> children) {
		this.children = children;
	}
	public NLink getParent() {
		return parent;
	}
	public void setParent(NLink parent) {
		this.parent = parent;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public void addChild(NLink node){
		children.add(node);
		node.setParent(this);
		//node.setId(node.getAbsoluteId());
		node.setTree(tree);
		if (tree!=null){
			tree.addNodeMap(node);
		}
	}
	public NLink addChild(String id, String label, String url){
		NLink node = new NLink( id, label, url);
		addChild(node);
		return node;
	}
	
	public String getAbsoluteId(){
		return getAbsoluteId(this);
	}
	
	public String getAbsoluteId(NLink n){
		if (n.getParent()==null){
			return n.getId();
		}else {
			return n.getParent().getId()+"."+n.getId();
		}
	}
	
	// clona NLink ricorsivamente
	public NLink clone(NTree nTree) throws CloneNotSupportedException {
		
		NLink nLink= new NLink(id, label, uri, nTree);
		if ((children!=null)&&(!children.isEmpty())){
			for(Iterator<NLink> nodes = children.iterator(); nodes.hasNext();){
				NLink node = nodes.next();
				nLink.addChild(node.clone(nTree));
			}
		}
		return nLink;
	}
	
	
	//public String getAbsoluteId
}
