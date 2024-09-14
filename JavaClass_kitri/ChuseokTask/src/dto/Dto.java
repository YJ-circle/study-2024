package dto;

import entity.IEntity;

public interface Dto {
	<T extends IEntity> void setDto(T entity);

}
