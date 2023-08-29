package com.example.phone_management_ajax_webservice.service;

import com.example.phone_management_ajax_webservice.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartPhone);
    void remove(Long id);
}
