package BST_A2;

public class BST_Node {
  String data;
  BST_Node left = null;
  BST_Node right = null;
  
  BST_Node(String data){ 
	  this.data=data; }


  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

public boolean containsNode(String s){ 
	  
	  BST_Node current = this;
	  while (current != null) {
			if (s.compareTo(current.data) < 0) {
				current = current.left;
			} else if (s.compareTo(current.data) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
	  return false;
	  
	  
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
  
  private int numberofConnections(BST_Node connected) {
	  if (connected.left == null && connected.right == null) {
		  return 0;
	  } else if (connected.left == null || connected.right == null) {
		  return 1;
	  } else {
		  return 2;
	  }
	 
  }
  


  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}