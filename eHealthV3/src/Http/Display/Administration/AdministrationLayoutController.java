package Http.Display.Administration;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * Created by salahtobok on 22/04/17.
 */
@ManagedBean
@SessionScoped
public class AdministrationLayoutController {

    private String page;


    @PostConstruct
    public void init() {
                this.page = "/resources/views/user/administration/landing";
    }

    public String getPage() {
        return page;
    }


    public void setPage(String page) {

        this.page = page;
    }


}
