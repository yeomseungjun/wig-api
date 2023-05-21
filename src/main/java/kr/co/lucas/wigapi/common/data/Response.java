package kr.co.lucas.wigapi.common.data;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Response<T> {
    private boolean success;
    private T data;
    private ErrorData error;

    @AllArgsConstructor
    @Getter
    public static class ErrorData{
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String message;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private List<String> messages;

        public ErrorData(String message) {
            this.message = message;
        }
        public ErrorData(List<String> messages) {
            this.messages = messages;
        }
    }
}
