package Http.Controller.MedicalStaff;


import DAO.Implementation.ServiceDAOImplBean;
import DBUtil.Admin.MedicalStaffDBUtil;
import DBUtil.Admin.ServiceDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Medecin;
import Entities.Service;
import Handler.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
public class MedicalStaffViewScopedController implements Serializable {

    @EJB
    MedicalStaffDBUtil medicalStaffDBUtil;

    @EJB
    ServiceDBUtil serviceDBUtil;


    private String selectedServiceName;


    private Medecin selectedMedecin;

    private Medecin newMedecin;

    private List<Service> serviceList;


    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {


        /*create fake medical staff*/
        newMedecin = medicalStaffDBUtil.createFakeMedecin();


        serviceList = serviceDBUtil.loadServiceList();
    }


    public Medecin getSelectedMedecin()
    {
        return selectedMedecin;
    }

    public void setSelectedMedecin(Medecin selectedMedecin) {
        this.selectedMedecin = selectedMedecin;
    }

    public Medecin getNewMedecin() {
        return newMedecin;
    }

    public void setNewMedecin(Medecin newMedecin) {
        this.newMedecin = newMedecin;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public String getSelectedServiceName() {
        return selectedServiceName;
    }

    public void setSelectedServiceName(String selectedServiceName) {
        this.selectedServiceName = selectedServiceName;
    }

    public void create() {


        for (Service service : serviceList) {

            if (service.getNom().equals(selectedServiceName)) {
                newMedecin.setService(service);
            }
        }

        newMedecin.setIdMedecin(0);


        if (medicalStaffDBUtil.createMedecin(newMedecin))
            showInfo(successMsg);
        else
            showError(failMsg);

    }


    public void update() {

        for (Service service : serviceList) {

            if (service.getNom().equals(selectedServiceName)) {
                selectedMedecin.setService(service);
            }
        }


        if (medicalStaffDBUtil.updateMedecin(selectedMedecin))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void delete() {
        if (medicalStaffDBUtil.deleteMedecin(selectedMedecin))
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
