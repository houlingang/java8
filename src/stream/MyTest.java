package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyTest {
	public static void main(String[] args) throws IOException {
		
	    List<String> list = new ArrayList<>();
	    readFile(list);
	    Map<String,List<String>> map = new HashMap<String,List<String>>();
	    initializeMap(map, list);
	    ArrayList result = getListOfFirstLetter(map,"d");
	    printList(result);
	}
	private static void readFile(List list) throws IOException{
	    File file = new File("animal.txt");

	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
		    while ((st = br.readLine()) != null) {
		      list.add(st);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void initializeMap(Map<String, List<String>> map, List<String> list) {
	    for (String s : list) {
	    	String firstLetter = s.substring(0,1);
	    	if (map.get(s.substring(1))!=null){
	    		List subList = map.get(firstLetter);
	    		subList.add(s);
	    		//map.put(firstLetter,subList);
	    	}else {
	    		List subList = new ArrayList();
	    		subList.add(s);
	    		map.put(firstLetter,subList);
	    	}
	    }
	}
	private static ArrayList getListOfFirstLetter(Map map, String letter) {
		return (ArrayList)map.get(letter);
	 
	}
	private static void printList (ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
