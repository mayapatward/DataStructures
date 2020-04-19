package A5_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class DiGraph implements DiGraph_Interface {

	Map<String, Vertex> nodes = new HashMap<String, Vertex>();
	
	//ID is edge ID
	
	Set<Long> nodeIDs = new HashSet<Long>();
	Set<Long> edgeIDs = new HashSet<Long>();
	
	int edgeNumber = 0;
	int nodeNumber = 0;


  public DiGraph ( ) { 
	  
  }

@Override
public boolean addNode(long idNum, String label) {
	if (label == null) {
		return false;
	} if (idNum < 0) {
		return false;
	} if (nodes.containsKey(label)) {
		return false;
	} if(nodeIDs.contains(idNum)) {
		return false;
	}
	Vertex newVertex = new Vertex(idNum, label);
	nodeIDs.add(idNum);
	nodes.put(label, newVertex);
	nodeNumber++;
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	
	if (idNum < 0) {
		return false;
	} if (edgeIDs.contains(idNum)) {
		return false;
	} if (!nodes.containsKey(sLabel) || sLabel == null) {
		return false;
	}
	if (!nodes.containsKey(dLabel) || dLabel == null) {
		return false;
	} if(nodes.get(sLabel).outputVertex.contains(nodes.get(dLabel))) {
		return false;
	}
	edgeIDs.add(idNum);
	Edge newEdge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
	
	nodes.get(sLabel).outputEdges.put(dLabel, newEdge);
	nodes.get(dLabel).inputEdges.put(sLabel, newEdge);
	nodes.get(sLabel).addOutputVertex(nodes.get(dLabel));
	nodes.get(dLabel).addInputVertex(nodes.get(sLabel));
	edgeNumber++;
	return true;
}

@Override
public boolean delNode(String label) {
	if(!nodes.containsKey(label)) {
		return false;
	} 
	Vertex node = nodes.get(label);
	nodes.remove(label);
	nodeIDs.remove(node.ID);
	for(int i =0; i<node.inputVertex.size(); i++) {
		delEdge(node.inputVertex.get(i).label, node.label);
	}
	for(int i =0; i<node.outputVertex.size(); i++) {
		delEdge(node.label, node.outputVertex.get(i).label);
	}
	
	nodeNumber--;
	return true;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	
	if (!nodes.containsKey(sLabel)) {
		return false;
	}
	if (!nodes.containsKey(dLabel)) {
		return false;
	} if (!nodes.get(sLabel).outputVertex.contains(nodes.get(dLabel))) {
		return false;
	} 
	Edge remove = nodes.get(sLabel).outputEdges.get(dLabel);
	edgeIDs.remove(remove.id);
	nodes.get(sLabel).outputEdges.remove(dLabel);
	nodes.get(dLabel).inputEdges.remove(sLabel);
	nodes.get(sLabel).outputVertex.remove(nodes.get(dLabel));
	nodes.get(dLabel).inputVertex.remove(nodes.get(sLabel));
	edgeNumber--;
	return true;
}

@Override
public long numNodes() {
	return nodeNumber;
}

@Override
public long numEdges() {
	return edgeNumber;
}

public boolean update(Map<Vertex, Integer> d, String x, int h, MinBinHeap p) {
	d.remove(nodes.get(x));
	d.put(nodes.get(x), h);
	p.insert(new EntryPair(x, h));
	return true;
}

@Override
public ShortestPathInfo[] shortestPath(String label) {
	ShortestPathInfo[] shortest = new ShortestPathInfo[(int) numNodes()];
	ArrayList<ShortestPathInfo> listPaths = new ArrayList<ShortestPathInfo>();
	Map<Vertex, Integer> distance = new HashMap<Vertex, Integer>();
	Set<Vertex> visited = new HashSet<Vertex>();
	ArrayList<Vertex> vertexArray = new ArrayList<Vertex>();
	MinBinHeap heap = new MinBinHeap();
	

	
	Set<String> stringArray =  nodes.keySet();
	for(String x: stringArray) {		
		vertexArray.add(nodes.get(x));
	}
	
	distance.put(nodes.get(label), 0);
	heap.insert(new EntryPair(label, 0));
	
	

	
	for (Vertex x: vertexArray) {
		if (!x.label.equals(label)) {
			distance.put(x, Integer.MAX_VALUE);			
		} 
	}
	
	while(! (heap.size() == 0)) {
		EntryPair in = heap.getMin();
		String v = heap.getMin().getValue();
		Vertex inVertex = nodes.get(in.getValue());
		heap.delMin();
		
		if (visited.contains(v)) {
			continue;
		}
		
		
		visited.add(inVertex);
				
		
		HashMap<String, Edge> outEdges = inVertex.outputEdges;
		for (Map.Entry<String, Edge> entry: outEdges.entrySet()) {
			Edge edge = entry.getValue();
			String destination = entry.getKey();
			int hypothetical = distance.get(inVertex) + (int)edge.weight;
			if(hypothetical <  distance.get(nodes.get(destination))) {
				if (hypothetical > -1) {
					update(distance, destination, hypothetical, heap);					
				}
			}			
			
		}	
		
	}
	

	
	for (int i = 0; i < shortest.length; i++) {
		if (distance.get(vertexArray.get(i)) == Integer.MAX_VALUE) {
			shortest[i] = new ShortestPathInfo(vertexArray.get(i).label, -1);}
		else {
			shortest[i] = new ShortestPathInfo(vertexArray.get(i).label, distance.get(vertexArray.get(i)));
			
		}
	}

	
	
	
	
	
	
	return shortest;
	
}
  
  // rest of your code to implement the various operations
}