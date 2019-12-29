package Http.Display.Administration.Patient;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MedicalAccountAdministrationController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/administration/patient/medical_account/master/account";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}