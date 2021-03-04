package week2.homework4;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class DepthTest
{
    protected BinarySearchTree<String> tree;
    
    @Before
    public void setUp() throws Exception {
        (this.tree = (BinarySearchTree<String>)new BinarySearchTree()).add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }
    
    @Test
    public void testNull() {
        try {
            Assert.assertEquals("depth should be -1 when input value is null", -1L, (long)this.tree.depth(null));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is null");
        }
    }
    
    @Test
    public void testNotInTree() {
        try {
            Assert.assertEquals("depth should be -1 when input value is not in tree", -1L, (long)this.tree.depth("banana"));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is not in tree");
        }
    }
    
    @Test
    public void testRoot() {
        try {
            Assert.assertEquals("depth should be 0 when input value is root", 0L, (long)this.tree.depth("dog"));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is root");
        }
    }
    
    @Test
    public void testLeftChildOfRoot() {
        try {
            Assert.assertEquals("depth should be 1 when input value is left child of root", 1L, (long)this.tree.depth("cat"));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is left child of root");
        }
    }
    
    @Test
    public void testRightChildOfRoot() {
        try {
            Assert.assertEquals("depth should be 1 when input value is right child of root", 1L, (long)this.tree.depth("pig"));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is right child of root");
        }
    }
    
    @Test
    public void testGrandchildOfRoot() {
        try {
            this.tree.add("ant");
            Assert.assertEquals("depth should be 2 when input value is grandchild of root", 2L, (long)this.tree.depth("ant"));
        }
        catch (Exception obj) {
            Assert.fail("depth throws " + obj + " when input value is grandchild of root");
        }
    }
}
