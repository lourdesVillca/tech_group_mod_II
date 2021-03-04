package week3.homework7;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class MazeGameTest
{
    Class<?> c;
    
    @Before
    public void setUp() throws Exception {
        try {
            this.c = Class.forName("week3.homework7.MazeGame");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("Class MazeGame does not exist");
        }
    }
    
    @Test
    public void testSuperClass() {
        if (!MasterTester7.hasSuperClass(this.c, "Object")) {
            Assert.fail("MazeGame should not extend anything");
        }
    }
    
    @Test
    public void testAbstract() {
        if (MasterTester7.isAbstract(this.c)) {
            Assert.fail("MazeGame should not be abstract");
        }
    }
    
    @Test
    public void testNumFields() {
        if (!MasterTester7.hasNumFields(this.c, 0)) {
            Assert.fail("MazeGame should have 0 fields");
        }
    }
    
    @Test
    public void testNumMethods() {
        if (!MasterTester7.hasNumMethods(this.c, 2)) {
            Assert.fail("MazeGame should have 2 methods");
        }
    }
    
    @Test
    public void testCreateMazeMethod() {
        if (!MasterTester7.hasMethod(this.c, "createMaze", Maze.class, (Class<?>[])new Class[0])) {
            Assert.fail("MazeGame should have a \"createMaze\" method that accepts no parameters and returns a Maze object");
        }
    }
    
    @Test
    public void testLoadMazeMethod() {
        if (!MasterTester7.hasMethod(this.c, "loadMaze", Void.TYPE, (Class<?>[])new Class[0])) {
            Assert.fail("MazeGame should have a \"loadMaze\" method that accepts no parameters and returns void");
        }
    }
}
