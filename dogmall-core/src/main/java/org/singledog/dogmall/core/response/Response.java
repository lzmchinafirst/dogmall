package org.singledog.dogmall.core.response;

/**
 * The response of project
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public interface Response<T> {

    /**
     * Get the response code
     *
     * @return response code
     */
    Integer getCode();

    /**
     * Get the response message
     *
     * @return response message
     */
    String getMessage();

    /**
     * Get the response status
     *
     * @return whether success
     */
    Boolean getSuccess();

    /**
     * Get the response data
     *
     * @return response data
     */
    T getData();
}
