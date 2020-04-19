/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  public int _size;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0);
    _size = 0;//Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	Node inserted = new Node(elt);
	if (index < 0) {
		return false;
	} else if (index>_size) {
		return false;
	} 
	if (index == 0) {
		if (_size == 0) {
			sentinel.next = inserted;
			inserted.next = sentinel;
			sentinel.prev = inserted;
			inserted.prev = sentinel;
			
		} else {
			inserted.next = sentinel.next;
			sentinel.next = inserted;
			inserted.prev = sentinel;
			inserted.next.prev = inserted;
		
			
		}
		_size++;
		return true;
		
		
	} else if (index == _size) {
		inserted.next = sentinel;
		inserted.prev = sentinel.prev;
		sentinel.prev.next = inserted;
		sentinel.prev = inserted;
		_size++;
		return true;
	} else {
		Node pointer = sentinel;
		for (int i=0; i<index; i++) {
			pointer = pointer.next;
		}
		inserted.next = pointer.next;
		inserted.prev = pointer;
		pointer.next.prev = inserted;
		pointer.next = inserted;
		_size++;
		return true;
	}
	
}

@Override
public boolean remove(int index) {
	// TODO Auto-generated method stub
	if (index<0) {
		return false;
	} else if (index >= _size) {
		return false;
	} else if (index ==0) {
		sentinel.next.next.prev = sentinel;
		sentinel.next = sentinel.next.next;
		_size--;
		return true;
	} else if (index == _size-1) {
		sentinel.prev.prev.next = sentinel;
		sentinel.prev = sentinel.prev.prev;
		_size--;
		return true;
	} else {
		Node pointer = sentinel;
		for (int i=0; i<index; i++) {
			pointer = pointer.next;
		}
		pointer.next.next.prev = pointer;
		pointer.next = pointer.next.next;
		
		_size--;
		return true;
	}
	
}

@Override
public double get(int index) {
	Node pointer = sentinel;
	if (index<0 || index>_size-1) {
		return Double.NaN;
	}
	for (int i=0; i<index+1; i++) {
		pointer = pointer.next;
	}
	return pointer.data;
}

@Override
public int size() {
	return _size;
}

@Override
public boolean isEmpty() {
	if (_size ==0) {
		return true;
	}
	else {
		return false;
	}
}

@Override
public void clear() {
	_size =0;
	sentinel.next = sentinel;
	sentinel.prev = sentinel;
	
}
}