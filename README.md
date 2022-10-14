# Pojo JAVA DB연동

## Code

```java
public class Dao {
    public void add() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/likelion-db", "root", dbPassword);
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, "01");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "password");

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public static void main (String[]args) throws SQLException, ClassNotFoundException {
        Dao dao = new Dao();
        dao.add();
    }
}
```

### 참고 
https://github.com/Kyeongrok/toby_spring

