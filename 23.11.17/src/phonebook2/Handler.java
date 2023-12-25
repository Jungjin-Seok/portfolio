package phonebook2;


import java.sql.SQLException;
import java.util.List;

public class Handler {
	
	public void showList() throws Exception {

	Phonebook2DAO dao = new Phonebook2DAO();
	List<Phonebook2DTO> list = dao.selectList();
	list.forEach(ob -> System.out.println(ob));

	}

	public int insertPhonebook2(Phonebook2DTO ob) throws SQLException {
		int row = 0;
		Phonebook2DAO dao = new Phonebook2DAO();
		row = dao.insertPhonebook2(ob);		
		return row;
	}

	public int updatePnum(String name, String pnum) {
		Phonebook2DAO dto = new Phonebook2DAO();
		dto.setName(name);
		dto.setPnum(pnum);
		int row = dao.updatePnum(dto);
		return row;
	}		





}
