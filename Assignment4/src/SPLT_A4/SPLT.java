package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }

@Override
public void insert(String s) {
	BST_Node inserted = new BST_Node(s);
	if(root == null) {
		root = inserted;
		size++;
		
	} else {
		if (root.insertNode(s)) {
			size++;
			BST_Node temp = root.containsNode(s);
			splay(temp);
			
		} else {
			BST_Node temp = root.containsNode(s);
			splay(temp);
		}
		
		
	}
	
}


@Override
public void remove(String s) {
	if (size == 1) {
		root = null;
		size--;
	}
	else {
		
		
		if(this.contains(s)) {
			size --;
			if (root.left == null) {
				root = root.right;
				root.par = null;
				return;
			} if (root.right == null) {
				root = root.left;
				root.par = null;
				return;
			}
			BST_Node L = root.left;
			BST_Node R = root.right;
			String x = L.findMax().data;
			BST_Node temp = root.containsNode(x);
			splay(temp);
			temp.right = R;
			R.par = temp;
			root = temp;
		}
		
	}
}

@Override
public String findMin() {
	if (root == null) {
		return null;
	} else {
		String s = root.findMin().data;
		BST_Node temp = root.containsNode(s);
		splay(temp);
		return s;
	}
}
@Override
public String findMax() {
	if (root == null) {
		return null;
	} else {
		String s = root.findMax().data;
		BST_Node temp = root.containsNode(s);
		splay(temp);
		return s;
	}
}


@Override
public boolean empty() {

	if(root == null) {
		return true;
	} else {
		return false;
	}
}


public BST_Node contains2(String s) {
	if (root == null) {
		return null;
	} else {
		BST_Node temp = root.containsNode(s);
		splay(temp);
		return temp;
		
	}
}

public boolean contains(String s) {
	if (root == null) {
		return false;
	} else {
		BST_Node temp = root.containsNode(s);
		splay(temp);
		if(temp.data.compareTo(s) == 0) {
			return true;
		} else {
			return false;
		}
		
	}
}
@Override
public int size() {
	return size;
}

@Override
public int height() {
	if (root == null) {
		return -1;
	} else {
		return root.getHeight()-1;
	}
}

public void splay(BST_Node X) {
	while (root != X) {
		BST_Node P = X.par;
		if(root == P && root.left == X) {
			zigLeft(X);
			continue;
		} else if (root == P && root.right == X) {
			zigRight(X);
			continue;
		} 
		else if (P != null) {
			BST_Node G = P.par;
			 if (G.right == P && P.right ==X) {
				zigzigRight(X);
				continue;
			} else if (G.left == P && P.left ==X) {
				zigzigLeft(X);
				continue;
			} else if (G.left == P && P.right ==X) {
				zigzagLeft(X);
				continue;
			} else if (G.right == P && P.left ==X) {
				zigzagRight(X);
				continue;
			}
		}
		
	
		
	}
//	  
	
}

//rotating causes downward movement
public void zigRight(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.left;
	BST_Node A = X.right;
	BST_Node C = P.left;
	
	X.left = P;
	P.par = X;
	P.right = B;
	if (B!=null) {
		B.par = P;
	}
	
	X.par = null;
	root = X;
	
	//look at case where P is null 

}

public void zigLeft(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.left;
	BST_Node A = X.right;
	BST_Node C = P.right;
	
	X.right = P;
	P.par = X;
	P.left  = A;
	if (A!=null) {
		A.par = P;
	}
	
	X.par = null;
	root = X;	
	
}

public void zigzigLeft(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.right;
	BST_Node A = X.left;
	BST_Node C = P.right;
	BST_Node G = P.par;
	BST_Node D = G.right;
	BST_Node GP = G.par;
	
	if(GP != null && X.data.compareTo(GP.data)<0) {
		GP.left = X;
	} if (GP != null && X.data.compareTo(GP.data)>0) {
		GP.right = X;
	}
	X.par = GP;
	X.right = P;
	P.par = X;
	P.left = B;
	if (B != null ) {
		B.par = P;
	} 
	P.right = G;
	G.par = P;
	G.left =C;
	if (C!=null) {
		C.par = G;
	}
	if (GP == null) {
		root = X;
	}
	
	
}

public void zigzigRight(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.right;
	BST_Node A = X.left;
	BST_Node C = P.left;
	BST_Node G = P.par;
	BST_Node D = G.left;
	BST_Node GP = G.par;
	if(GP != null && X.data.compareTo(GP.data)<0) {
		GP.left = X;
	} if (GP != null && X.data.compareTo(GP.data)>0) {
		GP.right = X;
	}
	X.par = GP;
	X.left = P;
	P.par = X;
	P.right = A;
	if (A != null ) {
		A.par = P;
	} 
	P.left = G;
	G.par = P;
	G.right =C;
	if (C!=null) {
		C.par = G;
	}
	if (GP == null) {
		root = X;
	}
	
}

public void zigzagLeft(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.left;
	BST_Node A = P.left;
	BST_Node C = X.right;
	BST_Node G = P.par;
	BST_Node D = G.right;
	BST_Node GP = G.par;
	if(GP != null && X.data.compareTo(GP.data)<0) {
		GP.left = X;
	} if (GP != null && X.data.compareTo(GP.data)>0) {
		GP.right = X;
	}
	X.par = GP;
	X.left = P;
	P.par = X;
	X.right = G;
	G.par = X;
	P.right = B;
	if (B!=null) {
		B.par = P;
	}
	G.left = C;
	if (C != null) {
		C.par = G;
	}
	if (GP == null) {
		root = X;
	}
	
}
public void zigzagRight(BST_Node X) {
	BST_Node P = X.par;
	BST_Node B = X.right;
	BST_Node C = P.right;
	BST_Node A = X.left;
	BST_Node G = P.par;
	BST_Node D = G.left;
	BST_Node GP = G.par;
	if(GP != null && X.data.compareTo(GP.data)<0) {
		GP.left = X;
	} if (GP != null && X.data.compareTo(GP.data)>0) {
		GP.right = X;
	}
	X.par = GP;
	X.right = P;
	P.par = X;
	X.left = G;
	G.par = X;
	P.left = B;
	if (B!=null) {
		B.par = P;
	}
	G.right = A;
	if (A != null) {
		A.par = G;
	}
	if (GP == null) {
		root =X;
	}
}








}