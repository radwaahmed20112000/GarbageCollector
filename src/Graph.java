import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	HashMap<String,Node> graph;
	LinkedList<String> ids;
	public Graph() {
		this.graph = new HashMap<>();
		this.ids = new LinkedList<>();
	}

	public void addNode (String id, int startMemory, int endMemory) {
		Node node =  new Node ( id,  startMemory,  endMemory);
		ids.add(id);
		graph.put(id,node);
	}

	public void removeNode (Node node) {
		ids.remove(node.getId());
		graph.remove(node.getId(),node);
	}

	public void addEdge(String id1, String id2) {
		graph.get(id1).addChild(graph.get(id2));
	}
	public Node getNode (String id) {
		return graph.get(id);
	}

	public HashMap<String, Node> getGraph() {
		return graph;
	}

	public LinkedList<String> getIds() {
		return ids;
	}
}
