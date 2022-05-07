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
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Edge)) { return false; }
		
		Edge e = (Edge) o;
		return (start.equals(e.getStart()) && end.equals(e.getEnd()));
	}
	
	@Override
	public int hashCode() {
		return start.hashCode() + end.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("Destination: %s, Time cost: %d, Distance: %d", end.getSymbol(), timeCost, distance);
	}
	
	public double getTime() {
		return timeCost;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Vertex getEnd() {
		return end;
	}
	
	public Vertex getStart() {
		return start;
	}
	
}
