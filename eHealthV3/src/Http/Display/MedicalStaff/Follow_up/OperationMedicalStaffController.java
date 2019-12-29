package Http.Display.MedicalStaff.Follow_up;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OperationMedicalStaffController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/medicalStaff/follow_up/operation/master/operation";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}