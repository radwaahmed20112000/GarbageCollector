import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//read from the csv file and create the graph
//read from file roots ids , linkedlist of strings
//read from file heap , create original graph ,
//read from file pointers , get node from hash graph and add its new child ,

public class GarbageCollector {
	Graph graph ;
	LinkedList <String> roots;
	MarkandSweep markandSweep;
	//Copy instance

	public GarbageCollector() {
		this.graph =  new Graph();
		this.roots =  new LinkedList<>();
	}

	public void markAndSweep (){
		readGraph();
		markandSweep = new MarkandSweep(roots,graph);
	}
	public void readRoot()  {


	}

	public void readGraph() {
		BufferedReader csvReader;
		String row;
		try {
			csvReader = new BufferedReader(new FileReader("/home/user/Documents/sample test/heap.csv"));
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				graph.addNode(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			}
			csvReader.close();
			int j = 0;
			System.out.println(graph.getGraph());
			csvReader = new BufferedReader(new FileReader("/home/user/Documents/sample test/pointers.csv"));
			while ((row = csvReader.readLine()) != null) {
				//delete
				if(j == 0)
					row = row.substring(1);
				//delete 
				String[] data = row.split(",");
				graph.addEdge(data[0],data[1]);
				j++;
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		graph.addNode(2,0,4);
//		graph.addNode(4,0,4);
//		graph.addNode(7,0,4);
//		graph.addNode(5,0,4);
//		graph.addNode(3,0,4);
//		graph.addNode(6,0,4);
//		graph.addNode(1,0,4);
//
//
//		graph.addEdge(2, 4);
//		graph.addEdge(4, 7);
//		graph.addEdge(5, 3);
//		graph.addEdge(6, 1);
//		graph.addEdge(6, 7);
	}
	public void setRoots(LinkedList<String> roots) {
		this.roots = roots;
	}

	public LinkedList<String> getRoots() {
		return roots;
	}

	public Graph getGraph() {
		return graph;
	}
	
}
