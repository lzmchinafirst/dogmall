package org.singledog.dogmail.core.response;

/**
 * Base response,if you need more,please extend.
 * Now the success code is 0.
 */
public enum CommonResponse implements Response {

    SUCCESS(0, "success", true),

    SYSTEM_ERROR(1, "system error", false),

    METHOD_NOT_MATCH_ERROR(2, "the request method not match", false),

    VALID_PARAMETER_ERROR(3, "the param valid fail", false);

    private Integer code;

    private String message;

    private Boolean success;

    CommonResponse(Integer code, String message, Boolean success) {
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