package com.i2i.ievolv.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.ievolv.dto.DesignationDTO;
import com.i2i.ievolv.entities.Designation;
import com.i2i.ievolv.repository.DesignationRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesignationService {

    DesignationRepository designationRepository;

    ObjectMapper mapper = new ObjectMapper();

    public DesignationDTO findDesignationById(Long id) {
        Optional<Designation> designation = designationRepository.findById(id);
        if(designation.isPresent()) {
            return mapper.convertValue(designation.get(), DesignationDTO.class);
        }
        return null;
    }

    public List<DesignationDTO> findDesignations() {
        List<Designation> designationList = designationRepository.findAll();
        if(!designationList.isEmpty()) {
            return designationList.stream().map(designation -> mapper.convertValue(designation, DesignationDTO.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public DesignationDTO createDesignation(DesignationDTO designationDTO) {
        Designation saved = designationRepository.save(mapper.convertValue(designationDTO, Designation.class));
        return mapper.convertValue(saved, DesignationDTO.class);
    }
}
