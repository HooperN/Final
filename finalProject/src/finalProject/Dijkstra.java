package finalProject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	
	private HeapPriorityQueue<Path> paths;
	private static int totalCost = 0;
	Map<Vertex, Set<Edge>> map;
	HashSet<Edge> adjacent;
	HashSet<Vertex> visited = new HashSet<Vertex>();
	private static boolean useDistCost;
	

	public Dijkstra(Map<Vertex, Set<Edge>> graph, Vertex start, Vertex end, boolean useDist) {
		useDistCost = useDist;
		paths.add(new Path(start, 0 ,start.getSymbol()));
		map = graph;
		
		
		
	}
	
	public static Path shortestPath() {
		while(!paths.isEmpty()) {
			Path nextEntry = paths.remove();
			if(visited.contains(nextEntry.getVertex())) {
				continue;
			}
			else {
				adjacent = (HashSet<Edge>) map.get(nextEntry.getVertex());
				for(Edge e : adjacent) {
					if(!visited.contains(e.getEnd())){
						paths.add(new Path(nextEntry, e.getEnd(), (useDistCost ? e.getDistance() : e.getTime())));
					}
				}
			}
			
			visited.add(nextEntry.getVertex());
			if(nextEntry.getVertex().equals(end)) {
				return nextEntry;
			}
			else {
				currVertex = 
			}
		}
		return null;
	}
	
}
