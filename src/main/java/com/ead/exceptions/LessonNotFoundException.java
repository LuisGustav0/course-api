package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class LessonNotFoundException extends ApmException{

    public LessonNotFoundException() {
        super(ErrorType.LESSON_NOT_FOUND.getMessage(), ErrorType.LESSON_NOT_FOUND.toString());
    }
}
