package n.w.RepoDetailsAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication()
public class RepoDetailsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoDetailsApiApplication.class, args);
	}

}

//	Acceptance criteria:
//		As an api consumer, given username and header “Accept: application/json”,

//		I would like to list all his github repositories, which are not forks. Information, which I require in the response, is:
//
//		Repository Name
//		Owner Login
//		For each branch it’s name and last commit sha
//
//		As an api consumer, given not existing github user, I would like to receive 404 response in such a format:
//		{
//		“status”: ${responseCode}
//		“Message”: ${whyHasItHappened}
//		}
//
//		As an api consumer, given header “Accept: application/xml”, I would like to receive 406 response in such a format:
//		{
//		“status”: ${responseCode}
//		“Message”: ${whyHasItHappened}
//		}
//
//		Notes:
//		Please full-fill the given acceptance criteria, delivering us your best code compliant with industry standards.
//		Please use https://developer.github.com/v3 as a backing API
//		Application should have a proper README.md file
