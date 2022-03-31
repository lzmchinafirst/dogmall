package org.singledog.dogmail.core.response;

/**
 * The project response
 *
 * @param <T> the {{@link #data}} type
 * @author Zheming Liu
 * @see {@link Response}
 * @since 1.0.0-RELEASE
 */
public class ResponseEntity<T> implements Response {

    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    protected ResponseEntity(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}