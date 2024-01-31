package board2;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board2.FileUtil;

public class FileUtil {
	
	private static FileUtil instance = new FileUtil();
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {
		File dir = new File(saveDirectory);
		dir.mkdirs();
	}
	
	private String saveDirectory = "C:\\upload";
	private final int maxPostSize = 1024 * 1024 * 50;
	private final String encoding = "UTF-8";
	private final FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	public Board2DTO getDTO(HttpServletRequest request) throws IOException {
		Board2DTO dto = new Board2DTO();
//		if(saveDirectory == null) {
//			ServletContext application = request.getServletContext(); 서버가 초기화 되면 그림파일도 날라감
//			saveDirectory = application.getRealPath("/reviewImage");
//			File dir = new File(saveDirectory);
//			dir.mkdirs();
//		}
		
		MultipartRequest mpRequest = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy
		);
		
		File uploadFile = mpRequest.getFile("uploadFile");
		if(uploadFile != null) {
			dto.setImage(uploadFile.getName());
		}
		
		dto.setTitle(mpRequest.getParameter("title"));
		dto.setWriter(mpRequest.getParameter("writer"));
		dto.setContent(mpRequest.getParameter("content"));
		dto.setIpaddr(mpRequest.getParameter("ipaddr"));

		return dto;
	}
}
