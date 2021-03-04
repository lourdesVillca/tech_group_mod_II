package week2.homework4;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class IsBalancedTreeTest
{
    protected BinarySearchTree<String> tree;
    
    @Before
    public void setUp() throws Exception {
        (this.tree = (BinarySearchTree<String>)new BinarySearchTree()).add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }
    
    @Test
    public void testRootAndTwoChildren() {
        try {
            Assert.assertTrue("isBalanced should be true when only nodes are root of tree and its two children", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when only nodes are root of tree and its two children");
        }
    }
    
    @Test
    public void testRootAndTwoChildrenAndOneLeftGrandchild() {
        this.tree.add("ant");
        try {
            Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of root's left and right subtrees is 1");
        }
    }
    
    @Test
    public void testRootAndTwoChildrenAndOneRightGrandchild() {
        this.tree.add("skunk");
        try {
            Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of root's left and right subtrees is 1");
        }
    }
    
    @Test
    public void testRightHeightIsMoreThanOneGreaterThanLeft() {
        this.tree.add("skunk");
        this.tree.add("zebra");
        try {
            Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of root's left and right subtrees is greater than 1");
        }
    }
    
    @Test
    public void testLeftHeightIsMoreThanOneGreaterThanRight() {
        this.tree.add("ant");
        this.tree.add("aah!");
        try {
            Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when difference in heights of root's left and right subtrees is greater than 1");
        }
    }
    
    @Test
    public void testRootIsBalancedButChildrenAreNot() {
        this.tree.add("ant");
        this.tree.add("aah!");
        this.tree.add("skunk");
        this.tree.add("zebra");
        try {
            Assert.assertFalse("isBalanced should be false when root Node is balanced but its children are not", this.tree.isBalanced());
        }
        catch (Exception obj) {
            Assert.fail("isBalanced throws " + obj + " when root Node is balanced but its children are not");
        }
    }
}
