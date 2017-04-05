package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;

public class FileGeneration {

	private Node start;
	private int cellNum;
	private int buttonNum;
	private int tag = 0;
	private int skip = 0;
	
	private Stack <Node> mergeNode = new Stack <Node>();
	//private Stack <Node> branchNode = new Stack <Node>();
	private Stack <String> tagName = new Stack <String>();
	private Stack <String> skipName = new Stack <String>();
	private Stack <String> spareStack = new Stack <String>();
	
	
	public FileGeneration (Node start){
		this.start = start;
		cellNum = 0;
		buttonNum = 0;
		tag = 0;
	}
	
	public void addNode (Node node){
		
		ArrayList <Node> parents = node.getParent();	
		for (Node a: parents){
			a.getChild().add(node);
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
		
		content.add(generateText(start));
		
		PrintStream writer = new PrintStream(new File ("output5.txt"));
		for (String s: content){
			writer.println(s);
			System.out.println(s);
		}
	}

	private String generateText(Node start) {
		
		StringBuilder content = new StringBuilder();
		Node curr = start;
		while (curr != null){
			if ((!mergeNode.isEmpty())&& curr.equals(mergeNode.peek())){
				return content.toString();
			}
			
			if (curr.getTag().matches("Pause") && curr.getValue()>0){
				content.append("/~pause:" + String.valueOf(curr.getValue()) + "\n");
			}
			
			if (curr.getTag().matches("Voice") && (curr.getValue() >=1 || curr.getValue() <= 4)){
				content.append("/~set-voice:" + String.valueOf(curr.getValue())+ "\n");
			}
		
			if (curr.getTag().matches("Display String")){
				if (curr.getInfo().trim() != ""){
					content.append("/~disp-clearAll\n");
					content.append("/~disp-string:" + curr.getInfo() + "\n");
				}
			}
			
			
			if (curr.getTag().matches("Sound")){
				content.append("/~sound:" + curr.getInfo() + "\n");
			}
			
			if (curr.getTag().matches("Repeat") ||curr.getChild().size() > 1){
				if (curr.getTag().matches("Repeat")){
						content.append(repeat(curr));
				}
			/*	if (curr.getChild().size() <= 1){ //remove
					content.append("/~reset-buttons\n");
					content.append("/~user-input\n");
				}
				else{                             //to here*/
					content.append(branch(curr));
				//}	
			}
			else{
			content.append(curr.getText() + "\n");
			}
			
			Node next = null;
			if (curr.getChild().size() ==1){
				next = curr.getChild().get(0);
			}
			
			curr = next;
			
			
		}
		return content.toString();
	}

	private String repeat(Node curr) {
		StringBuilder content = new StringBuilder();
		content.append("/~repeat\n");
		content.append(curr.getText() + "\n");
		content.append("/~endrepeat\n");
		content.append("/~reset-buttons\n");
		content.append("/~repeat-button:"+ Integer.toString(curr.getChild().size())+ "\n");
		return content.toString();
		
	}
	
	private String branch(Node curr) {
		StringBuilder content = new StringBuilder(); 
		if (!curr.getTag().matches("Repeat")) {
			content.append(curr.getText() + "\n");
			content.append("/~reset-buttons\n");
		}

		for (int i = 0; curr.getChild().size() > i; i++ ){
			String temp = "tag" + Integer.toString(tag);
			spareStack.push(temp);
			content.append("/~skip-button:" + Integer.toString(i)+ " " + temp + "\n");
			tag++;
		}
		
		skipName.push("jump" + Integer.toString(skip)+"\n");
		skip++;
		
		content.append("/~user-input\n");
		while (!spareStack.isEmpty()){
			tagName.push(spareStack.pop());
		}
		
		mergeNode.push(curr.getMerge());
		
		for (int i = 0; curr.getChild().size() > i; i++ ){
			content.append("/~" + tagName.pop() + "\n");
			content.append(generateText(curr.getChild().get(i)));
			content.append("/~skip:" + skipName.peek());
			if (i == curr.getChild().size()-1 ){
				content.append("/~" + skipName.pop());
				content.append(generateText(mergeNode.pop()));
			}
		}
		
		return content.toString();
	}
	
	
	
	
}
