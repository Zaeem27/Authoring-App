package backend;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileGenerationTest {

	FileGeneration fg ;
	Node node1;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testFileGeneration() {
		node1 = new Node ("This is test", "no tag", "no info", null);

		fg= new FileGeneration(node1);
		fg.setCellNum(3);
		fg.setButtonNum(3);
		assertEquals(fg.getStart(), node1);
		assertEquals(fg.getButtonNum(), 3);
		assertEquals(fg.getCellNum(), 3);
		
	}

	@Test
	public void testAddNode() {
		Node parent1 = new Node("This is parent1","no tag","no info", null);
		ArrayList<Node> parents = new ArrayList <Node>();
		parents.add(parent1);
		Node node1 = new Node("This is child","no tag","no info",parents);
		
		fg= new FileGeneration(node1);
		fg.setCellNum(3);
		fg.setButtonNum(3);
		fg.addNode(node1);
		for (int i=0;i<parents.size();i++){
			assertEquals(parent1, node1.getParent().get(i));
		}
	
	}
	
	@Test
	public void testGenerateFile() {
		StringBuilder result =new StringBuilder();
		
		result.append("This is test\n");
		result.append("/~reset-buttons\n");
		result.append("/~skip-button:0 tag0\n");
		result.append("/~skip-button:1 tag1\n");
		result.append("/~skip-button:2 tag2\n");
		result.append("/~user-input\n");
		result.append("/~tag0\n");
		result.append("/~pause:3\n");
		result.append("Testing pause\n");
		result.append("/~disp-clearAll\n");
		result.append("/~disp-string:display this\n");
		result.append("Testing output\n");
		result.append("/~sound:test.wav\n");
		result.append("fwefewfew\n");
		result.append("/~repeat\n");
		result.append("this text should be repeated\n");
		result.append("/~endrepeat\n");
		result.append("/~reset-buttons\n");
		result.append("/~repeat-button:0\n");
		result.append("/~user-input\n");
		result.append("/~skip:jump1\n");
		result.append("/~tag1\n");
		result.append("/~pause:3\n");
		result.append("Branch 1\n");
		result.append("/~skip:jump1\n");
		result.append("/~tag2\n");
		result.append("/~disp-clearAll\n");
		result.append("/~disp-string:test\n");
		result.append("Branch 2\n");
		result.append("/~disp-clearAll\n");
		result.append("/~disp-string:test\n");
		result.append("Branch 2suba\n");
		result.append("/~skip:jump1\n");
		result.append("/~jump1\n");
		
		ArrayList<String> contents=new ArrayList<String>();
		
		contents.add("Cell 3");
		contents.add("Button 3");
		contents.add(result.toString());
		
		Node node1 = new Node ("This is test", "no tag", "no info", null);
		FileGeneration test = new FileGeneration (node1);
		test.setButtonNum(3);
		test.setCellNum(3);

		ArrayList <Node> node2p = new ArrayList <Node>();
		node2p.add(node1);
		Node node2 = new Node ("Testing pause", "Pause", "3", node2p);
		test.addNode(node2);
		
		ArrayList <Node> node3p = new ArrayList <Node>();
		node3p.add(node2);
		Node node3 = new Node ("Testing output", "Display String", "display this", node3p);
		test.addNode(node3);
		
		ArrayList <Node> node4p = new ArrayList <Node>();
		node4p.add(node3);
		Node node4 = new Node ("fwefewfew", "Sound", "test.wav", node4p);
		test.addNode(node4);
		
		ArrayList <Node> node5p = new ArrayList <Node>();
		node5p.add(node4);
		Node node5 = new Node ("this text should be repeated", "Repeat", "does not matter", node5p);
		test.addNode(node5);
		
		
		node2p = new ArrayList <Node>();
		node2p.add(node1);
		node2 = new Node ("Branch 1", "Pause", "3", node2p);
		test.addNode(node2);
		
		node3p = new ArrayList <Node>();
		node3p.add(node1);
		node3 = new Node ("Branch 2", "Display String", "test", node3p);
		test.addNode(node3);
		
		node5p = new ArrayList <Node>();
		node5p.add(node3);
		node5 = new Node ("Branch 2suba", "Display String", "test", node5p);
		test.addNode(node5);
		
		try {
          test.generateFile();
		}
		catch (Exception e){
			
		}
		assertEquals(test.getContentTest().size(), contents.size());
		for (int i=0;i<contents.size();i++) {
			assertEquals(test.getContentTest().get(i), contents.get(i));
		}
		
		
	}

}
