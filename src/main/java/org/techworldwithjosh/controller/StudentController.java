package org.techworldwithjosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.techworldwithjosh.exception.CustomException;
import org.techworldwithjosh.model.Student;
import org.techworldwithjosh.repo.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index.html";
    }

    // Write code to get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Write code to get student by id else return null
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    // Write code to add student and return added student
    // If marks or attendance is less than 0 or greater than 100 then throw CustomException with message
    // "Marks should be between 0 and 100" or "Attendance should be between 0 and 100" respectively
    // and status code 400
    @PostMapping
    public Student addStudent(@RequestBody Student student) throws Exception {
        if (student.getMarks() < 0 || student.getMarks() > 100) {
            throw new CustomException("Marks should be between 0 and 100");
        }
        if (student.getAttendance() < 0 || student.getAttendance() > 100) {
            throw new CustomException("Attendance should be between 0 and 100");
        }
        return studentRepository.save(student);
    }

    // Write code to update student and return updated student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirst_name(updatedStudent.getFirst_name());
                    student.setLast_name(updatedStudent.getLast_name());
                    student.setMarks(updatedStudent.getMarks());
                    student.setAttendance(updatedStudent.getAttendance());
                    student.setPromotionStatus(updatedStudent.isPromotionStatus());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // Write code to delete student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // Write code to update promotion status of student by id and return student object
    // If marks and attendance is greater than 85 then set promotion_status to true else false
    @PutMapping("/{id}/updatePromotionStatus")
    public Student updatePromotionStatus(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    boolean promotionStatus = student.getMarks() > 85 && student.getAttendance() > 85;
                    student.setPromotionStatus(promotionStatus);
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

}

