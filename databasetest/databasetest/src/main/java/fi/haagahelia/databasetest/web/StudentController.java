package fi.haagahelia.databasetest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.databasetest.domain.Student;
import fi.haagahelia.databasetest.domain.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository  repository;
	
	@RequestMapping ("/students")
	public String students(Model model) {
		model.addAttribute("students",repository.findAll());
		return "studentlist";
	}
	@RequestMapping(value ="/add")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addstudent";
	}
	@RequestMapping(value ="/save", method =RequestMethod.POST)
	public String save(Student student){
		repository.save(student);
		return"redirect:studentlist";
	}
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id")Long studentId, Model model) {
		repository.delete(studentId);
		return "redirect:../studentlist";
	}
	
}
	

