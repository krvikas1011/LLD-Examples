package com.telephonedirectory.telephonedirectory;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactStorage {
    @Getter
    @Setter
    private static Map<String, List<String>> telephoneDirectoryList = new HashMap<>();
}
