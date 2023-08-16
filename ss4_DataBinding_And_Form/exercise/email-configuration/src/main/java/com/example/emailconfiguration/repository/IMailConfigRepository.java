package com.example.emailconfiguration.repository;

import com.example.emailconfiguration.model.MailConfig;

import java.util.List;

public interface IMailConfigRepository {
    List<MailConfig> getAll();
}
