package dal;

import model.Account;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DBContext {

    // Lấy tài khoản theo email và mật khẩu
    public Account getAccountByEmailAndPassword(String email, String password) {
        Account account = null;
        String query = "SELECT * FROM Users WHERE Email = ? AND Password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("UserID");  // Giả sử 'UserID' là ID của người dùng trong bảng 'Users'
                    String fullname = resultSet.getString("FullName");
                    String phoneNumber = resultSet.getString("PhoneNumber");
                    String address = resultSet.getString("Address");
                    String gender = resultSet.getString("Gender");
                    Date dateOfBirth = resultSet.getDate("DateOfBirth");
                    String role = resultSet.getString("Role");
                    String status = resultSet.getString("Status");
                    Timestamp createdAt = resultSet.getTimestamp("CreatedAt");
                    Timestamp updatedAt = resultSet.getTimestamp("UpdatedAt");

                    // Tạo đối tượng Account với dữ liệu từ bảng Users
                    account = new Account(id, fullname, email, phoneNumber, password, gender, address, dateOfBirth, role, status, createdAt, updatedAt);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return account;
    }

    public Account getAccountByUserID(int id) {
        Account account = null;
        String query = "SELECT * FROM Users WHERE UserID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phoneNumber");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    Timestamp address = rs.getTimestamp("address");
                    int dateOfBirth = rs.getInt("dateOfBirth");
                    int role = rs.getInt("role");
                    String status = rs.getString("status");
                    Timestamp createdAt = rs.getTimestamp("createdAt");
                    Timestamp updatedAt = rs.getTimestamp("updatedAt");
                    account = new Account(id, fullname, email, phoneNumber, password, gender, address, dateOfBirth, role, status, createdAt, updatedAt);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return account;
    }

    public int getTotalAccountCount() {
        int count = 0;
        try (
                PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Users"); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Loi " + e);
        }
        return count;
    }

    // Cập nhật tài khoản theo ID (cập nhật thông tin người dùng)
    public boolean updateAccount(int userId, String name, String email, String address) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE Users SET FullName = ?, Email = ?, Address = ? WHERE UserID = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, address);
            stmt.setInt(4, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Kiểm tra sự tồn tại của người dùng theo email
    public boolean isUserAdded(String email) {
        String query = "SELECT COUNT(*) FROM Users WHERE Email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Account> getAccountToManage(int page, int pageSize) {
        List<Account> accounts = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        try (
                PreparedStatement stmt = connection.prepareStatement("SELECT *\n"
                        + "FROM Users\n"
                        + "ORDER BY UserID\n"
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;")) {
            stmt.setInt(1, offset);
            stmt.setInt(2, pageSize);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setEmail(rs.getString("email"));
                    account.setPassword(rs.getString("password"));
                    account.setFullname(rs.getString("fullname"));
                    account.setCreatedAt(rs.getTimestamp("created_at"));
                    account.setStatus(rs.getString("status"));
                    account.setRole(rs.getString("role"));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void updateAccountStatus(int accountId) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE Users SET status = (CASE WHEN status = 1 THEN 0 ELSE 1 END) WHERE id = ?")) {
            stmt.setInt(1, accountId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật mật khẩu tài khoản
    public boolean updatePassword(int userId, String newPassword) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE Users SET Password = ? WHERE UserID = ?")) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, userId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Thêm tài khoản mới vào cơ sở dữ liệu

    public boolean addAccount(Account account) {
        boolean success = false;
        String query = "INSERT INTO Users (FullName, Email, PhoneNumber, Password, Address, Gender, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?)"; // Correct order

        java.sql.Date sqlDate = null;
        if (account.getDateOfBirth() != null) {
            sqlDate = new java.sql.Date(account.getDateOfBirth().getTime());
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, account.getFullname());
            statement.setString(2, account.getEmail());
            statement.setString(3, account.getPhoneNumber()); // Password before PhoneNumber
            statement.setString(4, account.getPassword());
            statement.setString(5, account.getAddress());
            statement.setString(6, account.getGender());

            if (sqlDate != null) {
                statement.setDate(7, sqlDate); 
            } else {
                statement.setNull(7, java.sql.Types.DATE);
            }

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static void main(String[] args) throws ParseException {  // Add throws
        AccountDAO dao = new AccountDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String dateOfBirthStr = "15/03/1990";
        java.util.Date utilDate = sdf.parse(dateOfBirthStr);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        Account newAccount = new Account("Nguyen Duck", "duck@gmail.com", "03641885257", "123",  "101 secondStreet", "Male", sqlDate); // Password before PhoneNumber


        boolean success = dao.addAccount(newAccount);

        if (success) {
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Failed to add account.");
        }
    }
}
