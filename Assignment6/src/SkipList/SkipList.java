package SkipList;
//used http://ee.usc.edu/~redekopp/cs104/slides/L23_SkipLists.pdf as a resource to learn and for pseudocode
public class SkipList implements SkipList_Interface {
  SkipList_Node head;
  SkipList_Node tail;
  int level;
  int size;
  static final int levelSize = 100;
  double probability = 0.5;
  
  SkipList() {
    head = new SkipList_Node(null, levelSize);
    tail = new SkipList_Node(null, levelSize);

    for (int i = 1; i <= levelSize; i++) {
      head.setForward(i, tail);
    }

    level = 0;
    size = 0;
  }
  
  @Override
  //used for testing, please leave as is
  public SkipList_Node getHead() {
    if (size == 0)
      return null;

    return head;
  }

  //use this when creating a new node, please leave as is
  public int randomLevel() {
    int level = 1;

    while (Math.random() < probability)
      level++;

    return level;
  }

@Override
public boolean insert(String s) {
	size++;
	SkipList_Node current = head;
	SkipList_Node[] update = new SkipList_Node[levelSize+1];
	
	for(int i = level; i>=1; i--) {
		while(current.forward[i].data.compareTo(s)<0) {
			current = current.forward[i];
		}
		update[i] = current;
	}
	
	current = current.forward[0];
	
	if(current.data.equals(s)) {
		return false;
	} else {		
		int height = randomLevel();
		SkipList_Node x = new SkipList_Node(s, height);
		for(int i =0; i<height; i++) {
			x.forward[i] = update[i].forward[i];
			update[i].forward[i] = x;
		}
	}
	
	return true;
}

@Override
public boolean remove(String s) {
	SkipList_Node current = head;
	SkipList_Node[] update = new SkipList_Node[levelSize+1];
	
	for(int i = level; i>=1; i--) {
		while(current.forward[i].data.compareTo(s)<0) {
			current = current.forward[i];
		}
		update[i] = current;
	}
	
	current = current.forward[0];
	
	if(!current.data.equals(s)) {
		return false;
	} else {		
		for(int i =0; i<current.level; i++) {
			update[i].forward[i] = current.forward[i];
			
		}
	}
	
	return true;
}

@Override
public String findMin() {
	SkipList_Node current = head;
	current = current.forward[0];
	return current.data;
}

@Override
public String findMax() {
	SkipList_Node current = head;
	for(int i =0; i<size; i++) {
		current = current.forward[0];
	}
	return current.data;
}

@Override
public boolean empty() {
	if(size==0) {
		return true;
	} else {
		return false;
	}
}

@Override
public boolean contains(String s) {
	SkipList_Node current = head;
	for(int i = level; i>=1; i--) {
		while(current.forward[i].data.compareTo(s)<0) {
			current = current.forward[i];
		}
	}
	current = current.forward[0];
	if(current.data.equals(s)) {
		return true;
	} else {
		return false;
	}
	
	
}

@Override
public int size() {
	return size;
}

@Override
public int level() {
	// TODO Auto-generated method stub
	return 0;
}

}