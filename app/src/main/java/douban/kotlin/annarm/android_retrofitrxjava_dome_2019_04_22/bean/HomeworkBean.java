package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.bean;

import java.io.Serializable;
import java.util.List;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/24 17:11
 * @version V1.0
 */
public class HomeworkBean {
    /**
     * subject : [{"id":"1","name":"语文"},{"id":"2","name":"数学"},{"id":"3","name":"英语"},{"id":"4","name":"奥数"},{"id":"6","name":"物理"},{"id":"7","name":"化学"},{"id":"8","name":"历史"},{"id":"9","name":"政治"},{"id":"10","name":"生物"},{"id":"11","name":"地理"}]
     * Code : 1
     * Msg : success
     * REQUEST_TIME_FLOAT : 0.012147188186646
     */

    private int Code;
    private String Msg;
    private double REQUEST_TIME_FLOAT;
    private List<SubjectBean> subject;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public double getREQUEST_TIME_FLOAT() {
        return REQUEST_TIME_FLOAT;
    }

    public void setREQUEST_TIME_FLOAT(double REQUEST_TIME_FLOAT) {
        this.REQUEST_TIME_FLOAT = REQUEST_TIME_FLOAT;
    }

    public List<SubjectBean> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectBean> subject) {
        this.subject = subject;
    }

    public static class SubjectBean implements Serializable {
        /**
         * id : 1
         * name : 语文
         */

        private String id;
        private String name;
        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
