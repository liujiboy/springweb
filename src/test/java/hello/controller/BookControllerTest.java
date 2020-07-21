package hello.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hello.service.TestDataBase;

public class BookControllerTest {

	@Autowired
	private TestDataBase testDataBase;
	@Before
	public void setUp() throws Exception {
		
		testDataBase.prepareData();
	}

	@After
	public void tearDown() throws Exception {
		testDataBase.clearData();
	}


	@Test
	public void testGetBookById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBookCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddBook() {
		fail("Not yet implemented");
	}

}
