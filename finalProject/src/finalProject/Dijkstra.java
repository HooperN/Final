package finalProject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	
	private HeapPriorityQueue<Path> paths;
	private static int totalCost = 0;
	Map<Vertex, Set<Edge>> map;
	
	HashSet<Vertex> visited;
	private static boolean useDistCost;
	private static Path shortest;
	

	public Dijkstra(Graph graph, String start, String end) {
		
		Vertex s = new Vertex(start, "", 0, 0);
		Vertex e = new Vertex(end, "", 0, 0);
		useDistCost = graph.getUseDist();
		map = graph.getMap();
		shortest = shortest(s, e);
		
		
//		while(!paths.isEmpty()) {
//			Path nextEntry = paths.remove();
//			if(visited.contains(nextEntry.getVertex())) {
//				continue;
//			}
//			else {
//				adjacent = (HashSet<Edge>) map.get(nextEntry.getVertex());
//				for(Edge e : adjacent) {
//					if(!visited.contains(e.getEnd())){
//						paths.add(new Path(nextEntry, e.getEnd(), (useDistCost ? e.getDistance() : e.getTime())));
//					}
//				}
//			}
//			
//			visited.add(nextEntry.getVertex());
//			if(nextEntry.getVertex().equals(end)) {
//				return nextEntry;
//		}
//		return null;
//	}
	}
	private Path shortest(Vertex start, Vertex end) {
		visited = new HashSet<Vertex>();
		paths = new HeapPriorityQueue<Path>();
		paths.add(new Path(start, 0 ,start.getSymbol()));
		HashSet<Edge> adjacent;
		
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
				totalCost = nextEntry.getCost();
				return nextEntry;
			}
		}
		return null;
	}
	
	public static Path shortestPath() {
		return shortest;
	}

	
}
