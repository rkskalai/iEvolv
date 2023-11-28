package com.i2i.ievolv.controller;

import com.i2i.ievolv.dto.CategoryDTO;
import com.i2i.ievolv.dto.DesignationDTO;
import com.i2i.ievolv.services.CategoryService;
import com.i2i.ievolv.services.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/designation")
public class DesignationController {

    @Autowired
    DesignationService designationService;

    @GetMapping(path = "/", params = {"id"})
    public ResponseEntity<DesignationDTO> getDesignationById(@RequestParam final Long id) {
        DesignationDTO designationDTO = designationService.findDesignationById(id);
        return new ResponseEntity<>(designationDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<DesignationDTO>> getAllDesignations() {
        List<DesignationDTO> designationDTOList = designationService.findDesignations();
        return new ResponseEntity<>(designationDTOList, HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<DesignationDTO> createDesignation(@RequestBody DesignationDTO designationDTO) {
        DesignationDTO savedDesignation = designationService.createDesignation(designationDTO);
        return new ResponseEntity<>(savedDesignation, HttpStatus.CREATED);
    }
}
