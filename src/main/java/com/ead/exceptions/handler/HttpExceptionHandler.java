package com.ead.exceptions.handler;

import com.ead.enums.ErrorType;
import com.ead.exceptions.CourseNotFoundException;
import com.ead.exceptions.LessonNotFoundException;
import com.ead.exceptions.ModuleNotFoundException;
import com.ead.factory.HttpErrorResponseFactory;
import com.ead.model.http.HttpErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class HttpExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        log.error(ex.getMessage());

        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();

        final HttpErrorResponse httpErrorResponse = HttpErrorResponseFactory.build(ErrorType.METHOD_ARG_NOT_VALID_ERROR.toString(),
                                                                                   ErrorType.METHOD_ARG_NOT_VALID_ERROR.getMessage());
        for (FieldError fieldError : fieldErrors) {
            httpErrorResponse.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(httpErrorResponse);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleCourseNotFoundException(CourseNotFoundException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(ModuleNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleModuleNotFoundException(ModuleNotFoundException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleModuleNotFoundException(LessonNotFoundException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }
}
