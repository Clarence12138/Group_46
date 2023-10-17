package testWeb1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testWeb1.dao.UserDAO;
import testWeb1.dao.impl.UserDAOImpl;
import testWeb1.dao.RecordDao;
import testWeb1.vo.UserInfo;
import testWeb1.vo.RecordInfo;

/**
 * User Login Servlet
 */
@WebServlet(urlPatterns = "/userLogin")
public class UserLoginServlet extends HttpServlet {

    /**
     * Handle GET requests
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
    }

    /**
     * Handle POST requests
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        UserInfo userinfo = new UserInfo();
        userinfo.setUsername(req.getParameter("username"));
        userinfo.setPassword(req.getParameter("password"));
        RecordInfo recordInfo = new RecordInfo();
        UserDAO dao = new UserDAOImpl(); 
        RecordDao dao2 = new RecordDao();
        List<RecordInfo> recordlist = dao2.getAllRecords();
        // dao2.saveImagePath(1, "20230525145723.jpg");
        // dao2.saveRecord(4,12.2,1,1);

        int flag = 0;
        try {
            flag = dao.queryByUserInfo(userinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == 1) {
            // Login successful, store the username in session
            HttpSession session = req.getSession();
            req.setAttribute("userinfo", userinfo);
            req.setAttribute("recordlist", recordlist); // Store in request scope
            req.getRequestDispatcher("/welcome.jsp").forward(req, res); // Forward to welcome.jsp with the original request and response objects
        } else {
            // Login failed, redirect to error page
            res.sendRedirect("./error.jsp");
        }
    }
}