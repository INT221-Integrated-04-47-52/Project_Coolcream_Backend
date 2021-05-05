package sit.int221.coolcream.exceptions;

public class IcecreamException extends RuntimeException {
    ExceptionResponse.ERROR_CODE errorCode;

    public IcecreamException(ExceptionResponse.ERROR_CODE errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ExceptionResponse.ERROR_CODE getErrorCode() {
        return errorCode;
    }
}
