package finalProject;


public class Test{
	
	public static void main(String[] args) {
		Graph g = new Graph("MapInformationXY.txt");
		g.setReturnAddress(true);
		//g.setUseDistCost(true);
		Dijkstra d = new Dijkstra(g, "A", "S");
		System.out.println(d.shortestPath());
		d = new Dijkstra(g, "T", "B");
		System.out.println(d.shortestPath());
		d = new Dijkstra(g, "E", "S");
		System.out.println(d.shortestPath());
		
	}
	
}