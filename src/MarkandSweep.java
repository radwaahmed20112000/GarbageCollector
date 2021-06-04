import java.util.*;

public class MarkandSweep extends GarbageCollector {
	
	
	public MarkandSweep(String heapFile, String rootFile, String pointersFile, String targetPath) {
		super(heapFile, rootFile, pointersFile, targetPath);
	}
	

	@Override
	public void garbageCollectorTechnique() {
		dfs();
		
	}
    

	public void dfs() {
		
		for (String id : fileManager.getRoots()) {	
			Node node = fileManager.getHeap().getNode(id);
			mark(node);
		}
		sweep();
	}

    private void mark(Node node) {
    	
    	node.setVisited(true);
    	LinkedList<Node> currentNodeChildren = node.getNextNodes();
    	for(Node child : currentNodeChildren) {
    		if (!child.isVisited()) {
    		mark(child);}
    	}
    }
    public void sweep () {
    	Graph heap = fileManager.getHeap();
    	for (int i = 0 ; i < heap.getGraph().size() ; i++ ) 
    	{
    		if(!heap.getGraph().get(heap.getIds().get(i)).isVisited())
    		{
    			heap.removeNode(heap.getGraph().get(heap.getIds().get(i)));
  
				i--;
			}
    	}
    }

    
}
