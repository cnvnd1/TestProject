package com.logic;


import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.DTO;

public interface DTOFactory {
	public DTO makeDTO(String type,BeaconWithUserIdDTO dto) throws InvalidDTOType;
}
