import java.sql.*;

public class StudentDAO {

    // CREATE
    public void addStudent(Student s) {

        try {

            Connection conn = DBconnection.getConnection();

            String sql = "INSERT INTO students(name,email) VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.name);
            ps.setString(2, s.email);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding student.");
        }
    }

    // READ
    public void viewStudents() {

        try {

            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM students";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while adding student.");
        }
    }

    // UPDATE
    public void updateStudent(int id, String name) {

        try {

            Connection conn = DBconnection.getConnection();

            String sql = "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student Updated");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding student.");
        }
    }

    // DELETE
    public void deleteStudent(int id) {

        try {

            Connection conn = DBconnection.getConnection();

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student Deleted");

        } catch (SQLException e) {
            System.out.println("Error occurred while adding student.");
        }
    }
}