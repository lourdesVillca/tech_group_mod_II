package week2.homework6;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class MinDistanceTest
{
    public static final String FILENAME = "./src/test/week2/homework6/graph_builder_test.txt";
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNullGraph() {
        try {
            Assert.assertTrue("minDistance should return -1 when input Graph is null", GraphUtils.minDistance((Graph)null, "src", "dest") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when input Graph is null");
        }
    }
    
    @Test
    public void testNullSrc() {
        final UndirectedGraph undirectedGraph = new UndirectedGraph();
        try {
            Assert.assertTrue("minDistance should return -1 when input src is null", GraphUtils.minDistance((Graph)undirectedGraph, (String)null, "dest") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when input src is null");
        }
    }
    
    @Test
    public void testNullDest() {
        final UndirectedGraph undirectedGraph = new UndirectedGraph();
        try {
            Assert.assertTrue("minDistance should return -1 when input dest is null", GraphUtils.minDistance((Graph)undirectedGraph, "src", (String)null) == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when input dest is null");
        }
    }
    
    @Test
    public void testSrcNotInGraph() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance should return -1 when input src is not in graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "BAD", "3") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when input src is not in graph");
        }
    }
    
    @Test
    public void testDestNotInGraph() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance should return -1 when input dest is not in graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "2", "BAD") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when input dest is not in graph");
        }
    }
    
    @Test
    public void testSrcDestSame() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance should return 0 when src and dest are the same", GraphUtils.minDistance((Graph)buildUndirectedGraph, "0", "0") == 0);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are the same");
        }
    }
    
    @Test
    public void testSrcDestConnectedUndirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance should return 1 when src and dest are connected by a single edge in an undirected graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "1", "2") == 1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are connected by a single edge in an undirected graph");
        }
    }
    
    @Test
    public void testSrcDestConnectedDirected() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance should return 1 when src and dest are connected by a single edge in a directed graph", GraphUtils.minDistance((Graph)buildDirectedGraph, "1", "2") == 1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are connected by a single edge in a directed graph");
        }
    }
    
    @Test
    public void testSrcDestMultipleEdgesUndirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance returns incorrect output when src and dest are connected via multiple edges in an undirected graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "0", "6") == 3);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are connected via multiple edges in an undirected graph");
        }
    }
    
    @Test
    public void testSrcDestMultipleEdgesDirected() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance returns incorrect output when src and dest are connected via multiple edges in a directed graph", GraphUtils.minDistance((Graph)buildDirectedGraph, "0", "6") == 3);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are connected via multiple edges in a directed graph");
        }
    }
    
    @Test
    public void testSrcDestNotConnectedUndirected() {
        final UndirectedGraph buildUndirectedGraph = GraphBuilder.buildUndirectedGraph(FILENAME);
        if (buildUndirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in an undirected graph", GraphUtils.minDistance((Graph)buildUndirectedGraph, "0", "8") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are not connected in an undirected graph");
        }
    }
    
    @Test
    public void testSrcDestNotConnectedDirected() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in a directed graph", GraphUtils.minDistance((Graph)buildDirectedGraph, "0", "8") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are not connected in a directed graph");
        }
    }
    
    @Test
    public void testSrcDestNotConnectedDirectedButConnectedUndirected() {
        final DirectedGraph buildDirectedGraph = GraphBuilder.buildDirectedGraph(FILENAME);
        if (buildDirectedGraph == null) {
            Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
        }
        try {
            Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in a directed graph but are connected in underlying undirected graph", GraphUtils.minDistance((Graph)buildDirectedGraph, "1", "3") == -1);
        }
        catch (Exception obj) {
            Assert.fail("minDistance throws " + obj + " when src and dest are not connected in a directed graph but are connected in underlying undirected graph");
        }
    }
}
