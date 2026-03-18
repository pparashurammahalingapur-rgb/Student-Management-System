import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        try {
            while (true) {

                System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        dao.addStudent(new Student(name, email));

                        break;

                    case 2:

                        dao.viewStudents();

                        break;

                    case 3:

                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        dao.updateStudent(id, newName);

                        break;

                    case 4:

                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();

                        dao.deleteStudent(deleteId);

                        break;

                    case 5:

                        System.out.println("Program Ended");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");

                }
            }
        } finally {
            sc.close();
        }

    }
}