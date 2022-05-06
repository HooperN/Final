package finalProject;

public class Edge{
	
	private Vertex start;
	private Vertex end;
	private int timeCost;
	private int distance;

	public Edge(Vertex start, Vertex end, int time, int dist) {
		this.start = start;
		this.end = end;
		timeCost = time;
		distance = dist;
	}

	//compareto?
	
	public double getTime() {
		return timeCost;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Vertex getEnd() {
		return end;
	}
	
	public String getString() {
		return String.format("Destination: %c, Time cost: %d, Distance: %d", end.getSymbol(), timeCost, distance);
	}

}
