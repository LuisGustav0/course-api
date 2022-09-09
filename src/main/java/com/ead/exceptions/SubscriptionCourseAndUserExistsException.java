package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class SubscriptionCourseAndUserExistsException extends ApmException {

    public SubscriptionCourseAndUserExistsException() {
        super(ErrorType.SUBSCRIPTION_COURSE_AND_USER_EXISTS_ERROR.getMessage(), ErrorType.SUBSCRIPTION_COURSE_AND_USER_EXISTS_ERROR.toString());
    }
}

