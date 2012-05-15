package code;

public class Node {
	Node left; 
    Node right;
    int ch;
    int count;
    int weight;
    int difference;
    int ranked;
    
    public Node(int c,int w){
    	left = null; 
        right = null; 
        ch=c;
        count=w;
        weight=0;
        difference=0;
        ranked=-1;
    }
}
