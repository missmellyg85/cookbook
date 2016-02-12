package cookbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.SpringApplication
import groovy.sql.Sql

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args)
	}

	@Bean
	public Sql db() {
		def dbUrl = "jdbc:postgresql://localhost:5432/cookbook"
		def dbUser = "missywilliams"
		def dbDriver = "org.postgresql.Driver"

		Sql.newInstance(dbUrl,dbUser,"", dbDriver)
	}
}
