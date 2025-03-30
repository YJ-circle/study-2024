package entity;

public class HistoryEntity {
	String id;
	String host;
	String type;
	String clickdate;
	public HistoryEntity(String id, String host, String type) {
		super();
		this.id = id;
		this.host = host;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClickdate() {
		return clickdate;
	}
	public void setClickdate(String clickdate) {
		this.clickdate = clickdate;
	}
	

}
