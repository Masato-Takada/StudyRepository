package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntryDAO;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/Entry")
public class Entry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entry() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 登録ページ
        String page = "/WEB-INF/jsp/Entry.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        // 画面URL
        String page = "";
        String successpage = "/WEB-INF/jsp/EntrySuccess.jsp";
        String errorpage = "/WEB-INF/jsp/EntryError.jsp";

        EntryDAO dao = new EntryDAO();
        int result = 0;

        try {
            // 登録処理
            result = dao.Insert(userid, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result > 0) {
            // 成功
            page = successpage;
        } else {
            // 失敗
            page = errorpage;
        }
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
