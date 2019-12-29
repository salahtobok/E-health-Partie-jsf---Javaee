package SessionUtil;

//import Core.Enseignant.extendedClasses.Enseignant_interne;
//import Core.Etudiant.Etudiant;
//import Core.Generale.Contraintes;
//import Core.Generale.Equipe;
//import Core.Generale.Soutenance;

import Entities.ComptePersonneMedical;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	/*public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}*/

	public static String getEmail() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("email").toString();
	}

	public static String getCompteType() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("compteType").toString();
	}

	public static ComptePersonneMedical getUserAccount() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (ComptePersonneMedical)session.getAttribute("userAccount");
	}

//	public static Enseignant_interne getEnseignantContrainte() {
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//				.getExternalContext().getSession(false);
//		return (Enseignant_interne)session.getAttribute("enseignantContrainte");
//	}
//
//	public static Etudiant getEtudiantContrainte() {
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//				.getExternalContext().getSession(false);
//		return (Etudiant) session.getAttribute("etudiantContrainte");
//	}
//
//	public static Contraintes getPromotionContrainte(){
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//				.getExternalContext().getSession(false);
//		return (Contraintes) session.getAttribute("promotionContrainte");
//	}
//
//	public static Soutenance getSoutenanceContrainte(){
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//				.getExternalContext().getSession(false);
//		return (Soutenance) session.getAttribute("soutenanceContrainte");
//	}
//
//
//	public static Equipe getEquipeConstraintes(){
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//				.getExternalContext().getSession(false);
//		return (Equipe) session.getAttribute("equipeConstraintes");
//	}



	/*public static String Filter() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}*/
}
