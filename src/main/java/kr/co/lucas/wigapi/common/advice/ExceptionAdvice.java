package kr.co.lucas.wigapi.common.advice;

import kr.co.lucas.wigapi.common.data.ApiException;
import kr.co.lucas.wigapi.common.data.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    @ExceptionHandler(ApiException.class)
    private ResponseEntity<Response.ErrorData> handleApiException(ApiException e) {
        log.info("ApiException : {}", e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new Response.ErrorData(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Response handleException(Exception e) {
        log.error("Occurred Exception : {}", stacktrace(e));
        return new Response(false, null, new Response.ErrorData("서버 에러가 발생 했습니다."));
    }

    private String stacktrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
