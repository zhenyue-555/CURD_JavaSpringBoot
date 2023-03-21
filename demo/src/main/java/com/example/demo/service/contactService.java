package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Contact;

public interface contactService {
    public List<Contact> getAllContatcs();
    public Contact getContactById(long id);
    public Contact addcontact(Contact contact);
    public Contact updateContact(Contact contact, long id);
    public void deleteContact(long id);
    
    
}
