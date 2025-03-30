package com.kitri.spring.aspect01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kitri.spring.aspect01.dto.Member;

@Component("productSvc")
public class ProductServiceImpl implements IProductService{
	private static List<Member> memberList;
	
	static {
		memberList = new ArrayList<Member>();
		memberList.add(new Member("test1", "test1"));
		memberList.add(new Member("test2", "test2"));
		memberList.add(new Member("test3", "test3"));
	}
	@Override
	public int multiply(int num1, int num2) {
		return num1*num2;
	}

	@Override
	public List<Member> doSomething() {
		System.out.println(" === 수정 전 ===");
		for (Member member : memberList) {
			System.out.println(member);
		}
		// TODO Auto-generated method stub
		return ProductServiceImpl.memberList;
	}

}
