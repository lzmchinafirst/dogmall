package org.singledog.dogmall.core.response;

import lombok.Data;

/**
 * The project response
 *
 * @param <T> the result type
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Data
public class ResponseEntity<T> implements Response<T> {

    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    ResponseEntity(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    ResponseEntity(Response<T> response) {
        this.code = response.getCode();
        this.message = response.getMessage();
        this.success = response.getSuccess();
        this.data = response.getData();
    }
}