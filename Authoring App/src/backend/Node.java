package backend;

import java.util.ArrayList;

public class Node {

	private String text;
	private int level;
	private ArrayList<Node> adj;
	private int pause;
	private int voice;
	private String disp;
	private boolean dispString;

	
	public Node(String text, ArrayList<Node> adj, int level, int pause, int voice,
			String disp, boolean dispString){
		this.text = text;
		this.level = level;
		this.adj = adj;
		this.pause = pause;
		this.voice = voice;
		this.disp = disp;
		this.dispString = dispString;
	}

	public String getText() {
		return text;
	}
	
	public ArrayList<Node> getAdj() {
		return adj;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getPause(){
		return pause;
	}
	
	public int getVoice(){
		return voice;
	}
	
	public String getDisp(){
		return disp;
	}
	
	public boolean getDispString(){
		return dispString;
	}
	
}