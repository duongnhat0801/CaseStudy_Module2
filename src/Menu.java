import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        StudentManager sm = new StudentManager();
        while (true) {
            System.out.println("================================");
            System.out.println("=======DANH SÁCH HỌC SINH=======");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc file");
            System.out.println("7. Ghi file");
            System.out.println("8 Tìm học sinh có điểm TB lớn nhất");
            System.out.println("9.Thoat");
            System.out.println("Chon chuc nang:");
            int choice = Input.getInt();
            switch (choice) {
                case 1:
                    sm.displayStudent();
                    break;
                case 2:
                    sm.addStudent();
                    break;
                case 3:
                    sm.updateStudent();
                    break;
                case 4:
                    sm.deleteStudent();
                    break;
                case 5:
                    sm.sortAvg();
                    sm.displayStudent();
                    break;
                case 6:
                    try {
                        sm.writeListStudentToFile();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    sm.readListStudentFromFile();
                    sm.displayStudent();
                    break;
                case 7:
                    try {
                        sm.writeListStudentToFile();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println(sm.findStudentByMaxAvg());
                    break;
                case 9:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(9);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
