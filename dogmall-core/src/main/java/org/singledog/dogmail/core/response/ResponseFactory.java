package org.singledog.dogmail.core.response;

import java.util.ArrayList;

/**
 * The factory of response,this factory create {@link ResponseEntity}
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public class ResponseFactory {

    private ResponseFactory() {
    }

    /**
     * Get {@link ResponseEntity}
     *
     * @param response {@link Response}
     * @param data     the response data
     */
    public static <T> ResponseEntity<T> getResponse(Response response, T data) {
        return getResponse(response.getCode(), response.getMessage(), response.getSuccess(), data);
    }

    /**
     * Get {@link ResponseEntity}
     *
     * @param code    the response code
     * @param message the response message
     * @param success whether response success
     * @param data    the response data
     */
    public static <T> ResponseEntity<T> getResponse(Integer code, String message, Boolean success, T data) {
        return new ResponseEntity<>(code, message, success, data);
    }

    /**
     * Get success response
     *
     * @param data the response data
     * @param <T>  the data type
     * @return {@link ResponseEntity}
     */
    public static <T> ResponseEntity<T> getSuccessResponse(T data) {
        return getResponse(BaseResponse.SUCCESS, data);
    }

    /**
     * Get success response
     *
     * @return {@link ResponseEntity}
     */
    public static ResponseEntity getSuccessResponse() {
        return getResponse(BaseResponse.SUCCESS, new ArrayList<>());
    }

    /**
     * Throw {@link BusinessException}
     *
     * @param response {@link Response}
     */
    public static void throwBusinessException(Response response) {
        if (response.getSuccess()) {
            return;
        }
        throw new BusinessException(response);
    }

    /**
     * Throw {@link BusinessException}
     *
     * @param code    the response code
     * @param message the response message
     */
    public static void throwBusinessException(Integer code, String message) {
        throw new BusinessException(code, message);
    }
}

