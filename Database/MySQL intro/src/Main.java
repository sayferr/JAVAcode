import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        insert();
//    }
//    public static void insert(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//            String url = "jdbc:mysql://127.0.0.1:3306/Intro?serverTimezone=GMT%2B8";
//            String username = "root";
//            String password = "root";
//
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//
//                Statement statement = connection.createStatement();
//
//                String sqlQuery = "INSERT INTO Persons(id, name, surname) VALUE(1, 'Roman', 'Sayfer'), " +
//                        "(2, 'Kamilla', 'Flower'), " +
//                        "(3, 'David', 'Money')";
//
//               int insertedRow = statement.executeUpdate(sqlQuery);
//                System.out.println("Add: " + insertedRow + " rows");
//            }
//
//        }catch(Exception e){
//            System.out.println("Error: "+e);
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        //dataBase();
        insertStudents(1, "Roman", "Sayfer", 20);
        deleteOldBooks();
        updateCityName("OldTown", "NewTown");

        List<String> cheap = getCheapProducts();
        System.out.println("Дешёвые продукты: " + cheap);

        int employees = countEmployees();
        System.out.println("Количество сотрудников: " + employees);

        addCategory("Electronics", "All electronic items");
        increaseSalary();
        deleteOrder(5);

        List<String> customers = getAllCustomersSorted();
        System.out.println("Клиенты: " + customers);

        List<String> top5 = getTop5ExpensiveProducts();
        System.out.println("Топ-5 дорогих товаров: " + top5);
    }
    public static Connection dataBase() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/Intro?serverTimezone=GMT%2B8";
            String username = "root";
            String password = "root";

                    System.out.println("Connecting to database...");
            return DriverManager.getConnection(url, username, password);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//            String url = "jdbc:mysql://127.0.0.1:3306/Intro?serverTimezone=GMT%2B8";
//            String username = "root";
//            String password = "root";
//
//            System.out.println("Connecting to database...");
//            return DriverManager.getConnection(url, username, password);
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//            return null;
//        }
    }

    // 1
    public static void insertStudents(int id, String name, String surname, int age) {
        String sql = "INSERT INTO students (id, firstName, lastName, age) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataBase();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setInt(4, age);

            int rows = ps.executeUpdate();
            System.out.println("Added " + rows + " rows");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2
    public static void deleteOldBooks() {
        String sql = "DELETE FROM Books WHERE year < 2000";
        try (Connection conn = dataBase();
             Statement st = conn.createStatement()) {

            int rows = st.executeUpdate(sql);
            System.out.println("Books removed: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3
    public static void updateCityName(String oldName, String newName) {
        String sql = "UPDATE Cities SET name = ? WHERE name = ?";
        try (Connection conn = dataBase();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setString(2, oldName);

            int rows = ps.executeUpdate();
            System.out.println("Changed cities: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4
    public static List<String> getCheapProducts() {
        String sql = "SELECT name FROM Products WHERE price < 100";
        List<String> products = new ArrayList<>();

        try (Connection conn = dataBase();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                products.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // 5
    public static int countEmployees() {
        String sql = "SELECT COUNT(*) AS cnt FROM Employees";

        try (Connection conn = dataBase();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("cnt");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 6
    public static void addCategory(String name, String description) {
        String sql = "INSERT INTO Categories (name, description) VALUES (?, ?)";
        try (Connection conn = dataBase();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, description);

            int rows = ps.executeUpdate();
            System.out.println("Added categories: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7
    public static void increaseSalary() {
        String sql = "UPDATE Employees SET salary = salary * 1.10";
        try (Connection conn = dataBase();
             Statement st = conn.createStatement()) {

            int rows = st.executeUpdate(sql);
            System.out.println("Salary increased for " + rows + " employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8
    public static void deleteOrder(int orderId) {
        String sql = "DELETE FROM Orders WHERE order_id = ?";
        try (Connection conn = dataBase();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            int rows = ps.executeUpdate();
            System.out.println("Orders removed: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 9
    public static List<String> getAllCustomersSorted() {
        String sql = "SELECT lastname FROM Customers ORDER BY lastname";
        List<String> customers = new ArrayList<>();

        try (Connection conn = dataBase();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                customers.add(rs.getString("lastname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    // 10
    public static List<String> getTop5ExpensiveProducts() {
        String sql = "SELECT name FROM Product ORDER BY price DESC LIMIT 5";
        List<String> products = new ArrayList<>();

        try (Connection conn = dataBase();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                products.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
