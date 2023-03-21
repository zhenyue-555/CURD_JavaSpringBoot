package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Contact;
import com.example.demo.service.contactService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/contacts")
public class contactController {
    contactService contactservice;
    public contactController(contactService contactservice) {
        this.contactservice = contactservice;
    }

    @GetMapping
    ResponseEntity<?> getAllContacts(){
        return ResponseEntity.ok(contactservice.getAllContatcs());
    }

    @PostMapping("/add")
    ResponseEntity<?> adContact(@RequestBody Contact contact){
        try{
            return ResponseEntity.ok(contactservice.addcontact(contact));
        }
        catch(Exception e){
            return ResponseEntity.ok("add failed, please check your contact details");
        }
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getContactById(@PathVariable long id){
        try{
            return ResponseEntity.ok(contactservice.getContactById(id));
        }
        catch(Exception e){
            return ResponseEntity.ok("get failed, please check your id");
        }
        
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateContact(@PathVariable long id, @RequestBody Contact contact){
        try{
            return ResponseEntity.ok(contactservice.updateContact(contact, id));
        }
        catch(Exception e){
            return ResponseEntity.ok("update failed, please check your id or contact details");
        }
    }
    
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteContact(@PathVariable long id){
        try{
            contactservice.deleteContact(id);
            return ResponseEntity.ok("Contact deleted");
        }
        catch(Exception e){
            return ResponseEntity.ok("delete failed, please check your id");
        }
       
    }
}
