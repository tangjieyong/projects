package keyon.tang.exception;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:14
 * @Version 1.0
 */
public class CustomException extends Exception {
    private String message;

    public  CustomException(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
