package week3.homework8;
/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicTier {

    private DataTier dataTier; // link to the Data Tier

    public LogicTier(DataTier dataTier) {
        this.dataTier = dataTier;
    }

    public Set<String> findBookTitlesByAuthor(String name) {
        List<Book> books = dataTier.getAllBooks();
        return books.stream().
                filter(b -> b.getAuthor().toLowerCase().contains(name.toLowerCase())).
                map(Book::getTitle).
                collect(Collectors.toSet());
    }

    public int findNumberOfBooksInYear(int year) {
        List<Book> books = dataTier.getAllBooks();
        return  (int)books.stream().filter(b -> b.getPublicationYear() == year).count();
    }
}
