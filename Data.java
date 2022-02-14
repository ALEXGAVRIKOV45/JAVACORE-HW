
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Data {

    public static List<Student> getStudentsList() {
        
        Course course1 = new Course("baseball");
        Course course2 = new Course("biathlon");
        Course course3 = new Course("bobsleigh");
        Course course4 = new Course("curling");
        Course course5 = new Course("slalom");
        Course course6 = new Course("run");
        Course course7 = new Course("snowboarding");
        Course course8 = new Course("ice hockey");
        Course course9 = new Course("swimming");
        Course course10 = new Course("ski");
        

        
        Student stud1 = new Student("Stud1", Arrays.asList(course1, course3, course5));
        Student stud2 = new Student("Stud2", Arrays.asList(course1, course2, course3));
        Student stud3 = new Student("Stud3", Arrays.asList(course1, course7, course8));
        Student stud4 = new Student("Stud4", Arrays.asList(course2, course4, course8, course1, course3, course5));
        Student stud5 = new Student("Stud5", Arrays.asList(course3, course7, course9));
        Student stud6 = new Student("Stud6", Arrays.asList(course1, course3, course5, course9));
        Student stud7 = new Student("Stud7", Arrays.asList(course2, course6, course7, course5, course9));
        Student stud8 = new Student("Stud8", Arrays.asList(course3, course2, course4));
        Student stud9 = new Student("Stud9", Arrays.asList(course4, course8, course5));
        Student stud10 = new Student("Stud10", Arrays.asList(course5, course1, course9));
        Student stud11 = new Student("Stud11", Arrays.asList(course6, course9, course5));
        Student stud12 = new Student("Stud12", Arrays.asList(course7, course6, course5));
        Student stud13 = new Student("Stud13", Arrays.asList(course8, course1, course5));
        Student stud14 = new Student("Stud14", Arrays.asList(course9, course2, course5));
        Student stud15 = new Student("Stud15", Arrays.asList(course10, course3, course1));
        Student stud16 = new Student("Stud16", Arrays.asList(course8, course9, course2));
        Student stud17 = new Student("Stud17", Arrays.asList(course5, course8, course3));
        Student stud18 = new Student("Stud18", Arrays.asList(course2, course7, course4));
        Student stud19 = new Student("Stud19", Arrays.asList(course10, course6, course5));
        Student stud20 = new Student("Stud20", Arrays.asList(course9, course5, course3));
        


        return Arrays.asList(stud1, stud2, stud3, stud4, stud5, stud6, stud7,
                stud8, stud9, stud10, stud11, stud12, stud13, stud14,
                stud15, stud16, stud17, stud18, stud19, stud20);
    }

    public static Course getRandomCourse() {
        Random random = new Random();
        List<Course> courses = getListCourses();
        return courses.get(random.nextInt(courses.size()));
    }

    private static List<Course> getListCourses() {
        return Arrays.asList(new Course("baseball"),
                new  Course("biathlon"),
                new  Course("bobsleigh"),
                new  Course("curling"),
                new  Course("slalom"),
                new  Course("run"),
                new  Course("snowboarding"),
                new  Course("ice hockey"),
                new  Course("swimming"),
                new  Course("ski"));
    }                
}

