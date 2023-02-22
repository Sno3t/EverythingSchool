import java.time.LocalDate;

public class Contact {
    private String name;
    private String email;
    private String mobile;
    private LocalDate birthday;

    public Contact(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact name is " + name;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
