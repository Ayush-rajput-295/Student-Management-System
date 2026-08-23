package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    // =========================
    // 1. ADD STUDENT
    // =========================

    public void addStudent(Student student) {

        String sql = "INSERT INTO students (id, name, age, course, email) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getCourse());
            statement.setString(5, student.getEmail());

            statement.executeUpdate();

            System.out.println("✅ Student added successfully!");

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println(
                    "❌ Student ID " + student.getId() + " already exists!"
                );
            } else {
                System.out.println(
                    "❌ Database error: " + e.getMessage()
                );
            }
        }
    }


    // =========================
    // 2. VIEW ALL STUDENTS
    // =========================

    public void viewAllStudents() {

        String sql = "SELECT * FROM students";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ) {

            if (!resultSet.next()) {

                System.out.println("❌ No students found.");

            } else {

                System.out.println("\n----- Student List -----");

                do {

                    System.out.println("ID: "
                            + resultSet.getInt("id"));

                    System.out.println("Name: "
                            + resultSet.getString("name"));

                    System.out.println("Age: "
                            + resultSet.getInt("age"));

                    System.out.println("Course: "
                            + resultSet.getString("course"));

                    System.out.println("Email: "
                            + resultSet.getString("email"));

                    System.out.println("------------------------");

                } while (resultSet.next());
            }

        } catch (SQLException e) {

            System.out.println(
                "❌ Database error: " + e.getMessage()
            );
        }
    }


    // =========================
    // 3. SEARCH STUDENT
    // =========================

    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    System.out.println("\n----- Student Found -----");

                    System.out.println("ID: "
                            + resultSet.getInt("id"));

                    System.out.println("Name: "
                            + resultSet.getString("name"));

                    System.out.println("Age: "
                            + resultSet.getInt("age"));

                    System.out.println("Course: "
                            + resultSet.getString("course"));

                    System.out.println("Email: "
                            + resultSet.getString("email"));

                    System.out.println("-------------------------");

                } else {

                    System.out.println("❌ Student not found!");
                }
            }

        } catch (SQLException e) {

            System.out.println(
                "❌ Database error: " + e.getMessage()
            );
        }
    }


    // =========================
    // 4. UPDATE STUDENT
    // =========================

    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, age = ?, course = ?, email = ? WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getCourse());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                    "✅ Student updated successfully!"
                );

            } else {

                System.out.println(
                    "❌ Student not found!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "❌ Database error: " + e.getMessage()
            );
        }
    }


    // =========================
    // 5. DELETE STUDENT
    // =========================

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                    "✅ Student deleted successfully!"
                );

            } else {

                System.out.println(
                    "❌ Student not found!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "❌ Database error: " + e.getMessage()
            );
        }
    }
}