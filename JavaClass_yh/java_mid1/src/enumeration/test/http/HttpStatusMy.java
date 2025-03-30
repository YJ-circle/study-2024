package enumeration.test.http;

public enum HttpStatusMy {
    OK(200, "OK", true), BAD_REQUEST(400,"Bad Request", false),
    NOT_FOUND(404,"Not Found", false),
    INTERNAL_SERVER_ERROR(500, "internal Server Error", false);

    private final int code;
    private final String message;
    private final boolean isSuccess;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public static HttpStatusMy findByCode(int httpCodeInput){
        HttpStatusMy[] status = HttpStatusMy.values();
        for (HttpStatusMy httpStatus : status) {
            if (httpStatus.getCode() == httpCodeInput) return httpStatus;
        }
        return null;
    }


    HttpStatusMy(int code, String message, boolean isSuccess) {
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

}
