package dto;

public class TourDto {
	String imagename;
	String description;
	String imagepath;
	public TourDto(String imagename, String description, String imagepath) {
		super();
		this.imagename = imagename;
		this.description = description;
		this.imagepath = imagepath;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	

}
