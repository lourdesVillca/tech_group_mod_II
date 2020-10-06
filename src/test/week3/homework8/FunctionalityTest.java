package week3.homework8;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.io.File;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class FunctionalityTest
{
    protected Class<?> dataTierClass;
    protected Class<?> logicTierClass;
    protected Class<?> presentationTierClass;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.dataTierClass = Class.forName("week3.homework8.DataTier");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class DataTier does not exist");
        }
        try {
            this.logicTierClass = Class.forName("week3.homework8.LogicTier");
        }
        catch (ClassNotFoundException ex2) {
            throw new Exception("Class LogicTier does not exist");
        }
        try {
            this.presentationTierClass = Class.forName("week3.homework8.PresentationTier");
        }
        catch (ClassNotFoundException ex3) {
            throw new Exception("Class PresentationTier does not exist");
        }
    }
    
    protected Class<?> determineClassForMethod(final String s) {
        Class<?> clazz = null;
        if (MasterTester8.hasMethod(this.dataTierClass, s)) {
            clazz = this.dataTierClass;
        }
        else if (MasterTester8.hasMethod(this.logicTierClass, s)) {
            clazz = this.logicTierClass;
        }
        else if (MasterTester8.hasMethod(this.presentationTierClass, s)) {
            clazz = this.presentationTierClass;
        }
        return clazz;
    }
    
    @Test
    public void testGetAllBooks() {
        final Class<?> determineClassForMethod = this.determineClassForMethod("getAllBooks");
        if (determineClassForMethod != this.dataTierClass) {
            Assert.fail("Could not determine the correctness of getAllBooks: it is not implemented in the correct class");
        }
        if (!new File("./src/test/week3/homework8/test.txt").exists()) {
            Assert.fail("Could not determine correctness of getAllBooks: please be sure that test.txt is in the project root directory or the directory where you started Java.");
        }
        try {
            final Object instance = determineClassForMethod.getConstructor(String.class).newInstance("./src/test/week3/homework8/test.txt");
            for (final Method method : determineClassForMethod.getDeclaredMethods()) {
                if (method.getName().equals("getAllBooks")) {
                    Collection<Book> collection = null;
                    String s = "Collection";
                    if (Collection.class.isAssignableFrom(method.getReturnType())) {
                        if (!((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0].getTypeName().equals("week3.homework8.Book")) {
                            Assert.fail("Could not determine the correctness of getAllBooks: it returns a Collection of the incorrect type");
                        }
                        collection = (Collection<Book>)method.invoke(instance, new Object[0]);
                        if (collection == null) {
                            Assert.fail("Collection returned by getAllBooks is null.");
                        }
                    }
                    else if (method.getReturnType().getName().equals("[LBook;")) {
                        final Book[] array = (Book[])method.invoke(instance, new Object[0]);
                        if (array == null) {
                            Assert.fail("Array returned by getAllBooks is null.");
                        }
                        collection = new LinkedList<Book>();
                        final Book[] array2 = array;
                        for (int length2 = array2.length, j = 0; j < length2; ++j) {
                            collection.add(array2[j]);
                        }
                        s = "Array";
                    }
                    else {
                        Assert.fail("Could not determine the correctness of getAllBooks: it should return a Collection or an array");
                    }
                    final Book book = new Book("title1", "author1", 1);
                    final Book book2 = new Book("title2", "author2", 2);
                    final Book book3 = new Book("title 3", "author 3", 3);
                    Assert.assertNotNull("getAllBooks returns null for valid input", (Object)collection);
                    Assert.assertTrue(s + " returned by getAllBooks contains incorrect number of Books", collection.size() == 3);
                    Assert.assertTrue(s + " returned by getAllBooks does not contain correct Book objects", collection.contains(book));
                    Assert.assertTrue(s + " returned by getAllBooks does not contain correct Book objects", collection.contains(book2));
                    Assert.assertTrue(s + " returned by getAllBooks does not contain correct Book objects", collection.contains(book3));
                }
            }
        }
        catch (Exception obj) {
            obj.printStackTrace();
            Assert.fail("An error occurred in trying to test the correctness of getAllBooks: " + obj);
        }
    }
    
    protected static boolean isNumericType(final Class<?> clazz) {
        if (Number.class.isAssignableFrom(clazz)) {
            return true;
        }
        final String name = clazz.getName();
        return name.equals("int") || name.equals("long") || name.equals("short") || name.equals("double") || name.equals("float");
    }
    
    @Test
    public void testFindNumberOfBooksInYear() {
        final Class<?> determineClassForMethod = this.determineClassForMethod("findNumberOfBooksInYear");
        if (determineClassForMethod != this.logicTierClass) {
            Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it is not implemented in the correct class");
        }
        if (!new File("./src/test/week3/homework8/books.txt").exists()) {
            Assert.fail("Could not determine correctness of findNumberOfBooksInYear: please be sure that books.txt is in the project root directory or the directory where you started Java.");
        }
        try {
            final Object instance = determineClassForMethod.getConstructor(DataTier.class).newInstance(new DataTier("./src/test/week3/homework8/books.txt"));
            for (final Method method : determineClassForMethod.getDeclaredMethods()) {
                if (method.getName().equals("findNumberOfBooksInYear")) {
                    Object o = null;
                    final Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 0) {
                        Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it should take a numeric parameter");
                    }
                    if (isNumericType(parameterTypes[0])) {
                        o = new Integer(1999);
                    }
                    else if (parameterTypes[0].getName().equals("java.lang.String")) {
                        o = "1999";
                    }
                    else {
                        Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it should take a numeric parameter");
                    }
                    if (isNumericType(method.getReturnType())) {
                        Assert.assertTrue("findNumberOfBooksInYear returns incorrect value when using books.txt as input file", ((Number)method.invoke(instance, o)).intValue() == 3);
                    }
                    else {
                        Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: its return type should be numeric");
                    }
                }
            }
        }
        catch (Exception obj) {
            Assert.fail("An error occurred in trying to test the correctness of findNumberOfBooksInYear: " + obj);
        }
    }
    
    @Test
    public void testFindBookTitlesByAuthor() {
        final Class<?> determineClassForMethod = this.determineClassForMethod("findBookTitlesByAuthor");
        if (determineClassForMethod != this.logicTierClass) {
            Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it is not implemented in the correct class");
        }
        if (!new File("./src/test/week3/homework8/books.txt").exists()) {
            Assert.fail("Could not determine correctness of findBookTitlesByAuthor: please be sure that books.txt is in the project root directory or the directory where you started Java.");
        }
        try {
            final Object instance = determineClassForMethod.getConstructor(DataTier.class).newInstance(new DataTier("./src/test/week3/homework8/books.txt"));
            for (final Method method : determineClassForMethod.getDeclaredMethods()) {
                if (method.getName().equals("findBookTitlesByAuthor")) {
                    Collection<String> collection = null;
                    String str = "Collection";
                    if (Collection.class.isAssignableFrom(method.getReturnType())) {
                        if (!((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0].getTypeName().equals("java.lang.String")) {
                            Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it returns a Collection of the incorrect type");
                        }
                        collection = (Collection<String>)method.invoke(instance, "Fielding");
                        if (collection == null) {
                            Assert.fail("Collection returned by findBookTitlesByAuthor is null");
                        }
                    }
                    else if (method.getReturnType().getName().equals("[Ljava.lang.String;")) {
                        final String[] array = (String[])method.invoke(instance, "Fielding");
                        if (array == null) {
                            Assert.fail("Array returned by findBookTitlesByAuthor is null");
                        }
                        collection = new LinkedList<String>();
                        final String[] array2 = array;
                        for (int length2 = array2.length, j = 0; j < length2; ++j) {
                            collection.add(array2[j]);
                        }
                        str = "Array";
                    }
                    else {
                        Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it should return a Collection or an array");
                    }
                    Assert.assertTrue(str + " returned by findBookTitlesByAuthor contains incorrect number of book titles", collection.size() == 2);
                    Assert.assertTrue(str + " returned by findBookTitlesByAuthor does not contain correct book titles", collection.contains("Bridget Jones: The Edge of Reason"));
                    Assert.assertTrue(str + " returned by findBookTitlesByAuthor does not contain correct book titles", collection.contains("Bridget Jones's Diary:A Novel"));
                }
            }
        }
        catch (Exception obj) {
            Assert.fail("An error occurred in trying to test the correctness of findBookTitlesByAuthor: " + obj);
        }
    }
}
