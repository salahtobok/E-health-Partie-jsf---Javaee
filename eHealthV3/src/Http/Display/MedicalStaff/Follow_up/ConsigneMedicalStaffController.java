package Http.Display.MedicalStaff.Follow_up;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConsigneMedicalStaffController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/medicalStaff/follow_up/consigne/master/consigne";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}