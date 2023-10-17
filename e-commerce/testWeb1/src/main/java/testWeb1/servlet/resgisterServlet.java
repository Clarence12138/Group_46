package testWeb1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * register Servlet
 */
@WebServlet(urlPatterns = "/register")
public class resgisterServlet extends HttpServlet {

    /**
     * 处理POST请求
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // Obtain the parameter information sent from the form page
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String profession = request.getParameter("profession");
        String favor = request.getParameter("favor");
        String description = request.getParameter("description");

        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            response.getWriter().println("驱动注册失败");
            e.printStackTrace();
        }

        Connection conn = null;
        ResultSet res = null;
        PreparedStatement ps = null;

        try {
            // Establish a database connection
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javawebdb", "root", "111111");
            System.out.println("数据库连接成功");

            try {
                // Example Query whether the same user name exists
                String sql1 = "select * from userinfo where username=?";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, username);
                res = ps.executeQuery();
                if (res.next()) {
                    response.getWriter().println("Duplicate account, please re-register");
                    return;
                }

                // Perform insert operation
                String sql2 = "insert into userinfo(username,password,gender,profession,favor,description) values(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql2);

                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, gender);
                ps.setString(4, profession);
                ps.setString(5, favor);
                ps.setString(6, description);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    response.getWriter().println("registered successfully!");
                } else {
                    response.getWriter().println("fail to register!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 关闭资源
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("数据库连接失败!请检查协议、IP、端口号或者用户名和密码是否有错");
        } finally {
            // 关闭数据库连接
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Handle GET requests
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("执行doGet请求");
    }
}
