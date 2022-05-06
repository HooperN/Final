package finalProject;


public class Path implements Comparable<Path>{
	
	private int cost = 0;
	private Vertex end;
	private String pathStr;

	public Path(Vertex end, int cost, String pathStr) {
		this.end = end;
		this.cost = cost;
		this.pathStr = pathStr;
	}
	
//	public boolean addEdge(Edge e) {
//		if(edges.contains(e)) { return false; }
//		
//		edges.add(e);
//		cost+=(useDist ? e.getDistance() : e.getTime());
//		return true;
//	}
	
	public int getCost() {
		return cost;
	}
	
	public String toString() {	
		return String.format("%s %s %d", end.getSymbol(), pathStr, cost);
	}

	@Override
	public int compareTo(Path o) {
		return cost - o.cost;
	}

}
