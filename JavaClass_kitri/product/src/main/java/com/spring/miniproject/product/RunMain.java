package com.spring.miniproject.product;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.miniproject.product.config.TestUser;
import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.service.IGoodsSvc;
import com.spring.miniproject.product.service.IOrderSvc;

public class RunMain {
	/* 6시간 */
	private static String userid;
	private static TestUser testUser = new TestUser();
	private static IGoodsSvc goodsSvc;
	private static IOrderSvc orderSvc;
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		getServiceBean();
		while(true) {
			if(loginCheck()) {
				switch(printMainMenu()) {
				case 1: /* 상품 전체 조회*/
					      getProductAll(); break;
				case 2: /* 상품 id 조회 */
						  getProductById(); break;
				case 3: /* 상품 추가 */
					      addGoods(); break;
					      
				case 4: /* 상품 주문 */
					      orderGoods(); break;
					      
				case 5: /* 전체 주문 조회 */
					      getOrderAll(); break;
					      
				case 7: /* 로그아웃 */
					    System.out.println("로그아웃합니다\n");
				        userid = null; break;
				}
			} else {
				login();
			}	
		}
	}
	


	private static void getServiceBean() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/spring/miniproject/product/config/config.xml");
		goodsSvc = (IGoodsSvc) ctx.getBean("goodsSvc");
		orderSvc = (IOrderSvc) ctx.getBean("orderSvc");
	}



	/* 메인 메뉴 */
	private static int printMainMenu() {
		System.out.println("1. 상품 전체 조회");
		System.out.println("2. 상품 id 조회");
		System.out.println("3. 상품 추가");		
		System.out.println("4. 상품 주문");
		System.out.println("5. 전체 주문 조회");
		System.out.println("6. 회원 주문 조회");
		System.out.println("7. 로그아웃");
		System.out.println("-1. 종료");		
		
		int userInput = inputInt("\n원하는 메뉴 번호를 입력하세요: ");
		if(userInput == -1) {
			exit();
		}
		return userInput;
		
	}
	
	/* 상품 전체 조회 */
	private static void getProductAll() {
		List<GoodsDto> goodsList = goodsSvc.getGoodsAll();
		System.out.println(goodsList);
	}

	/* 상품 id 조회 */
	private static void getProductById() {
		int goodsId = inputInt("상품ID입력 (ex: 34): ");
		if(goodsId == -1) {
			return;
		}
		System.out.println(goodsSvc.getGoodsById(goodsId));
	}
	
	private static void addGoods() {
		/* 상품 추가 하기 */
		System.out.println("=== 상품 추가 메뉴 ===");
		String name = inputString("상품명: ");
		String category = inputString("카테고리: ");
		int price = inputInt("가격: ");
		
		if(price == -1) {
			return;
		}
		
		int stock = inputInt("재고: ");
		if(stock == -1) {
			return;
		}
		if(goodsSvc.insertGoods(name, category, price, stock)) {
			System.out.println("추가 성공");
		} else { System.out.println("추가 실패");}
	}

	private static void orderGoods() {
		
		OrderCart cart = new OrderCart();
		cart.setUserId(userid);
		while(true) {
			System.out.println("-1가 입력되면 상품 담기가 종료 되고 주문 됩니다.");
			
			int userInput = inputInt("상품 id: ");
			if(userInput == -1 ) {
				break;
			}
			cart.addCart(userInput,
					     inputInt("상품 수량: "));
			System.out.println();
		}
		
		if(orderSvc.insertOrder(cart)) {
			System.out.println("주문 성공!");
		} else {
			System.out.println("주문 실패..");
		}
	}
	
	private static void getOrderAll() {
		System.out.println(orderSvc.getOrderAll());
	}






	private static boolean loginCheck() {
		if(userid == null) {
			System.out.println(" ==== 어서 오세요 ====");
			System.out.println("로그인 후 이용 가능합니다.");
			return false;
		}
		else {
			inputString("계속 하려면 아무키나 입력하세요");
			System.out.println("메뉴를 선택하세요");
			return true;
		}
		
	}
	
	private static void exit() {
		if(sc!=null) {
			sc.close();
		}
		
		System.out.println("\n\n프로그램을 종료 합니다.");
		System.exit(0);
	}
	
	private static void login() {
		System.out.println("\n\n== 로그인 메뉴 ==");
		while(true) {
			System.out.println("테스트ID : hong, park 중 선택하세요\n"
							 + "-1을 입력하면 프로그램을 종료합니다");
			String inputId = inputString("아이디를 입력하세요:");
			if("-1".equals(inputId)) {
				exit();
			}
			if(testUser.getUser(inputId)!=null) {
				userid = inputId;
				System.out.println("\n ==== 환영합니다 " + 
				                   testUser.getUser(inputId).getName() 
				                   + "님 ====");
				break;
			}
			System.out.println("없는 아이디 입니다.");
		}
		
		
	}
	private static String inputString(String message) {
			System.out.print(message);
			return sc.nextLine();	
		
	}
	private static int inputInt(String message) {
		try{
			System.out.print(message);
			int userInput = sc.nextInt();
			sc.nextLine();
			return userInput;
		} catch (Exception e) {
			System.out.println("잘못 입력하였습니다.");
			return -1;
		}
	}
	

	


}
