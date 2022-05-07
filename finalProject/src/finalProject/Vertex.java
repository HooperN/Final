package finalProject;


public class Vertex {

	//notes: 
	//Vertex (A) Edges ({C, 4}, {Q, 3}, ... )
	//
	private String symbol;
	private String address;
	private int x;
	private int y;
	
	
	public Vertex(String symbol, String address, int x, int y) {
		this.symbol = symbol;
		this.address = address;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return symbol.hashCode();
	}
	
	@Override
	public String toString() {
		return "Vertex " + symbol + ": " + address;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Vertex)) { return false; }
		
		Vertex v = (Vertex) o;
		
		return symbol.equals(v.getSymbol());
	}
	
	public boolean equals(String s) {
		return symbol.equals(s);
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getAddress() {
		return address;
	}
}
