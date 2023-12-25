package youtube;

//이름       널?       유형            
//-------- -------- ------------- 
//IDX      NOT NULL NUMBER        
//TITLE    NOT NULL VARCHAR2(100) 
//CHNAME   NOT NULL VARCHAR2(100) 
//IMGNAME  NOT NULL VARCHAR2(200) 
//VIDEOTAG NOT NULL VARCHAR2(200) 

public class YouTubeDTO {

	private int idx;
	private String title;
	private String chName;
	private String imgName;
	private String videoTag;
	private String category;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getVideoTag() {
		return videoTag;
	}
	public void setVideoTag(String videoTag) {
		this.videoTag = videoTag;
	}
	
	
}
