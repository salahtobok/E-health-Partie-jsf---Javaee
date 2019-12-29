package Http.Display.MedicalStaff.Patient;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MedicalFolderMedicalStaffController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/medicalStaff/patient/medical_folder/master/folder";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}