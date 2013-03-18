package src.main;

public class Measurement{
	private Bag<Node> measurements;

	public Measurement(){
		measurements = new Bag<Node>();
	}
	private class Node{
		long n;
		long space;
		long numOps;
		long diameter;
		Node(long num, long s, long no, long d){
			n = num;
			space = s;
			numOps = no;
			diameter = d;
		}
	}

	public void addData(long n, long s, long no, long d){
		measurements.add(new Node(n, s, no, d));
	}

	public void averageAllAddToMeasurement(Measurement avg){
		long spaceTotal = 0, numOpsTotal = 0, diameterTotal = 0, numTotal = 0;
		for(Node n : measurements){
			numTotal += n.n;
			spaceTotal += n.space;
			numOpsTotal += n.numOps;
			diameterTotal += n.diameter;
		}
		long numAvg = numTotal/measurements.size();
		long spaceAvg = spaceTotal/measurements.size();
		long numOpsAvg = numOpsTotal/measurements.size();
		long diameterAvg = diameterTotal/measurements.size();
		avg.addData(numAvg,spaceAvg, numOpsAvg, diameterAvg);
	}

	public String diameterDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {\n");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.diameter+")\n");
		}
		s.append("};");
		return s.toString();
	}

	public String spaceDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {\n");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.space+")\n");
		}
		s.append("};");
		return s.toString();
	}	

	public String numOpsDataString(){
		StringBuilder s = new StringBuilder();
		s.append("\\addplot coordinates {\n");
		for(Node n: measurements){
			s.append("("+n.n+", "+n.numOps+")\n");
		}
		s.append("};");
		return s.toString();
	}
}