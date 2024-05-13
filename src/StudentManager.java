import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private final ArrayList<Student> students = new ArrayList<>();
    private static StudentManager instance = null;

    StudentManager() {

    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent() {
        System.out.println("Vui lòng nhập mã học sinh : ");
        String code = Input.getString();
        while (!validateCode(code)) {
            code = Input.getString();
        }
        System.out.println("Vui lòng nhập tên học sinh : ");
        String name = Input.getString();
        while (!validateName(name)) {
            name = Input.getString();
        }
        System.out.println("Vui lòng nhập tuổi : ");
        int age = Input.getInt();
        while (!validateAge(age)) {
            age = Input.getInt();
        }
        System.out.println("Vui lòng nhập giới tính :");
        String gender = Input.getString();
        while ((!validateGender(gender))) {
            gender = Input.getString();
        }
        System.out.println("Vui lòng nhập ngày sinh");
        String dob = Input.getString();
        while (!validateDate(dob)) {
            dob = Input.getString();
        }
        System.out.println("Vui lòng nhập điểm trung bình");
        double avg = Input.getDouble();
        while (!validateAvg(avg)) {
            avg = Input.getDouble();
        }
        students.add(new Student(code, name, age, gender, dob, avg));

    }

    private boolean validateAge(int age) {
        if (age < 0 || age > 100) {
            System.out.println("Vui lòng nhập lại tuổi");
            return false;
        }
        return true;
    }

    private boolean validateAvg(double avg) {
        if (avg < 0 || avg > 11) {
            System.out.println("Vui lòng nhập lại điểm trung bình");
            return false;
        }
        return true;
    }

    private boolean validateDate(String dob) {

        String str = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
        return dob.matches(str);
    }

    public static boolean validateName(String name) {
        if (name.isEmpty()) {
            System.out.println("Tên học sinh không được để trống");
            return false;
        }
        return true;
    }

    private boolean validateGender(String gender) {
        if (gender.isEmpty()) {
            System.out.println("Giới tính không được để trống");
            return false;
        }
        return true;
    }

    private boolean validateCode(String code) {
        if (code.isEmpty()) {
            System.out.println("Mã học sinh không được để trống");
            return false;
        }
        if (findIndexByCode(code) != -1) {
            System.out.println("Mã học sinh đã tồn tại");
            return false;
        }
        return true;
    }

    private int findIndexByCode(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("Danh sách trống , vui lòng nhập vào");
            return;
        }
        int pageSize = 7;
        int current = 0;
        while (true) {
            for (int i = current; i < (current + pageSize); i++) {
                if (i >= students.size()) {
                    return;
                }
                System.out.println(students.get(i));
            }
            current += pageSize;
            System.out.println("Enter để sang trang mới");
            Input.getString();
        }
    }

    public void updateStudent() {
        System.out.println("Vui lòng nhập mã học sinh: ");
        String code = Input.getString();
        int index = findIndexByCode(code);
        if (index == -1) {
            System.out.println("Không tồn tại học sinh này");
            return;
        }
        menuUpdateStudent();
        int choice = Input.getInt();
        switch (choice) {
            case 1:
                updateCode(index);
                break;
            case 2:
                updateName(index);
                break;
            case 3:
                updateAge(index);
                break;
            case 4:
                updateGender(index);
                break;
            case 5:
                updateDob(index);
                break;
            case 6:
                updateAvg(index);
                break;
        }
    }

    private void updateAvg(int index) {
        System.out.println("Vui lòng nhập điểm trung bình mới");
        Double newAvg = Input.getDouble();
        while (!validateAvg(newAvg)) {
            newAvg = Input.getDouble();
        }
        students.get(index).setAvg(newAvg);
        System.out.println("Cập nhật thành công!!!");
    }

    private void updateDob(int index) {
        System.out.println("Vui lòng nhập ngày tháng năm sinh");
        String newDob = Input.getString();
        while (!validateDate(newDob)) {
            newDob = Input.getString();
        }
        students.get(index).setDob(newDob);
        System.out.println("Cập nhật thành công!!!");
    }

    private void updateGender(int index) {
        System.out.println("Vui lòng nhập giới tính mới");
        String newGender = Input.getString();
        while (!validateGender(newGender)) {
            newGender = Input.getString();
        }
        students.get(index).setGender(newGender);
        System.out.println("Cập nhật thành công!!!");

    }

    private void updateAge(int index) {
        System.out.println("Vui lòng nhập tuổi mới");
        Integer newAge = Input.getInt();
        while (!validateAge(newAge)) {
            newAge = Input.getInt();
        }
        students.get(index).setAge(newAge);
        System.out.println("Cập nhật thành công!!!");
    }

    private void updateName(int index) {
        System.out.println("Vui lòng nhập tên mới");
        String newName = Input.getString();
        while (!validateName(newName)) {
            newName = Input.getString();
        }
        Student student = students.get(index);
        student.setName(newName);
        System.out.println("Cập nhật thành công!!!");
    }

    private void updateCode(int index) {
        System.out.println("Vui lòng nhập mã học sinh mới");
        String newCode = Input.getString();
        while (!validateCode(newCode)) {
            newCode = Input.getString();
        }
        Student student = students.get(index);
        student.setCode(newCode);
        System.out.println("Cập nhật thành công!!!");
    }

    private void menuUpdateStudent() {
        System.out.println("1. Mã học sinh");
        System.out.println("2. Tên học sinh");
        System.out.println("3. Tuổi");
        System.out.println("4. Giới tính");
        System.out.println("5. Ngày/Tháng/Năm sinh");
        System.out.println("6. Điểm trung bình");
    }

    public void deleteStudent() {
        System.out.println("Vui lòng nhập mã học sinh muốn xoá");
        String code = Input.getString();
        if (code.isEmpty()) {
            return;
        }
        int index = findIndexByCode(code);
        if (index == -1) {
            System.out.println("Không tìm thấy học sinh với mã tương ứng");
            deleteStudent();
            return;
        }
        System.out.println(students.get(index));
        System.out.println("Bạn có chắc muốn xoá không? Nhấn Y để xoá");
        String Y = Input.getString();
        if (Y.equals("Y")) {
            students.remove(index);
            students.remove(index);
        }
    }

    public void sortAvg() {
        System.out.println("1. Sắp xếp điển tb từ thấp đến cao");
        System.out.println("2. Sắp xếp điểm tb từ cao đến thấp");
        System.out.println("3. Quay lại menu ");
        int choice = Input.getInt();
        switch (choice) {
            case 1:
                System.out.println("Điểm từ thấp đến cao: ");
                students.sort(new StudentComparator());
                break;
            case 2:
                System.out.println("Điểm từ cao đến thấp: ");
                students.sort(new StudentComparator().reversed());
                break;
            case 3:
                System.out.println("Đã quay lại menu chính.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    public Student findStudentByMaxAvg() {
        students.sort(new StudentComparator());
        return students.get(students.size() - 1);
    }

    public void readListStudentFromFile() throws IOException {

        File file = new File("data/students.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        students.clear();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Student student = new Student();
            student.setCode(data[0]);
            student.setName(data[1]);
            student.setAge(Integer.parseInt(data[2]));
            student.setGender(data[3]);
            student.setAvg(Double.parseDouble(data[4]));
            student.setDob(data[5]);
            students.add(student);
        }
    }

    public void writeListStudentToFile() throws IOException {
        File file = new File("data/students.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        if(students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào!");
            return;
        }
        for (Student student : students) {
            String line = student.getCode() + "," + student.getName() + "," + student.getAge() + "," + student.getGender()
                    + "," + student.getAvg() + "," + student.getDob();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}




