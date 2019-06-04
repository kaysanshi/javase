package cn.test.memo.entity;

public class Record {
	private Integer id;
	private String title;
	private String text;
	private String time;
	private String addtime;
	
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", title=" + title + ", text=" + text + ", time=" + time + ", addtime=" + addtime + "]";
	}
}
