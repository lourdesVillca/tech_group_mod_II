package week4.homework10;
import java.util.Set;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

// 
// Decompiled by Procyon v0.5.36
// 

public class FriendFinderTest
{
    protected ClassesDataSource cds;
    protected StudentsDataSource sds;
    protected FriendFinder ff;
    
    @Before
    public void setUp() throws Exception {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                return new ArrayList<String>();
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                return new ArrayList<Student>();
            }
        };
    }
    
    @Test
    public void testNullClassesDataSource() {
        this.ff = new FriendFinder((ClassesDataSource)null, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
            Assert.fail("findClassmates does not correctly handle situation in which ClasssesDataSource field is null");
        }
        catch (IllegalStateException ex) {}
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when ClasssesDataSource field is null");
        }
    }
    
    @Test
    public void testNullStudentsDataSource() {
        this.ff = new FriendFinder(this.cds, (StudentsDataSource)null);
        try {
            this.ff.findClassmates(new Student("chris"));
            Assert.fail("findClassmates does not correctly handle situation in which StudentsDataSource field is null");
        }
        catch (IllegalStateException ex) {}
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when StudentsDataSource field is null");
        }
    }
    
    @Test
    public void testNullInput() {
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates((Student)null);
            Assert.fail("findClassmates does not correctly handle situation in which input is null");
        }
        catch (IllegalArgumentException ex) {}
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testNullInputStudentName() {
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student((String)null));
            Assert.fail("findClassmates does not correctly handle situation in which name of input Student is null");
        }
        catch (IllegalArgumentException ex) {}
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when name of input Student is null");
        }
    }
    
    @Test
    public void testClassesDataSourceGetReturnsNull() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                return null;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when ClassesDataSource.get returns null for input name");
        }
    }
    
    @Test
    public void testStudentsDataSourceGetReturnsNull() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                list.add("cis573");
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                return null;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when StudentsDataSource.get returns null");
        }
    }
    
    @Test
    public void testClassesDataSourceGetReturnsNullForOtherStudents() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                if (s.equals("chris")) {
                    list.add("cis573");
                    return list;
                }
                return null;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                list.add(new Student("swap"));
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when ClassesDataSource.get returns null for some students");
        }
    }
    
    @Test
    public void testClassesDataSourceGetReturnsListContainingNull() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                list.add("cis573");
                list.add(null);
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                list.add(new Student("swap"));
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when ClassesDataSource.get returns a List containing null");
        }
    }
    
    @Test
    public void testStudentsDataSourceGetReturnsListContainingNull() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                list.add("cis573");
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                list.add(new Student("swap"));
                list.add(null);
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when StudentsDataSource.get returns a List containing null");
        }
    }
    
    @Test
    public void testStudentsDataSourceGetReturnsListContainingStudentWithNullName() {
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                list.add("cis573");
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                list.add(new Student("swap"));
                list.add(new Student((String)null));
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            this.ff.findClassmates(new Student("chris"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when StudentsDataSource.get returns a List containing a Student with name = null");
        }
    }
    
    @Test
    public void testOneOtherStudentTakingSameClassesAsMe() {
        final String s = "Me";
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                if (s.equals("Me")) {
                    list.add("CIS573");
                    list.add("CIS550");
                }
                else if (s.equals("A")) {
                    list.add("CIS573");
                    list.add("CIS550");
                }
                else if (s.equals("B")) {
                    list.add("CIS573");
                    list.add("CIS550");
                }
                else if (s.equals("C")) {
                    list.add("CIS573");
                }
                else {
                    list.add("");
                }
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                if (s.equals("CIS573")) {
                    list.add(new Student("Me"));
                    list.add(new Student("A"));
                    list.add(new Student("B"));
                    list.add(new Student("C"));
                }
                else if (s.equals("CIS550")) {
                    list.add(new Student("Me"));
                    list.add(new Student("A"));
                    list.add(new Student("B"));
                }
                else {
                    list.add(new Student(""));
                }
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            final Set classmates = this.ff.findClassmates(new Student(s));
            Assert.assertTrue("findClassmates returns List with incorrect number of classmates when there are two or more other students taking the same classes", classmates.size() == 2);
            Assert.assertTrue("findClassmates returns List with incorrect classmate names when there are two or more other students taking the same classes", classmates.contains("A"));
            Assert.assertTrue("findClassmates returns List with incorrect classmate names when there are two or more other students taking the same classes", classmates.contains("B"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when there are two or more other students taking the same classes");
        }
    }
    
    @Test
    public void testTwoOtherStudentsTakingSameClassesAsMe() {
        final String s = "Me";
        this.cds = (ClassesDataSource)new ClassesDataSource() {
            public List<String> getClasses(final String s) {
                final ArrayList<String> list = new ArrayList<String>();
                if (s.equals("Me")) {
                    list.add("CIS573");
                    list.add("CIS550");
                }
                else if (s.equals("A")) {
                    list.add("CIS573");
                    list.add("CIS550");
                }
                else if (s.equals("B")) {
                    list.add("CIS573");
                }
                else {
                    list.add("");
                }
                return list;
            }
        };
        this.sds = (StudentsDataSource)new StudentsDataSource() {
            public List<Student> getStudents(final String s) {
                final ArrayList<Student> list = new ArrayList<Student>();
                if (s.equals("CIS573")) {
                    list.add(new Student("Me"));
                    list.add(new Student("A"));
                    list.add(new Student("B"));
                }
                else if (s.equals("CIS550")) {
                    list.add(new Student("Me"));
                    list.add(new Student("A"));
                }
                else {
                    list.add(new Student(""));
                }
                return list;
            }
        };
        this.ff = new FriendFinder(this.cds, this.sds);
        try {
            final Set classmates = this.ff.findClassmates(new Student(s));
            Assert.assertTrue("findClassmates returns List with incorrect number of classmates when there is exactly one other student taking the same classes", classmates.size() == 1);
            Assert.assertTrue("findClassmates returns List with incorrect classmate names when there is exactly one other student taking the same classes", classmates.contains("A"));
        }
        catch (Exception obj) {
            Assert.fail("findClassmates throws " + obj + " when there is exactly one other student taking the same classes");
        }
    }
}
