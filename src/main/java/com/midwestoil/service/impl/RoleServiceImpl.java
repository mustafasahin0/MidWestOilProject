package com.midwestoil.service.impl;

import com.midwestoil.dto.RoleDTO;
import com.midwestoil.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<Long, RoleDTO> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
