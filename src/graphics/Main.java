package graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import code.Calculate;

public class Main {
	////////////////METRICS/////////////////////
	
		/////////WINDOW////////////////////
		public static int wWidth=500; //760 def 470 min
		public static int wHeight=500; //500 
		public static int wAddY=20;
		//////////////////////////////////
		
		//////////FONT////////////////////
		public static int fontSize=18;
		public static Font textFont= new Font("ArialNarrow",Font.PLAIN,fontSize);
		//////////////////////////////////
		
		///////POSITIONING////////////////
		
		public static int posWindowBorder=30;
			
			//////////BUTTONS/////////////////
			public static int posButtonSpaceX=20;
			public static int posButtonSpaceY=40;
			//////////////////////////////////
				
			/////////BACKGROUND///////////////
			public static int posBgrCurve=15;
			public static int posBgrBorder=15;
			//////////////////////////////////
			
			/////////////STRING///////////////
			public static int posStringX=20;
			public static int posStringY=25;
			public static int posStringSpace=fontSize+2;
			public static int posStringUpperAdd=17;
			public static int posStringLowerAdd=-15;
			//////////////////////////////////
			
			/////////////TREE/////////////////
			public static int posTreeBorder=10;
			public static int posTreeStartX=posBgrBorder+posTreeBorder;
			public static int posTreeStartY=posStringY+posStringSpace*3+24; //90;
			public static int posTreeSpaceX=25; //25
			public static int posTreeSpaceY=100; //50
			public static int posTreeBgrUpperAdd=22;
			public static int posTreeBgrLowerAdd=33;
			public static double posTreeRatio=0.5;
			//////////////////////////////////
				
			/////////RANK/////////////////////
			public static int posRankUpperAdd=20;
			public static int posRankLowerAdd=10;
			public static int posRankStringY=38;
			//////////////////////////////////
			
			/////////LABEL////////////////////
			public static int posLabelX=wWidth-150;
			public static int posLabelY=wHeight-46;
			//////////////////////////////////
			
		//////////////////////////////////
		
		///////PANEL//////////////////////
		public static int pX=posWindowBorder;
		public static int pY=posWindowBorder+posButtonSpaceY;
		public static int pWidth=wWidth-pX*2;
		public static int pHeight=wHeight-pY-posWindowBorder- wAddY;
		//////////////////////////////////
			
		/////////SCROLL///////////////////
		public static int defaultScroll=184+(wHeight-500)-(fontSize-10)*9;//posStringSpace*9+80;
		public static int maxScroll=defaultScroll;
		public static int scrollStep=20;
		//////////////////////////////////
		
	////////////////////////////////////////////
			
	//////////////COLORS////////////////////////
	public static Color cFrameBgr= new Color(22,0,149,255);
	public static Color cPanelBgr= new Color(210,202,255,255);
	public static Color cFont= new Color(0,0,0,255);
	public static Color cTreeBgr= new Color(255,255,255,70);
	public static Color cNodeBgr= new Color(255,255,255,168);
	public static Color cNodeRank=new Color(255,0,0,255);
	public static int cNodeRankStep = 60;
	////////////////////////////////////////////
		
	/////////////VARIABLES//////////////////////
	public static String wStr=""; 				  // workString
	public static int layout=0; 				  // 0=angled;1=linear;
	public static JFrame frame; 			 	  //window
	public static Calculate calc=new Calculate(); //calculate instance  
	public static boolean displayLabel=true;	  //name label bottom
	////////////////////////////////////////////
	
	public static void main(String[] args){
		frame= new Window();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
