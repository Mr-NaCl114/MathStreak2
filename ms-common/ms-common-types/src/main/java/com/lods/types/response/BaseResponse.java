package com.lods.types.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Base response returned by controller endpoints that do not need a data payload.
 */
@Getter
@ToString
@EqualsAndHashCode
public class BaseResponse {

    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "success";
    public static final String FAILURE_CODE = "500";
    public static final String FAILURE_MSG = "failure";
    public static final String EMPTY_TID = "";

    private final String code;
    private final String msg;
    private final String tid;

    /**
     * Creates a response from a subclass.
     */
    protected BaseResponse(String code, String msg, String tid) {
        this.code = code;
        this.msg = msg;
        this.tid = tid;
    }

    public static BaseResponse success() {
        return success(SUCCESS_CODE, SUCCESS_MSG, EMPTY_TID);
    }

    public static BaseResponse successWithTid(String tid) {
        return success(SUCCESS_CODE, SUCCESS_MSG, tid);
    }

    public static BaseResponse success(String code, String msg, String tid) {
        return new BaseResponse(code, msg, tid);
    }

    public static BaseResponse failure() {
        return failure(FAILURE_CODE, FAILURE_MSG, EMPTY_TID);
    }

    public static BaseResponse failureWithTid(String tid) {
        return failure(FAILURE_CODE, FAILURE_MSG, tid);
    }

    public static BaseResponse failure(String code, String msg, String tid) {
        return new BaseResponse(code, msg, tid);
    }
}
