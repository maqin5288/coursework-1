package jdbc;

import org.junit.Test;

public class AddressDAOTest {

	@Test
	public void selectAll() throws Exception {
		AddressDAO dao = new AddressDAO();
		dao.selectAll();
	}

	@Test
	public void selectAllBasedOnCity() throws Exception {
		AddressDAO dao = new AddressDAO();
		dao.selectAllBasedOnCity("Farmington");
		System.out.println("*****************");
		dao.selectAllBasedOnCity("Detroit");
	}

}
