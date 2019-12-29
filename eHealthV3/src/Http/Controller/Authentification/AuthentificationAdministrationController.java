package Http.Controller.Authentification;


import DBUtil.Authentification.LoginAdministrationDbUtil;

import Entities.CompteAdministration;
import Handler.PropertiesHandler;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class AuthentificationAdministrationController implements Serializable {

    @EJB
    LoginAdministrationDbUtil loginDbUtil;

    HttpSession session = SessionUtils.getSession();


    private String login;
    private String password;


    private CompteAdministration userCompte;

    private String successMsg = "Signé";
    private String failMsg = "Erreur d'accès";

    @PostConstruct
    public void init() {
    }


    public String authenticate() {

        boolean authenticate = false;

        CompteAdministration userAccount = loginDbUtil.authenticate(login, password);
        if (userAccount != null) {

            showInfo(successMsg);
            authenticate = true;
        } else
            showError(failMsg);


        if (authenticate) {
            session.setAttribute("userAccount", userAccount);
            return "/public/pages/administration/dashboard.xhtml";
        }else
            return null;
    }


    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompteAdministration getUserCompte() {
        return userCompte;
    }

    public void setUserCompte(CompteAdministration userCompte) {
        this.userCompte = userCompte;
    }
}
