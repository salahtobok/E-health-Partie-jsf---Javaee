package Http.Controller.Service;


import DBUtil.Admin.ServiceDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Medecin;
import Entities.Patient;
import Entities.Service;
import Handler.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class ServiceViewScopedController implements Serializable{

    @EJB
    ServiceDBUtil serviceDBUtil ;

    private Service selectedService;

    private Service newService;


    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {
        newService = serviceDBUtil.createFakeService() ;
    }


    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    public Service getNewService() {
        return newService;
    }

    public void setNewService(Service newService) {
        this.newService = newService;
    }


    public void create() {
        newService.setIdService(0);
        if (serviceDBUtil.createService(newService))
            showInfo(successMsg);
        else
            showError(failMsg);

    }


    public void update() {
        if (serviceDBUtil.updateService(selectedService))
            showInfo(successMsg);
        else
            showError(failMsg);
    }
//
    public void delete() {
        if (serviceDBUtil.deleteService(selectedService))
            showInfo(successMsg);
        else
            showError(failMsg);
    }





    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
