package com.qa.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.persistence.domain.Person;
import com.qa.demo.persistence.repo.PersonRepo;

@SpringBootTest
public class PersonServiceUnitTest {

	@Autowired
	private PersonService service;

	@MockBean
	private PersonRepo repo;

	private final Person TEST_PERSON = new Person(null, 26, "JH");

	private final Person TEST_SAVED_PERSON = new Person(1L, 26, "JH");

	@Test
	public void testCreate() {
		Mockito.when(this.repo.save(this.TEST_PERSON)).thenReturn(this.TEST_SAVED_PERSON);

		Assertions.assertThat(this.service.create(this.TEST_PERSON)).isEqualTo(this.TEST_SAVED_PERSON);

		Mockito.verify(this.repo, Mockito.times(1)).save(this.TEST_PERSON);
	}

}
