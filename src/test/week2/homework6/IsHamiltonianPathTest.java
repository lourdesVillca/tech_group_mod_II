package week2.homework6;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import java.util.LinkedList;
import java.util.List;

// 
// Decompiled by Procyon v0.5.36
// 

public class IsHamiltonianPathTest
{
    public static final String FILENAME = "./src/test/week2/homework6/is_hamiltonian_path_test.txt";
    
    protected List<String> createValidPath() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("0");
        return list;
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNullGraph() {
        final List<String> validPath = this.createValidPath();
        try {
            Assert.assertFalse("isHamiltonianPath should return false when input Graph is null", GraphUtils.isHamiltonianPath((Graph)null, (List)validPath));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when input Graph is null");
        }
    }
    
    @Test
    public void testNullLinkedList() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is null", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)null));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when input LinkedList is null");
        }
    }
    
    @Test
    public void testEmptyLinkedList() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is empty", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)new LinkedList()));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when input LinkedList is empty");
        }
    }
    
    @Test
    public void testValidUndirected() {
        final List<String> validPath = this.createValidPath();
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)validPath));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid Hamiltonian path in undirected graph");
        }
    }
    
    @Test
    public void testValidDirected() {
        final List<String> validPath = this.createValidPath();
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)validPath));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid Hamiltonian path in directed graph");
        }
    }
    
    @Test
    public void testValidDoesntVisitAllNodesUndirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("2");
        list.add("5");
        list.add("0");
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that does not visit all nodes in undirected graph");
        }
    }
    
    @Test
    public void testValidDoesntVisitAllNodesDirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("2");
        list.add("5");
        list.add("0");
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that does not visit all nodes in directed graph");
        }
    }
    
    @Test
    public void testNotCycleUndirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("3");
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that is not a cycle in undirected graph");
        }
    }
    
    @Test
    public void testNotCycleDirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("3");
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that is not a cycle in directed graph");
        }
    }
    
    @Test
    public void testVisitsNodeMoreThanOnceUndirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("5");
        list.add("3");
        list.add("1");
        list.add("4");
        list.add("5");
        list.add("0");
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that visits a node more than once in undirected graph");
        }
    }
    
    @Test
    public void testVisitsNodeMoreThanOnceDirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("5");
        list.add("3");
        list.add("1");
        list.add("4");
        list.add("5");
        list.add("0");
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a valid path that visits a node more than once in directed graph");
        }
    }
    
    @Test
    public void testUnconnectedNodesUndirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("0");
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in undirected graph", GraphUtils.isHamiltonianPath((Graph)buildUndirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath " + obj + " when list represents a path in which some nodes are not connected in undirected graph");
        }
    }
    
    @Test
    public void testUnconnectedNodesDirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("0");
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in directed graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a path in which some nodes are not connected in directed graph");
        }
    }
    
    @Test
    public void testNotConnectedDirectedButConnectedUndirected() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        list.add("0");
        list.add("5");
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
        }
        try {
            Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph", GraphUtils.isHamiltonianPath((Graph)buildDirectedGraph, (List)list));
        }
        catch (Exception obj) {
            Assert.fail("isHamiltonianPath throws " + obj + " when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph");
        }
    }
}
