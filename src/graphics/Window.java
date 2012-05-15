package graphics;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class Window extends JFrame {
	
	public JScrollBar sSpaceX= new JScrollBar(0);
	public JScrollBar sSpaceY= new JScrollBar(0);
	public JLabel lSpaceX= new JLabel("X: "+Main.posTreeSpaceX);
	public JLabel lSpaceY= new JLabel("Y: "+Main.posTreeSpaceY);
	protected static TreePanel StrPan;
	
	public Window(){
		
		super("Binary search tree");
		
		getContentPane(); 
		getContentPane().setBackground(Main.cFrameBgr);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		center(this);
		evaluateTreeSpaceX();
		
		StrPan= new TreePanel();
		JButton bChString = new JButton("Change string");
		JButton bRun = new JButton("Run");
		JButton bSetLayout = new JButton("Layout");
		JLabel lName= new JLabel("Dean Panayotov 2012");
		
		
		add(StrPan);
		add(bChString);
		add(bRun);
		add(bSetLayout);
		add(lName);
		add(sSpaceX);
		add(sSpaceY);
		add(lSpaceX);
		add(lSpaceY);
		
		int max=(Main.pWidth-Main.posTreeBorder*2-20)/26;
		sSpaceX.setMaximum(max+10);
		sSpaceX.setValue(Main.posTreeSpaceX);
		sSpaceY.setMaximum(200);
		sSpaceY.setValue(Main.posTreeSpaceY);
		
		int bBor=Main.posWindowBorder;
		int bSpc=Main.posButtonSpaceX;
		int bX=bBor;
		Insets insets = getInsets();
		Dimension size = bChString.getPreferredSize();
		bChString.setBounds(bX + insets.left, bBor + insets.top,
		             size.width, size.height);
		bX+= bSpc + size.width;
		size = bRun.getPreferredSize();
		bRun.setBounds(bX + insets.left, bBor + insets.top,
		             size.width, size.height);
		bX+= bSpc + size.width;
		size = bSetLayout.getPreferredSize();
		bSetLayout.setBounds(bX + insets.left, bBor + insets.top,
	             size.width, size.height);
		bX+= bSpc + size.width;
		size = sSpaceX.getPreferredSize();
		sSpaceX.setBounds(bX + insets.left, bBor + insets.top,
	             size.width+50, size.height-4);
		sSpaceY.setBounds(bX + insets.left, bBor+13 + insets.top,
	             size.width+50, size.height-4);
		bX+= bSpc + size.width+50;
		size = lSpaceX.getPreferredSize();
		lSpaceX.setBounds(bX + insets.left, bBor -2 + insets.top,
	             size.width, size.height);
		size = lSpaceY.getPreferredSize();
		lSpaceY.setBounds(bX + insets.left, bBor+11 + insets.top,
	             size.width, size.height);
		lSpaceX.setForeground(Main.cPanelBgr);
		lSpaceX.setVisible(true);
		lSpaceY.setForeground(Main.cPanelBgr);
		lSpaceY.setVisible(true);
		
		size = lName.getPreferredSize();
		lName.setBounds(Main.posLabelX + insets.left, Main.posLabelY + insets.top,
	             size.width, size.height);
		lName.setForeground(Main.cPanelBgr);
		lName.setVisible(Main.displayLabel);
		
		HandlerClass handler = new HandlerClass();
		AdjustmentClass aHandler = new AdjustmentClass();
		
		bChString.addActionListener(handler);
		bRun.addActionListener(handler);
		bSetLayout.addActionListener(handler);
		sSpaceX.addAdjustmentListener(aHandler);
		sSpaceY.addAdjustmentListener(aHandler);
		
	}
	
	private void center(JFrame frame){

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension scrnsize = toolkit.getScreenSize();
			frame.setBounds((int)(scrnsize.getWidth()/2-Main.wWidth/2),
					(int)(scrnsize.getHeight()/2-Main.wHeight/2),
					Main.wWidth, Main.wHeight);
			
	}
	
	private void evaluateTreeSpaceX(){
		int max=(Main.pWidth-Main.posTreeBorder*2-Main.posBgrBorder*2)/26;
		if(Main.posTreeSpaceX>max){
			Main.posTreeSpaceX=max;
		}
	}
	
	private class AdjustmentClass implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			Main.posTreeSpaceX=sSpaceX.getValue();
			Main.posTreeSpaceY=sSpaceY.getValue();
			lSpaceX.setText("X: "+Main.posTreeSpaceX);
			lSpaceY.setText("Y: "+Main.posTreeSpaceY);
			StrPan.repaint();
			Main.calc.setScroll();
			
		}
		
	}
	
	private class HandlerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			switch(event.getActionCommand()){
			
			case "Layout":{
				if(Main.layout==0){
					Main.layout=1;
				}else{
					Main.layout=0;
				}
				break;
			}
			case "Change string":{
				Main.wStr= JOptionPane.showInputDialog(Main.frame,"Enter string:",Main.wStr);
				break;
			}
			case "Run":{
				Main.calc.run();				
				break;
			}
			}
			StrPan.repaint();
			
			
		}
		
	}
	
}
