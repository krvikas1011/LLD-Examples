package com.telephonedirectory.telephonedirectory.model;

import lombok.Getter;
import lombok.Setter;

public class UpdatedContactInfo {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String oldPhoneNumber;
    @Getter
    @Setter
    private String newPhoneNumber;

}
