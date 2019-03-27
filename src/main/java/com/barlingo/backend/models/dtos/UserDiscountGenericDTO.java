package com.barlingo.backend.models.dtos;

import lombok.Data;

@Data
public class UserDiscountGenericDTO {
	
	private String code;
	private Boolean exchanged;
	private Boolean isVisible;
	private int userId;
	private int langExchangeId;

}
