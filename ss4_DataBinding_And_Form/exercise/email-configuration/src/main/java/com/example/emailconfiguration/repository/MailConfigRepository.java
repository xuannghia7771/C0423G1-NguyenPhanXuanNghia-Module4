package com.example.emailconfiguration.repository;

import com.example.emailconfiguration.model.MailConfig;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailConfigRepository implements IMailConfigRepository{
    static List<MailConfig> mailConfigList = new ArrayList<>();
    static {
        mailConfigList.add(new MailConfig("English","5","Enable spam filter","xzczxc"));
        mailConfigList.add(new MailConfig("Chinese","50","Enable spam filter","xzczxc"));
        mailConfigList.add(new MailConfig("Vietnamese","25","Enable spam filter","xzczxc"));
        mailConfigList.add(new MailConfig("Japanese","100","Enable spam filter","xzczxc"));
    }
    public List<MailConfig> getAll(){
        return mailConfigList;
    }
}
