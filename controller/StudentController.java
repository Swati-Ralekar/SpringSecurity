package nz.co.stylesoftware.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import nz.co.stylesoftware.SpringSecurity.model.Student;

@RestController
public class StudentController {

	List<Student> students = new ArrayList<>(List.of(
			new Student(1, "Swati", "Java"),
			new Student(2, "Sayali", "Docker"),
			new Student(3, "Neha", "Kafka")
			));
	
	@GetMapping("getStudent")
	public List<Student> getStudent(){
		return students;
	}
	
	@PostMapping("addStudent")
	public List<Student> addStudent(@RequestBody Student newStudent) {
		students.add(newStudent);
		return students;
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
}
