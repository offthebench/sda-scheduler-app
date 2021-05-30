package exceptions;

public class MaximumNumberOfStudentsReachedException extends RuntimeException {

    public MaximumNumberOfStudentsReachedException(String studentNanme) {
        super("The Maximum limit for number of students for a group reached for Student: " + studentNanme);
    }
}
