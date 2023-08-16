package com.example.emailconfiguration.service;

import com.example.emailconfiguration.model.MailConfig;
import com.example.emailconfiguration.repository.IMailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailConfigService implements IMailConfigService{
    @Autowired
    private IMailConfigRepository repository;

    @Override
    public List<MailConfig> getAll() {
        return repository.getAll();
    }
}
