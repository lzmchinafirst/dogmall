package org.singledog.dogmall.core.response;

import lombok.Data;
import lombok.ToString;

/**
 * The project response with page.
 *
 * @param <T> the result type
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Data
@ToString
public class ResponsePageEntity<T> implements Response<T> {

    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    /**
     * Total page number
     */
    private Long pages;

    /**
     * Current page number
     */
    private Long current;

    /**
     * Page size
     */
    private Long size;

    /**
     * Total results
     */
    private Long total;

    ResponsePageEntity(Integer code, String message, Boolean success, T data, Long pages, Long current, Long size, Long total) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
        this.pages = pages;
        this.current = current;
        this.size = size;
        this.total = total;
    }

    ResponsePageEntity(Response<T> response, Long pages, Long current, Long size, Long total) {
        this.code = response.getCode();
        this.message = response.getMessage();
        this.success = response.getSuccess();
        this.data = response.getData();
        this.pages = pages;
        this.current = current;
        this.size = size;
        this.total = total;
    }
}
