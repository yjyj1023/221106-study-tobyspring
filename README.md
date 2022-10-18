# Pojo JAVA DB연동

## Code

```java
public class UserDao {
    public void add() {
        Map<String, String> env = System.getenv();
        try {
            // DB접속 (ex sql workbeanch실행)
            Connection c = DriverManager.getConnection(env.get("DB_HOST"),
                    env.get("DB_USER"), env.get("DB_PASSWORD"));

            // Query문 작성
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO users(id, name, password) VALUES(?,?,?);");
            pstmt.setString(1, "6");
            pstmt.setString(2, "Mimi");
            pstmt.setString(3, "1q2w3e4r");

            // Query문 실행
            pstmt.executeUpdate();

            pstmt.close();
            c.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) {
        Map<String, String> env = System.getenv();
        Connection c;
        try {
            // DB접속 (ex sql workbeanch실행)
             c = DriverManager.getConnection(env.get("DB_HOST"),
                    env.get("DB_USER"), env.get("DB_PASSWORD"));

            // Query문 작성
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM users WHERE id = ?");
            pstmt.setString(1, id);

            // Query문 실행
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            User user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("name"));

            rs.close();
            pstmt.close();
            c.close();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        userDao.add();
        User user = userDao.findById("6");
        System.out.println(user.getName());
    }
}
```


## Factory를 Bean으로

```java
@Configuration
public class UserDaoFactory2 {

    @Bean
    public UserDao05Interface userDao05Interface() {
        return new UserDao05Interface(() -> {
            return null;
        });
    }

}

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(UserDaoFactory2.class);
        UserDao05Interface userDao = ctx.getBean("userDao05Interface", UserDao05Interface.class);

    }
}
```

### 참고 
https://github.com/Kyeongrok/toby_spring

