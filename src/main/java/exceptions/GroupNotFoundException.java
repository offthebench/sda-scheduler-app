package exceptions;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(String groupName) {
        super(groupName + " is not found in Group list of SDA.");
    }
}
