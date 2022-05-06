/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package djktras;

/**
 *
 * @author Aristah
 */
// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

// Main class DPQ
public class Graph {

    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    
      URL url1 ;
	// Member variables of this class
	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Vertex> pq;
	// Number of vertices
	private int V;
	List<List<Vertex> > adj;
        
        Edge edge = new Edge();

	// Constructor of this class
	public Graph(int V)
	{

		// This keyword refers to current object itself
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Vertex>(V, new Vertex());
	}

	// Method 1
	// Dijkstra's Algorithm
	public void dijkstra(List<List<Vertex> > adj, int src)
	{
		this.adj = adj;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		// Add source node to the priority queue
		pq.add(new Vertex(src, 0));

		// Distance to the source is 0
		dist[src] = 0;

		while (settled.size() != V) {

			// Terminating condition check when
			// the priority queue is empty, return
			if (pq.isEmpty())
				return;

			// Removing the minimum distance node
			// from the priority queue
			int u = pq.remove().node;

			// Adding the node whose distance is
			// finalized
			if (settled.contains(u))

				// Continue keyword skips exwcution for
				// following check
				continue;

			// We don't have to call e_Neighbors(u)
			// if u is already present in the settled set.
			settled.add(u);

			e_Neighbours(u);
		}
	}

	// Method 2
	// To process all the neighbours
	// of the passed node
	private void e_Neighbours(int u)
	{

		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			Vertex v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;

				// Add the current node to the queue
				pq.add(new Vertex(v.node, dist[v.node]));
			}
		}
	}

	// Main driver method
	public static void main(String arg[]) throws IOException
	{

		int V = 20;
		int source = 0;
                
                

             System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                
                blue("Select Shortest Path From Source to Destination Based On:");
                
             System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                info("1. Distance Cost");
                info("2. Time Cost");
            
     

                
                Scanner scnr = new Scanner(System.in);
                 int choice = scnr.nextInt();
                 
                 
                 
               while(1< choice && choice>2){
                     
                warning("Invalid Choice..");
                blue("Select Shortest Path Based On:");
                info("1. Distance Cost");
                info("2. Time Cost");
                     
                      choice = scnr.nextInt();
                     
                 }
                
                
                
               // Adjacency list representation of the
		// connected edges by declaring List class object
		// Declaring object of type List<Node>
		List<List<Vertex> > adj
			= new ArrayList<List<Vertex> >();

		// Initialize list for every node
		for (int i = 0; i < V; i++) {
			List<Vertex> item = new ArrayList<Vertex>();
			adj.add(item);
		}
                
                
                String file_path="MapInformationXY.txt";
                        
                FileReader fr = new FileReader("C:\\Users\\Aristah\\Documents\\NetBeansProjects\\Djktras\\src\\djktras\\MapInformationXY.txt");
                BufferedReader br = new BufferedReader(fr);
                
                String sentence = br.readLine();
                
                int count =0;
                while((sentence=br.readLine())!=null){
                 
                   
                   StringTokenizer st = new StringTokenizer(sentence);
                   String src = st.nextToken();
                   String dst = st.nextToken();
                   String d_cost = st.nextToken();
                   String t_cost = st.nextToken();
                   
                   int int_src;
                   int int_dst;
                   int int_d_cost = Integer.valueOf(d_cost);
                   int int_t_cost = Integer.valueOf(t_cost);
                   
                   String alphbt = "ABCDEFGHIJKLMNOPQRST";
                   
                   int pstn_s = alphbt.indexOf(src);
                   int pstn_d = alphbt.indexOf(dst);
                   

                    count++;
                     //System.out.println(int_src+ " " +int_dst + " "+int_d_cost+ " "+int_t_cost);
                     
                     if(choice==1){
                     adj.get(pstn_s).add(new Vertex(pstn_d, int_d_cost));
                     }
                     else {
                         adj.get(pstn_s).add(new Vertex(pstn_d, int_t_cost));
                         
                     }
                   
                }



		// Calculating the single source shortest path
		Graph dpq = new Graph(V);
		dpq.dijkstra(adj, source);
                

                 
                 if(choice==1)
                 {
               
                     
             System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");   
		// Printing the shortest path to all the nodes
		// from the source node
		System.out.println("The shorted Distance Fron the Source to Each node :");
                
             System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                
                 String alphabet = "abcdefghijklmnopqrst";

		for (int i = 0; i < dpq.dist.length; i++)
                    
			amber("A" + " to " + alphabet.charAt(i) + " is "
							+ dpq.dist[i]);
                 }
                 
             else
                 {
               
		// Printing the shortest path to all the nodes
		// from the source node
           System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
           System.out.println("The shorted Time from Source to the Nodes :");
                
          System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                
                 String alphabet = "abcdefghijklmnopqrst";

		for (int i = 0; i < dpq.dist.length; i++)
                    
			yellow("A" + " to " + alphabet.charAt(i) + " is "
							+ dpq.dist[i]);
                 }


	}
        
      //blue text
    public static void blue(String message) {
        System.out.println(ANSI_BLUE  + message);
    }
     //green text
        public static void info(String message) {
        System.out.println(ANSI_GREEN + message);
    }
        
         //purple
        public static void amber(String message) {
        System.out.println(ANSI_PURPLE + message);
    }
        
         //red warning text
        public static void warning(String message) {
        System.out.println(ANSI_RED + message);
    }
        
         //yellow text
        public static void yellow(String message) {
        System.out.println(ANSI_CYAN + message);
    }
}
