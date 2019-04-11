package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.forms.UserEdit;
import com.barlingo.backend.models.forms.UserSignin;
import java.util.List;
import org.springframework.validation.BindingResult;

public interface IAdminService {

  Admin findById(Integer id);

}
