package jdbc;

import org.junit.Test;

public class AddressDAOTest {

	@Test
	public void test() throws Exception {
		AddressDAO dao = new AddressDAO();
		dao.selectAll();
	}
	

}
