package org.singledog.dogmail.mvc.provider.exception;

import lombok.extern.slf4j.Slf4j;
import org.singledog.dogmail.core.response.BusinessException;
import org.singledog.dogmail.core.response.BaseResponse;
import org.singledog.dogmail.core.response.ResponseEntity;
import org.singledog.dogmail.core.response.ResponseFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

/**
 * The project global exception handler
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@ControllerAdvice
@ConditionalOnBean(DispatcherServlet.class)
@Slf4j
public class UnifiedExceptionHandler {

    /**
     * Handle {@link Exception}
     */
    @ExceptionHandler
    public ResponseEntity systemExceptionHandle(Exception exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error(exception.getMessage(), exception);
        log.error("The system exception occurred in {},the message is {}", requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.SYSTEM_ERROR, null);
    }

    /**
     * Handle {@link HttpRequestMethodNotSupportedException}
     */
    @ExceptionHandler
    public ResponseEntity methodNotMatchHandle(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error(exception.getMessage(), exception);
        log.error("The request method not match exception occurred in {},the message is {}", requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.METHOD_NOT_MATCH_ERROR, null);
    }

    /**
     * Handle {@link BindException}
     */
    @ExceptionHandler
    public ResponseEntity validExceptionHandle(BindException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error(exception.getMessage(), exception);
        log.error("The valid exception occurred in {},the message is {}", requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.VALID_PARAMETER_ERROR, null);
    }

    /**
     * Handle {@link ValidationException}
     */
    @ExceptionHandler
    public ResponseEntity validExceptionHandle(ValidationException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error(exception.getMessage(), exception);
        log.error("The valid exception occurred in {},the message is {}", requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.VALID_PARAMETER_ERROR, null);
    }

    /**
     * Handle {@link BusinessException}
     */
    @ExceptionHandler
    public ResponseEntity businessExceptionHandle(BusinessException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error(exception.getMessage(), exception);
        log.error("The business exception occurred in {},the code is {},the message is {}", requestURI, exception.getCode(), exception.getMessage());
        return ResponseFactory.getResponse(exception, null);
    }
}
