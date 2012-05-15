package code;

import graphics.Main;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Calculate {
	private String wStr="";
	private String wght="";
	private int count[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private Node bestW[]={null,null,null,null,null,null};
	private int maxRank=5;
	public int tDepth=0;
	public Node root;
	
	public Calculate(){
	}
	
	public void run(){
		clear();
		if(Main.wStr!=null){
			wStr=Main.wStr.toUpperCase();
		}
		if(wStr!=null && hasLetters(wStr)){
			stringTrim();
			buildTree();
			setScroll();
			rate(root);
			setRank();
		}	
	}
	
	public void setScroll(){
		Main.maxScroll=Main.defaultScroll-Main.posTreeSpaceY*(tDepth-1);
	}
	
	public void setRank(){
		for(int i=0;i<maxRank;i++){
			if(bestW[i]!=null && bestW[i].difference>0){
				bestW[i].ranked=i;
			}
		}
	}
	
	public boolean hasLetters(String str){
		String teststr="";
		for(int i=0;i<26;i++){
			teststr=""+(char)(i+65);
			if(str.contains(teststr)){
				return true;
			}
		}
		return false;
	}
	
	public String stringTrim(){
		char wChar;
		for(int i=0;i<wStr.length();i++){
			wChar=wStr.charAt(i);
			if(wChar>64 && wChar<91){
				if(wStr.indexOf(wChar)==i){
					count[wChar-65]+=1;
				}else{
					count[wChar-65]+=1;
					wStr=wStr.substring(0, i)+wStr.substring(i+1);
					--i;
				}
			}else{
				wStr=wStr.substring(0, i)+wStr.substring(i+1);
				--i;
			}
		}
		for(int i=0;i<count.length;i++){
			wght+=""+count[i]+" ";
		}
		return wStr;
	}
	
	public void buildTree(){  
		
		root=new Node((int) (wStr.charAt(0)-65),count[(wStr.charAt(0)-65)]);
		for(int i=1;i<wStr.length();i++){
			insert(root, (int) (wStr.charAt(i)-65),count[(wStr.charAt(i)-65)],1);
		}

	}
	
	private Node insert(Node node,int c, int w,int d) { 
	    if (node==null) { 
	      node = new Node(c,w); 
	      if(tDepth<d) tDepth=d;
	    } 
	    else { 
	      if (c <= node.ch) { 
	        node.left = insert(node.left, c,w,++d); 
	      } 
	      else { 
	        node.right = insert(node.right, c,w,++d); 
	      } 
	    }
	    
	    return(node); 
	  }
	
	public int rate(Node node){
		node.weight=1;
		int l=0;
		int r=0;
		if(node.left!=null){
			l=rate(node.left);
			node.weight+=l;
			
		}
		if(node.right!=null){
			r=rate(node.right);
			node.weight+=r;
		}
		node.difference=Math.abs(l-r);
		rateWeight(node);
		return node.weight;
	}
	
	public void rateWeight(Node node){
		
		for(int i=0;i<=maxRank;i++){
			if(bestW[i]==null || node.difference>bestW[i].difference){
				for(int j=maxRank-1;j>i;j--){
					bestW[j]=bestW[j-1];
				}
				bestW[i]=node;
				break;
			}
		}
	}
	
	public void clear(){
		wStr="";
		wght="";
		for(int i=0;i<count.length;i++){
			count[i]=0;
		}
		root=null;
		tDepth=0;
		for(int i=0;i<maxRank;i++){
			bestW[i]=null;
		}
		Main.maxScroll=Main.defaultScroll;
	}
	
	public void drawTree(Graphics2D g,Node node,int  depth,int scroll){
		if(node==null){
			return;
		}
		g.setColor(Main.cFont);
		if(Main.layout==0){
			if(node.left!=null){
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll,
						Main.posTreeStartX+Main.posTreeSpaceX*node.left.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*(depth+1)  +scroll
						);
			}
			if(node.right!=null){
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll,
						Main.posTreeStartX+Main.posTreeSpaceX*node.right.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*(depth+1)  +scroll
						);
			}
		}else{
			if(node.left!=null){
				int RatioY=(int) (Main.posTreeStartY+Main.posTreeSpaceY*depth +Main.posTreeSpaceY*Main.posTreeRatio  +scroll);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll,
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						RatioY
						);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						RatioY,
						Main.posTreeStartX+Main.posTreeSpaceX*node.left.ch,
						RatioY
						);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.left.ch,
						RatioY,
						Main.posTreeStartX+Main.posTreeSpaceX*node.left.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth +Main.posTreeSpaceY  +scroll
						);
			}
			if(node.right!=null){
				int RatioY=(int) (Main.posTreeStartY+Main.posTreeSpaceY*depth +Main.posTreeSpaceY*Main.posTreeRatio  +scroll);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll,
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						RatioY
						);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.ch,
						RatioY,
						Main.posTreeStartX+Main.posTreeSpaceX*node.right.ch,
						RatioY
						);
				g.drawLine(
						Main.posTreeStartX+Main.posTreeSpaceX*node.right.ch,
						RatioY,
						Main.posTreeStartX+Main.posTreeSpaceX*node.right.ch,
						Main.posTreeStartY+Main.posTreeSpaceY*depth +Main.posTreeSpaceY  +scroll
						);
			}
		}
		g.setColor(Main.cNodeBgr);
		String str=(char) (node.ch+65)+","+node.count;
		FontMetrics fontMetrics = g.getFontMetrics();
		int width = fontMetrics.stringWidth(str);
	    int height = fontMetrics.getHeight();
		g.fillRoundRect(
				Main.posTreeStartX+Main.posTreeSpaceX*node.ch -3,
				Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll -height+3,
				width+4, height, 4, 4);
		if(node.ranked>=0){
			g.setColor(new Color(255,0+Main.cNodeRankStep*(node.ranked),0,255));
			g.drawRoundRect(
					Main.posTreeStartX+Main.posTreeSpaceX*node.ch -4,
					Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll -height+2, 
					width+6, height+1, 4, 4);
		}
		g.setColor(Main.cFont);
		g.drawString(
				(char) (node.ch+65)+","+node.count,
				Main.posTreeStartX+Main.posTreeSpaceX*node.ch, 
				Main.posTreeStartY+Main.posTreeSpaceY*depth  +scroll
				);
		drawTree(g,node.left,depth+1,scroll);
		drawTree(g,node.right,depth+1,scroll);
	}
	
	public void drawSpecs(Graphics2D g,int scroll){
		g.drawString(
				"String: "+Main.wStr,
				Main.posStringX,
				Main.posStringY + scroll);
		g.drawString(
				"Cropped string: "+wStr,
				Main.posStringX,
				Main.posStringY+Main.posStringSpace + scroll);
		g.drawString(
				"Count: "+wght,
				Main.posStringX,
				Main.posStringY+Main.posStringSpace*2 + scroll);
	}
	
	public void drawRank(Graphics2D g,int scroll){
		int y=Main.posTreeStartY+Main.posTreeSpaceY*(Math.max(tDepth-1,0))+Main.posRankStringY;
		String str;
		g.drawString(
				"Ranking the most disballanced nodes:",
				Main.posStringX,
				y + scroll);
		for(int i=0;i<maxRank;i++){
			if(bestW[i]!=null){
				str=(i+1)+": "+(char)(bestW[i].ch+65)+" - ";
				if(bestW[i].left!=null){
					str+=bestW[i].left.weight;
				}else{
					str+="0";
				}
				str+=":";
				if(bestW[i].right!=null){
					str+=bestW[i].right.weight;
				}else{
					str+="0";
				}
				g.drawString(
						str,
						Main.posStringX,
						y+Main.posStringSpace*(i+1) + scroll);
			}
		}
	}
	
	
}
