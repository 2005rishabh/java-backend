package in.rishabh.filterDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import in.rishabh.filterDemo.controller.StudentController;

@SpringBootTest
class FilterDemoApplicationTests {

	@Autowired
	private StudentController studentController;

	@Test
	void createStudentEndpointReturnsSuccessMessage() {
		ResponseEntity<String> response = studentController.createStudent();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Student created successfully", response.getBody());
	}

}
