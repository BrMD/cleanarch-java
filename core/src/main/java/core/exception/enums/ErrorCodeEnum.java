package core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax Number invalido", "ON-0001"),
    TR0001("Usuário lojista não tem a função transferencia disponivel", "TR-0001"),
    TR0002("Saldo Indisponivel", "TR-0002"),
    TRP0001("Pin invalido", "TRP-0001");
    private String message;
    private String code;

    private ErrorCodeEnum(String message, String code) {
        this.message = message;
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
