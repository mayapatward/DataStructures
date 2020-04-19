package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	BST_Node inserted = new BST_Node(s);
	if(root == null) {
		root = inserted;
		size++;
		return true;
	} else {
		if (root.insertNode(s)) {
			size++;
			return true;
		}
		
		return false;
	}
	
}

@Override
public boolean remove(String s) {
	if (!this.contains(s)) {
		return false;
	} else if (size == 1) {
		root = null;
		size--;
		return true;
	}
	else {
		size --;
		root.removeNode(s);
		return true;
		
	}
}

@Override
public String findMin() {
	if (root == null) {
		return null;
	} else {
		return root.findMin().data;
	}
}

@Override
public String findMax() {
	if (root == null) {
		return null;
	} else {
		return root.findMax().data;
	}
}

@Override
public boolean empty() {
	if(size == 0) {
		return true;
	} else {
		return false;
	}
}

@Override
public boolean contains(String s) {
	if (root == null) {
		return false;
	} else {
		return root.containsNode(s);
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



}