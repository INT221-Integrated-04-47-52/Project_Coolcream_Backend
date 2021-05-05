package sit.int221.coolcream.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    public static enum ERROR_CODE {
        ICECREAM_DOES_NOT_EXIST(101), ICECREAM_ALREADY_EXIST(102);

        private int errorValue;

        ERROR_CODE(int errorValue) {
            this.errorValue = errorValue;
        }
    }

    private ERROR_CODE errorCode;
    private String errorMessage;
    private LocalDateTime errorDateTime;

    public ExceptionResponse(ERROR_CODE errorCode, String errorMessage, LocalDateTime errorDateTime) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDateTime = errorDateTime;
    }
}
