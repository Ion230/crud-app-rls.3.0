package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.dao.StudentDAOImplimentation;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//returneaza lista de studenti
		List<Student> theStudent = studentDAO.findByLastName("Popescu");

		//afiseazza lista de studenti
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		//cream un obiect Student
			System.out.println("Creating new student object...");
			Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

		//salvam obiectul Student in baza de date folosind DAO(Data-Acces-Object)
			System.out.println("Saving the student...");
			studentDAO.save(newStudent);

		//afisam ID-UL studentului salvat
			System.out.println("Saved student. Generated id:" +newStudent.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		//cream mai multi studenti
		System.out.println("Creating 3 student objects...");
		Student newStudent1 = new Student("Andrei", "Munteanu" , "andrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian", "Vataman" , "iulic@pixelacademy.md");
		Student newStudent3 = new Student("Maria", "Mirabela" , "mira@pixelacademy.md");

		//salvam obiectele student in baza de date
		System.out.println("Saving the students...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}
	private void readStudent(StudentDAO studentDAO) {

		//creeaza un obiect de tip Student
		System.out.println("Creating new student object...");
		Student newStudent  = new Student("Mircea", "Popescu", "mirceap@pixel.academy");

		//salveaza studentul in baza de date
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//afiseaza id-ul studentului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//recupereaza studentul pe baza ID-ului (PK)
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findByID(theId);

		//afiseaza detaliile studentului
		System.out.println("Found the student: " + myStudent);
	}
	private void queryForStudents(StudentDAO studentDAO) {

		//obtine lista de studenti
		List<Student> theStudents = studentDAO.findAll();

		//afiseaza lista de studenti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}

		}
	}



