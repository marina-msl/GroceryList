package GUI;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProductsView {

	
	 final static boolean shouldFill = true;
	    final static boolean shouldWeightX = true;
	    final static boolean RIGHT_TO_LEFT = false;
	 
	    public static void addComponentsToPane(Container pane) {
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        }
	 
	    JLabel jLabelProduct;
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    if (shouldFill) {
	    //natural height, maximum width
	    c.fill = GridBagConstraints.HORIZONTAL;
	    }
	 
	    jLabelProduct = new JLabel("Product");
	    if (shouldWeightX) {
	    c.weightx = 0.5;
	    }
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    pane.add(jLabelProduct, c);
	 
	    JTextField txtFieldProduct;
	    txtFieldProduct = new JTextField("enter with name");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 1;
	    pane.add(txtFieldProduct, c);
	    
	    jLabelProduct = new JLabel("Amount");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 0;
	    pane.add(jLabelProduct, c);
	 
	    
	    //JTextField txtFieldProduct;
	    txtFieldProduct = new JTextField("enter with amount");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 1;
	    c.gridx = 1;
	    c.gridy = 1;
	    pane.add(txtFieldProduct, c);
	    
	    
	    jLabelProduct = new JLabel("Price");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    pane.add(jLabelProduct, c);
	 
	    txtFieldProduct = new JTextField("enter with price");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 1;
	    c.gridx = 2;
	    c.gridy = 1;
	    pane.add(txtFieldProduct, c);
	    
	 
	    JButton buttonAddProduct;
	    buttonAddProduct = new JButton("Add Product");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.weighty = 1.0;   //request any extra vertical space
	    c.anchor = GridBagConstraints.NORTH; //bottom of space
	    c.insets = new Insets(10,0,0,0);  //top padding
	    c.gridx = 2;       //aligned with button 2
	    c.gridwidth = 1;   //2 columns wide
	    c.gridy = 2;       //third row
	    pane.add(buttonAddProduct, c);
	    
	    buttonAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Oi gente!");
				
			}
		});
	    
	    
	    jLabelProduct = new JLabel("Produt's List");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 3;
	    pane.add(jLabelProduct, c);
	 
	    txtFieldProduct = new JTextField("Products in the list");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 4;
	    pane.add(txtFieldProduct, c);
}
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    public static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Grocery List");
	        frame.setMinimumSize(new Dimension(350,500));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
		/*
		 * public static void main(String[] args) { //Schedule a job for the
		 * event-dispatching thread: //creating and showing this application's GUI.
		 * javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() {
		 * createAndShowGUI(); } }); }
		 */
	
}
