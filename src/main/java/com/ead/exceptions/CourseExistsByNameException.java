package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class CourseExistsByNameException extends ApmException {

    public CourseExistsByNameException() {
        super(ErrorType.COURSE_NAME_EXISTS_BY_NAME_ERROR.getMessage(), ErrorType.COURSE_NAME_EXISTS_BY_NAME_ERROR.toString());
    }
}

