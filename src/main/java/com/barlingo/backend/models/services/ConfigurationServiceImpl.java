package com.barlingo.backend.models.services;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.models.entities.Configuration;
import com.barlingo.backend.models.repositories.ConfigurationRepository;

@Service
@Transactional
public class ConfigurationServiceImpl implements IConfigurationService {


  @Autowired
  private ConfigurationRepository configRepository;


  @Override
  public Configuration find() {
    Collection<Configuration> configurations = this.configRepository.findAll();
    return configurations.iterator().next();
  }

}
