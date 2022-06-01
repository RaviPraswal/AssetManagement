package com.adj.amgmt.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.dto.AccessoryIssueDTO;
import com.adj.amgmt.entity.AccessoryIssue;
import com.adj.amgmt.repository.AccessoryIssueRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class AccessoryIssueServiceImpl implements AccessoryIssueService {

	@Autowired
	AccessoryIssueRepository accessoryIssueRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<AccessoryIssueDTO> getAccessoryIssuesList() {

		List<AccessoryIssue> accessoryIssueList = accessoryIssueRepository.findAll();
//		List<AccessoryIssueDTO> accessoryIssueListDTO = Arrays.asList(modelMapper.map(accessoryIssueList, AccessoryIssueDTO.class));
		List<AccessoryIssueDTO> accessoryIssueListDTO = modelMapper.map(accessoryIssueList,
				((TypeToken<List<AccessoryIssueDTO>>) new TypeToken<List<AccessoryIssueDTO>>() {
				}).getType());
		return accessoryIssueListDTO;
	}

	public void saveAccessoryIssue(AccessoryIssueDTO accessoryIssueDTO) {
		AccessoryIssue accessoryIssue = modelMapper.map(accessoryIssueDTO, AccessoryIssue.class);
		accessoryIssueRepository.saveAndFlush(accessoryIssue);
	}

	public void deleteAccessoryIssueById(int id) {
		accessoryIssueRepository.deleteById(id);

	}

	public void updateAccessoryIssue(AccessoryIssue accessoryIssues) {
		accessoryIssueRepository.saveAndFlush(accessoryIssues);

	}

	public AccessoryIssueDTO getAccessoryIssueById(int accessoryIssueId) {
		AccessoryIssue accessoryIssue = accessoryIssueRepository.getReferenceById(accessoryIssueId);
		AccessoryIssueDTO accessoryIssueDTO = modelMapper.map(accessoryIssue, AccessoryIssueDTO.class);
		return accessoryIssueDTO;
	}

}
