package dto;

public class MemberInfoDto {
		private String id;
		private String name;
		private int coupon;
		private int mile;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCoupon() {
			return coupon;
		}
		public void setCoupon(int coupon) {
			this.coupon = coupon;
		}
		public int getMile() {
			return mile;
		}
		public void setMile(int mile) {
			this.mile = mile;
		}
}
