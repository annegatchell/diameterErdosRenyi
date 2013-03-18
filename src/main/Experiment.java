package src.main;

public class Experiment{

	public static void main(String[] args){
		int[] n = {10, 20, 50, 130, 320, 770, 1790, 4100, 9220};
		int trials = 10;
		Measurement rawTrialData;
		Measurement averagedData = new Measurement();
		Graph g;
		
		for(int graphSize : n){
			System.out.print("Running tests for graph size "+graphSize+" ");
			rawTrialData = new Measurement();
			for(int i = 0; i < trials; i++){
				System.out.print(i);
				g = Graph.generateErdosRenyiGraph(graphSize);
				int d = g.diameter();
				//System.out.println("size "+g.space());
				rawTrialData.addData(graphSize, g.space(), g.numOps(), d);
			}
			rawTrialData.averageAllAddToMeasurement(averagedData);
			System.out.print("averaged.\n");
		}

		System.out.println("DONE");
		System.out.println("Average Diameters:\n"+averagedData.diameterDataString());
		System.out.println("Average NumOps:\n"+averagedData.numOpsDataString());
		System.out.println("Average Space:\n"+averagedData.spaceDataString());
		

	}
}