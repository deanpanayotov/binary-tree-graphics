package graphics;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class TreePanel extends JPanel implements MouseWheelListener{
	
	protected int scroll=0;
	
	public TreePanel(){
		setBackground(Main.cPanelBgr);
		setBounds(Main.pX,Main.pY,Main.pWidth,Main.pHeight);
		setVisible(true);
		setIgnoreRepaint(true);
		setFocusable(true);
		requestFocus();
		addMouseWheelListener(this);
	}
	
	public void paint(Graphics g)
    {
      super.paint(g);

      Graphics2D g2 = (Graphics2D) g;

      RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON);

      rh.put(RenderingHints.KEY_RENDERING,
             RenderingHints.VALUE_RENDER_QUALITY);
      g2.setRenderingHints(rh);
      g2.setStroke(new BasicStroke(1));
      g2.setFont(Main.textFont);
      g2.setColor(Main.cTreeBgr);
      g2.fillRoundRect(
    		  Main.posBgrBorder, 
    		  Main.posStringY-Main.posStringUpperAdd +scroll,
    		  Main.pWidth-Main.posBgrBorder*2,
    		  Main.posStringY+Main.posStringSpace*3+Main.posStringLowerAdd,
    		  Main.posBgrCurve,
    		  Main.posBgrCurve);
      g2.fillRoundRect(
    		  Main.posBgrBorder, 
    		  Main.posTreeStartY-Main.posTreeBgrUpperAdd +scroll,
    		  Main.pWidth-Main.posBgrBorder*2,
    		  Main.posTreeSpaceY*(Math.max(Main.calc.tDepth-1,0))+Main.posTreeBgrLowerAdd,
    		  Main.posBgrCurve,
    		  Main.posBgrCurve);
      g2.fillRoundRect(
    		  Main.posBgrBorder, 
    		  Main.posTreeStartY+Main.posTreeSpaceY*(Math.max(Main.calc.tDepth-1,0))+Main.posRankUpperAdd +scroll,
    		  Main.pWidth-Main.posBgrBorder*2,
    		  Main.posStringSpace*6+Main.posRankLowerAdd,
    		  Main.posBgrCurve,
    		  Main.posBgrCurve);
      g2.setColor(Main.cFont);
      Main.calc.drawTree(g2, Main.calc.root, 0,scroll);
      Main.calc.drawSpecs(g2, scroll);
      Main.calc.drawRank(g2, scroll);
      
      
    }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll-=e.getWheelRotation()*Main.scrollStep;
		if(scroll<Main.maxScroll) scroll=Main.maxScroll;
		if(scroll>0) scroll =0;
		repaint();
	}

}
