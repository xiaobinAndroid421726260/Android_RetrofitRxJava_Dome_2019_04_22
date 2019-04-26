package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.bean;

import java.util.List;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/24 17:10
 * @version V1.0
 */
public class HomeBean {
    /**
     * teacher_name : 统一教育
     * subject_id : 0
     * subject_name : 语文
     * finish_num : 0
     * message : 暂时没有学生完成作业
     * class_info : [{"id":"185","categories_id":"24","classname":"一班","name":"初二·一班","student_num":70,"homework_list":[{"id":"1082","class_id":"185","type":"p","title":"语文 2017-11-17 预习作业","subject_id":"1","knowledges":"2779","ques_num":"5","right_rate":"0","create_time":"1510902080","subject_name":"语文","over_num":0,"video_num":1},{"id":"1081","class_id":"185","type":"p","title":"数学 2017-11-17 预习作业","subject_id":"2","knowledges":"3673,3850","ques_num":"10","right_rate":"0","create_time":"1510894340","subject_name":"数学","over_num":1,"video_num":3}]},{"id":"186","categories_id":"24","classname":"二班","name":"初二·二班","student_num":12,"homework_list":[{"id":"1083","class_id":"186","type":"p","title":"语文 2017-11-17 预习作业","subject_id":"1","knowledges":"2779","ques_num":"5","right_rate":"0","create_time":"1510902081","subject_name":"语文","over_num":0,"video_num":1},{"id":"1067","class_id":"186","type":"p","title":"数学 2017-11-10 预习作业","subject_id":"2","knowledges":"3518,3525,3535","ques_num":"15","right_rate":"29","create_time":"1510276522","subject_name":"数学","over_num":1,"video_num":5}]}]
     * yuxi_homework : 0
     * lianxi_homework : 0
     * Code : 1
     * Msg : success
     * subjects : []
     */

    private String teacher_name;
    private String subject_id;
    private String subject_name;
    private int finish_num;
    private String message;
    private int yuxi_homework;
    private int lianxi_homework;
    private int Code;
    private String Msg;
    private List<ClassInfoBean> class_info;
    private List<HomeworkBean.SubjectBean> subjects;

    public List<HomeworkBean.SubjectBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<HomeworkBean.SubjectBean> subjects) {
        this.subjects = subjects;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getFinish_num() {
        return finish_num;
    }

    public void setFinish_num(int finish_num) {
        this.finish_num = finish_num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getYuxi_homework() {
        return yuxi_homework;
    }

    public void setYuxi_homework(int yuxi_homework) {
        this.yuxi_homework = yuxi_homework;
    }

    public int getLianxi_homework() {
        return lianxi_homework;
    }

    public void setLianxi_homework(int lianxi_homework) {
        this.lianxi_homework = lianxi_homework;
    }

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

    public List<ClassInfoBean> getClass_info() {
        return class_info;
    }

    public void setClass_info(List<ClassInfoBean> class_info) {
        this.class_info = class_info;
    }

    public static class ClassInfoBean {
        /**
         * id : 185
         * categories_id : 24
         * classname : 一班
         * name : 初二·一班
         * student_num : 70
         * homework_list : [{"id":"1082","class_id":"185","type":"p","title":"语文 2017-11-17 预习作业","subject_id":"1","knowledges":"2779","ques_num":"5","right_rate":"0","create_time":"1510902080","subject_name":"语文","over_num":0,"video_num":1},{"id":"1081","class_id":"185","type":"p","title":"数学 2017-11-17 预习作业","subject_id":"2","knowledges":"3673,3850","ques_num":"10","right_rate":"0","create_time":"1510894340","subject_name":"数学","over_num":1,"video_num":3}]
         */

        private String id;
        private String categories_id;
        private String classname;
        private String name = "";
        private int student_num;
        private List<HomeworkListBean> homework_list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategories_id() {
            return categories_id;
        }

        public void setCategories_id(String categories_id) {
            this.categories_id = categories_id;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudent_num() {
            return student_num;
        }

        public void setStudent_num(int student_num) {
            this.student_num = student_num;
        }

        public List<HomeworkListBean> getHomework_list() {
            return homework_list;
        }

        public void setHomework_list(List<HomeworkListBean> homework_list) {
            this.homework_list = homework_list;
        }

        public static class HomeworkListBean {
            /**
             * id : 1082
             * class_id : 185
             * type : p
             * title : 语文 2017-11-17 预习作业
             * subject_id : 1
             * knowledges : 2779
             * ques_num : 5
             * right_rate : 0
             * create_time : 1510902080
             * subject_name : 语文
             * over_num : 0
             * video_num : 1
             * "class_group_id": "0",
             * "second_type": "0",
             * "group_name": "",
             * "student_num": 2
             */

            private String id;
            private String class_id;
            private String type;
            private String title;
            private String subject_id;
            private String knowledges;
            private String ques_num;
            private String student_num;
            private String group_name;
            private String subject_name;
            private int over_num;
            private int video_num;
            private String right_rate;
            private String create_time;
            private String class_group_id;
            private String second_type;

            public String getClass_group_id() {
                return class_group_id;
            }

            public void setClass_group_id(String class_group_id) {
                this.class_group_id = class_group_id;
            }

            public String getSecond_type() {
                return second_type;
            }

            public void setSecond_type(String second_type) {
                this.second_type = second_type;
            }

            public String getStudent_num() {
                return student_num;
            }

            public void setStudent_num(String student_num) {
                this.student_num = student_num;
            }

            public String getGroup_name() {
                return group_name;
            }

            public void setGroup_name(String group_name) {
                this.group_name = group_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubject_id() {
                return subject_id;
            }

            public void setSubject_id(String subject_id) {
                this.subject_id = subject_id;
            }

            public String getKnowledges() {
                return knowledges;
            }

            public void setKnowledges(String knowledges) {
                this.knowledges = knowledges;
            }

            public String getQues_num() {
                return ques_num;
            }

            public void setQues_num(String ques_num) {
                this.ques_num = ques_num;
            }

            public String getRight_rate() {
                return right_rate;
            }

            public void setRight_rate(String right_rate) {
                this.right_rate = right_rate;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getSubject_name() {
                return subject_name;
            }

            public void setSubject_name(String subject_name) {
                this.subject_name = subject_name;
            }

            public int getOver_num() {
                return over_num;
            }

            public void setOver_num(int over_num) {
                this.over_num = over_num;
            }

            public int getVideo_num() {
                return video_num;
            }

            public void setVideo_num(int video_num) {
                this.video_num = video_num;
            }
        }
    }
}
