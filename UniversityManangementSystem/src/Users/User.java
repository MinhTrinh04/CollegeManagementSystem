package Users;

public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String password;

    public User() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String GetFirstName() {
        return firstName;
    }

    public void SetFirstName(String name) {
        this.firstName = name;
    }

    public String GetLastName() {
        return lastName;
    }

    public void SetLastName(String name) {
        this.lastName = name;
    }

    public String GetEmail() {
        return email;
    }

    public void SetEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNumber;
    }

    public void SetPhoneNum(String phonenum) {
        this.phoneNumber = phonenum;
    }

    public String GetBirth() {
        return birthDate;
    }

    public void SetBirth(String birthDate) {
        this.birthDate = birthDate;
    }

    public String GetPassword() {
        return password;
    }

    public void SetPassword(String password) {
        this.password = password;
    }


}