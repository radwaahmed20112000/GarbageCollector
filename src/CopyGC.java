import java.util.LinkedList;

public class CopyGC extends GarbageCollector {
	
	LinkedList<Node> newHeap ;
	LinkedList<String> newIds;
	Graph modifiedHeap;
	
	
	public CopyGC(String heapFile, String rootFile, String pointersFile, String targetPath)
	{
		super(heapFile, rootFile, pointersFile, targetPath);
		newHeap = new LinkedList<>();
		newIds = new LinkedList<>();
		modifiedHeap = new Graph();
	}
	

	@Override
	public void garbageCollectorTechnique() {
		copyHeap();
		for(Node node : newHeap) {
			modifiedHeap.addNode(node.getId(),node.getStartMemory(),node.getEndMemory());
		}
		modifiedHeap.setIds(newIds);
		fileManager.setHeap(modifiedHeap);
		
	}

	public void copyHeap() {
		Graph heap = fileManager.getHeap();
		int lastInvestigated = 0;
		int end = 0;
		for (String id : fileManager.getRoots())
		{
			Node node = heap.getNode(id);
			end = addToHeap(node,end);
		}
		while (lastInvestigated != end) {
			Node current = newHeap.get(lastInvestigated);
			for(Node node : current.getNextNodes() ) 
			{
				end = addToHeap(node,end);
			}
			lastInvestigated++;
		}	
	}
	
	private int addToHeap(Node node,int end) {
		if(!node.isVisited())
		{
			newHeap.add(node);
			newIds.add(node.getId());
			end++;
			node.setVisited(true);
		}
		return end;
	}
	
}
