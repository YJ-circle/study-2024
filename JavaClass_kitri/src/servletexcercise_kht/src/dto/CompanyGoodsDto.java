package dto;

public class CompanyGoodsDto {
	private String comName;
	private String representative;
	private String cd;
	private String goodsName;

	public CompanyGoodsDto() {}
	public CompanyGoodsDto(String comName, String representative, String cd, String goodsName) {
		this.comName = comName;
		this.representative = representative;
		this.cd = cd;
		this.goodsName = goodsName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
