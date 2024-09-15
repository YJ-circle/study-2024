package dto;


public interface IProductDto extends Dto{
	public String getCode();
	public String getName();
	public int getPrice();
	public String getCategory();
	public String getImgPath();
	public String priceToString();
	
}
