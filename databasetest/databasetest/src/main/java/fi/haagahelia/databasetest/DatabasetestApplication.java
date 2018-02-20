package fi.haagahelia.databasetest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.databasetest.domain.Student;
import fi.haagahelia.databasetest.domain.StudentRepository;

@SpringBootApplication
public class DatabasetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabasetestApplication.class, args);
	}

	
	
	@Bean public CommandLineRunner demo(StudentRepository repository){

		return(args) -> {

			Student s1 = new Student("juha", "hinkula", "juha.hinkula@email.com" );
			Student s2 = new Student("Mike", "Mars", "mars@mars.com" );

			repository.save(s1);
			repository.save(s2);
		};
	}
}


		

