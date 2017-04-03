package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Remove {

	
	public static void createFile (int numButton, int numCell, ArrayList<Integer> mergeNode, ArrayList<Integer[]> parent, ArrayList<String> tag, ArrayList<String> info, ArrayList<String> text) throws FileNotFoundException{
		
		for (int i = 0; i < tag.size(); i++){
			if (text.get(i) == null){
				text.remove(i);
				text.add(i, " ");
			}
			
			if (info.get(i) == null && (tag.get(i).matches("Repeat") || tag.get(i).matches("Select"))){
				info.remove(i);
				info.add(i, " ");
			}
			
		}
		
		for (int i = 0; i < info.size(); i++){
			if (info.get(i) == null){
				throw new IllegalArgumentException("An infomation box is empty when it shouldn't be empty.");
			}	
		}
		
		ArrayList <Node> node = new ArrayList<Node>();
		for (int i = 0; i < text.size(); i++){
			if (i == 0){
			node.add(new Node(text.get(i),tag.get(i),info.get(i), null));
			}
			else{
				ArrayList <Node> parentNode = new ArrayList<Node>();
				for (int k: parent.get(i)){
					parentNode.add(node.get(k));
				}
				node.add(new Node(text.get(i),tag.get(i),info.get(i), parentNode));
			}
		}
		
		for (int i = 0; i<mergeNode.size(); i++){
			if (mergeNode.get(i) != null){
				node.get(i).setMerge(node.get(mergeNode.get(i)));
			}
		}

		FileGeneration a = new FileGeneration(node.get(0));
		a.setButtonNum(numButton);
		a.setCellNum(numCell);
		for (int i = 1; i<node.size(); i++){
			a.addNode(node.get(i));
		}
		
	
		
		a.generateFile();

	}
}
