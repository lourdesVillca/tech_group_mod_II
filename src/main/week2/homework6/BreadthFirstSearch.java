package week2.homework6;

import java.util.*;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	protected HashMap<Node, Integer> path_distance;


	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		path_distance = new HashMap<>();
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return false;
		}
		if (start.getElement().equals(elementToFind)) {
			path_distance.put(start, 0);
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		path_distance.put(start, 0);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						path_distance.put(neighbor, path_distance.get(current) + 1);
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
					path_distance.put(neighbor, path_distance.get(current) + 1);
				}
			}
		}
		return false;
	}
	public int getPathDistance(Node node) {
		return path_distance.get(node);
	}

}
