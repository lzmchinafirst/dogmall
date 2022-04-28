package org.singledog.dogmall.mvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.singledog.dogmall.core.response.BusinessException;
import org.singledog.dogmall.core.response.BaseResponse;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

/**
 * The project global exception handler
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@RestControllerAdvice
@Slf4j
public class MvcExceptionHandler implements InitializingBean {

    /**
     * Handle {@link Exception}
     */
    @ExceptionHandler
    public ResponseEntity systemExceptionHandle(Exception exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The system exception occurred in {} {},the message is {}", method, requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.SYSTEM_ERROR);
    }

    /**
     * Handle {@link HttpRequestMethodNotSupportedException}
     */
    @ExceptionHandler
    public ResponseEntity methodNotMatchHandle(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The request method not match exception occurred in {} {},the message is {}", method, requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.METHOD_NOT_MATCH_ERROR);
    }

    /**
     * Handle {@link NoHandlerFoundException}
     */
    @ExceptionHandler
    public ResponseEntity noHandlerFoundHandle(NoHandlerFoundException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The target handler method not found exception occurred in {} {},the message is {}", method, requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.NO_HANDLER_METHOD_FOUND);
    }

    /**
     * Handle {@link BindException}
     */
    @ExceptionHandler
    public ResponseEntity validExceptionHandle(BindException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The valid exception occurred in {} {},the message is {}", method, requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.VALID_PARAMETER_ERROR);
    }

    /**
     * Handle {@link ValidationException}
     */
    @ExceptionHandler
    public ResponseEntity validExceptionHandle(ValidationException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The valid exception occurred in {} {},the message is {}", method, requestURI, exception.getMessage());
        return ResponseFactory.getResponse(BaseResponse.VALID_PARAMETER_ERROR);
    }

    /**
     * Handle {@link BusinessException}
     */
    @ExceptionHandler
    public ResponseEntity businessExceptionHandle(BusinessException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error(exception.getMessage(), exception);
        log.error("The business exception occurred in {} {},the code is {},the message is {}", method, requestURI, exception.getCode(), exception.getMessage());
        return ResponseFactory.getResponse(exception);
    }

    /**
     * A record for bean init
     */
    @Override
    public void afterPropertiesSet() {
        log.info("The global exception handler is initialized");
    }
}
