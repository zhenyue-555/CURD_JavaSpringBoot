package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Contact;
import com.example.demo.repository.contactRepo;

@Service
public class contactServiceImp implements contactService {
    
    contactRepo contactrepo;
    public contactServiceImp(contactRepo contactrepo) {
        this.contactrepo = contactrepo;
    }

    @Override
    public List<Contact> getAllContatcs(){
        List<Contact> contacts = new ArrayList<>();   
        contactrepo.findAll().forEach(contacts::add);
        return contacts;
    }

    @Override
    public Contact getContactById(long id){
        return contactrepo.findById(id).get();
    }

    @Override
    public Contact addcontact(Contact contact){
        return contactrepo.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, long id){
        Contact contact1 = contactrepo.findById(id).get();
        contact1.setFirstName(contact.getFirstName());
        contact1.setLastName(contact.getLastName());
        contact1.setEmail(contact.getEmail());
        contact1.setPhone(contact.getPhone());
        contact1.setAddress(contact.getAddress());
        return contactrepo.save(contact1);
    }
    
    @Override
    public void deleteContact(long id){
        contactrepo.deleteById(id);
    }


    
}
