package dto.impl;

import dto.Dto;
import dto.IMemberDto;
import entity.IEntity;
import entity.MemberEntity;
import error.DtoConvertError;

public class MemberDto implements IMemberDto{
	private String id;
	private String name;
	private String address;

	@Override
	public <E extends IEntity> void setDto(E entity) {
		if(!(entity instanceof MemberEntity)) {
			throw new DtoConvertError("DTO 변환 실패: 타입 불일치", entity);
		}
		MemberEntity member = (MemberEntity) entity;
		this.id = member.getId();
		this.name = member.getName();
		this.address = member.getAddress();
		
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getAddress() {
		return address;
	}

}
