package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class CourseNotFoundException extends ApmException{

    public CourseNotFoundException() {
        super(ErrorType.COURSE_NOT_FOUND.getMessage(), ErrorType.COURSE_NOT_FOUND.toString());
    }
}
