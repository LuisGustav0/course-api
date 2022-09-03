package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class ModuleNotFoundException extends ApmException{

    public ModuleNotFoundException() {
        super(ErrorType.MODULE_NOT_FOUND.getMessage(), ErrorType.MODULE_NOT_FOUND.toString());
    }
}
