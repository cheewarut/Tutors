package th.ac.kmitl.Tutors.service;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.kmitl.Tutors.model.Student;
import th.ac.kmitl.Tutors.model.StudentRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void createStudent(Student student) {
        String hashPin = hash(student.getPin());
        student.setPin(hashPin);
        repository.save(student);
    }

    public Student findStudent(int id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student checkPin(Student inputStudent) {
        Student storedStudent = findStudent(inputStudent.getId());

        if (storedStudent != null) {
            String storedPin = storedStudent.getPin();
            if (BCrypt.checkpw(inputStudent.getPin(), storedPin))
                return storedStudent;
        }
        return null;
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}
