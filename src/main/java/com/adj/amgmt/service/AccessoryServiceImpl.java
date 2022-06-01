package com.adj.amgmt.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AccessoryDTO;
import com.adj.amgmt.dto.AccessoryIssueDTO;
import com.adj.amgmt.entity.Accessory;
import com.adj.amgmt.repository.AccessoryRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AccessoryServiceImpl implements AccessoryService {

	@Autowired
	AccessoryRepository accessoryRepository;
	
//	@Autowired
//	AccessoryRepositoryImpl accessoryRepository;

	@Autowired
	AccessoryIssueService accessoryIssueService;

	@Autowired
	ModelMapper modelMapper;

	public void saveAccessory(AccessoryDTO accessoryDTO) {

		Accessory accessory = modelMapper.map(accessoryDTO, Accessory.class);
		accessory.setFileName(accessoryDTO.getFile().getOriginalFilename());
		accessoryRepository.saveAndFlush(accessory);

	}

	public boolean deleteAccessoryBySkuId(int id) {

		List<AccessoryIssueDTO> accessoryIssuesList = accessoryIssueService.getAccessoryIssuesList();
		boolean flag = false;
		for (AccessoryIssueDTO accessoryIssueDTO : accessoryIssuesList) {
			Accessory accessory = accessoryIssueDTO.getAccessory();
			if (accessory.getId() == id) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			accessoryRepository.deleteById(id);
			return true;
		}
		return false;

	}

	public void updateAccessory(Accessory accessory) {
		accessoryRepository.saveAndFlush(accessory);

	}

	public List<AccessoryDTO> getAccessoryList() {
		List<Accessory> accessoryList = accessoryRepository.findAll();
		List<AccessoryDTO> accessoryListDTO = Arrays.asList(modelMapper.map(accessoryList, AccessoryDTO[].class));
		return accessoryListDTO;
	}

	public AccessoryDTO getAccessoryById(int accessoryId) {

		Accessory accessory = accessoryRepository.getById(accessoryId);
		AccessoryDTO accessoryDTO = modelMapper.map(accessory, AccessoryDTO.class);
		return accessoryDTO;
	}

}
