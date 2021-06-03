import java.util.LinkedList;

public class Node {

	private String id;
	private boolean isVisited;
	private LinkedList<Node> nextNodes;
	private int startMemory;
	private int endMemory;
	private int length;

	public Node(String id, int startMemory, int endMemory) {
		super();
		this.id = id;
		this.isVisited = false;
		this.startMemory = startMemory;
		this.endMemory = endMemory;
		this.length = endMemory - startMemory;
		this.nextNodes = new LinkedList<>();
	}

	protected void addChild(Node node) {
		nextNodes.add(node);
	}

	public int getStartMemory() {
		return startMemory;
	}

	public void setStartMemory(int startMemory) {
		this.startMemory = startMemory;
	}

	public int getEndMemory() {
		return endMemory;
	}

	public void setEndMemory(int endMemory) {
		this.endMemory = endMemory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public LinkedList<Node> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(LinkedList<Node> nextNodes) {
		this.nextNodes = nextNodes;
	}

}
