package org.singledog.dogmall.core.response;

/**
 * The factory of response.
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
     */
    public static ResponseEntity getResponse(Response response) {
        return getResponse(response.getCode(), response.getMessage(), response.getSuccess(), response.getData());
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
        return getResponse(BaseResponse.SUCCESS, null);
    }

    /**
     * Get success response page
     *
     * @param data the response data
     * @param <T>  the data type
     * @return {@link ResponsePageEntity}
     */
    public static <T> ResponsePageEntity<T> getSuccessPageResponse(T data, Long pages, Long current, Long size, Long total) {
        return new ResponsePageEntity<>(getSuccessResponse(data), pages, current, size, total);
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

