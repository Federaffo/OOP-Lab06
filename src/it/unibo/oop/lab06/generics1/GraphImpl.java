package it.unibo.oop.lab06.generics1;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.hamcrest.core.IsNull;

public class GraphImpl<N> implements Graph<N> {

	private final Map<N, Set<N>> myAdjacencyMap;
	
	public GraphImpl() {
		this.myAdjacencyMap = new HashMap<>();
	}

	public void addNode(N node) {
		if(node != null) {
			if(!myAdjacencyMap.containsKey(node)) {
				myAdjacencyMap.put(node, new HashSet<>());
			}
		}	
	}

	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			myAdjacencyMap.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return myAdjacencyMap.keySet();
	}

	public Set<N> linkedNodes(N node) {
		if (node != null) {
			return Collections.unmodifiableSet(myAdjacencyMap.get(node));
		}
		return null;
	}

	public List<N> getPath(N source, N target) {
		List<N> pathFromSourceToTargetList = new ArrayList<>();
		
		Queue<N> myQueue = new PriorityQueue<>();
		
		Map<N, Boolean> isVisited = new HashMap<>();
		
		for (N x : myAdjacencyMap.keySet()) {
			isVisited.put(x, false);
		}
		
		myQueue.add(source);
		isVisited.replace(source, true);
		
		
		while (!myQueue.isEmpty()) {
			
			N currentN = myQueue.poll();
			if(currentN.equals(target)) {
				pathFromSourceToTargetList.add(currentN);
				return Collections.unmodifiableList(adjustList(pathFromSourceToTargetList));
			}
			pathFromSourceToTargetList.add(currentN);
			for (N x : myAdjacencyMap.get(currentN)) {
				if(!isVisited.get(x)) {
					isVisited.replace(x, true);
					myQueue.add(x);
				}
			}
			
		}
		return null;	
	}
	
	private List<N> adjustList(List<N> myList ) {
		for (int i = 0; i < myList.size(); i++) {		
			if(i < myList.size() - 1) {
				if(!existingEdge(myList.get(i), myList.get(i + 1))) {
					myList.remove(myList.get(i));					
				}
			}
		}
		return myList;
	}

	private boolean existingEdge(N source, N target) {
		return myAdjacencyMap.get(source).contains(target);
	}
}
