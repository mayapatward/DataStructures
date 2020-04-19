package MinBinHeap_A3;



public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }
  

@Override
public void insert(EntryPair entry) {
	int current = size+1;
	array[current] = entry;
	while (current != 1) {
		if (entry.getPriority() < array[current / 2].getPriority()) {
		EntryPair temporary = array[current / 2];
		array[current / 2] = entry;
		array[current] = temporary;
		current = current / 2;
		} else {
			break;
		}
	}
	size ++;
	
}

@Override
public void delMin() {
	
	int current = 1;	
	
	if (array[1] != null) {
		array[1] = array[size];
		size--;
		while(current * 2 <= size) {
			 int child = current *2;
			 if (child != size && array[child+1].getPriority()<array[child].getPriority()) {
				 child++;
			 } if (array[child].getPriority() < array[current].getPriority()) {
				 EntryPair temporary = array[child];
				 array[child] = array[current];
				 array[current] = temporary;
				  
			 } else {
				 break;
			 }
			
			 current = child;
		}
		
		
		

	
	}
	
}

@Override
public EntryPair getMin() {
	return array[1];
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public void build(EntryPair[] entries) {
	size = entries.length;
	
	for (int i = 0; i < size; i++) {
		array[i+1] = entries[i];
	}
	
	int current = size/2;
	int parent = size/2;
	while( current > 0 ) {
		current = parent;
		while(current*2 <= size){
			int child = current *2;
			if (array[child+1] != null) {
			if(array[child +1].getPriority() < array[child].getPriority()){
					child++;
				}
			}
			if(array[child].getPriority() < array[current].getPriority()){
				EntryPair temporary = array[child];
				array[child] = array[current];
				array[current] = temporary;
				current = child;
			}
			else{
				break;
			}
			
		}
		
	parent--;
	}
	
}
}