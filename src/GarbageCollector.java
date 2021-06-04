import java.util.LinkedList;

public abstract class  GarbageCollector {
	
	FileManager fileManager;

	public GarbageCollector(String heapFile ,String rootFile,String pointersFile, String targetPath) {
		fileManager = new FileManager(heapFile,rootFile,pointersFile,targetPath);
	}
	
	public void runGarbageCollector (){
		fileManager.readHeap();
		fileManager.readRoot();
	
		garbageCollectorTechnique();	
		
		compactMemory();
		fileManager.writeOutput();
	}
	
	public abstract void garbageCollectorTechnique() ;
		
	
	
	
	public void compactMemory() {
		LinkedList<String> ids = fileManager.getHeap().getIds();
		int start = 0;
		for (String id : ids) {
			Node node = fileManager.getHeap().getNode(id);
			node.setStartMemory(start);
			node.setEndMemory(start + node.getLength());
			start = node.getEndMemory() + 1;	
		}
	}
	
}
