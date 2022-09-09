package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class UserMustBeInstructorOrAdminException extends ApmException {

    public UserMustBeInstructorOrAdminException() {
        super(ErrorType.USER_MUST_BE_INSTRUCTOR_OR_ADMIN_ERROR.getMessage(),
              ErrorType.USER_MUST_BE_INSTRUCTOR_OR_ADMIN_ERROR.toString());
    }
}
