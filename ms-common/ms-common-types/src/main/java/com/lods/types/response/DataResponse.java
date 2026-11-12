package com.lods.types.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Response returned by controller endpoints that expose a typed data payload.
 *
 * @param <T> payload type
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class DataResponse<T> extends BaseResponse {

    private final T data;

    private DataResponse(String code, String msg, String tid, T data) {
        super(code, msg, tid);
        this.data = data;
    }

    public static <T> DataResponse<T> success(T data) {
        return success(SUCCESS_CODE, SUCCESS_MSG, EMPTY_TID, data);
    }

    public static <T> DataResponse<T> success(T data, String tid) {
        return success(SUCCESS_CODE, SUCCESS_MSG, tid, data);
    }

    public static <T> DataResponse<T> success(String code, String msg, String tid, T data) {
        return new DataResponse<>(code, msg, tid, data);
    }

    public static <T> DataResponse<T> failureWithData(T data) {
        return failure(FAILURE_CODE, FAILURE_MSG, EMPTY_TID, data);
    }

    public static <T> DataResponse<T> failureWithData(T data, String tid) {
        return failure(FAILURE_CODE, FAILURE_MSG, tid, data);
    }

    public static <T> DataResponse<T> failure(String code, String msg, String tid, T data) {
        return new DataResponse<>(code, msg, tid, data);
    }
}
