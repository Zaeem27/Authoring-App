package backend;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class Client {

    
    //MainFrame frame;
    
    
  
  
  
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
                
                MainFrame main = new MainFrame();
                main.setLayout(new GridLayout());
                main.setVisible(true);
		
                
               // Panel test_panel = new Panel();
             // MainFrame  main = new MainFrame();
             /*  JScrollPane sP = new JScrollPane();
                sP.setPreferredSize(new Dimension(985, 475));
                sP.setBackground(Color.red);
               // main.add(sP, BorderLayout.CENTER);
               
               
              main.add(sP);
                Panel p = new Panel();
                sP.add(p);*/
               // main.add("Test Panel", test_panel);
              //  main.repaint();
              //  main.setVisible(true);
               // main.revalidate();
               
		//String text, String tag, String info, ArrayList<Node> parent
		/*Node node1 = new Node ("This is test", "no tag", "no info", null);
		
		
		FileGeneration test = new FileGeneration (node1);
		test.setButtonNum(3);
		test.setCellNum(3);*/
		
		/*ArrayList node2p = new ArrayList <Node>();
		node2p.add(node1);
		Node node2 = new Node ("Testing pause", "Pause", "3", node2p);
		test.addNode(node2);
		
		ArrayList node3p = new ArrayList <Node>();
		node3p.add(node2);
		Node node3 = new Node ("Testing output", "Display String", "display this", node3p);
		test.addNode(node3);
		
		ArrayList node4p = new ArrayList <Node>();
		node4p.add(node3);
		Node node4 = new Node ("fwefewfew", "Sound", "test.wav", node4p);
		test.addNode(node4);
		
		ArrayList node5p = new ArrayList <Node>();
		node5p.add(node4);
		Node node5 = new Node ("this text should be repeated", "Repeat", "does not matter", node5p);
		test.addNode(node5);*/
		
		/*
		ArrayList node2p = new ArrayList <Node>();
		node2p.add(node1);
		Node node2 = new Node ("Branch 1", "Pause", "3", node2p);
		test.addNode(node2);
		
		ArrayList node3p = new ArrayList <Node>();
		node3p.add(node1);
		Node node3 = new Node ("Branch 2", "Display String", "test", node3p);
		test.addNode(node3);
		
		ArrayList node5p = new ArrayList <Node>();
		node5p.add(node3);
		Node node5 = new Node ("Branch 2suba", "Display String", "test", node5p);
		test.addNode(node5);
		
		
		ArrayList node6p = new ArrayList <Node>();
		node6p.add(node3);
		Node node6 = new Node ("Branch 2sub B", "Display String", "test", node6p);
		test.addNode(node6);
		
		
		ArrayList node7p = new ArrayList <Node>();
		node7p.add(node5);
		node7p.add(node6);
		Node node7 = new Node ("SubBranch Merge", "", "", node7p);
		test.addNode(node7);
		
		ArrayList node8p = new ArrayList <Node>();
		node8p.add(node2);
		node8p.add(node7);
		Node node8 = new Node ("Branch Merge", "", "", node8p);
		test.addNode(node8);
		
		node1.setMerge(node8);
		node3.setMerge(node7);
		test.generateFile();*/
	}

}