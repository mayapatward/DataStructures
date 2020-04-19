package A5_Dijkstra;

public class Edge {
	long id;
	String source;
	String destination;
	long weight = 1;
	String label;
	
	
	

	public Edge (long id, String source, String destination, long weight, String label) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.label = label;
		
	}

}
