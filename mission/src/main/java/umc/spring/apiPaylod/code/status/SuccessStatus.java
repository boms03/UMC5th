package umc.spring.apiPaylod.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPaylod.BaseCode;
import umc.spring.apiPaylod.ReasonDTO;

@AllArgsConstructor
@Getter
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "200", "성공"),
    _CREATED(HttpStatus.CREATED, "201", "생성"),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .isSuccess(true)
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .isSuccess(true)
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
