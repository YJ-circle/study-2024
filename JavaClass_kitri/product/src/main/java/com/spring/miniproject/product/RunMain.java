package com.spring.miniproject.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.miniproject.product.config.TestUser;
import com.spring.miniproject.product.dao.IGoodsDao;
import com.spring.miniproject.product.dto.GoodsDto;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.service.IGoodsSvc;
import com.spring.miniproject.product.service.IOrderSvc;

public class RunMain {
	private static ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext("classpath:/com/spring/miniproject/product/"
					                         + "config/config.xml");
	private static Scanner sc = new Scanner(System.in);
	private static String userid; 
	private static TestUser testUser = TestUser.getInstance();
	private static IGoodsSvc goodsSvc;
	private static IOrderSvc orderSvc;
	
	
	
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
					case 6: /* 회원ID로 주문 조회 */
							  getOrderByUserId(); break;
					case 7: /* 로그아웃 */
						    System.out.println("로그아웃합니다\n");
					        userid = null; break;
				}
			} else {login();}	
		}
	}

	/* 사용하는 서비스 Bean을 가져옵니다. */
	private static void getServiceBean() {
		goodsSvc = (IGoodsSvc) ctx.getBean("goodsSvc");
		orderSvc = (IOrderSvc) ctx.getBean("orderSvc");
		OrderCart.setGoodsDao((IGoodsDao) ctx.getBean("goodsDao"));
	}

	/* 로그인 여부 체크*/
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
	
	/* 로그인 */
	private static void login() {
		
		System.out.println("\n\n== 로그인 메뉴 ==");
		// 로그인이 성공할 때까지 반복
		while(true) { 
			System.out.println("테스트ID : hong, park 중 선택하세요\n"
							 + "-1을 입력하면 프로그램을 종료합니다");
			
			String inputId = inputString("아이디를 입력하세요:");
			
			// -1을 입력하면 프로그램 종료
			if("-1".equals(inputId)) {exit();}
			
			//등록된 아이디이면, 로그인 성공
			if(testUser.getUser(inputId)!=null) { 
				userid = inputId;
				System.out.println(
								String.format("%n"
						        + "==== 환영합니다 %s님 ====",
						        testUser.getUser(inputId).getName())
						        );
				break;
			}
			
			//등록되지 않은 아이디이면 메시지 출력
			System.out.println("없는 아이디 입니다.");
		}
		
		
	}
	
	/* 메인 메뉴 출력 */
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
		printList("전체 상품 조회 결과", goodsList);
	}

	/* 상품 id 조회 */
	private static void getProductById() {
		int goodsId = inputInt("상품ID입력 (ex: 34): ");
		if(goodsId == -1) {
			return;
		}
		System.out.println(goodsSvc.getGoodsById(goodsId));
	}
	
	/* 상품 추가 */
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

	/* 상품 주문 */
	private static void orderGoods() {

		List<OrderCart> orderList = new ArrayList<>();
		while(true) {
			System.out.println("-1가 입력되면 상품 담기가 종료 되고 주문 됩니다.");
			
			int userInputGoods = inputInt("상품 id: ");
			
			if(userInputGoods == -1 ) { break;}
			int userInputQty = inputInt("상품 수량: ");
			OrderCart cart;
			if((cart = OrderCart.addCart(userid, userInputGoods, userInputQty)) == null) {
				System.out.println("선택한 상품은 재고가 부족합니다");
			}
			orderList.add(cart);
			System.out.println("상품을 장바구니에 담았습니다.");
		}
		
		if(orderList.size() == 0) {
			System.out.println("주문 실패..\n");
			System.out.println("주문할 상품이 없습니다.");
			return;
		}
		
		if(orderSvc.insertOrder(orderList)) {
			System.out.println("주문 성공!");
		} else {
			System.out.println("주문 실패..");
		}
	}
	
	/* 주문 전체 조회 */
	private static void getOrderAll() {
		printList("주문 전체 조회", orderSvc.getOrderAll());
	}

	/* 회원ID로 주문 조회 */
	private static void getOrderByUserId() {
		String userId = inputString("사용자 ID입력: ");
		if("-1".equals(userId)) {return;}
		printList("사용자 주문 정보", orderSvc.getOrderById(userId));
	}
	
	
	/* 프로그램 종료 */
	private static void exit() {
		if(sc!=null) {
			sc.close();
		}
		System.out.println("\n\n프로그램을 종료 합니다.");
		System.exit(0);
	}

	/***
	 * Scanner 클래스를 이용하여, 사용자에게 문자를 입력 받습니다.<br/><br/>
	 * 출력 예시: <br/>
	 * 문자를 입력하세요: Scanner.nextLine()
	 * @param message 입력 전 출력할 메시지
	 * @return String 사용자가 입력한 문자
	 * 
	 * <pre>
	 * inputInt("문자를 입력하세요: ");
	 * </pre>
	 */
	private static String inputString(String message) {
			System.out.print(message);
			return sc.nextLine();	
		
	}
	
	/***
	 * Scanner 클래스를 이용하여, 사용자에게 숫자를 입력 받습니다.<br/><br/>
	 * 출력 예시: <br/>
	 * 숫자를 입력하세요: Scanner.nextInt()
	 * @param message 입력 전 출력할 메시지
	 * @return int 사용자가 입력한 숫자
	 * 
	 * <pre>
	 * inputInt("숫자를 입력하세요: ");
	 * </pre>
	 */
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
	
	/***
	 * 조회 결과 LIST를 출력합니다. <br/><br/>
	 * 출력 예시: <br/>
	 * 목록 출력  <br/>
	 * ======================= <br/>
	 * GoodsDto.toString()
	 * 
	 * <pre>
	 * List<GoodsDto> list = new ArrayList<GoodsDto>();
	 * list.add(new GoodsDto);
	 * printList("목록 출력", GoodsDto);
	 * </pre>
	 * @param preOutputMessage
	 *        List 출력 전에 콘솔에 먼저 출력할 내용을 입력합니다.
	 * @param list
	 *        Dto 객체가 담긴 list
	 * @since 2024.10.18
	 * @author 함예정
	 */
	private static <T> void printList(String preOutputMessage, List<T> list) {
		System.out.println("\n"+preOutputMessage);
		System.out.println("=======================");
		list.sort(null);
		for (T t : list) {
			System.out.println(t);
			System.out.println("---------------------");
		}
		
	}
}
