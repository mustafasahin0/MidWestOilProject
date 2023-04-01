package com.midwestoil.service.impl;

import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractMapService<String, UserDTO> implements UserService {

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
}
