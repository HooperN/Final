package finalProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph {

	private Map<Vertex, Set<Edge>> adjacencyList;
	private static boolean useDistCost = false;
	private static boolean returnAddress = true;

	public Graph(String fname) {
		adjacencyList = new HashMap<Vertex, Set<Edge>>();
		readFile(fname);
		
//		for(Vertex v : adjacencyList.keySet()) 
//			for(Edge e : adjacencyList.get(v)) 
//				System.out.println(e);
		
	}
	
	public void setUseDistCost(boolean useDist) {
		Graph.useDistCost = useDist;
	}
	
	public void setReturnAddress(boolean useAddress) {
		Graph.returnAddress = useAddress;
	}
	
	public Map<Vertex, Set<Edge>> getMap(){
		return adjacencyList;
	}
	
	public boolean getUseDist() {
		return useDistCost;
	}
	
	public String toString() {
		String ret = "";
		
		for(Vertex v : adjacencyList.keySet()) {
			ret += (returnAddress ? v.toString() : "Vertex:" + v.getSymbol()) + ", Edges: [";
			for(Edge e : adjacencyList.get(v)) {
				ret += " (" + (returnAddress ? e.getEnd().toString() : e.getEnd().getSymbol()) 
				+ (useDistCost ? "Distance: " + e.getDistance() : "Time: " + e.getTime()) + ") ";
			}
			ret += "]\n";
		}
		return ret;
	}
 
	
	public void readFile(String fname) {
        try {
            
            // Creates a scanner
            Scanner file = new Scanner(new File(fname));
            String line = file.nextLine();
            
            
            
            // Skips lines until the Nodes are reached
            while (!line.equals("<Nodes>")) { line = file.nextLine(); }
            
            // Skips two lines of header text in the file
            file.nextLine();
            line = file.nextLine();
            
            // Creates Vertex objects (each of which contains a symbol and an address property)
            while (!line.equals("</Nodes>")) {
                String[] s = line.split("\t");
                adjacencyList.put(new Vertex(s[0], s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3])), new HashSet<>());
                line = file.nextLine();
            }
            
            // Skips lines until Edges are reached
            while (!line.equals("<Edges>")) { line = file.nextLine(); }
            file.nextLine();
            
            // Creates Edge objects (each of which contains a source, destination, time cost, 
            // and distance cost property) and adds them to a set
            line = file.nextLine();
            String[] s = line.split("\t");
            while (!line.equals("</Edges>")) {
            	Vertex v = new Vertex(s[0], "", 0, 0);
            	Set<Edge> edgeSet = new HashSet<Edge>();
            	
                do {
                	Vertex end = new Vertex(s[1], "", 0, 0);
                	Edge e = new Edge(v, end, Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                	//System.out.println(e.toString());
                	edgeSet.add(e);
                    line = file.nextLine();
                    s = line.split("\t");
                } while (s[0].equals(v.getSymbol()));
                adjacencyList.replace(v, edgeSet);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        }
    }
 	
 	
}