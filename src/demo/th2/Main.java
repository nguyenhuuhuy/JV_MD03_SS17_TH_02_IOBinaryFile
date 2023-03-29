package demo.th2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();

            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        String part_file = "src/demo/th2/student.txt";
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        System.out.println("Nhap id sinh vien: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten sv: ");
        String studentName = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        String address = sc.nextLine();
        Student studentelement = new Student(id,studentName,address);
        students.add(new Student(1, "long", "Ha noi"));
        students.add(new Student(2, "dung", "Ha noi"));
        students.add(new Student(3, "hong", "Ha noi"));
        students.add(new Student(4, "yen", "Ha noi"));
        students.add(studentelement);
        writeToFile(part_file, students);
        List<Student> studentDataFromFile = readDataFromFile(part_file);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
}
