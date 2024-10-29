package core.exception;

public class TransferException extends Exception{
    private String message;
    private String code;
    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


}
