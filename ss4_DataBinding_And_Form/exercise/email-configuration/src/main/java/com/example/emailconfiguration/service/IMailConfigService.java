package com.example.emailconfiguration.service;

import com.example.emailconfiguration.model.MailConfig;

import java.util.List;

public interface IMailConfigService {
    List<MailConfig> getAll();
}
