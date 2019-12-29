package Http.Controller.Operation;


import DAO.Local.IOperationDAOLocal;
import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.OperationDBUtil;
import Entities.Consigne;
import Entities.Operation;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class OperationMedicalStaffRequestScopedController implements Serializable {

    @EJB
    OperationDBUtil operationDBUtil;


    @EJB
    IOperationDAOLocal iOperationDAOLocal;

    private List<Operation> operations;

    private List<Operation> filteredOperations ;

//    private List<String> medicalFileStates;




    @PostConstruct
    public void init(){



//        String[] medicalFileStatesData = new String[3];
//        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
//        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
//        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
//        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }


    public List<Operation> getOperations() {


        int userId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();

        operations = iOperationDAOLocal.myOperations(userId);
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getFilteredOperations() {
        return filteredOperations;
    }

    public void setFilteredOperations(List<Operation> filteredOperations) {
        this.filteredOperations = filteredOperations;
    }
}
