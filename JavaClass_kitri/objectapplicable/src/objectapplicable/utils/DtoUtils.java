package objectapplicable.utils;

import objectapplicable.dto.TestDto1;
import objectapplicable.dto.TestDto2;
import objectapplicable.entity.TestEntity1;
import objectapplicable.entity.TestEntity2;

public class DtoUtils {
	
	public static Object convertEntityToDto(Object entity, Object dto) {
		
		if(entity instanceof TestEntity1) {
			TestEntity1 source = (TestEntity1) entity;
			((TestDto1) dto).setA(source.getA());
			((TestDto1) dto).setB(source.getB());
		} else if (entity instanceof TestEntity2) {
			TestEntity2 source = (TestEntity2) entity;
			((TestDto2) dto).setA(source.getA());
			((TestDto2) dto).setB(source.getB());
		}
		return dto;
		
	}
}
