package com.kitri.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpSession;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private ApplicationContext context;
	private MemberDao dao;
	

	private PostDao postDao;
	
//	@BeforeEach
//	void init() {
//		dao = context.getBean(MemberDao.class);
//	}
	
	@Test
	@Transactional
	void getPost() throws InterruptedException {
		postDao = context.getBean(PostDao.class);
		List<Post> findAll = postDao.findAll();
		System.out.println(findAll.get(0).getId());
		System.out.println();
		System.out.println("== 자유게시판 Entity 출력 ==");
		System.out.println(findAll.get(0).getBoard());
		System.out.println();
		System.out.println("작성자 이름 출력");
		System.out.println(findAll.get(0).getWrtier().getName());
	}
	public void printList() {
		

	}
//	@Test
//	void customTest() {
//		
//		System.out.println(" === 전체 데이터 출력 ===");
//		printList((List<MemberEntity>) dao.findAll());
//		
//		System.out.println(" === (이름 = 박길동)으로 조회 ==");
//		printList(dao.findByName("박길동"));
//		
//		
//		System.out.println("=== testCol이 5이상 + active Y ===");
//		printList(dao.findByTestcolGreaterThanEqualAndActive(5,"Y"));
//		
//		System.out.println("=== 이름 박길동 + 주소 길동이집 ===");
//		printList(dao.findByNameAndAddress("박길동", "길동이집"));
//		
//		System.out.println("=== 이름 박길동 또는 이메일 a@test.com ===");
//		printList(dao.findByNameOrEmail("박길동", "a@test.com"));
//		
//		System.out.println("=== (testCol 5이하 + Active Y)  OR (주소 길동이집) ===");
//		printList(dao.findByTestcolLessThanEqualAndActiveOrAddress(5, "Y", "길동이집"));
//		
//		System.out.println("=== testCol 5이상, active Y, 이메일 a 포함===");
//		printList(dao.findByTestcolGreaterThanEqualAndActiveAndEmailContaining(5, "Y", "a"));
//		
//		System.out.println("=== 아이디 id + 이름 홍길동===");
//		printList(dao.findByIdAndName("id", "홍길동"));
//		
//		
//	}
//	
//	private void printList(List<MemberEntity> list) {
//		for (MemberEntity memberEntity : list) {
//			System.out.println();
//			System.out.println("아이디 = " + memberEntity.getId());
//			System.out.println("패스워드 = " + memberEntity.getPassword());
//			System.out.println("이름 = " + memberEntity.getName());
//			System.out.println("이메일 = " + memberEntity.getEmail());
//			System.out.println("전화번호 = " + memberEntity.getTel());
//			System.out.println("주소 = " + memberEntity.getAddress());
//			System.out.println("active = " + memberEntity.getActive());
//			System.out.println("addCol = " + memberEntity.getTestcol());
//			System.out.println();
//		}
//	}
//	//1. 데이터베이스 입력
//	@Test
//	void saveBoard() throws InterruptedException {
//		System.out.println("1. 데이터베이스 입력");
//		System.out.println("아이디: 8");
//		System.out.println("이  름: 테스트 게시판");
//		BoardEntity entity = new BoardEntity();
//		entity.setId(8);
//		entity.setName("테스트 게시판");
//		Dao dao = context.getBean(Dao.class);
//		dao.save(entity);
//		System.out.println("=== 입력 완료 ===");
//		System.out.println();
//
//	}
//	
//	
//	//2. 기본 키 조회
//	@Test
//	void findBoard() {
//		System.out.println("2. 기본키 조회");
//		System.out.println(dao.findById(8).orElse(new BoardEntity(2,"없음")));
//
//	}
	
	//3. 업데이트
	// 특정 필드 값이 변경하고 호출, 세터를 이용해 변경
//	@Test
//	void update() {
//		System.out.println("3. 데이터베이스 입력");
//		System.out.println(" == 업데이트 == ");
//		System.out.println("아이디: 8");
//		System.out.println("이  름: 수정된 테스트 게시판");
//		BoardEntity entity = new BoardEntity();
//		entity.setId(8);
//		entity.setName("수정된 테스트 게시판");
//		Dao dao = context.getBean(Dao.class);
//		dao.save(entity);
//		System.out.println("=== 수정 완료 ===");
//		System.out.println();
//	}
//	
//	4. 테스트
//	@Test
//	void findAll() {
//		System.out.println(" == 모두 조회 == ");
//		Iterable<BoardEntity> findAll = dao.findAll();
//		for (BoardEntity boardEntity : findAll) {
//			
//			System.out.println("게시판 아이디: " + boardEntity.getId());
//			System.out.println("게시판 이  름: " + boardEntity.getName());
//			
//		}
//		System.out.println("== 조회 완료");
//		
//		
//	}
	
//	//5. 삭제
//	@Test
//	void delete() {
//		System.out.println(" == 삭제 == ");
//		dao.deleteById(8);
//	System.out.println("== 삭제 완료===");
//	}

}
