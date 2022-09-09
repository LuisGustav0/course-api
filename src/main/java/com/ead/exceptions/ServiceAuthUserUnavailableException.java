package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class ServiceAuthUserUnavailableException extends ApmException {

    public ServiceAuthUserUnavailableException(Exception ex) {
        super(ErrorType.SERVICE_UNAVAILABLE.getMessage(), ErrorType.SERVICE_UNAVAILABLE.toString(), ex);
    }
}
