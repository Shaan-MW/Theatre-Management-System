public class Customer {
    private String username;
    private String firstname;
    private String password;

    public Customer(String username, String firstname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

}
