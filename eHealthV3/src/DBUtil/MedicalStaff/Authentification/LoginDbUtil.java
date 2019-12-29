package DBUtil.MedicalStaff.Authentification;



public class LoginDbUtil {

//	public static boolean validate(String login, String password) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs;
//
//		try {
//			con = DataConnect.getConnection();
//			ps = con.prepareStatement("Select login, password from compte_enseignant where login = ? and password = ?");
//			ps.setString(1, login);
//			ps.setString(2, password);
//
//			rs = ps.executeQuery();
//
//			if (rs.next()) {
//				HttpSession session = SessionUtils.getSession();
//				session.setAttribute("compteType","enseignant");
//				return true;
//			}else {
//
//				ps = con.prepareStatement("Select login, password from compte_etudiant where login = ? and password = ?");
//				ps.setString(1, login);
//				ps.setString(2, password);
//
//				rs = ps.executeQuery();
//
//				if (rs.next()) {
//					HttpSession session = SessionUtils.getSession();
//					session.setAttribute("compteType","etudiant");
//					return true;
//				}
//			}
//		} catch (SQLException ex) {
//			System.out.println("Login error -->" + ex.getMessage());
//			return false;
//		} finally {
//			DataConnect.close(con);
//		}
//		return false;
//	}
}