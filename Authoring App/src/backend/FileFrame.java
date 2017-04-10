package backend;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zaeem
 */
public class FileFrame extends javax.swing.JFrame {

    /**
     * Creates new form FileFrame
     */
    public FileFrame() {
        initComponents();
        jButton1.setText("Create Node");
        jButton2.setText("Save");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Add Scenario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("Cells");

        jTextField2.setText("Buttons");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    NodePanel[] nP = new NodePanel[1000];
    JPanel jP = new JPanel();
    
    int i=0;

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        jP.setLayout(new BoxLayout(jP,BoxLayout.PAGE_AXIS));
        
    	nP[i] = new NodePanel();
            nP[i].visibility();
    	jP.add(nP[i]);
        jP.add(Box.createRigidArea(new Dimension(0,6)));
    
    	jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	jScrollPane1.getViewport().add(jP);
        jScrollPane1.repaint();
        i++;
       /* 
       JPanel jP = new JPanel();
      
       jP.setLayout(new BoxLayout(jP,BoxLayout.PAGE_AXIS));
       for (int i=0; i<1000;i++){
           nP[i] = new NodePanel();
           jP.add(nP[i]);
       }
       
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       
        
        
      jScrollPane1.getViewport().add(jP);
      jScrollPane1.repaint();*/
        
     
      
       
        
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Node[] nodes = new Node[1000];
       try{
    	   
    	   if (NodePanel.i == 0){
      		   throw new IllegalArgumentException("File generation failed. There are no nodes." );
      	   }
    	   
    	   
    	   if (!jTextField1.getText().matches("[0-9]+")){
    		   throw new IllegalArgumentException("File generation failed. Cell number specified is not a valid value." );
    	   }
    	int numCell = Integer.parseInt(jTextField1.getText());
    	
    	 if (!jTextField2.getText().matches("[0-9]+")){
  		   throw new IllegalArgumentException("File generation failed. Button number specified is not a valid value." );
  	   }
    	
    	int numButton = Integer.parseInt(jTextField2.getText());
    	
    	
    	ArrayList <Integer> mergeNode = new ArrayList <Integer> ();
		ArrayList <Integer[]> parent = new ArrayList <Integer[]> ();
		ArrayList <String> tag = new ArrayList <String> ();
		ArrayList <String> info = new ArrayList <String> ();
		ArrayList <String> text = new ArrayList <String> ();
		
        for (int j=0;j<NodePanel.i; j++) {
        	if (j>0 && !nP[j].getParentFieldRef().getText().matches("[0-9][0-9 ]*") ){
        		throw new IllegalArgumentException("File generation failed. Specified parent ID at ID " + j + " format is wrong." );
        	}
        	
        	
        	if (!nP[j].getMergeFieldRef().getText().matches("[0-9]*")){
        		throw new IllegalArgumentException("File generation failed. Specified merge node ID at ID " + j + " format is wrong." );
        	}
        	
        	
       /* 	if (!nP[j].getTextFieldRef().getText().toLowerCase().matches("[a-z ]*")){
        		throw new IllegalArgumentException("File generation failed. Text at ID " + j + " format is wrong." );
        	}*/
        	
        	if(nP[j].getComboBoxRef().getSelectedItem().toString().matches("Sound")){
        		if ( !nP[j].getInfoFieldRef().getText().matches("[A-Za-z0-9]+.wav")){
        			throw new IllegalArgumentException("File generation failed. Tag infomation at ID " + j + " format is wrong.  Should be name of file followed by .wav" );
        		}
        	}
        	
        	if(nP[j].getComboBoxRef().getSelectedItem().toString().matches("Pause")){
        		if ( !nP[j].getInfoFieldRef().getText().matches("[0-9]+") || Integer.parseInt(nP[j].getInfoFieldRef().getText()) == 0){
        			throw new IllegalArgumentException("File generation failed. Tag infomation at ID " + j + " format is wrong.  Should be an integer greater than 0." );
        		}
        	}
        	
        	if(nP[j].getComboBoxRef().getSelectedItem().toString().matches("Voice")){
        		if ( !nP[j].getInfoFieldRef().getText().matches("[1-4]")){
        			throw new IllegalArgumentException("File generation failed. Tag infomation at ID " + j + " format is wrong.  Should be an integer from 1-4 inclusive." );
        		}
        	}
        	
        	if(nP[j].getComboBoxRef().getSelectedItem().toString().matches("Display String")){
        		if ( !nP[j].getInfoFieldRef().getText().matches("[a-z ]+")){
        			throw new IllegalArgumentException("File generation failed. Tag infomation at ID " + j + " format is wrong.  String to be displayed not supported. Should be lower case letters or space only." );
        		}
        		if ( nP[j].getInfoFieldRef().getText().length() > numCell){
        			throw new IllegalArgumentException("File generation failed. Tag infomation at ID " + j + " format is wrong.  String to be displayed length greater than cell number specified." );
        		}
        	}
        	
        	
        	
        	
        	
        	
        	tag.add(nP[j].getComboBoxRef().getSelectedItem().toString());
        	
        	if (nP[j].getInfoFieldRef().getText().matches("")){
        		info.add(null);
        	}
        	
        	else{
        		info.add(nP[j].getInfoFieldRef().getText());
        	}
        	
        	if (nP[j].getTextFieldRef().getText().matches("")){
        		text.add(null);
        	}
        	else{
        		text.add(nP[j].getTextFieldRef().getText());
        	}
        	if (nP[j].getMergeFieldRef().getText().matches("")){

        		mergeNode.add(null);
        	}
        	else {
        		mergeNode.add(Integer.parseInt(nP[j].getMergeFieldRef().getText()));
        	}
        	String [] temp = nP[j].getParentFieldRef().getText().split(" ");
        	Integer [] temp1 = new Integer [temp.length];
        	if (j == 0){
        		parent.add(null);
        	}
        	else{
        		for (int counter = 0; counter <temp.length; counter++){
        			temp1[counter] = Integer.parseInt(temp[counter]);
        			
        			if (temp1 [counter] >= j){
        				throw new IllegalArgumentException("File generation failed. Specified parent ID at ID " + j + " is greater or equal to current ID." );
        			}
    
        		}
        		parent.add(temp1.clone());
        	}
    
        	
        	        	
           /* String text = nP[i].getTextFieldRef().getText();
            String tag = nP[i].getComboBoxRef().getSelectedItem().toString();
            String info = nP[i].getInfoFieldRef().getText();
            String parentNum = nP[i].getParentFieldRef().getText();
            String mergeNode = nP[i].getMergeFieldRef().getText(); 
            nodes[i]= new Node(text, tag, info, null);*/
        }
        FileGenerationSimplified.createFile(numButton, numCell, mergeNode, parent, tag, info, text);
    	}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
                        ErrorForm eF = new ErrorForm();
                        eF.getTextAreaRef().setText(e.getMessage());
                        eF.setVisible(true);
		}
       
       catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
                        ErrorForm eF = new ErrorForm();
                        eF.getTextAreaRef().setText(e.getMessage());
                        eF.setVisible(true);
		}
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
