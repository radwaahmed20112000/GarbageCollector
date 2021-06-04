public class Application {

//"C:\\Users\\MIS\\Downloads\\Test\\Test1\\heap.csv"
	public static void main(String[] args) {
		
		GarbageCollector copyGc = new CopyGC (args[0],args[1],args[2],args[3]);
		copyGc.runGarbageCollector();
		
		GarbageCollector mark = new MarkandSweep(args[0],args[1],args[2],args[3]);
		mark.runGarbageCollector();
	}


}
