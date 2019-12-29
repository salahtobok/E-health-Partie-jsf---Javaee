package DBUtil.Authentification;


/**
 * Created by salahtobok on 28/04/17.
 */

public class ConstraintsDbUtil {



//    public static Contraintes loadContraintes() {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs;
//        Contraintes contraintes=null;
//        try {
//            con = DataConnect.getConnection();
//
//            ps = con.prepareStatement("SELECT * FROM contraintes WHERE contraintes.code_promo = ?");
//
//            ps.setString(1, SessionUtils.getEtudiantContrainte().getCode_prom());
//
//            rs = ps.executeQuery();
//
//
//            if (rs.next()) {
//
//                int code_contrainte= rs.getInt("code_contrainte");
//                String mode_affectation = rs.getString("mode_affectation");
//                int nombre_min_equipe = rs.getInt("nombre_min_equipe");
//                int nombre_max_equipe = rs.getInt("nombre_max_equipe");
//                System.out.println("zzzzzzzz"+nombre_max_equipe);
//                int coefficient = rs.getInt("coefficient");
//                Date date_debut = rs.getDate("date_debut");
//                Date date_fin = rs.getDate("date_fin");
//                Date date_fin_equipe= rs.getDate("date_fin_equipe");
//                Date date_fin_projet= rs.getDate("date_fin_projet");
//                int nbre_choix_fiche_voeux = rs.getInt("nbre_choix_fiche_voeux");
//
//                String code_promo = rs.getString("code_promo");
//                String choice_fiche_voeux_demarrer = rs.getString("choice_fiche_voeux_demarrer");
//                String choice_amiable_demarrer = rs.getString("choice_amiable_demarrer");
//                String soutenance_demarrer= rs.getString("soutenance_demarrer");
//
//
//
//
//
//                contraintes = new Contraintes( code_contrainte,  mode_affectation,  nombre_min_equipe,  nombre_max_equipe,  coefficient,  date_debut,  date_fin,  date_fin_equipe,  date_fin_projet,  nbre_choix_fiche_voeux,  code_promo,  choice_fiche_voeux_demarrer,  choice_amiable_demarrer,  soutenance_demarrer);
//
//                HttpSession session = SessionUtils.getSession();
//                session.setAttribute("promotionContrainte",contraintes);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Login error -->" + ex.getMessage());
//        } finally {
//            DataConnect.close(con);
//        }
//        return contraintes;
//
//    }
}
