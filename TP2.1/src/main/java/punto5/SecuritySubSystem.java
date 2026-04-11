package punto5;

public class SecuritySubSystem {
    public boolean checkPermission(String userId) {
        return userId.equals("1");
    }
}