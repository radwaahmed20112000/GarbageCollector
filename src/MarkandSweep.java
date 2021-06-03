import java.util.*;

public class MarkandSweep {
	LinkedList <String> roots;
	Graph graph;
	Stack<Node> stack;

	public MarkandSweep(LinkedList<String> roots,Graph graph) {
		this.roots = roots;
		this.graph = graph;
		this.stack = new Stack<>();
		dfs();
	}

	public void dfs() {
		for (String id : roots) {
			Node node = graph.getNode(id);
			mark(node);
		}
		sweep();
	}

    private void mark(Node node) {
    	this.stack.add(node);
    	node.setVisited(true);
    	LinkedList<Node> currentNodeChildren = node.getNextNodes();
    	for(Node child : currentNodeChildren) {
    		mark(child);
    	}
    }
    public void sweep () {
    	for (int i = 0 ; i < graph.getGraph().size() ; i++ ) {
    		if(!graph.getGraph().get(graph.getIds().get(i)).isVisited()) {
				graph.removeNode(graph.getGraph().get(graph.getIds().get(i)));
				i--;
			}
    	}
    }
}
