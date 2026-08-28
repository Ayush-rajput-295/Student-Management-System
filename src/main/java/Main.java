import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");

            // Check choice
            if (!sc.hasNextInt()) {

                System.out.println(
                    "❌ Please enter a number from 1 to 6."
                );

                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                // ==================================
                // 1. ADD STUDENT
                // ==================================

                case 1:

                    System.out.println("\n----- Add Student -----");

                    // Student ID
                    System.out.print("Enter Student ID: ");

                    if (!sc.hasNextInt()) {

                        System.out.println(
                            "❌ Student ID must be a number!"
                        );

                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();

                    if (id <= 0) {

                        System.out.println(
                            "❌ Student ID must be greater than 0!"
                        );

                        break;
                    }

                    sc.nextLine();

                    // Name
                    System.out.print("Enter Name: ");

                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {

                        System.out.println(
                            "❌ Name cannot be empty!"
                        );

                        break;
                    }

                    // Age
                    System.out.print("Enter Age: ");

                    if (!sc.hasNextInt()) {

                        System.out.println(
                            "❌ Age must be a number!"
                        );

                        sc.nextLine();
                        break;
                    }

                    int age = sc.nextInt();

                    if (age <= 0 || age > 100) {

                        System.out.println(
                            "❌ Please enter a valid age!"
                        );

                        break;
                    }

                    sc.nextLine();

                    // Course
                    System.out.print("Enter Course: ");

                    String course = sc.nextLine().trim();

                    if (course.isEmpty()) {

                        System.out.println(
                            "❌ Course cannot be empty!"
                        );

                        break;
                    }

                    // Email
                    System.out.print("Enter Email: ");

                    String email = sc.nextLine().trim();

                    if (!isValidEmail(email)) {

                        System.out.println(
                            "❌ Please enter a valid email!"
                        );

                        break;
                    }

                    // Create Student object
                    Student student = new Student(
                            id,
                            name,
                            age,
                            course,
                            email
                    );

                    // Add to database
                    dao.addStudent(student);

                    break;


                // ==================================
                // 2. VIEW ALL STUDENTS
                // ==================================

                case 2:

                    System.out.println(
                        "\n----- All Students -----"
                    );

                    dao.viewAllStudents();

                    break;


                // ==================================
                // 3. SEARCH STUDENT
                // ==================================

                case 3:

                    System.out.println(
                        "\n----- Search Student -----"
                    );

                    System.out.print(
                        "Enter Student ID to search: "
                    );

                    if (!sc.hasNextInt()) {

                        System.out.println(
                            "❌ Student ID must be a number!"
                        );

                        sc.nextLine();
                        break;
                    }

                    int searchId = sc.nextInt();

                    if (searchId <= 0) {

                        System.out.println(
                            "❌ Invalid Student ID!"
                        );

                        break;
                    }

                    dao.searchStudent(searchId);

                    break;


                // ==================================
                // 4. UPDATE STUDENT
                // ==================================

                case 4:

                    System.out.println(
                        "\n----- Update Student -----"
                    );

                    System.out.print(
                        "Enter Student ID to update: "
                    );

                    if (!sc.hasNextInt()) {

                        System.out.println(
                            "❌ Student ID must be a number!"
                        );

                        sc.nextLine();
                        break;
                    }

                    int updateId = sc.nextInt();

                    if (updateId <= 0) {

                        System.out.println(
                            "❌ Invalid Student ID!"
                        );

                        break;
                    }

                    sc.nextLine();

                    // New Name
                    System.out.print("Enter New Name: ");

                    String updateName = sc.nextLine().trim();

                    if (updateName.isEmpty()) {

                        System.out.println(
                            "❌ Name cannot be empty!"
                        );

                        break;
                    }

                    // New Age
                    System.out.print("Enter New Age: ");

                    if (!sc.hasNextInt()) {

                        System.out.println(
                            "❌ Age must be a number!"
                        );

                        sc.nextLine();
                        break;
                    }

                    int updateAge = sc.nextInt();

                    if (updateAge <= 0 || updateAge > 100) {

                        System.out.println(
                            "❌ Please enter a valid age!"
                        );

                        break;
                    }

                    sc.nextLine();

                    // New Course
                    System.out.print("Enter New Course: ");

                    String updateCourse =
                            sc.nextLine().trim();

                    if (updateCourse.isEmpty()) {

                        System.out.println(
                            "❌ Course cannot be empty!"
                        );

                        break;
                    }

                    // New Email
                    System.out.print("Enter New Email: ");

                    String updateEmail =
                            sc.nextLine().trim();

                    if (!isValidEmail(updateEmail)) {

                        System.out.println(
                            "❌ Please enter a valid email!"
                        );

                        break;
                    }

                    // Create updated Student object
                    Student updatedStudent = new Student(
                            updateId,
                            updateName,
                            updateAge,
                            updateCourse,
                            updateEmail
                    );

                    // Update database
                    dao.updateStudent(updatedStudent);

                    break;


                // ==================================
                // 5. DELETE STUDENT
                // ==================================

                case 5:

                   System.out.println("\n----- Delete Student -----");

                   System.out.print("Enter Student ID to delete: ");

                   if (!sc.hasNextInt()) {
                      System.out.println("❌ Student ID must be a number!");
                       sc.nextLine();
                      break;
                    }

                  int deleteId = sc.nextInt();

                  if (deleteId <= 0) {
                      System.out.println("❌ Invalid Student ID!");
                       break;
                    }

                      sc.nextLine();

                    System.out.print("Are you sure you want to delete this student? (Y/N): ");
                    String confirmation = sc.nextLine().trim();

                   if (confirmation.equalsIgnoreCase("Y")) {
                      dao.deleteStudent(deleteId);

                    } else if (confirmation.equalsIgnoreCase("N")) {

                      System.out.println("❌ Delete cancelled.");

                    } else {

                       System.out.println("❌ Please enter Y or N.");
                    }

                    break;

                // ==================================
                // 6. EXIT
                // ==================================

                case 6:

                    System.out.println(
                        "\nThank you for using "
                        + "Student Management System!"
                    );

                    sc.close();

                    return;


                // ==================================
                // INVALID CHOICE
                // ==================================

                default:

                    System.out.println(
                        "❌ Invalid choice!"
                    );

                    System.out.println(
                        "Please choose between 1 and 6."
                    );
            }
        }
    }


    // ==================================
    // EMAIL VALIDATION METHOD
    // ==================================

    public static boolean isValidEmail(String email) {

        return email.matches(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );
    }
}