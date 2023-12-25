package schedule;

import java.util.Date;
import java.util.List;

public class Handler {
	
	private ScheduleDAO dao = new ScheduleDAO();

	public List<ScheduleDTO> selectAll() {
		return dao.selectAll();
	}

	public String getVersion() {
		return dao.selectVersion();
	}

	public Date getSysdate() {
		return dao.selectSysdate();
	}

}
