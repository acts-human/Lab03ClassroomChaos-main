import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    Student[] remembered = new Student[100];
    ArrayList<Student> students = new ArrayList<>();
    int curr = 0;
    public Teacher(String studentFile, String knownFile){
        try {
            //This is some file reading. You will learn how to do this yourself later,
            //But for now, just know that this code is reading from a file with all students and
            // with known students to fill its Array and ArrayList
            Scanner stu = new Scanner(new File(studentFile));
            Scanner know = new Scanner(new File(knownFile));
            while(stu.hasNext()){
                String name = stu.next();
                int ID = Integer.parseInt(stu.next());
                students.add(new Student(name, ID));
            }
            while(know.hasNext()){
                if (curr == remembered.length) {
                    break;
                }
                String name = know.next();
                int ID = Integer.parseInt(know.next());
                remembered[curr] = new Student(name, ID);
                curr++;
            }

        } catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }
  
  //This code adds new students to the Array of students with their names remembered. If the Array is full, it returns false, else it returns true
    public boolean remember(Student s){
        if (remembered.length != curr){
            remembered[curr] = s;
            curr++;
            return true;
        }
        return false;
    }

  //Refer to the directions for how to code this
    public String recallName(Student s) {
        for (Student x : remembered) {
            if (x != null) {
                if (x.getName().equals(s.getName())) {
                    return s.getName();
                }

            }
        }

        return "Er...You";

    }

    public static void main(String[] args){
        Teacher Steven = new Teacher("Students.txt", "Memorable.txt");
        Student Jacob = new Student("Jacob", 679);
        Student Adeline = new Student("Adeline", 276);
        System.out.println("TESTING " + Steven.recallName(Jacob));
        System.out.println("TESTING " + Steven.recallName(Adeline));
    }
}
