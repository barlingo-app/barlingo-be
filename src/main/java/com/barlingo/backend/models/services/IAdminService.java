package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.Admin;

public interface IAdminService {

  Admin findById(Integer id);

}
