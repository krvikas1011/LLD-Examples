package com.telephonedirectory.telephonedirectory.service;


import com.telephonedirectory.telephonedirectory.model.Contact;
import com.telephonedirectory.telephonedirectory.model.UpdateContact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class TelephoneDirectoryService {

    // ConcurrentNavigableMap allows the map to be thread safe, and sorts the keys by ascending order internally while storing the data
    private ConcurrentNavigableMap<String, List<String>> telephoneDirectory = new ConcurrentSkipListMap<>();

    public Contact createContact(Contact contact) {
        List<String> phoneNumbersList;
        if(telephoneDirectory != null) {
            if(!telephoneDirectory.containsKey(contact.getName().toLowerCase())) {
                phoneNumbersList = new ArrayList<>();
                phoneNumbersList.add(contact.getPhoneNumber());
                telephoneDirectory.put(contact.getName().toLowerCase(), phoneNumbersList);
            } else {
                phoneNumbersList = telephoneDirectory.get(contact.getName().toLowerCase());
                if(!phoneNumbersList.contains(contact.getPhoneNumber())) {
                    phoneNumbersList.add(contact.getPhoneNumber());
                }
            }
        } else {
            telephoneDirectory = new ConcurrentSkipListMap<>();
            phoneNumbersList = new ArrayList<>();
            phoneNumbersList.add(contact.getPhoneNumber());
            telephoneDirectory.put(contact.getName().toLowerCase(), phoneNumbersList);
        }
        return contact;
    }

    public ArrayList<String> getContact(String name) {
        List<String> phoneNumbersList;
        if(!telephoneDirectory.containsKey(name.toLowerCase())) {
            phoneNumbersList = new ArrayList<>();
        } else {
            phoneNumbersList = telephoneDirectory.get(name.toLowerCase());
        }
        return new ArrayList<>(phoneNumbersList);
    }

    public Map<String, List<String>> getAllContacts() {
        return telephoneDirectory;
    }

    public Contact updateContact(UpdateContact updatedContact) {
        Contact contact = new Contact();
        if(telephoneDirectory.containsKey(updatedContact.getName().toLowerCase())) {
            List<String> phoneNumbersList = telephoneDirectory.get(updatedContact.getName().toLowerCase());
            if (phoneNumbersList.contains(updatedContact.getOldPhoneNumber())) {
                int position = phoneNumbersList.indexOf(updatedContact.getOldPhoneNumber());
                phoneNumbersList.remove(updatedContact.getOldPhoneNumber());
                phoneNumbersList.add(position, updatedContact.getNewPhoneNumber());
                contact.setName(updatedContact.getName().toLowerCase());
                contact.setPhoneNumber(updatedContact.getNewPhoneNumber());
            }
        }
        return contact;
    }

    public String deleteContact(Contact contact) {
        if(telephoneDirectory.containsKey(contact.getName().toLowerCase())) {
            List<String> phoneNumbersList = telephoneDirectory.get(contact.getName().toLowerCase());
            if (phoneNumbersList.contains(contact.getPhoneNumber())) {
                phoneNumbersList.remove(contact.getPhoneNumber());
            }
            return "Deleted your contact";
        } else {
            return "Contact not found";
        }
    }

}
