package com.barlingo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.ConfigurationDTO;
import com.barlingo.backend.models.mapper.ConfigurationMapper;
import com.barlingo.backend.models.services.IConfigurationService;
import com.barlingo.backend.utilities.ResponseBody;

@RestController
@RequestMapping("/configuration")
public class ConfigurationRestController extends AbstractRestController {

  @Autowired
  private IConfigurationService configurationService;
  @Autowired
  private ConfigurationMapper configMapper;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<ResponseBody> show() {
    ResponseEntity<ResponseBody> result;
    try {
      ConfigurationDTO config = this.configMapper.entityToDto(this.configurationService.find());
      result = this.createResponse(config);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }
}
