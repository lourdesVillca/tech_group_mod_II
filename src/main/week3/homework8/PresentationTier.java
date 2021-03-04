package week3.homework8;
/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.plaf.SpinnerUI;
import java.util.Scanner;
import java.util.Set;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	private Scanner scanner;
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
		scanner = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("1. Filter book by author's title.");
		System.out.println("2. Count number of books in year.");
		System.out.println("3. Exit");
		System.out.print("Select the option that you want: ");
		String input = scanner.nextLine();
		while(!input.equals("3")){
			if (input.equals("1")) {
				showBookTitlesByAuthor();
			} else if(input.equals("2")) {
				showNumberOfBooksInYear();
			}
			System.out.println("Select the option that you want: ");
			input = scanner.nextLine();
		}
	}

	public void showBookTitlesByAuthor(){
		System.out.print("Insert the AUTHOR name: ");
		String author = scanner.nextLine();
		Set<String> books = logicTier.findBookTitlesByAuthor(author);
		for (String book : books) {
			System.out.println(book);
		}
	}

	public void showNumberOfBooksInYear(){
		System.out.print("Insert the YEAR: ");
		int year = scanner.nextInt();
		System.out.printf("Books in year: %d is %d\n", year, logicTier.findNumberOfBooksInYear(year));
	}

}
