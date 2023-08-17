package com.example.emailconfiguration.repository;

import com.example.emailconfiguration.model.MailConfig;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailConfigRepository implements IMailConfigRepository{
    static List<MailConfig> mailConfigList = new ArrayList<>();
    static {
        mailConfigList.add(new MailConfig(1,"English","5","Enable Spam","asdzxc"));
        mailConfigList.add(new MailConfig(2,"Vietnamese","100","Enable Spam","asdzxc"));
        mailConfigList.add(new MailConfig(3,"English","50","Enable Spam","zxcasd"));
        mailConfigList.add(new MailConfig(4,"Japanese","25","Enable Spam","vbnfgh"));
        mailConfigList.add(new MailConfig(5,"Chinese","10","Enable Spam","yiyu"));
    }
    @Override
    public List<MailConfig> getAll() {
        return mailConfigList;
    }

    @Override
    public MailConfig findById(int id) {
        for (MailConfig mailConfig : mailConfigList){
            if (mailConfig.getId()==id){
                return mailConfig;
            }
        }
        return null;
    }

    @Override
    public void edit(int id, MailConfig mailBox) {
        for (MailConfig mailConfig : mailConfigList){
            if (mailConfig.getId() == id){
                mailConfig.setLanguages(mailBox.getLanguages());
                mailConfig.setPageSize(mailBox.getPageSize());
                mailConfig.setSpam(mailBox.getSpam());
                mailConfig.setSignature(mailBox.getSignature());
            }
        }
    }

}
