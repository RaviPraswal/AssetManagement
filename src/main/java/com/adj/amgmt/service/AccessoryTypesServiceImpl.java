package com.adj.amgmt.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.dto.AccessoryTypesDTO;
import com.adj.amgmt.entity.AccessoryTypes;
import com.adj.amgmt.repository.AccessoryTypeRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AccessoryTypesServiceImpl implements AccessoryTypeService{

	@Autowired
	AccessoryTypeRepository accessoryTypesRepository;
	
	/*
	 * @Autowired AccessoryTypesRepositoryImpl accessoryTypesRepository;
	 */

	@Autowired
	AccessoryService accessoryService;

	@Autowired
	ModelMapper modelMapper;

	public void saveAccessoryType(AccessoryTypesDTO accessoryTypeDTO) {
		AccessoryTypes accessoryType = modelMapper.map(accessoryTypeDTO, AccessoryTypes.class);
		accessoryTypesRepository.saveAndFlush(accessoryType);
	}

	public boolean deleteAccessoryTypeById(int id) {

		List<AccessoryDTO> accessoryList = accessoryService.getAccessoryList();
		boolean flag = false;
		for (AccessoryDTO accessoryDTO : accessoryList) {
			if (accessoryDTO.getAccessoryType().getId() == id) {
				flag = true;// it means we have a mapping of accessory with accessory type
				break;
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			accessoryTypesRepository.deleteById(id);
			return true;
		}
		return false;

	}

	public void updateAccessoryType(AccessoryTypes accessoryType) {
		accessoryTypesRepository.saveAndFlush(accessoryType);

	}

	public List<AccessoryTypesDTO> getAccessoryTypeList() {
		List<AccessoryTypes> accessoryTypeList = accessoryTypesRepository.findAll();
		// List<AccessoryTypesDTO> accessoryTypeListDTO =
		// Arrays.asList(modelMapper.map(accessoryTypeList, AccessoryTypesDTO.class));

		List<AccessoryTypesDTO> accessoryTypeListDTO = modelMapper.map(accessoryTypeList,
				((TypeToken<List<AccessoryTypesDTO>>) new TypeToken<List<AccessoryTypesDTO>>() {
				}).getType());

		return accessoryTypeListDTO;
	}

	public AccessoryTypesDTO getAccessoryTypeId(int accessoryTypeId) {
		AccessoryTypes accessoryType = accessoryTypesRepository.getById(accessoryTypeId);
		AccessoryTypesDTO accessoryTypeDTO = modelMapper.map(accessoryType, AccessoryTypesDTO.class);
		return accessoryTypeDTO;
	}
}
