/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djktras;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Aristah
 * 
 */

public class Dijkstra {
    
    
    Edge edge = new Edge();
    
    
    
	// Member variables of this class
	public int dist[];
	public Set<Integer> settled;
	public PriorityQueue<Vertex> pq;
	// Number of vertices
	public int V;
	List<List<Vertex> > adj;

    public Dijkstra(int[] dist, Set<Integer> settled, PriorityQueue<Vertex> pq, int V, List<List<Vertex>> adj) {
        this.dist = dist;
        this.settled = settled;
        this.pq = pq;
        this.V = V;
        this.adj = adj;
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

			edge.e_Neighbours(u);
		}
	}
    
}
