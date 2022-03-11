package com.telephonedirectory.telephonedirectory.service;


import com.telephonedirectory.telephonedirectory.model.Contact;
import com.telephonedirectory.telephonedirectory.model.UpdatedContact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class TelephoneDirectoryService {

    private ConcurrentNavigableMap<String, List<String>> telephoneDirectoryList = new ConcurrentSkipListMap<>();

    public Contact createContact(Contact contact) {
        List<String> phoneNumbersList;
        if(telephoneDirectoryList != null) {
            if(!telephoneDirectoryList.containsKey(contact.getName().toLowerCase())) {
                phoneNumbersList = new ArrayList<>();
                phoneNumbersList.add(contact.getPhoneNumber());
                telephoneDirectoryList.put(contact.getName().toLowerCase(), phoneNumbersList);
            } else {
                phoneNumbersList = telephoneDirectoryList.get(contact.getName().toLowerCase());
                if(!phoneNumbersList.contains(contact.getPhoneNumber())) {
                    phoneNumbersList.add(contact.getPhoneNumber());
                }
            }
        } else {
            telephoneDirectoryList = new ConcurrentSkipListMap<>();
            phoneNumbersList = new ArrayList<>();
            phoneNumbersList.add(contact.getPhoneNumber());
            telephoneDirectoryList.put(contact.getName().toLowerCase(), phoneNumbersList);
        }
        return contact;
    }

    public ArrayList<String> getContact(String name) {
        List<String> phoneNumbersList;
        if(!telephoneDirectoryList.containsKey(name.toLowerCase())) {
            phoneNumbersList = new ArrayList<>();
        } else {
            phoneNumbersList = telephoneDirectoryList.get(name.toLowerCase());
        }
        return new ArrayList<>(phoneNumbersList);
    }

    public Map<String, List<String>> getAllContacts() {
        return telephoneDirectoryList;
    }

    public UpdatedContact updateContact(UpdatedContact updatedContact) {
        if(telephoneDirectoryList.containsKey(updatedContact.getName().toLowerCase())) {
            List<String> phoneNumbersList = telephoneDirectoryList.get(updatedContact.getName().toLowerCase());
            if (phoneNumbersList.contains(updatedContact.getOldPhoneNumber())) {
                int position = phoneNumbersList.indexOf(updatedContact.getOldPhoneNumber());
                phoneNumbersList.remove(updatedContact.getOldPhoneNumber());
                phoneNumbersList.add(position, updatedContact.getNewPhoneNumber());
            }
            return updatedContact;
        } else {
            return new UpdatedContact();
        }

    }

    public String deleteContact(Contact contact) {
        if(telephoneDirectoryList.containsKey(contact.getName().toLowerCase())) {
            List<String> phoneNumbersList = telephoneDirectoryList.get(contact.getName().toLowerCase());
            if (phoneNumbersList.contains(contact.getPhoneNumber())) {
                phoneNumbersList.remove(contact.getPhoneNumber());
            }
            return "Deleted your contact";
        } else {
            return "Contact not found";
        }
    }

}
