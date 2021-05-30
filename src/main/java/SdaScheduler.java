import exceptions.GroupNotFoundException;
import exceptions.MaximumNumberOfStudentsReachedException;
import model.Group;
import model.Student;
import model.Trainer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SdaScheduler {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private List<Student> studentList;
    private List<Trainer> trainerList;
    private List<Group> groupList;

    /***
     * Initialise Scheduler and seed data into trainers,
     * student and group list into it.
     *
     * @throws ParseException
     */
    public SdaScheduler() throws ParseException {
        studentList = new ArrayList<>();
        trainerList = new ArrayList<>();
        groupList = new ArrayList<>();

        initTrainers();
        initStudents();
        initGroups();
    }

    /***
     * It adds an existing student of SDA to a group.
     *
     * @param student - Student from student list
     * @param groupName - group available in SDA groups list.
     */
    public void addStudentToGroup(Student student, String groupName) {
        boolean ok = false;
        for (Group g : groupList) {
            if(g.getName().equals(groupName)) {
                ok = true;
                if (g.getStudents().size() < 5) {
                    g.getStudents().add(student);
                } else {
                    throw new MaximumNumberOfStudentsReachedException(
                            student.getFirstName() + " " + student.getLastName());
                }
            }
        }

        if (!ok) {
            throw new GroupNotFoundException(groupName);
        }
    }

    /***
     * Displays the names of students for a group alphabetically.
     *
     * @param groupName - name of the group from SDA group list.
     */
    public void displayStudentsForGroup(String groupName) {
        boolean ok = false;
        for (Group g : groupList) {
            if (g.getName().equals(groupName)) {
                ok = true;
                Set<Student> students = g.getStudents();

                ArrayList<Student> studentList = new ArrayList<>(students);
                Collections.sort(studentList);

                System.out.println(groupName);
                for (Student student : studentList) {
                    System.out.printf("First Name: %s \nLast Name: %s\n\n",
                            student.getFirstName(), student.getLastName());
                }
            }
        }

        if (!ok) {
            throw new GroupNotFoundException(groupName);
        }
    }

    public Group getGroupWithMaxStudents() {
        Collections.sort(groupList);
        return groupList.get(0);

//        int max = 0;
//        Group maxGroup = null;

//        for (Group group : groupList) {
//            int size = group.getStudents().size();

//            if (size > max) {
//                maxGroup = group;
//            }

//            max = Math.max(max, size);
//        }

//        return maxGroup;
    }

    public Map<Group, List<Student>> getStudentsAboveAge20ByGroup() throws ParseException {
        Map<Group, List<Student>> groupStudentsMap = new HashMap<>();
        for (Group group : groupList) {
            List<Student> studentsAbove20 = new ArrayList<>();
            for (Student student : group.getStudents()) {
                Date currentDate = simpleDateFormat.parse("01/01/2021");
                if (currentDate.getYear() - student.getDateOfBirth().getYear() > 20) {
                    studentsAbove20.add(student);
                }
            }
            groupStudentsMap.put(group, studentsAbove20);
        }

        return groupStudentsMap;
    }

    public void displayStudentsWithPreviousJavaKnowledge() {
        for (Student student : studentList) {
            if (student.isHasPreviousJavaKnowledge()) {
                System.out.printf("\n%s %s\n", student.getFirstName(), student.getLastName());
            }
        }
    }

    public void removeAllStudentsYoungerThanAgeOf20() throws ParseException {
        for (Group group : groupList) {
            List<Student> studentsBelow20 = new ArrayList<>();
            for (Student student : group.getStudents()) {
                Date currentDate = simpleDateFormat.parse("01/01/2021");
                if (currentDate.getYear() - student.getDateOfBirth().getYear() < 20) {
                    studentsBelow20.add(student);
                }
            }
            group.getStudents().removeAll(studentsBelow20);
        }
    }

    /***
     * Initialise and seed data into trainer list
     *
     * @throws ParseException
     */
    private void initTrainers() throws ParseException {
        Trainer trainer1 = new Trainer("Akshay", "Saxena", simpleDateFormat.parse("03/07/1991"), true);
        Trainer trainer2 = new Trainer("Andrew", "Briston", simpleDateFormat.parse("13/01/1993"), true);
        Trainer trainer3 = new Trainer("John", "Legend", simpleDateFormat.parse("12/12/1887"), true);

        trainerList.addAll(List.of(trainer1, trainer2, trainer3));
    }

    /***
     * Initialise and seed data into student list
     *
     * @throws ParseException
     */
    private void initStudents() throws ParseException {
        Student s1 = new Student("A", "Z", simpleDateFormat.parse("01/02/2000"), false);
        Student s2 = new Student("S", "X", simpleDateFormat.parse("01/02/2001"), false);
        Student s3 = new Student("D", "C", simpleDateFormat.parse("01/02/2000"), false);
        Student s4 = new Student("F", "V", simpleDateFormat.parse("01/02/2002"), true);
        Student s5 = new Student("G", "B", simpleDateFormat.parse("01/02/2000"), false);
        Student s6 = new Student("H", "N", simpleDateFormat.parse("01/02/2003"), false);
        Student s7 = new Student("J", "M", simpleDateFormat.parse("01/02/2000"), true);
        Student s8 = new Student("K", "O", simpleDateFormat.parse("01/02/2004"), false);
        Student s9 = new Student("L", "I", simpleDateFormat.parse("01/02/2000"), true);
        Student s10 = new Student("P", "Y", simpleDateFormat.parse("01/02/2005"), false);


        studentList.addAll(List.of(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));
    }

    /***
     * Initialise and seed data into group list
     *
     */
    private void initGroups() {
        Group g1 = new Group("JavaEstoniaEE6", trainerList.get(0), Stream.of(studentList.get(0), studentList.get(1), studentList.get(2)).collect(Collectors.toSet()));
        Group g2 = new Group("JavaEstoniaEE8", trainerList.get(1), Stream.of(studentList.get(0), studentList.get(3), studentList.get(4), studentList.get(5)).collect(Collectors.toSet()));
        Group g3 = new Group("JavaEstoniaEE10", trainerList.get(2), Stream.of(studentList.get(6), studentList.get(7), studentList.get(8)).collect(Collectors.toSet()));
        Group g4 = new Group("JavaEstoniaEE12", trainerList.get(1), Stream.of(studentList.get(9), studentList.get(0), studentList.get(7), studentList.get(8)).collect(Collectors.toSet()));

        groupList.addAll(List.of(g1, g2, g3, g4));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public List<Group> getGroupList() {
        return groupList;
    }
}
