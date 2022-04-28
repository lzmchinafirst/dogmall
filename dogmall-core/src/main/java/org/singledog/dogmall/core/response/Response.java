package org.singledog.dogmall.core.response;

/**
 * The response of project
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
public interface Response {

    /**
     * Get the response code
     */
    Integer getCode();

    /**
     * Get the response message
     */
    String getMessage();

    /**
     * Get the response status
     */
    Boolean getSuccess();
}
