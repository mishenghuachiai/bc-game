package common.api;

import lombok.Data;
import java.time.Instant;

@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;
    private long timestamp;
    private String traceId;
    private Boolean isRetryable;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }
}
