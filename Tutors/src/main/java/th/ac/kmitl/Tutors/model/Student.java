package th.ac.kmitl.Tutors.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String pin;

    public Student() {}
    public Student(int id, String name, int pin) {
        this.id = id;
        this.name = name;
        this.pin = String.valueOf(pin);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
