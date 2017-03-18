package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Storage {

	private Node start;
	private int cellNum;
	private int buttonNum;
	
	
	public Storage (Node start){
		this.start = start;
		cellNum = 0;
		buttonNum = 0;
	}
	
	//This assumes the node to be added has the parent in its adj arraylist.
	public void addNode (Node node){
		
		ArrayList <Node> parents = node.getAdj();	
		for (Node a: parents){
			a.getAdj().add(node);
		}	
	}
	
	public void setCellNum(int cellNum){
		this.cellNum = cellNum;
	}
	
	public void setButtonNum(int buttonNum){
		this.buttonNum = buttonNum;
	}
	
	public void generateFile() throws FileNotFoundException{
		ArrayList<String> content = new ArrayList<String>();
		
		if (buttonNum <= 0 || cellNum <= 0){
			throw new IllegalArgumentException("Invalid button or cell number.");
		}
		content.add("Cell " + String.valueOf(cellNum));
		content.add("Button " + String.valueOf(buttonNum));
		
		Node curr = start;
		while (curr != null){
			if (curr.getPause()>0){
				content.add("/~pause:" + String.valueOf(curr.getPause()));
			}
			
			if (curr.getVoice()<1 || curr.getVoice() > 4){
				content.add("/~set-voice:1");
			}
			else if (curr.getVoice() == 0){
				
			}
			else{
				content.add("/~set-voice:" + String.valueOf(curr.getVoice()));
			}
			
			if (curr.getDispString()){
				if (curr.getDisp().trim() != ""){
					content.add("~disp-clearAll");
					content.add("~disp-string:" + curr.getDisp());
				}
			}
			
			
			
			content.add(curr.getText());
			int numChild = 0;
			Node next = null;
			if (curr.getAdj()!=null){
				for (Node a: curr.getAdj()){
					if (a.getLevel()> curr.getLevel()){
						numChild++;
						next = a;
					}
				}
			}
			if (numChild <=1){
				curr = next;
			}
			
		}
		
		PrintStream writer = new PrintStream(new File ("output5.txt"));
		for (String s: content){
			writer.println(s);
			System.out.println(s);
		}
	}
	
}