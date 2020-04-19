package SkipList;

public class SkipList_Node {
  String data;
  int level;
  SkipList_Node[] forward;
  
  SkipList_Node(String s, int level) {
    this.data = s;
    this.level = level;
    this.forward = new SkipList_Node[level + 1];
  }



  public boolean setForward(int level, SkipList_Node forward) { 
	 this.forward[level] = forward;
	 return true;
	  }
  
  String getData() { 
	  return this.data; 
	  }
  
}