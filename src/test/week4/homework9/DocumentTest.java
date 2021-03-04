package week4.homework9;
import java.util.Set;
import java.util.Date;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class DocumentTest
{
    Class<?> c;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.c = Class.forName("week4.homework9.Document");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class Document does not exist");
        }
    }
    
    @Test
    public void testSuperClass() {
        if (!MasterTester9.hasSuperClass(this.c, "Object")) {
            Assert.fail("Document should have no superclass");
        }
    }
    
    @Test
    public void isAbstract() {
        if (!MasterTester9.isAbstract(this.c)) {
            Assert.fail("Document should be abstract class");
        }
    }
    
    @Test
    public void testNumFields() {
        if (!MasterTester9.hasNumFields(this.c, 4)) {
            Assert.fail("Document should have 4 fields");
        }
    }
    
    @Test
    public void testTitleField() {
        if (!MasterTester9.hasPrivateField(this.c, "String", "title")) {
            Assert.fail("Document should have private String field named title");
        }
    }
    
    @Test
    public void testAuthorField() {
        if (!MasterTester9.hasPrivateField(this.c, "String", "author")) {
            Assert.fail("Document should have private String field named author");
        }
    }
    
    @Test
    public void testSameAuthorMethod() {
        if (!MasterTester9.hasMethod(this.c, "sameAuthor", Document.class, Boolean.TYPE)) {
            Assert.fail("Document should have method called sameAuthor");
        }
    }
    
    @Test
    public void testPublishingLocationFieldType() {
        if (!MasterTester9.hasFieldType(this.c, "PublishingLocation")) {
            Assert.fail("Document should have a field of type PublishingLocation");
        }
    }
    
    @Test
    public void testDateField() {
        if (!MasterTester9.hasPrivateField(this.c, "Date", "date")) {
            Assert.fail("Document should have a private Date field named date");
        }
    }
    
    @Test
    public void testCompareDatesMethod() {
        if (!MasterTester9.hasMethod(this.c, "compareDates", Document.class, Integer.TYPE)) {
            Assert.fail("Document should have method called compareDates with Document parameter that returns int");
        }
    }
    
    @Test
    public void testCompareWithGeneralDateMethod() {
        if (!MasterTester9.hasMethod(this.c, "compareWithGeneralDate", Date.class, Integer.TYPE)) {
            Assert.fail("Document should have method called compareWithGeneralDate with Date parameter that returns int");
        }
    }
    
    @Test
    public void testGetTitleMethod() {
        if (!MasterTester9.hasMethod(this.c, "getTitle", null, String.class)) {
            Assert.fail("Document should have getTitle method");
        }
    }
    
    @Test
    public void testGetAuthorMethod() {
        if (!MasterTester9.hasMethod(this.c, "getAuthor", null, String.class)) {
            Assert.fail("Document should have getAuthor method");
        }
    }
    
    @Test
    public void testGetDateMethod() {
        if (!MasterTester9.hasMethod(this.c, "getDate", null, Date.class)) {
            Assert.fail("Document should have getDate method");
        }
    }
    
    @Test
    public void testGetStartPageMethod() {
        if (MasterTester9.hasMethod(this.c, "getStartPage", null, Integer.TYPE)) {
            Assert.fail("Document should not have getStartPage method");
        }
    }
    
    @Test
    public void testGetEndPageMethod() {
        if (MasterTester9.hasMethod(this.c, "getEndPage", null, Integer.TYPE)) {
            Assert.fail("Document should not have getEndPage method");
        }
    }
    
    @Test
    public void testGetEditorsMethod() {
        if (MasterTester9.hasMethod(this.c, "getEditors", null, Set.class)) {
            Assert.fail("Document should not have getEditors method");
        }
    }
}
