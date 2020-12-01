package com.restapinaming.demo.error;

import java.util.Set;

public class CustomerUnSupportedFieldException extends RuntimeException {
    public CustomerUnSupportedFieldException (Set<String> keys){
        super("Field" + keys.toString() + "update is not allow");
    }
}
