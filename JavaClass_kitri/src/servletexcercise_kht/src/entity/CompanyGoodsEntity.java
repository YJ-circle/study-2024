package entity;

public class CompanyGoodsEntity {
	private  CompanyEntity ce;
	private GoodsEntity ge;

	public CompanyGoodsEntity() {
	}

	public CompanyGoodsEntity(CompanyEntity ce, GoodsEntity ge) {
		this.ce = ce;
		this.ge = ge;
	}

	public CompanyEntity getCe() {
		return ce;
	}

	public void setCe(CompanyEntity ce) {
		this.ce = ce;
	}

	public GoodsEntity getGe() {
		return ge;
	}

	public void setGe(GoodsEntity ge) {
		this.ge = ge;
	}

}
