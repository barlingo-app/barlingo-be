package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController {

  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private EstablishmentMapper establishmentMapper;

  @GetMapping("")
  public List<EstablishmentGenericDTO> findAllEstablishments() {
    return this.establishmentMapper.establishmentsToDtos(this.establishmentService.findAll());
  }

  @GetMapping("/{estId}")
  public EstablishmentDetailsDTO show(@PathVariable int estId) {
    return this.establishmentMapper.establishmentToDto(this.establishmentService.findById(estId));
  }

}
