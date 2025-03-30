package dto;

import entity.IEntity;

public interface Dto {
	<E extends IEntity> void setDto(E entity);
}
