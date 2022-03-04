package com.telephonedirectory.telephonedirectory.controller;

import com.telephonedirectory.telephonedirectory.model.Contact;
import com.telephonedirectory.telephonedirectory.service.TelephoneDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class TelephoneDirectoryController {

    @Autowired
    TelephoneDirectoryService telephoneDirectoryService;

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<String>> getContact(@PathVariable String name) {
        return new ResponseEntity<>(telephoneDirectoryService.getContact(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getAllContacts() {
        return new ResponseEntity<>(telephoneDirectoryService.getAllContacts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(telephoneDirectoryService.createContact(contact), HttpStatus.CREATED);
    }

    @PutMapping("/{newPhone}")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact, @PathVariable String newPhone) {
        return new ResponseEntity<>(telephoneDirectoryService.updateContact(contact, newPhone), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(telephoneDirectoryService.deleteContact(contact), HttpStatus.NO_CONTENT);
    }

}
