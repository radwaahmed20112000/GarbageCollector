import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileManager {
	Graph heap ;
	LinkedList <String> roots;
	String heapFile, rootFile, pointersFile, targetPath	;
	
	public FileManager(String heapFile, String rootFile, String pointersFile, String targetPath) {
		this.heap =  new Graph();
		this.roots =  new LinkedList<>();
		this.heapFile = heapFile;
		this.pointersFile = pointersFile;
		this.rootFile = rootFile;
		this.targetPath = targetPath;		
	}

	
	public void readRoot()  {

		File file = new File(rootFile);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			 String st;
			  while ((st = br.readLine()) != null) {
				  roots.add(st);
			  }
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
	}

	public void readHeap() {
		BufferedReader csvReader;
		String row;
		try {
			csvReader = new BufferedReader(new FileReader(this.heapFile));
			while ((row = csvReader.readLine()) != null) {
				row = row.replaceAll("\\p{C}", "");
				String[] data = row.split(",");
				heap.addNode(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
			}
			csvReader.close();
			csvReader = new BufferedReader(new FileReader(this.pointersFile));
			while ((row = csvReader.readLine()) != null) {
				row = row.replaceAll("\\p{C}", "");				
				String[] data = row.split(",");
				heap.addEdge(data[0],data[1]);
				
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void writeOutput() {
		try {
			FileWriter csvWriter = new FileWriter(targetPath);
			
			
			
			for (String id : heap.getIds()) {
				Node node = heap.getNode(id);
				
				
			    csvWriter.append(node.getId());
			    csvWriter.append(",");
			    csvWriter.append(Integer.toString(node.getStartMemory()));
			    csvWriter.append(",");
			    csvWriter.append(Integer.toString(node.getEndMemory()));
			    csvWriter.append("\n");
			}

			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setRoots(LinkedList<String> roots) {
		this.roots = roots;
	}

	public LinkedList<String> getRoots() {
		return roots;
	}

	public Graph getHeap() {
		return heap;
	}


	public void setHeap(Graph heap) {
		this.heap = heap;
	}
}
