package SkipList;

public class SkipList_Playground {
/*
 * you will test your own skiplist implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create SkipList objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and level, and looking at if they
 * are all linked up correctly for a SkipList
 * 
*/
  
  public static void main(String[]args){

   // you should test your skiplist implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print skiplist method
   // feel free to use the printSkipList method to verify your skiplists manually
   // or write one you like better
 
  }

  public static void printSkipList(SkipList sl) {
    SkipList_Node x = sl.getHead();
    for (int i = 0; i < sl.size(); i++) {
      System.out.print(x.forward[1].getData() + " ");
      x = x.forward[1];
    }
    System.out.println();
  }
}