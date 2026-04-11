package punto6;

public class SecuritySubSystem {
    public boolean checkAddPermission(String userId) {
        return userId.equals("1");
    }

    public boolean checkRemovePermission(String userId) {
        return userId.equals("1");
    }

    public boolean checkListPermission(String userId) {
        return userId.equals("1");
    }
}