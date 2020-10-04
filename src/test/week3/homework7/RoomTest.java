package week3.homework7;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class RoomTest
{
    Class<?> c;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.c = Class.forName("week3.homework7.Room");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class Room does not exist");
        }
    }
    
    @Test
    public void testSuperClass() {
        if (!MasterTester7.hasSuperClass(this.c, "MapSite")) {
            Assert.fail("Room should extend MapSite");
        }
    }
    
    @Test
    public void testAbstract() {
        if (MasterTester7.isAbstract(this.c)) {
            Assert.fail("Room should not be abstract");
        }
    }
    
    @Test
    public void testNumFields() {
        if (!MasterTester7.hasNumFields(this.c, 3)) {
            Assert.fail("Room should have 3 fields");
        }
    }
    
    @Test
    public void testRoomNumberField() {
        if (!MasterTester7.hasPublicField(this.c, "int", "roomNumber")) {
            Assert.fail("Room should have public field of type int called roomNumber");
        }
    }
    
    @Test
    public void testSidesField() {
        if (!MasterTester7.hasPublicField(this.c, "Wall[]", "sides")) {
            Assert.fail("Room should have public field of type Wall[] called sides");
        }
    }
    
    @Test
    public void testMapSitesField() {
        if (!MasterTester7.hasPublicField(this.c, "MapSite[]", "mapsites")) {
            Assert.fail("Room should have public field of type MapSite[] called mapsites");
        }
    }
    
    @Test
    public void testNumMethods() {
        if (!MasterTester7.hasNumMethods(this.c, 2)) {
            Assert.fail("Room should have 2 methods");
        }
    }
    
    @Test
    public void testGetSideMethod() {
        if (!MasterTester7.hasMethod(this.c, "getSide", Wall.class, Integer.TYPE)) {
            Assert.fail("Room should have a \"getSide\" method that accepts an int parameter and returns a Wall object");
        }
    }
    
    @Test
    public void testSetSideMethod() {
        final Class[] array = { Integer.TYPE, Wall.class };
        MasterTester7.hasMethod(this.c, "setSide", Void.TYPE, (Class<?>[])array);
        if (!MasterTester7.hasMethod(this.c, "setSide", Void.TYPE, (Class<?>[])array)) {
            Assert.fail("Room should have a \"setSide\" method that accepts int and Wall parameters and returns void");
        }
    }
}
