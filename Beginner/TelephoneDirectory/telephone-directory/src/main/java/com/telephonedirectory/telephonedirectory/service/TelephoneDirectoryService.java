package com.telephonedirectory.telephonedirectory.service;

import com.telephonedirectory.telephonedirectory.TelephoneDirectory;

import java.util.ArrayList;
import java.util.List;


public class TelephoneDirectoryService {

    public String createContact(String name, String phone) {
        List<String> phoneNumbersList;
        if(!TelephoneDirectory.telephoneDirectoryList.containsKey(name.toLowerCase())) {
            phoneNumbersList = new ArrayList<>();
            phoneNumbersList.add(phone);
            TelephoneDirectory.telephoneDirectoryList.put(name, phoneNumbersList);
        } else {
            phoneNumbersList = TelephoneDirectory.telephoneDirectoryList.get(name);
            if(!phoneNumbersList.contains(phone)) {
                phoneNumbersList.add(phone);
            }
        }
        return "Added contact";
    }

    public ArrayList<String> getContact(String name) {
        List<String> phoneNumbersList;
        if(!TelephoneDirectory.telephoneDirectoryList.containsKey(name.toLowerCase())) {
            phoneNumbersList = new ArrayList<>();
        } else {
            phoneNumbersList = TelephoneDirectory.telephoneDirectoryList.get(name);
        }
        return new ArrayList<>(phoneNumbersList);
    }

    public String updateContact(String name, String oldPhone, String newPhone) {
        List<String> phoneNumbersList;
        if(TelephoneDirectory.telephoneDirectoryList.containsKey(name.toLowerCase())) {
            phoneNumbersList = TelephoneDirectory.telephoneDirectoryList.get(name);
            if (phoneNumbersList.contains(oldPhone)) {
                int position = phoneNumbersList.indexOf(oldPhone);
                phoneNumbersList.remove(oldPhone);
                phoneNumbersList.add(position, newPhone);
            }
        }
        return "Updated contact";
    }

    public String deleteContact(String name, String phone) {
        List<String> phoneNumbersList;
        if(TelephoneDirectory.telephoneDirectoryList.containsKey(name.toLowerCase())) {
            phoneNumbersList = TelephoneDirectory.telephoneDirectoryList.get(name);
            if (phoneNumbersList.contains(phone)) {
                phoneNumbersList.remove(phone);
            }
        }
        return "Deleted your contact";
    }

}
