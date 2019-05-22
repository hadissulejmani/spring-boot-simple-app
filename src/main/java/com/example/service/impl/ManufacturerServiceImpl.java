package com.example.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Manufacturer;
import com.example.repository.ManufacturerRepository;
import com.example.service.ManufacturerService;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerRepository repo;

    public ManufacturerServiceImpl(ManufacturerRepository repo) {
        this.repo = repo;
    }


    @Override
    public Manufacturer save(Manufacturer m) {
        return repo.save(m);
    }

    @Override
    public Optional<Manufacturer> findByManID(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Manufacturer> getAll(){
        return repo.findAll();
    };
}
