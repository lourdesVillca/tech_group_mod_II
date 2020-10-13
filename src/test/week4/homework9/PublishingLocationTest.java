package week4.homework9;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class PublishingLocationTest
{
    Class<?> c;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.c = Class.forName("week4.homework9.PublishingLocation");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class PublishingLocation does not exist");
        }
    }
    
    @Test
    public void testSuperClass() {
        if (!MasterTester9.hasSuperClass(this.c, "Object")) {
            Assert.fail("PublishingLocation should not extend anything");
        }
    }
    
    @Test
    public void testAbstract() {
        if (MasterTester9.isAbstract(this.c)) {
            Assert.fail("PublishingLocation should not be abstract");
        }
    }
    
    @Test
    public void testNumFields() {
        if (!MasterTester9.hasNumFields(this.c, 3)) {
            Assert.fail("PublishingLocation should have 3 fields");
        }
    }
    
    @Test
    public void testCityField() {
        if (!MasterTester9.hasPrivateField(this.c, "String", "city")) {
            Assert.fail("PublishingLocation should have a private String field named city");
        }
    }
    
    @Test
    public void testStateField() {
        if (!MasterTester9.hasPrivateField(this.c, "String", "state")) {
            Assert.fail("PublishingLocation should have a private String field named state");
        }
    }
    
    @Test
    public void testPostCodeField() {
        if (!MasterTester9.hasPrivateField(this.c, "String", "postCode")) {
            Assert.fail("PublishingLocation should have a private String field named postCode");
        }
    }
    
    @Test
    public void testGetCityMethod() {
        if (!MasterTester9.hasMethod(this.c, "getCity", null, String.class)) {
            Assert.fail("PublishingLocation should have a getCity method");
        }
    }
    
    @Test
    public void testGetStateMethod() {
        if (!MasterTester9.hasMethod(this.c, "getState", null, String.class)) {
            Assert.fail("PublishingLocation should have a getState method");
        }
    }
    
    @Test
    public void testGetPostCodeMethod() {
        if (!MasterTester9.hasMethod(this.c, "getPostCode", null, String.class)) {
            Assert.fail("PublishingLocation should have a getPostCode method");
        }
    }
}
