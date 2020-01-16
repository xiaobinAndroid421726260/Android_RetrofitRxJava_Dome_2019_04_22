package example.dbz.dome.bean;

/**
 * description:
 *
 * @author Db_z
 * date 2020/1/16 17:19
 * @version V1.0
 */
public class BaseResponse {

    private int Code;
    private String Msg;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
