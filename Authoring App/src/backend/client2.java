package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class client2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//int numButton, int numCell, ArrayList<Integer> mergeNode, ArrayList<Integer[]> parent, ArrayList<String> tag, ArrayList<String> info, ArrayList<String> text
		
		int numButton = 10;
		int numCell = 20;
		ArrayList <Integer> mergeNode = new ArrayList <Integer> ();
		ArrayList <Integer[]> parent = new ArrayList <Integer[]> ();
		ArrayList <String> tag = new ArrayList <String> ();
		ArrayList <String> info = new ArrayList <String> ();
		ArrayList <String> text = new ArrayList <String> ();
		
		mergeNode.add(3);
		mergeNode.add(null);
		mergeNode.add(null);
		mergeNode.add(null);
		
		Integer[] node0p = null;
		Integer [] node1p = {0};
		Integer [] node2p = {0};
		Integer [] node3p = {1,2};
		parent.add(node0p);
		parent.add(node1p);
		parent.add(node2p);
		parent.add(node3p);
		
		tag.add("Repeat");
		tag.add("Select");
		tag.add("Pause");
		tag.add("Voice");
		
		info.add(null);
		info.add(null);
		info.add("10");
		info.add("2");
		
		text.add("Beginning of the branch!!!!!!!!!!!!!!!!!!!!!!!!!!");
		text.add("SUBbranch left no action !!!!!!!!!!!!!!!!!!!!!!!!!!");
		text.add("SubBranch right pause!!!!!!!!!!!!!!!!!!!!!!!!!!");
		text.add("merge node and change voice!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Remove.createFile(numButton, numCell, mergeNode, parent, tag, info, text);
		
	}

}
