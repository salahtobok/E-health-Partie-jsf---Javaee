package Http.Controller;


import DBUtil.Admin.MedicalStaffDBUtil;
import DBUtil.Authentification.LoginAdministrationDbUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.CompteAdministration;
import Entities.ComptePersonneMedical;
import Handler.PropertiesHandler;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class UserController implements Serializable {




    private String successMsg = PropertiesHandler.getProperty(UserController.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(UserController.class, "messeges_fr.properties", "failure_update");


    ComptePersonneMedical comptePersonneMedical;

    @EJB
    MedicalStaffDBUtil medicalStaffDBUtil;

    @PostConstruct
    public void init() {


        comptePersonneMedical  = SessionUtils.getUserAccount();

    }


    public ComptePersonneMedical getComptePersonneMedical() {
        return comptePersonneMedical;
    }

    public void setComptePersonneMedical(ComptePersonneMedical comptePersonneMedical) {
        this.comptePersonneMedical = comptePersonneMedical;
    }




    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (medicalStaffDBUtil.updateMedecin(comptePersonneMedical.getMedecin()))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }



    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/public/pages/landingpage.xhtml?faces-redirect=true";
    }


}
