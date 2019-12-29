package Http.Display.Administration.Follow_up;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class QuestionAdministrationController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/administration/follow_up/question/master/question";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}