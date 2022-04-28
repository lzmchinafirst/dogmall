package org.singledog.dogmall.core.response;

/**
 * Base response,if you don't want use these codes,please customize.
 *
 * @author Zheming Liu
 * @see Response
 * @since 1.0.0-RELEASE
 */
public enum BaseResponse implements Response {

    /**
     * Success response
     */
    SUCCESS(0, "success", true),

    /**
     * System error response
     */
    SYSTEM_ERROR(1, "system error", false),

    /**
     * Http request method not match error
     */
    METHOD_NOT_MATCH_ERROR(2, "the request method not match", false),

    /**
     * {@link org.springframework.validation.annotation.Validated} annotation valid error
     */
    VALID_PARAMETER_ERROR(3, "the param valid fail", false),

    /**
     * No HandlerMethod found in spring container,the ture status is 404
     */
    NO_HANDLER_METHOD_FOUND(4, "no target handler", false);

    private final Integer code;

    private final String message;

    private final Boolean success;

    BaseResponse(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }
}