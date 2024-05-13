public class Student {
    private String code;
    private String name;
    private int age;
    private String gender;
    private double avg;
    private String dob;


    public Student(String code, String name, int age, String gender, String dob, double avg) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.avg = avg;
    }

    public Student() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", avg=" + avg +
                ", dob='" + dob + '\'' +
                '}';
    }
}