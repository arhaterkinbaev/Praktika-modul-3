import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Email: " + email + ", Роль: " + role;
    }
}

class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(String name, String email, String role) {
        users.add(new User(name, email, role));
    }

    public void removeUser(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }

    public void updateUser(String email, String name, String role) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                user.setName(name);
                user.setRole(role);
            }
        }
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.addUser("Айдар", "aidar@example.com", "Admin");
        userManager.addUser("Алия", "aliya@example.com", "User");
        userManager.updateUser("aliya@example.com", "Алия", "Admin");
        userManager.removeUser("aidar@example.com");
        userManager.printUsers();
    }
}
