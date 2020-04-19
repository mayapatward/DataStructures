package SPLT_A4;



public class BST_Node {
  String data;
  BST_Node left = null;
  BST_Node right = null;
  BST_Node par;
  boolean justMade;
  BST_Node containsBefore;
  
  BST_Node(String data){ 
	  this.data=data;
	  this.justMade = true;
	  
  }
  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
	    this.data=data;
	    this.left=left;
	    this.right=right;
	    this.par=par;
	    this.justMade=true;
	  }


  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  
 
public BST_Node containsNode(String s){ 
	  
	  BST_Node current = this;
	  BST_Node parent = null;
	  while (current != null) {
			if (s.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			} else if (s.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			} else {
				return current;
			}
		}
	  return parent;

	  
  }


  public boolean insertNode(String s){
	  BST_Node inserted = new BST_Node(s);
	  BST_Node current = this;
	  BST_Node parent = null;
	  while (current != null) {
			parent = current;
			if (inserted.data.compareTo(current.data) < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
	  inserted.par = parent;
	  if (inserted.data.compareTo(parent.data) < 0) {
		  parent.left = inserted;
		  return true;
	  } else if (inserted.data.compareTo(parent.data) > 0) {
		  parent.right = inserted;
		  return true;
	  } else {
		  return false;
	  }
	  
		
	
	 
	  }
  public boolean removeNode(String s){

		if(data==null)return false;
		if(data.equals(s)){
			if(left!=null){
				data=left.findMax().data;
				left.removeNode(data);
				if(left.data==null)left=null;
			}
			else if(right!=null){
				data=right.findMin().data;
				right.removeNode(data);
				if(right.data==null)right=null;
			}
			else data=null;
			return true;
		}
		else if(data.compareTo(s)>0){
			if(left==null)return false;
			if(!left.removeNode(s))return false;
			if(left.data==null)left=null;
			return true;
		}
		else if(data.compareTo(s)<0){
			if(right==null)return false;
			if(!right.removeNode(s))return false;
			if(right.data==null)right=null;
			return true;
		}
		return false;
	}
  

  public BST_Node findMin(){
	  BST_Node current = this;
	  BST_Node parent = null;
	  while(current != null) {
		  parent = current;
		  current = current.left;
	  }
	  
	  return parent; 
	  
  }
  public BST_Node findMax(){ 
	  BST_Node current = this;
	  BST_Node parent = null;
	  while(current != null) {
		  parent = current;
		  current = current.right;
	  }
	  
	  return parent; 
 }
  public int getHeight(){ 
	  int leftside;
	  int rightside;
	  if(left == null) {
		  leftside = 0;
	  } else {
		   leftside = left.getHeight();
	  } if (right == null) {
		  rightside = 0;
	  } else {
		  rightside = right.getHeight();
	  }
	
	  
	  return 1 + Math.max(leftside, rightside);
	  }
  

 


  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}