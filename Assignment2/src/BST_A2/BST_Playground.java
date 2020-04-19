package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

  BST test = new BST();  
  BST testE = new BST();

  test.insert("C");
  test.insert("B");
  test.insert("A");

  test.remove("C");
 
  System.out.print(test.empty());

  
 
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  ////https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}