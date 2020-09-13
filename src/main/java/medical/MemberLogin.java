package medical;

public class  MemberLogin {

    String firstName;
    String lastName;
    String password;
    int doctorID;



    public MemberLogin(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
