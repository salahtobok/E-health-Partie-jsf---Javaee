package Http.Controller.Report;


import DAO.Local.IRapportDAOLocal;
import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.MyConsigneDBUtil;
import DBUtil.MedicalStaff.ReportDBUtil;
import Entities.Consigne;
import Entities.Rapport;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ReportMedicalStaffRequestScopedController implements Serializable {

    //    @EJB
//    MyConsigneDBUtil myConsigneDBUtil;
//
    @EJB
    ReportDBUtil reportDBUtil;

    @EJB
    IRapportDAOLocal iRapportDAOLocal;
    //
//    private List<Consigne> myConsignes;
//
//    private List<Consigne> filteredmyConsignes ;
//
//
    private List<Rapport> rapports;

    private List<Rapport> filteredRapports;

//    private List<String> medicalFileStates;


    @PostConstruct
    public void init() {


//        String[] medicalFileStatesData = new String[3];
//        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
//        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
//        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
//        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }

    public List<Rapport> getRapports() {
        int medcineId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();
        rapports =  iRapportDAOLocal.myRapport(medcineId);
        return rapports;
    }

    public void setRapports(List<Rapport> rapports) {
        this.rapports = rapports;
    }

    public List<Rapport> getFilteredRapports() {
        return filteredRapports;
    }

    public void setFilteredRapports(List<Rapport> filteredRapports) {
        this.filteredRapports = filteredRapports;
    }
}
