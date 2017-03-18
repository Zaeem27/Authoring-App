package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<Node> node0p = new ArrayList<Node> ();
		//text, arrayList of parent, level, pause, voice, string display on cell,
		//truth value to determine string disply or cell+pin display
		Node node0 = new Node("hi there", node0p, 0, 0 , 0, "test", true);
		Storage test = new Storage(node0);
		
		ArrayList<Node> node1p = new ArrayList<Node> ();
		node1p.add(node0);
		Node node1 = new Node("testing", node1p, 1, 3, 2, "fef", false);
		test.addNode(node1);
		
		ArrayList<Node> node2p = new ArrayList<Node> ();
		node2p.add(node1);
		Node node2 = new Node("it worksd", node2p, 2, -3, 3, "", true);
		test.addNode(node2);
		
		test.setButtonNum(3);
		test.setCellNum(4);
		
		try{
			test.generateFile();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}