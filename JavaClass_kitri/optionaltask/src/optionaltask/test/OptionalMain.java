package optionaltask.test;

public class OptionalMain {
	private static HouseService svc = new HouseService();
	public static void main(String[] args) {
		
		
		// 1. 집주인(이름), 주소 모두 있는 경우

		House house1 = new House();
		svc.setOwner(house1, "집주인");
		svc.setAddress(house1, "서울시 구로구 좋은집");
		
		System.out.println("첫번째 집 = " + svc.getOwnerName(house1));
		System.out.println("첫번째 집 = " +svc.getAddress(house1));
		
		System.out.println();
		// 2. 집주인 없이(객체, 집주인 이름) 주소만 있는 경우
		
		House house2 = new House();
		svc.setAddress(house2, "서울시 구로구 좋은집");
		
		System.out.println("두번째 집 = " +svc.getOwnerName(house2));
		System.out.println("두번째 집 = " +svc.getAddress(house2));
		
		System.out.println();
		
		// 3. 집주인 있으나, 집주소 없는 경우
		
		
		
		House house3 = new House();
		svc.setOwner(house3, "집주인");
		
		System.out.println("세번째 집 = " +svc.getOwnerName(house3));
		System.out.println("세번째 집 = " +svc.getAddress(house3));
		
		System.out.println();
		
	}

}
