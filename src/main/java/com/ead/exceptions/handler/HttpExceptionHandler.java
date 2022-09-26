package com.ead.exceptions.handler;

import com.ead.enums.ErrorType;
import com.ead.exceptions.CourseNotFoundException;
import com.ead.exceptions.LessonNotFoundException;
import com.ead.exceptions.ModuleNotFoundException;
import com.ead.exceptions.ServiceAuthUserUnavailableException;
import com.ead.exceptions.SubscriptionCourseAndUserExistsException;
import com.ead.exceptions.UnexpectedErrorException;
import com.ead.exceptions.UserBlockedException;
import com.ead.exceptions.UserInstructorOrAdminNotFoundException;
import com.ead.exceptions.UserMustBeInstructorOrAdminException;
import com.ead.exceptions.UserNotFoundException;
import com.ead.factory.HttpErrorResponseFactory;
import com.ead.model.http.HttpErrorResponse;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
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

    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<HttpErrorResponse> handleUnexpectedErrorException(UnexpectedErrorException e) {
        log.error(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(HttpErrorResponseFactory.build(e.getErrorCode(), e.getMessage()));
    }

    @ExceptionHandler(ServiceAuthUserUnavailableException.class)
    public ResponseEntity<HttpErrorResponse> handleServiceAuthUserUnavailableException(ServiceAuthUserUnavailableException e) {
        log.error(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(HttpErrorResponseFactory.build(e.getErrorCode(), e.getMessage()));
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

    @ExceptionHandler(SubscriptionCourseAndUserExistsException.class)
    public ResponseEntity<HttpErrorResponse> handleSubscriptionCourseAndUserExistsException(SubscriptionCourseAndUserExistsException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(UserBlockedException.class)
    public ResponseEntity<HttpErrorResponse> handleUserBlockedException(UserBlockedException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(UserMustBeInstructorOrAdminException.class)
    public ResponseEntity<HttpErrorResponse> handleUserMustBeInstructorOrAdminException(UserMustBeInstructorOrAdminException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(UserInstructorOrAdminNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleUserInstructorNotFoundException(UserInstructorOrAdminNotFoundException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(HttpErrorResponseFactory.build(ex.getErrorCode(), ex.getMessage()));
    }
}
