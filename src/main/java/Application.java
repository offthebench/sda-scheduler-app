import model.Group;
import model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        try {
            SdaScheduler scheduler = new SdaScheduler();

            scheduler.displayStudentsForGroup("JavaEstoniaEE6");
            scheduler.addStudentToGroup(scheduler.getStudentList().get(7), "JavaEstoniaEE6");
            scheduler.addStudentToGroup(scheduler.getStudentList().get(8), "JavaEstoniaEE6");
            System.out.println("---------------------------------------------------");
            scheduler.displayStudentsForGroup("JavaEstoniaEE6");
            System.out.println("---------------------------------------------------");
            System.out.println("Group with Maximum number of students in class: "
                    + scheduler.getGroupWithMaxStudents().getName());
            System.out.println("---------------------------------------------------");
            Map<Group, List<Student>> studentsAboveAge20ByGroup = scheduler.getStudentsAboveAge20ByGroup();
            for (Group group : studentsAboveAge20ByGroup.keySet()) {
                System.out.println(group.getName());
                List<Student> students = studentsAboveAge20ByGroup.get(group);
                System.out.println("Students above age of 20 years:");
                for (Student student : students) {
                    System.out.printf("\n%s %s\n", student.getFirstName(), student.getLastName());
                }
            }
            System.out.println("---------------------------------------------------");
            scheduler.removeAllStudentsYoungerThanAgeOf20();
            System.out.println("---------------------------------------------------");
            scheduler.displayStudentsForGroup("JavaEstoniaEE6");
        } catch (Exception ex) {
            System.out.println("Exception occurred while initialisation: " + ex.getMessage());
        }
    }
}
