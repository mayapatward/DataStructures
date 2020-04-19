package A5_Dijkstra;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "A");
      d.addNode(2, "B");
      d.addNode(3, "C");
      d.addNode(4, "D");
      d.addNode(5, "E");
      d.addNode(6, "F");
      d.addNode(7, "G");
      d.addNode(27, "H");
      d.addNode(28, "I");
      d.addEdge(9, "A", "B", 2, null);
      d.addEdge(10, "A", "D", 1, null);
      d.addEdge(11, "B", "D", 3, null);
      d.addEdge(12, "B", "E", 1, null);
      d.addEdge(14, "C", "A", 4, null);
      d.addEdge(15, "C", "F", 5, null);
      d.addEdge(16, "D", "C", 2, null);
      d.addEdge(17, "D", "F", 8, null);
      d.addEdge(18, "D", "G", 4, null);
      d.addEdge(19, "D", "E", 3, null);
      d.addEdge(20, "E", "G", 6, null);
      d.addEdge(21, "G", "F", 1, null);
      d.addEdge(21, "H", "G", 1, null);
      d.shortestPath("A");
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
    }
}
