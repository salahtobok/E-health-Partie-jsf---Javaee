package Http.Display.MedicalStaff;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


/**
 * Created by salahtobok on 22/04/17.
 */
@ManagedBean
@SessionScoped
public class MedicalStaffLayoutController {

    private String page;


    @PostConstruct
    public void init() {
                this.page = "/resources/views/user/medicalStaff/patient/medical_account/medical_account";
    }

    public String getPage() {
        return page;
    }


    public void setPage(String page) {

        this.page = page;
    }


}
