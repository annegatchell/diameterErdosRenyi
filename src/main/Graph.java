/*
An implemenation of an unweighted, undirected graph.

Does not guard against adding duplicate edges.

*/

package src.main;
import java.util.Random;

public class Graph{
	private final int V; //number of verteces
	private int E; //number of edges
	private boolean isDirected;
	private Bag<Integer>[] adj; //adjacency list
	public Random rand;

	public Graph(int v){
		V = v;
		E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Integer>();
		}
		rand = new Random();
	}

	public static int diameter(Graph g){
		//Get the largest component of the graph
		int[] componentForDiameter = getLargestComponentVertices(g);

		boolean[] visited = new boolean[g.V()]; //visited
		int[] distance = new int[g.V()]; //distance from source
		int[] parent = new int[g.V()]; //
		int[] component = new int[g.V()];




		for(int i = 0; i < g.V(); i++){
			visited[i] = false;
		}
		int longestLength = 0;

		return 0;
	}

	//
	public static int[] getLargestComponentVertices(Graph g){
		int[] visitedInComponent = new int[g.V()];
		for(int i = 0; i < g.V(); i++){
			visitedInComponent[i] = -1;
		}
		int component = 0;
		for(int i = 0; i < g.V(); i++){
			if(visitedInComponent[i] < 0){
				largetComponentVisit(component, visitedInComponent,g,i);
				component++;
			}
		}
		int[] componentSizes = new int[component];
		for(int i = 0; i < g.V(); i++){
			componentSizes[visitedInComponent[i]]++;
		}
	 	int largest = -1;
		int size = 0;
		for(int i = 0; i < component; i++){
			if(size < componentSizes[i]){
				size = componentSizes[i];
				largest = i;
			}
		}
		int[] largestComponent = new int[size];
		int j = 0;
		for(int i = 0; i < g.V(); i++){
			if(visitedInComponent[i] == largest){
				largestComponent[j] = i;
				j++;
			}
		}
		return largestComponent;
	}

	public static void largetComponentVisit(int component, int[] visited, Graph g, int u){
		visited[u] = component;
		for(int a :g.adj[u]){
			if(visited[a] < 0){
				largetComponentVisit(component, visited, g, a);
			}
		}
	}

	public static Graph generateErdosRenyiGraph(int n){
		int c = 5;
		double p = (double)c/(double)(n-1);
		Graph g = new Graph(n);
		System.out.println("p = "+p);
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(g.rand.nextInt(Integer.MAX_VALUE) < p*Integer.MAX_VALUE){
					g.addEdge(i, j);
					System.out.println("Adding edge "+i+" "+j);
				}
				else
				System.out.println("Not adding edge "+i+" "+j);
			}
		}
		return g;
	}

	private static boolean placeEdge(Graph g, double p){
		return g.rand.nextInt(Integer.MAX_VALUE) < p*Integer.MAX_VALUE;
	}

	public void addEdge(int x, int y){
		adj[x].add(y);
		adj[y].add(x);
		E++;
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(V+" vertices, "+E+" edges\n");
		for(int i = 0; i < V; i++){
			s.append(i+": "+adj[i].toString()+"\n");
		}
		return s.toString();
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
	}


}