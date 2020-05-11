import java.util.*;

public class UndirectedGraph {

    private ArrayList<UndirectedGraphNode> nodes;


	/**
	 * Constructs an undirected graph with the given adjacency matrix. The adjacency
	 * matrix is a 2d array of booleans representing the presence of edges in the
	 * graph.
	 *
	 * The graph will have a number of vertices equal to the length of the adjacency matrix.
	 * 
	 * An edge from vertex i to vertex j exists if adjacencyMatrix[i][j] is true.
	 * @param adjacencyMatrix a 2d boolean array representing an adjacency matrix.
	 */
	public UndirectedGraph(boolean[][] adjacencyMatrix) {

		nodes = new ArrayList<UndirectedGraphNode>();

		// populate the graph with nodes.
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			nodes.add(new UndirectedGraphNode(i));
		}

		// connect the nodes based on the adjacency matrix
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				if (adjacencyMatrix[i][j]) {
					this.connect(i, j);
				}//if
			}
        }

    }// constructor
    
    /**
	 * Returns a string representation of all the nodes in the graph. The string
	 * displays all of the data fields in the node.
	 *
	 * @return a string representation of the graph.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// for every node
		for (int i = 0; i < this.nodes.size(); i++) {
			// append the string representation to the result.
			UndirectedGraphNode current = this.nodes.get(i);
			sb.append(String.format("Node %-8d Adjacent Nodes %3s\n", current.getData(), this.getArrayData(current.getAdjacentNodes())));
		}
		return sb.toString();
    }// toString
    
    private String getArrayData(LinkedList<UndirectedGraphNode> output) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (output.size() > 0) {
            sb.append(output.get(0).data);
            for (int i = 1; i < output.size(); i++) {
                sb.append(", " + output.get(i).data);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
	 * Retrieves the number of nodes in the Graph.
	 * 
	 * @return the number of nodes in the graph.
	 */
	public int getGraphSize() {
		return this.nodes.size();
	}// getGraphSize
    
    
    /**
	 * adds the node other as a neighbor to root.
	 *
	 * @param root  the data of the node to receive a neighbor
	 * @param other the data of the node to be added
	 */
	private void connect(int nodeA, int nodeB) {

		if (0 > nodeA || nodeA >= this.getGraphSize()) {
			throw new ArrayIndexOutOfBoundsException("Cannot connect nonexistent root with value: " + nodeA
					+ ". Valid Nodes are between 0 and " + (this.nodes.size() - 1) + ".");
		}

		if (0 > nodeB || nodeB >= this.getGraphSize()) {
			throw new ArrayIndexOutOfBoundsException("Cannot connect nonexistent root with value: " + nodeB
					+ ". Valid Nodes are between 0 and " + (this.nodes.size() - 1) + ".");

		}

		UndirectedGraphNode connectNodeA = findNode(nodeA);
		UndirectedGraphNode connectNodeB = findNode(nodeB);

        // add the other node to the root
        if (!connectNodeA.hasAdjacentNode(connectNodeB)) {
            connectNodeA.addAdjacentNode(connectNodeB);
        }
        if (!connectNodeB.hasAdjacentNode(connectNodeA)) {
            connectNodeB.addAdjacentNode(connectNodeA);
        }
        

	}// connect
    
    private UndirectedGraphNode findNode(int data) {
		if(0 <= data && data < this.nodes.size()){
			return nodes.get(data);
		}else{
			return null;
		}
    }// findNode
    
    /**
     * This method takes data for a starting node and ending node and returns the number of unique shortest paths between them.
     * For example, if the the shortest path between nodes 1 and 5 is 3, and there is only ONE path of length 3, this method will 
     * return 1.  However, if there are 4 different paths that lead from 1 to 5 that are all length 3, this method will return 4.
	 * If there is not a path between start and end, this method should return 0
	 * 
     * @param start
     * @param end
     * @return
     */
    public int numShortestPaths(int start, int end) {

		//ADD YOUR CODE HERE

        return 0;
    }
    
    
    private static class UndirectedGraphNode {
        private int data;
        private LinkedList<UndirectedGraphNode> adjacentNodes;

        public UndirectedGraphNode(int data) {
            this.data = data;
            this.adjacentNodes = new LinkedList<UndirectedGraphNode>();
        }

        public int getData() {
            return this.data;
        }

        public LinkedList<UndirectedGraphNode> getAdjacentNodes() {
            return this.adjacentNodes;
        }

        public void addAdjacentNode(UndirectedGraphNode newNode) {
            this.adjacentNodes.add(newNode);
        }

        public boolean hasAdjacentNode(UndirectedGraphNode node) {
            for (int i = 0; i < this.adjacentNodes.size(); i++) {
                if (this.adjacentNodes.get(i).equals(node)) {
                    return true;
                }
            }
            return false;
        }
    }

}