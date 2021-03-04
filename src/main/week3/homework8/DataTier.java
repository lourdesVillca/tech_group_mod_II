package week3.homework8;
/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}

	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(line -> {
				String[] processedLine = line.split("\t");
				String title= processedLine[0];
				String author = processedLine[1];
				int year = Integer.parseInt(processedLine[2]);
				books.add(new Book(title, author, year));

			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return books;
	}

}
