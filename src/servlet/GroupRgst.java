package servlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ErrorViewData;
import model.InputCheckException;
import model.ValidationKey;

//static import
import static model.InputChecker.checkLongInput;

//���[�U�̒ǉ��@�\
//GET�ŃA�N�Z�X���ꂽ�ꍇ �o�^�t�H�[����\��
//POST�ŃA�N�Z�X���ꂽ�ꍇ �o�^�t�H�[�����瑗��ꂽ�f�[�^������
//�o�^�t�H�[�����瑗��ꂽ�f�[�^�́ADB�ۑ����Ƃ���session�ϐ��ɕۑ�
@WebServlet("/grouprgst")
public class GroupRgst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GroupRgst() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�����ȃt�H�[�����瑗��ꂽ�f�[�^�ł��邱�Ƃ��m�F���邽�߂̃L�[�𐶐�
		ValidationKey validationKey = new ValidationKey();
		try {
			Random random = new Random();
			String randomStr = String.valueOf(random.nextLong());
			MessageDigest validation = MessageDigest.getInstance("MD5");
			validation.reset();
			validation.update(randomStr.getBytes("utf-8"));
			String vkey = String.format("%032x" ,new BigInteger(1 ,validation.digest()));
			validationKey.setValue(vkey);
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//�t�H�[���m�F�L�[���Z�b�V�����X�R�[�v�ɐݒ�
		HttpSession session = request.getSession();
		session.setAttribute("validationKey",validationKey);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rgstForm.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//�t�H�[�����瑗��ꂽ�m�F�L�[���ۑ��������̂Ƃ���v���邩�m�F
		ValidationKey validationKey = (ValidationKey) session.getAttribute("validationKey");
		if(!request.getParameter("vKey").equals(validationKey.getValue())) {
			//��v���Ȃ������̂ŁA�Z�b�V�����X�R�[�v�ɕۑ������L�[��j�����A�G���[�y�[�W��
			session.removeAttribute("validationKey");
			//�\���f�[�^��p�ӂ���
			ErrorViewData errorData = new ErrorViewData("��肪�������܂����B", "�g�b�v�̖߂�","/ActionLogger/");
			//�G���[�\���Ƀt�H���[�h
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorView.jsp");
			dispatcher.forward(request,response);
			return;
		}
	}
	
}
