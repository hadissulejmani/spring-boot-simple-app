package com.example.service;

import com.example.models.Manufacturer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

public interface ManufacturerService {
    Manufacturer save(Manufacturer m);
    Optional<Manufacturer> findByManID(Long id);
    List<Manufacturer> getAll();
}

