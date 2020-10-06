package week3.homework8;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class MethodsTest
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
    
    @Test
    public void testFindBookTitlesByAuthorClass() {
        if (!MasterTester8.hasMethod(this.logicTierClass, "findBookTitlesByAuthor")) {
            Assert.fail("findBookTitlesByAuthor method is not implemented in correct class");
        }
        else if (MasterTester8.hasMethod(this.dataTierClass, "findBookTitlesByAuthor")) {
            Assert.fail("findBookTitlesByAuthor method is implemented in incorrect class");
        }
        else if (MasterTester8.hasMethod(this.presentationTierClass, "findBookTitlesByAuthor")) {
            Assert.fail("findBookTitlesByAuthor method is implemented in incorrect class");
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
    public void testFindBookTitlesByAuthorReturnType() {
        final Class<?> determineClassForMethod = this.determineClassForMethod("findBookTitlesByAuthor");
        if (determineClassForMethod == null) {
            Assert.fail("No class implements findBookTitlesByAuthor.");
        }
        for (final Method method : determineClassForMethod.getDeclaredMethods()) {
            if (method.getName().equals("findBookTitlesByAuthor")) {
                if (method.getGenericReturnType() instanceof ParameterizedType) {
                    if (!((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0].getTypeName().equals("java.lang.String")) {
                        Assert.fail("findBookTitlesByAuthor returns Collection of incorrect type");
                    }
                }
                else if (!method.getReturnType().getName().equals("[Ljava.lang.String;")) {
                    Assert.fail("findBookTitlesByAuthor should return Collection or array of correct type");
                }
            }
        }
    }
    
    @Test
    public void testGetAllBooksReturnType() {
        final Class<?> determineClassForMethod = this.determineClassForMethod("getAllBooks");
        if (determineClassForMethod == null) {
            Assert.fail("No class implements getAllBooks.");
        }
        for (final Method method : determineClassForMethod.getDeclaredMethods()) {
            if (method.getName().equals("getAllBooks")) {
                if (method.getGenericReturnType() instanceof ParameterizedType) {
                    final String name = method.getReturnType().getName();
                    if (!name.equals("java.util.List") && !name.equals("java.util.Set") && !name.equals("java.util.Collection")) {
                        Assert.fail("getAllBooks should return generic List, Set, or Collection");
                    }
                    if (!((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0].getTypeName().equals("week3.homework8.Book")) {
                        Assert.fail("getAllBooks returns Collection of incorrect type");
                    }
                }
                else if (!method.getReturnType().getName().equals("[LBook;")) {
                    Assert.fail("getAllBooks should return Collection or array of correct type");
                }
            }
        }
    }
    
    @Test
    public void testFindNumberOfBooksInYearClass() {
        if (!MasterTester8.hasMethod(this.logicTierClass, "findNumberOfBooksInYear")) {
            Assert.fail("findNumberOfBooksInYear method is not implemented in correct class");
        }
        else if (MasterTester8.hasMethod(this.dataTierClass, "findNumberOfBooksInYear")) {
            Assert.fail("findNumberOfBooksInYear method is implemented in incorrect class");
        }
        else if (MasterTester8.hasMethod(this.presentationTierClass, "findNumberOfBooksInYear")) {
            Assert.fail("findNumberOfBooksInYear method is implemented in incorrect class");
        }
    }
    
    @Test
    public void testGetAllBooksClass() {
        if (!MasterTester8.hasMethod(this.dataTierClass, "getAllBooks")) {
            Assert.fail("getAllBooks method is not implemented in correct class");
        }
        else if (MasterTester8.hasMethod(this.logicTierClass, "getAllBooks")) {
            Assert.fail("getAllBooks method is implemented in incorrect class");
        }
        else if (MasterTester8.hasMethod(this.presentationTierClass, "getAllBooks")) {
            Assert.fail("getAllBooks method is implemented in incorrect class");
        }
    }
    
    @Test
    public void testShowBookTitlesByAuthorClass() {
        if (!MasterTester8.hasMethod(this.presentationTierClass, "showBookTitlesByAuthor")) {
            Assert.fail("showBookTitlesByAuthor method is not implemented in correct class");
        }
        else if (MasterTester8.hasMethod(this.logicTierClass, "showBookTitlesByAuthor")) {
            Assert.fail("showBookTitlesByAuthor method is implemented in incorrect class");
        }
        else if (MasterTester8.hasMethod(this.dataTierClass, "showBookTitlesByAuthor")) {
            Assert.fail("showBookTitlesByAuthor method is implemented in incorrect class");
        }
    }
    
    @Test
    public void testShowNumberOfBooksInYearClass() {
        if (!MasterTester8.hasMethod(this.presentationTierClass, "showNumberOfBooksInYear")) {
            Assert.fail("showNumberOfBooksInYear method is not implemented in correct class");
        }
        else if (MasterTester8.hasMethod(this.logicTierClass, "showNumberOfBooksInYear")) {
            Assert.fail("showNumberOfBooksInYear method is implemented in incorrect class");
        }
        else if (MasterTester8.hasMethod(this.dataTierClass, "showNumberOfBooksInYear")) {
            Assert.fail("showNumberOfBooksInYear method is implemented in incorrect class");
        }
    }
}
