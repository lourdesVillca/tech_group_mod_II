package week2.homework4;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class FindNodeTest
{
    protected BinarySearchTree<String> tree;
    
    @Before
    public void setUp() throws Exception {
        (this.tree = (BinarySearchTree<String>)new BinarySearchTree()).add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }
    
    @Test
    public void testTargetIsRoot() {
        try {
            final BinarySearchTree.Node node = this.tree.findNode("dog");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is root", (Object)"dog", (Object)node.value);
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is root");
        }
    }
    
    @Test
    public void testTargetIsLeftChildOfRoot() {
        try {
            final BinarySearchTree.Node node = this.tree.findNode("cat");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is left child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is left child of root", (Object)"cat", (Object)node.value);
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is left child of root");
        }
    }
    
    @Test
    public void testTargetIsRightChildOfRoot() {
        try {
            final BinarySearchTree.Node node = this.tree.findNode("pig");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is right child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is right child of root", (Object)"pig", (Object)node.value);
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is right child of root");
        }
    }
    
    @Test
    public void testTargetIsGrandchildOfRoot() {
        this.tree.add("ant");
        try {
            final BinarySearchTree.Node node = this.tree.findNode("ant");
            if (node == null) {
                Assert.fail("findNode returned null when looking for value that is grandchild of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is grandchild of root", (Object)"ant", (Object)node.value);
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is grandchild of root");
        }
    }
    
    @Test
    public void testTargetIsNotInTree() {
        try {
            Assert.assertNull("findNode did not return null when looking for value that is not in tree", (Object)this.tree.findNode("monkey"));
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when looking for value that is not in tree");
        }
    }
    
    @Test
    public void testTargetIsNull() {
        try {
            Assert.assertNull("findNode did not return null when input value is null", (Object)this.tree.findNode(null));
        }
        catch (Exception obj) {
            Assert.fail("findNode throws " + obj + " when input value is null");
        }
    }
}
