package week2.homework6;
import java.util.Iterator;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;
import java.io.File;


// 
// Decompiled by Procyon v0.5.36
// 

public class Homework6Grader
{
    public static void main(final String[] array) {
        try {
            if (!new File("./src/test/week2/homework6/is_hamiltonian_path_test.txt").exists()) {
                System.out.println("Cannot run tests: graph_builder_test.txt needs to be in project root directory or directory where you ran Java.");
                System.exit(1);
            }
        }
        catch (Exception obj) {
            System.out.println("An unexpected error occurred while trying to read graph_builder_test.txt: " + obj);
            System.out.println("Please check that graph_builder_test.txt is in the project root directory or directory where you ran Java.");
            System.exit(1);
        }
        try {
            if (!new File("./src/test/week2/homework6/is_hamiltonian_path_test.txt").exists()) {
                System.out.println("Cannot run tests: is_hamiltonian_path_test.txt needs to be in project root directory or directory where you ran Java.");
                System.exit(1);
            }
        }
        catch (Exception obj2) {
            System.out.println("An unexpected error occurred while trying to read is_hamiltonian_path_test.txt: " + obj2);
            System.out.println("Please check that is_hamiltonian_path_test.txt is in the project root directory or directory where you ran Java.");
            System.exit(1);
        }
        final Result runClasses = JUnitCore.runClasses(new Class[] { MinDistanceTest.class, NodesWithinDistanceTest.class, IsHamiltonianPathTest.class });
        final int failureCount = runClasses.getFailureCount();
        final int i = runClasses.getRunCount() - failureCount;
        if (i == 1) {
            System.out.println("1 test passed.");
        }
        else {
            System.out.println(i + " tests passed.");
        }
        if (failureCount == 1) {
            System.out.println("1 test failed.");
        }
        else {
            System.out.println(failureCount + " tests failed.");
        }
        if (failureCount == 0) {
            System.out.println("Great job!");
        }
        else {
            final int j = (int)(i / (double)(failureCount + i) * 100.0);
            int k = 1;
            for (final Failure failure : runClasses.getFailures()) {
                if (failure.getMessage() == null) {
                    final Throwable exception = failure.getException();
                    System.out.println("#" + k + ". A test threw " + exception + " at " + exception.getStackTrace()[0]);
                }
                else if (failure.getException() instanceof AssertionError) {
                    System.out.println("#" + k + ". " + failure.getMessage());
                }
                else {
                    System.out.println("#" + k + ". " + failure.getException() + " occurs at " + failure.getException().getStackTrace()[0]);
                }
                ++k;
            }
            System.out.println("Your score for this assignment would be " + j + "%\n");
        }
    }
}
