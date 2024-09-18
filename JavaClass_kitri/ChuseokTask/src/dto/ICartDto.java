package dto;

public interface ICartDto extends Dto {
	public String getGoodsname();
	public String getGoodscode();

	public int getQty();

	public String getCartPrice();
	public String getCartTotalPrice();
	public String getCategory();
	public String getImgPath();
	public int getCatPriceInt();
}
