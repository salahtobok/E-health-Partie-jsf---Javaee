package Http.Controller.Service;


import DBUtil.Admin.ServiceDBUtil;
import Entities.Medecin;
import Entities.Service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@ManagedBean
@RequestScoped
public class ServiceRequestScopedController implements Serializable{

    @EJB
    ServiceDBUtil serviceDBUtil ;

    private List<Service> services ;
    private List<Service> filteredServices ;
    private Set<Medecin> selectedMedicalStaff;
    private List<Medecin> filteredMedicalStaff;


    @PostConstruct
    public void init() {
        }


    public List<Service> getServices() {
        services =serviceDBUtil.loadServiceList();

        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }


    public List<Service> getFilteredServices() {
//        System.out.println("filtred"+filteredServices.size());
        return filteredServices;
    }

    public void setFilteredServices(List<Service> filteredServices) {
        this.filteredServices = filteredServices;
    }


    public Set<Medecin> getSelectedMedicalStaff() {
        return selectedMedicalStaff;
    }

    public void setSelectedMedicalStaff(Set<Medecin> selectedMedicalStaff) {
        this.selectedMedicalStaff = selectedMedicalStaff;
    }

    public List<Medecin> getFilteredMedicalStaff() {
        return filteredMedicalStaff;
    }

    public void setFilteredMedicalStaff(List<Medecin> filteredMedicalStaff) {
        this.filteredMedicalStaff = filteredMedicalStaff;
    }
}
