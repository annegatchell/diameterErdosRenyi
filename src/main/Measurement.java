package src.main;

public class Measurement{
	Bag<Node> measurements;

	public Measurement(int[] nums){
		measurements = new Bag<Node>();
	}

	class Node{
		int n;
		int space;
		int numOps;
		int diameter;
		Point next;
		Node(int num, int s, int no, int d){
			n = num;
			space = s;
			numOps = no;
			diameter = d;
		}
	}

	public addData(int n, int s, int no, int d){
		measurements.add(new Node(n, s, no, d));
	}

	public String diameterDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.diameter+")\n");
		}
		s.append("};");
		return s.toString();
	}

	public String spaceDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.space+")\n");
		}
		s.append("};");
		return s.toString();
	}	

	public String numOpsDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.numOps+")\n");
		}
		s.append("};");
		return s.toString();
	}
}