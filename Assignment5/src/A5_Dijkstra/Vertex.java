package A5_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
	long ID;
	String label;
	
	HashMap<String, Edge> inputEdges = new HashMap<String, Edge>();
	HashMap<String, Edge> outputEdges = new HashMap<String, Edge>();
	
	
	ArrayList<Vertex> outputVertex = new ArrayList<Vertex>();
	ArrayList<Vertex> inputVertex = new ArrayList<Vertex>();

	
	
	public Vertex (long ID, String label) {
		this.ID = ID;
		this.label = label;
	}

	public void addOutputVertex(Vertex v) {
		if(!outputVertex.contains(v)) {
			outputVertex.add(v);
		}
	}
	
	public void addInputVertex(Vertex v) {
		if(!inputVertex.contains(v)) {
			inputVertex.add(v);
		}
	}

	
	
	
	
	

}