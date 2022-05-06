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
 */
public class Edge {
    	List<List<Vertex> > adj;
        public Set<Integer> settled;
        public int dist[];
        public PriorityQueue<Vertex> pq;
        

    
    	// Method 2
	// To process all the neighbours
	// of the passed node
	public void e_Neighbours(int u)
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
}
