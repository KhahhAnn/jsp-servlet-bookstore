package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;
import util.SoNgauNhien;
import util.email;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang-controller")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if(hanhDong.equals("dang-nhap")) {
			login(request, response);
		} else if(hanhDong.equals("dang-xuat")) {
			Logout(request, response);
		} else if(hanhDong.equals("dang-ky")) {
			register(request, response);
		}  else if(hanhDong.equals("quen-mat-khau")) {
			forgotPassword(request, response);
		} else if(hanhDong.equals("doi-mat-khau")) {
			changePassword(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			matKhau = MaHoa.toSHA1(matKhau);
			KhachHang khachHang = new KhachHang();
			khachHang.setTenkDangNhap(tenDangNhap);
			khachHang.setMatKhau(matKhau);
			KhachHangDAO khd = new KhachHangDAO();
			String url = "";	
			KhachHang kh = khd.dangNhap(khachHang);
			if(kh != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", kh);
				session.setAttribute("taiKhoan", kh.getTenkDangNhap());
				url = "/index.jsp";
			} else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng");
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String matKhau = request.getParameter("matKhau");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			matKhau = MaHoa.toSHA1(matKhau);
			HttpSession session = request.getSession();
			KhachHang kh = new KhachHang();
			String taiKhoan = kh.getTenkDangNhap();
			KhachHangDAO khd = new KhachHangDAO();
			kh.setMatKhau(matKhau);
			kh.setTenkDangNhap(session.getAttribute("taiKhoan")+"");
			String url = "";
			String baoLoi = "";
			if(!matKhauMoi.equals(matKhauNhapLai)) {
				baoLoi = "Mật khẩu nhập lại không giống!";
				url = "/ChangePassword.jsp";
			}else {
				if(!khd.kiemTraTonTaiDoiMatKhau(kh)) {
					baoLoi = "Mật khẩu hiện tại không chính xác!";
					url = "/ChangePassword.jsp";
				} else {
					matKhauMoi = MaHoa.toSHA1(matKhauMoi);
				}
			}
			KhachHang khachHang = new KhachHang();
			khachHang.setTenkDangNhap(session.getAttribute("taiKhoan")+"");
			khachHang.setMatKhau(matKhauMoi);
			if(khd.doiMatKhau(khachHang) != 0) {
				url = "/index.jsp";
			} else {
				baoLoi = "Đổi mật khẩu thất bại!";
				url = "/ChangePassword.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset = UTF-8");
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String nhapLaiMatKhau = request.getParameter("nhapLaiMatKhau");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("email", email);
			request.setAttribute("dongYNhanMail", dongYNhanMail);
			String baoLoi = "";
			String url = "";
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			
			if(khachHangDAO.kiemTraTonTai(tenDangNhap)) {
				baoLoi += "Tên đăng nhập đã tồn tại!";
			}
			if(!matKhau.equals(nhapLaiMatKhau)) {
				baoLoi += "Mật khẩu không khớp!";
			} else {
				matKhau = MaHoa.toSHA1(matKhau);
			}
			request.setAttribute("baoLoi", baoLoi);
			if(baoLoi.length() > 0) {
				url = "/register.jsp";
			} else {
				Random rd = new Random();
				String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang, Date.valueOf(ngaySinh), dienThoai, email, (dongYNhanMail!=null));
				if(khachHangDAO.insert(kh)>0) {
					kh = khachHangDAO.selectById(kh);
					//Dãy số xác thực
					String soNgauNhien = SoNgauNhien.getSoNgauNhien();
					//Quy định thời gian hiệu lực
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);
					c.add(Calendar.DATE, 1);
					Date thoGianHieuLucXacThuc = new Date(c.getTimeInMillis());
					//Trạng thái xác thực
					boolean trangThaiXacThuc = false;
					kh.setMaXacThuc(soNgauNhien);
					kh.setThoiGianHieuLucCuaMaXacThuc(thoGianHieuLucXacThuc);
					kh.setTrangThaiXacThuc(trangThaiXacThuc);
					
					if(khachHangDAO.updateVerifyInfomation(kh) > 0) {
						//Gửi email
						util.email.sendEmail(kh.getEmail(), "Xác thực tài khoản", getNoiDung(kh));
					}
				}
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void forgotPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("taiKhoan");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			KhachHang khachHang = new KhachHang();
			khachHang.setTenkDangNhap(tenDangNhap);
			KhachHangDAO khd = new KhachHangDAO();
			String  url = "";
			String  baoLoi = "";
			if(!matKhauMoi.equals(matKhauNhapLai)) {
				baoLoi = "Mật khẩu nhập lại không giống!";
			} else {			
				if(khd.kiemTraTonTai(tenDangNhap)) {
					url = "/ChangePassword.jsp";
					baoLoi = "Tài khoản sai hoặc không tồn tại!";
				} else {
					matKhauMoi = MaHoa.toSHA1(matKhauMoi);				
				}
			}
			KhachHang kh = new KhachHang();
			kh.setTenkDangNhap(tenDangNhap);
			kh.setMatKhau(matKhauMoi);
			if(khd.doiMatKhau(kh) != 0) {
				url = "/login.jsp";
			} else {
				url = "/ChangePassword.jsp";
				baoLoi = "Đổi mật khẩu thất bại!";
			}
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getNoiDung(KhachHang kh) {
		String link = "http://localhost:8080/bai9_bookStore/khach-hang?hanhDong=xac-thuc&maKhachHang="+kh.getMaKhachHang()+"&maXacThuc="+kh.getMaXacThuc();
		String noiDung = "<p>KA xin ch&agrave;o bạn <strong>"+kh.getHoVaTen()+"</strong>,</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"+kh.getMaXacThuc()+"</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}
}
