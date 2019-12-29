package Http.Controller.MedicalStaff;

import SessionUtil.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * Created by salahtobok on 14/04/17.
 */
@ManagedBean
@ApplicationScoped
public class UtilisateurController {
//
//        private String email;
//        private String password;
//        private boolean emailValidate=false;
//        private boolean passwordValidate=false;
//
//        public UtilisateurController() {
//        }
//        public UtilisateurController(String email, String password) {
//            this.email = email;
//            this.password = password;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//    public boolean isEmailValidate() {
//
//        return emailValidate;
//    }
//
//    public void setEmailValidate(boolean emailValidate) {
//        this.emailValidate = emailValidate;
//    }
//
//    public boolean isPasswordValidate() {
//        return passwordValidate;
//    }
//
//    public void setPasswordValidate(boolean passwordValidate) {
//        this.passwordValidate = passwordValidate;
//    }
//
//    public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//        if (value == null) {
//            return;
//        }
//        String data = value.toString();
//        final Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
//        if (!pattern.matcher(data).matches()) {
//            if (isEmailValidate())
//                setEmailValidate(false);
//            FacesMessage message = new FacesMessage("⊗");
//            throw new ValidatorException(message);
//        }else {
//            setEmail(data);
//            setEmailValidate(true);
//        }
//    }
//
//
//    public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//        if (value == null) {
//            return;
//        }
//        String data = value.toString();
//        if (data.length()<5) {
//            if (isEmailValidate())
//                setEmailValidate(false);
//            FacesMessage message = new FacesMessage("⊗");
//            throw new ValidatorException(message);
//        }else {
//            setEmail(data);
//            setEmailValidate(true);
//        }
//    }
//
//    //validate login
//    public String validateUsernamePassword() {
//        boolean valid = LoginMedicalStaffDbUtil.validate(getEmail(), getPassword());
//        if (valid) {
//            HttpSession session = SessionUtils.getSession();
//            session.setAttribute("email", getEmail());
//
//            String page=null;
//
//            if (SessionUtils.getCompteType().equals("etudiant")){
//                //Load promotion contraintes and student data
//                EtudiantDbUtil.loadEtudiantData();
//                ContraintesDbUtil.loadContraintes();
//                SoutenanceController.loadSoutnanceConstraintes();
//                page= "/studentSession.xhtml";
//                return page;
//            }
//            else if (SessionUtils.getCompteType().equals("enseignant"))
//                EnseignantDbUtil.loadEnseignantData();
//            page= "/teacherSession.xhtml";
//            return page;
//        } else {
//            return "/Modals/identificationError.xhtml";
//        }
//    }
//
//    //logout event, invalidate session
//    public String logout() {
//        HttpSession session = SessionUtils.getSession();
//        session.invalidate();
//        return "/loginPage.xhtml?faces-redirect=true";
//    }



}

