package com.midwestoil.service.impl;

import com.midwestoil.dto.RoleDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }

    public List<UserDTO> findEmployees() {
       return findAll().stream().filter(each -> each.getRole().getDescription() == "Employee").collect(Collectors.toList());
    }
}
