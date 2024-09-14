package dto;

import entity.IEntity;
import entity.MemberEntity;
import error.DtoConvertError;

public class MemberDto implements Dto{
	private String id;
	private String name;
	private String address;

	@Override
	public <T extends IEntity> void setDto(T entity) {
		if(!(entity instanceof MemberEntity)) {
			throw new DtoConvertError("DTO 변환 실패", entity);
		}
		MemberEntity member = (MemberEntity) entity;
		this.id = member.getId();
		this.name = member.getName();
		this.address = member.getAddress();
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	


}
