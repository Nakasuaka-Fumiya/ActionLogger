package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

//ユーザー追加機能
//GETでアクセスされた場合　登録フォームを表示
//POSTでアクセスされた場合　登録フォームから送られたデータを処理
//登録フォームから送られたデータは、DB保存候補としてsession変数に保存
@WebServlet("/adduser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddUser() {
        super();

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    RequestDispatcher dispatcher =
		        req.getRequestDispatcher
		            ("/WEB-INF/jsp/addUserForm.jsp");
		    dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		User user = new User();
		user.setUserId( req.getParameter("userid") );
		user.setName( req.getParameter("name") );
		user.setAddress( req.getParameter("address") );
		user.setTel( req.getParameter("tel") );
		user.setEmail( req.getParameter("email") );
		
		try {
			//パスワードのハッシュ化
			String rawPassword = req.getParameter("password");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(rawPassword.getBytes("utf8"));
			String passwordHash = String.format("%064x", new BigInteger(1, digest.digest()));
			
			user.setPwdHash(passwordHash);
			
			HttpSession session = req.getSession();
			session.setAttribute("userToAdd", user);
		    
			RequestDispatcher dispatcher =
			        req.getRequestDispatcher
			            ("/WEB-INF/jsp/addUserConfirm.jsp");
			    dispatcher.forward(req, resp);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
