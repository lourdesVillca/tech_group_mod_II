package week3.homework8;
/*
 * SD2x Homework #8
 * This class creates the classes in the three tiers and links them together.
 * You should not modify this code. You do not need to submit it.
 */

public class Main {
	
	public static void main(String[] args) {
		
		DataTier dt = new DataTier("./src/test/week3/homework8/books.txt");
		LogicTier lt = new LogicTier(dt);
		PresentationTier pt = new PresentationTier(lt);
		pt.start();
		
	}

}
