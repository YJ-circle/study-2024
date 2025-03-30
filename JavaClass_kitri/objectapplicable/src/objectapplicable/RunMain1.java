package objectapplicable;

import java.util.Optional;

import objectapplicable.dto.TestDto1;
import objectapplicable.dto.TestDto2;
import objectapplicable.entity.TestEntity1;
import objectapplicable.entity.TestEntity2;
import objectapplicable.utils.DtoUtils;

public class RunMain1 {
	public static void main(String[] args) {
		TestEntity1 testEntity1 =  new TestEntity1(1, "2");
		TestEntity2 testEntity2 =  new TestEntity2(1, "2");
		TestDto1 testDto1 = (TestDto1) DtoUtils.convertEntityToDto(testEntity1, new TestDto1());
		TestDto2 testDto2 = (TestDto2) DtoUtils.convertEntityToDto(testEntity2, new TestDto2());
		
		System.out.println("testDto1 = " + testDto1);
		System.out.println("testDto2 = " + testDto2);
		
		
		
		
	}

}
