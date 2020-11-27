package dao;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import db.DBConnect;
import model.User;



/*
 * TODO DBConnectTest EXTRA
 */
class UserSCLDAOTest {
	
	private UserSQLDAO userDAO;

//	JUnit4
//	@Before
//	void setUp() throws Exception {
//		
//		
//	}
	
	//JUnit5
	@BeforeAll
	static void setUpAll() {
		System.out.println("setup before all");
	}
	
	
	//JUnit 5
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup before");
		userDAO = new UserSQLDAO();
		userDAO.deleteAll();
		userDAO.save(new User("Max", "Meier", "meier@web.de", LocalDate.of(1999, Month.AUGUST, 2)));
		userDAO.save(new User("Ina", "Schultz", "schultzr@web.de", LocalDate.of(1972, Month.SEPTEMBER, 3)));
		userDAO.save(new User("Otto", "Krause", "krausez@web.de", LocalDate.of(1989, Month.OCTOBER, 12)));
		
		
	}

	

	@AfterEach
	void tearDown() throws Exception {
	
	}

	@Test
	void testFindAll() {
		List<User> users = userDAO.findAll();
		assertNotNull(users);;
		assertEquals(3, users.size());

	
	}

	@Test
	void testSave() {
		boolean saved = userDAO.save(new User("Anke", "Lehmannüüü", "lehm@gmail.com", LocalDate.of(1999, Month.AUGUST, 2)));
		assertTrue(saved);
	}

	@Test
	void testDelete() {
		User u = userDAO.findAll().get(0);
		boolean deleted = userDAO.delete(u.getId());
		assertTrue(deleted);
		
	}

}
