package it.almavivaitalia.web.sh.utils.navigator;

import static it.almavivaitalia.bsn.sh.utils.ReflectionUtilLev2.getInputStreamFromClasspath;
import it.almavivaitalia.web.sh.utils.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class NTree implements Cloneable,Serializable{

	

		private static final long serialVersionUID = 1L;
		
		private Map<String, NLink> nodeMap=new HashMap<String, NLink>();;
		private NLink root;
		
		
		public Map<String, NLink> getNodeMap() {
			return nodeMap;
		}

		public void setNodeMap(Map<String, NLink> nodeMap) {
			this.nodeMap = nodeMap;
		}

		private static void setParentChain(NLink root){
			if (root.getChildren()!=null){
				for (NLink n  : root.getChildren()) {
					n.setParent(root);
					n.setId(n.getAbsoluteId());
					setParentChain(n);
				}
			}
		}
		
		public static NTree getFromXML(String classPathResource) throws Exception{
			NLink root = (NLink)Util.unMarshallNavigatorNode(getInputStreamFromClasspath(classPathResource));
			setParentChain(root);
			NTree tree=new NTree();
			root.clone(tree);
			return tree;
		}

//		public NTree(){
//			nodeMap=new HashMap<String, NLink>();
//		}
		
		protected void addNodeMap(NLink node){
			nodeMap.put(node.getId(), node);
			if ((node.getParent()==null)&&(root==null)){
				root = node;
			}
		}
		public NLink getNodeById(String id){
			return nodeMap.get(id);
		}
		
		/**
		 * 
		 * Con questo metodo è possibile passare semplicemente il codi_item
		 * @param id
		 * @return
		 */
		public NLink getNodeByLastToken(String id){
			NLink current=null;
			
			String[] x=id.split("\\.");
			String last=x[x.length-1];
			
			for(Map.Entry<String, NLink> nodi:nodeMap.entrySet()){
				String[] _x=nodi.getKey().split("\\.");
				String _last=_x[_x.length-1];
				
				if(_last.equals(last)){
					current=nodi.getValue();
					break;
				}
			}
			
			return current;
		}
		
		
//		public static void main(String[] args){
//			try {
//				NTree tree = new NTree();
//				NLink root = new NLink("ROOT", "Root", "link-root", tree);
//				
//				root.addChild("C-1", "Child-1", "link-child-1");
//				NLink c2 = root.addChild("C-2", "Child-2", "link-child-2");
//				c2.addChild("C-3", "Child-3", "link-child-3");
//			
//				NTree clone = (NTree)tree.clone();
//				
//				
//				System.out.println(tree.renderHTMLNodePath("C-3", "/NSIP"));
//				System.out.println(clone.renderHTMLNodePath("C-3", "/NSIP"));
//				
//				
//				
//				System.out.println(Util.marshallNavigatorNode(root));
//				
//				/*
//				NLink node = (NLink)Util.unMarshallNavigatorNode(Util.getInputStreamFromClasspath("navigator.xml"));
//				NTree clone2=new NTree();
//				node.clone(clone2);
//				*/
//				
//				
//				NTree fromXML = NTree.getFromXML("navigator.xml");
//				
//				System.out.println(fromXML);
//				
//				
//				
//				
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
//		}
		

		public List<NLink> getNodePath(String id){
			NLink node=getNodeById(id);
			List<NLink> revert = new ArrayList<NLink>();
			while(node!=null){
				revert.add(node);
				node = node.getParent();
			}
			
			List<NLink> correct = new ArrayList<NLink>();
			
			for(int i=(revert.size()-1); i>=0;i--){
				correct.add(revert.get(i));
			}
			return correct;
		}
		
		
		public void setNodeUrl(String nodeId, String nodeUri){
			getNodeById(nodeId).setUri(nodeUri);
		}
		
		public void setNodeLabel(String nodeId, String nodeLabel){
			getNodeById(nodeId).setLabel(nodeLabel);
		}
		
		public String renderHTMLNodePath(String nodeId, String contextPath){
			StringBuffer sb = new StringBuffer();
			
			List<NLink> path = getNodePath(nodeId);
			
			for(int i=1; i<path.size(); i++){
				NLink node = (NLink)path.get(i);
			
				if(node.getUri()==null||"".equals(node.getUri()) || i+1==path.size()){
					sb.append(node.getLabel());
				}else{
					sb.append("<a href=\"");
					if (contextPath!=null){
						sb.append(contextPath);
						sb.append("/");
					}
					sb.append(node.getUri());
					sb.append("\">");
					sb.append(node.getLabel());
					sb.append("</a>");
					if(i!=path.size()-1){
						sb.append("&nbsp;&#8250;&nbsp;");
					}
				}
			}
			return sb.toString();
		}

		public String renderHTMLNode(String nodeId, String contextPath){
			StringBuffer sb = new StringBuffer();
			NLink node = getNodeById(nodeId);
			sb.append("<a href=\"");
			if (contextPath!=null){
				sb.append(contextPath);
				sb.append("/");
			}
			sb.append(node.getUri());
			sb.append("\">");
			sb.append(node.getLabel());
			sb.append("</a>");
			return sb.toString();
		}
		
		
		
//		public String renderHTMLNodePath(String nodeId){
//			return renderHTMLNodePath(nodeId, null);
//		}
		
		
		public boolean isIncluded(String nodeId, String nodeIdSuper){
			List<NLink> path = getNodePath(nodeId);
			boolean isIncluded=false;
			for (Iterator<NLink> iterator = path.iterator(); iterator.hasNext();) {
				NLink node = iterator.next();
				if (node.getId().equals(nodeIdSuper)){
					isIncluded=true;
					break;
				}
			}
			return isIncluded;
		}
	
		public NLink getRoot(){
			return root;
		}
		@Override
		public Object clone() throws CloneNotSupportedException {
			NTree nTree = new NTree();
			// clona NLink ricorsivamente
			getRoot().clone(nTree);
			return nTree;
		}
}

		