package th.ac.kmitl.Tutors.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.Tutors.model.Student;
import th.ac.kmitl.Tutors.service.StudentService;

@Controller
@RequestMapping("/gust")
public class GustController {
    private StudentService studentService;

    public GustController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentPage(Model model) {
        model.addAttribute("allStudents", studentService.getStudents());
        return "gust";
    }

    @PostMapping
    public String registerStudent(@ModelAttribute Student student, Model model) {
        studentService.createStudent(student);
        model.addAttribute("allStudents", studentService.getStudents());
        return "redirect:student";
    }
}
