package errors;

public enum Response {

    FILE_NOT_FOUND(1001, "Файл отсутствует!"),
    INVALID_INPUT_DATA(1001, "Входыне данные некорректны");

    private int errorCode;
    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    Response(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
