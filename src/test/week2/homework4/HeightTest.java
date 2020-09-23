package week2.homework4;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class HeightTest
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
            Assert.assertEquals("height should be -1 when input value is null", -1L, (long)this.tree.height(null));
        }
        catch (Exception obj) {
            Assert.fail("height throws " + obj + " when input value is null");
        }
    }
    
    @Test
    public void testNotInTree() {
        try {
            Assert.assertEquals("height should be -1 when input value is not in tree", -1L, (long)this.tree.height("banana"));
        }
        catch (Exception obj) {
            Assert.fail("height throws " + obj + " when input value is not in tree");
        }
    }
    
    @Test
    public void testLeaf() {
        try {
            Assert.assertEquals("height should be 0 when input value is leaf", 0L, (long)this.tree.height("cat"));
        }
        catch (Exception obj) {
            Assert.fail("height throws " + obj + " when input value is leaf");
        }
    }
    
    @Test
    public void testParentOfLeaves() {
        try {
            Assert.assertEquals("height should be 1 when input value is parent of two leaves", 1L, (long)this.tree.height("dog"));
        }
        catch (Exception obj) {
            Assert.fail("height throws " + obj + " when input value is parent of two leaves");
        }
    }
    
    @Test
    public void testNumerousDescendants() {
        this.tree.add("ant");
        this.tree.add("cow");
        this.tree.add("aah!");
        try {
            Assert.assertTrue("height incorrect when input value has numerous descendants", 3 == this.tree.height("dog"));
        }
        catch (Exception obj) {
            Assert.fail("height throws " + obj + " when input value has numerous descendants");
        }
    }
}
