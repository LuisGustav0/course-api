package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class UserInstructorOrAdminNotFoundException extends ApmException{

    public UserInstructorOrAdminNotFoundException() {
        super(ErrorType.USER_INSTRUCTOROR_ADMIN_NOT_FOUND.getMessage(), ErrorType.USER_INSTRUCTOROR_ADMIN_NOT_FOUND.toString());
    }
}
