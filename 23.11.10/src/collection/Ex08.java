package collection;

import java.util.HashMap;

public class Ex08 {
	public static void main(String[] args) throws Exception {
		String url = "https://search.naver.com//search.naver";
		url += "?";
		
		HashMap<String, String> param = new HashMap<>();
		param.put("query", "부산 날씨");
		param.put("where", "news");
		
		param.put("query", param.get("query").replace(" ", "%20"));
		
		
		for(String key : param.keySet()) {
			String value = param.get(key);
			url += key + "=" + value + "&";
		}
		
		Runtime rt = Runtime.getRuntime();
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		rt.exec(chromePath + " " + url);
		
	}
}
