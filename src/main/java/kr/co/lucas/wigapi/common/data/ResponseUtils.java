package kr.co.lucas.wigapi.common.data;

public class ResponseUtils {
    public static <T> Response<T> success(T response) {
        return new Response<>(true, response, null);
    }
    public static Response<?> error(Response.ErrorData error) {
        return new Response<>(false, null, error);
    }
}
