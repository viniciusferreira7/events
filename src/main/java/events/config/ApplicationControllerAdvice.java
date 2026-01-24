package events.config;

import events.infra.mapper.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

//    @ExceptionHandler(UsernameOrPasswordInvalid.class)
//    @ResponseStatus(HttpStatus UsernameOrPasswordInvalid(
//            UsernameOrPasswordInvalid exception,
//            HttpServletRequest request
//    ) {
//        return ErrorResponse.builder()
//                .timestamp(Instant.now())
//                .status(HttpStatus.BAD_REQUEST.value())
//                .error("Bad Request")
//                .message(exception.getMessage())
//                .path(request.getRequestURI())
//                .build();
//
//
//    }
}
