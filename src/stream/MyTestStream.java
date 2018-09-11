package stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyTestStream {
	public static void main(String[] args) throws IOException {
		
	    List<String> list = readFile();
	    Map<String,List<String>> map = initializeMap(list);
	    List<String> result = getListOfFirstLetter(map,"d");
	    printList(result);
	}
	private static List<String> readFile() throws IOException{
	    String fileName = "animal.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))){
			return stream.collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	private static Map<String, List<String>> initializeMap(List<String> list) {
	    return list.stream()
	    .filter(s->!s.trim().isEmpty())
	    .collect(Collectors.groupingBy(s->Character.toString(s.charAt(0))));
	}
	private static List<String> getListOfFirstLetter(Map map, String letter) {
		return (List<String>)map.get(letter);
	 
	}
	private static void printList (List<String> list) {
		list.forEach(System.out::println);
	}
}
