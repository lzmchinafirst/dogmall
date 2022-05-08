package org.singledog.dogmall.core.response;

import lombok.Getter;
import lombok.ToString;

/**
 * Base response,if you don't want use these codes,please customize.
 *
 * @author Zheming Liu
 * @see Response
 * @since 1.0.0-RELEASE
 */
@Getter
@ToString
public enum BaseResponse implements Response {

    /**
     * Success response
     */
    SUCCESS(0, "success", true, null),

    /**
     * System error response
     */
    SYSTEM_ERROR(1, "system error", false, null),

    /**
     * Http request method not match error
     */
    METHOD_NOT_MATCH_ERROR(2, "the request method not match", false, null),

    /**
     * {@link org.springframework.validation.annotation.Validated} annotation valid error
     */
    VALID_PARAMETER_ERROR(3, "the param valid fail", false, null),

    /**
     * No HandlerMethod found in spring container,the ture status is 404
     */
    NO_HANDLER_METHOD_FOUND(4, "no target handler", false, null),

    /**
     * Remote call failed
     */
    REMOTE_CALL_FAILED(5, "remote call failed", false, null);

    private final Integer code;

    private final String message;

    private final Boolean success;

    private final Object data;

    BaseResponse(Integer code, String message, Boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }
}