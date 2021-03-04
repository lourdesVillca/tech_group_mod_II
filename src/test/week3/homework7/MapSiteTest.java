package week3.homework7;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class MapSiteTest
{
    Class<?> c;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.c = Class.forName("week3.homework7.MapSite");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class MapSite does not exist");
        }
    }
    
    @Test
    public void testSuperClass() {
        if (!MasterTester7.hasSuperClass(this.c, "Object")) {
            Assert.fail("MapSite should not extend anything");
        }
    }
    
    @Test
    public void testAbstract() {
        if (!MasterTester7.isAbstract(this.c)) {
            Assert.fail("MapSite should be abstract class");
        }
    }
    
    @Test
    public void testNumFields() {
        if (!MasterTester7.hasNumFields(this.c, 0)) {
            Assert.fail("MapSite should not have any fields");
        }
    }
    
    @Test
    public void testNumMethods() {
        if (!MasterTester7.hasNumMethods(this.c, 1)) {
            Assert.fail("MapSite should have 1 method");
        }
    }
    
    @Test
    public void testEnterMethod() {
        if (!MasterTester7.hasMethod(this.c, "enter", Void.TYPE, (Class<?>[])new Class[0])) {
            Assert.fail("MapSite should have an \"enter\" method that accepts no parameters and returns void");
        }
    }
}
