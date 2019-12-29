package Http.Display.Administration.Infrastructure;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InfrastructureController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/administration/infrastructure/service/master/service";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}