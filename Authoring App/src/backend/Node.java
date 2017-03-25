package backend;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Node {

	private String text;
	private String tag;
	private String info;
	private int value;
	private ArrayList<Node> child;
	private ArrayList<Node> parent;
	private Node merge;

	
	public Node(String text, String tag, String info, ArrayList<Node> parent){
		this.text = text;
		this.tag = tag;
		this.info = info;
		this.parent = parent;
		child = new ArrayList<Node>();
		if (info.matches("[0-9]+")){
			this.value = Integer.valueOf(info);
		}
		
	}
	
	
	public Node(String text, String tag, String info, ArrayList<Node> parent, Node merge){
		this(text, tag, info, parent);
		this.merge = merge;
		
	}

	public String getText() {
		return text;
	}
	
	public ArrayList<Node> getChild() {
		return child;
	}
	
	public ArrayList<Node> getParent() {
		return parent;
	}
	
	public String getTag(){
		return tag;
	}

	public int getValue(){
		return value;
	}
	
	public String getInfo(){
		return info;
	}
	
	public Node getMerge(){
		return merge;
	}
	
	public void setMerge(Node merge){
		this.merge = merge;
	}


}
