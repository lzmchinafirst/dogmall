package org.singledog.dogmall.core.response;

/**
 * Business exception
 */
public class BusinessException extends RuntimeException implements Response {

    private Response response;

    protected BusinessException(Response response) {
        super(response.getMessage());
        this.response = response;
    }

    protected BusinessException(Integer code, String message) {
        super(message);
        this.response = new Response() {
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
                return false;
            }
        };
    }

    @Override
    public Integer getCode() {
        return response.getCode();
    }

    @Override
    public Boolean getSuccess() {
        return response.getSuccess();
    }
}