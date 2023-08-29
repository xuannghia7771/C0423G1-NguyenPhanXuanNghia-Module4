package com.example.phone_management_ajax_webservice.repository;

import com.example.phone_management_ajax_webservice.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
