package model;

import java.util.Set;

public class Group implements Comparable<Group> {
    private String name;
    private Trainer trainer;
    private Set<Student> students;

    public Group(String name, Trainer trainer, Set<Student> students) {
        this.name = name;
        this.trainer = trainer;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public int compareTo(Group group) {
        return Integer.compare(group.getStudents().size(), this.students.size());
    }
}