/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package djktras;

import java.util.Comparator;

/**
 *
 * @author Aristah
 */
public class Vertex implements Comparator<Vertex> {
    
    
    // Member variables of this class
	public int node;
	public int cost;

	// Constructors of this class

	// Constructor 1
	public Vertex() {}

	// Constructor 2
	public Vertex(int node, int cost)
	{

		// This keyword refers to current instance itself
		this.node = node;
		this.cost = cost;
	}

	// Method 1
	@Override public int compare(Vertex node1, Vertex node2)
	{

		if (node1.cost < node2.cost)
			return -1;

		if (node1.cost > node2.cost)
			return 1;

		return 0;
	}
    
}
