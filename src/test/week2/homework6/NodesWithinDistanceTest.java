package week2.homework6;
import java.util.Set;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class NodesWithinDistanceTest
{
    public static final String FILENAME = "./src/test/week2/homework6/graph_builder_test.txt";
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNullGraph() {
        try {
            Assert.assertNull("nodesWithinDistance should return null when input Graph is null", (Object)GraphUtils.nodesWithinDistance((Graph)null, "0", 3));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when input Graph is null");
        }
    }
    
    @Test
    public void testNullSrc() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertNull("nodesWithinDistance should return null when input src is null", (Object)GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, (String)null, 3));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when input src is null");
        }
    }
    
    @Test
    public void testSrcNotInGraph() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertNull("nodesWithinDistance should return null when input src is not in graph", (Object)GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "banana", 3));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when input src is not in graph");
        }
    }
    
    @Test
    public void testNegativeDistance() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertNull("nodesWithinDistance should return null when distance is negative", (Object)GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "0", -1));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance is negative");
        }
    }
    
    @Test
    public void testZeroDistance() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertNull("nodesWithinDistance should return null when distance is zero", (Object)GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "0", 0));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance is zero");
        }
    }
    
    @Test
    public void testOnlyNodeInGraph() {
        final UndirectedGraph undirectedGraph = new UndirectedGraph();
        ((Graph)undirectedGraph).addNode(new Node("lonely"));
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)undirectedGraph, "lonely", 2);
            Assert.assertNotNull("nodesWithinDistance returns null when specified node is only node in graph and distance >= 1", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance should return empty Set when specified node is only node in graph and distance >= 1", nodesWithinDistance.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when specified node is only node in graph and distance >= 1");
        }
    }
    
    @Test
    public void testDistance1Undirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "0", 1);
            Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in undirected graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in undirected graph", nodesWithinDistance.size() == 4);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("1"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("2"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("3"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", nodesWithinDistance.contains("5"));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance = 1 in undirected graph");
        }
    }
    
    @Test
    public void testDistance1Directed() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildDirectedGraph, "1", 1);
            Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in directed graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in directed graph", nodesWithinDistance.size() == 2);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", nodesWithinDistance.contains("2"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", nodesWithinDistance.contains("5"));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance = 1 in directed graph");
        }
    }
    
    @Test
    public void testDistanceGreaterThan1Undirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildUndirectedGraph, "0", 3);
            Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in undirected graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in undirected graph", nodesWithinDistance.size() == 6);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("1"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("2"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("3"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("4"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("5"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", nodesWithinDistance.contains("6"));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance > 1 in undirected graph");
        }
    }
    
    @Test
    public void testDistanceGreaterThan1Directed() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            final Set nodesWithinDistance = GraphUtils.nodesWithinDistance((Graph)buildDirectedGraph, "2", 2);
            Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in directed graph", (Object)nodesWithinDistance);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in directed graph", nodesWithinDistance.size() == 3);
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", nodesWithinDistance.contains("4"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", nodesWithinDistance.contains("5"));
            Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", nodesWithinDistance.contains("6"));
        }
        catch (Exception obj) {
            Assert.fail("nodesWithinDistance throws " + obj + " when distance > 1 in directed graph");
        }
    }
}
