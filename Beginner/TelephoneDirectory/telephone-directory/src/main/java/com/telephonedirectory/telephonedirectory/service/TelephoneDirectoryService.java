package com.telephonedirectory.telephonedirectory.service;

import com.telephonedirectory.telephonedirectory.ContactStorage;
import com.telephonedirectory.telephonedirectory.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class TelephoneDirectoryService {

    Contact contact = new Contact();

    public String createContact(Contact contact) {
        List<String> phoneNumbersList;
        if(ContactStorage.getTelephoneDirectoryList() != null) {
            if(!ContactStorage.getTelephoneDirectoryList().containsKey(contact.getName().toLowerCase())) {
                phoneNumbersList = new ArrayList<>();
                phoneNumbersList.add(contact.getPhone());
                ContactStorage.getTelephoneDirectoryList().put(contact.getName().toLowerCase(), phoneNumbersList);
            } else {
                phoneNumbersList = ContactStorage.getTelephoneDirectoryList().get(contact.getName().toLowerCase());
                if(!phoneNumbersList.contains(contact.getPhone())) {
                    phoneNumbersList.add(contact.getPhone());
                }
            }
        } else {
            phoneNumbersList = new ArrayList<>();
            phoneNumbersList.add(contact.getPhone());
            ContactStorage.getTelephoneDirectoryList().put(contact.getName().toLowerCase(), phoneNumbersList);
        }
        return "Added contact";
    }

    public ArrayList<String> getContact(String name) {
        List<String> phoneNumbersList;
        if(!ContactStorage.getTelephoneDirectoryList().containsKey(name.toLowerCase())) {
            phoneNumbersList = new ArrayList<>();
        } else {
            phoneNumbersList = ContactStorage.getTelephoneDirectoryList().get(name.toLowerCase());
        }
        return new ArrayList<>(phoneNumbersList);
    }

    public Map<String, List<String>> getAllContacts() {
        return ContactStorage.getTelephoneDirectoryList();
    }

    public String updateContact(Contact contact, String newPhone) {
        List<String> phoneNumbersList;
        if(ContactStorage.getTelephoneDirectoryList().containsKey(contact.getName().toLowerCase())) {
            phoneNumbersList = ContactStorage.getTelephoneDirectoryList().get(contact.getName().toLowerCase());
            if (phoneNumbersList.contains(contact.getPhone())) {
                int position = phoneNumbersList.indexOf(contact.getPhone());
                phoneNumbersList.remove(contact.getPhone());
                phoneNumbersList.add(position, newPhone);
            }
        }
        return "Updated contact";
    }

    public String deleteContact(Contact contact) {
        List<String> phoneNumbersList;
        if(ContactStorage.getTelephoneDirectoryList().containsKey(contact.getName().toLowerCase())) {
            phoneNumbersList = ContactStorage.getTelephoneDirectoryList().get(contact.getName().toLowerCase());
            if (phoneNumbersList.contains(contact.getPhone())) {
                phoneNumbersList.remove(contact.getPhone());
            }
        }
        return "Deleted your contact";
    }

}
