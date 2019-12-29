import DAO.Implementation.PatientDAOImplBean;
import DAO.Local.IMedecinDAOLocal;
import DAO.Local.IPatientDAOLocal;
import DAO.Local.IServiceDAOLocal;
import Entities.ComptePatient;
import Entities.DossierMedical;
import Entities.Embeddable.Adresse;
import Entities.Patient;
import Enumeration.Civility;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {


//    @EJB
//    IPatientDAOLocal  iPatientDAOLocal =new PatientDAOImplBean();
//    @EJB
//    IMedecinDAOLocal iMedecinDAOLocal;
//    @EJB
//    IServiceDAOLocal iServiceDAOLocal ;
    public static void  main(String args[]){
        PatientDAOImplBean  iPatientDAOLocal =new PatientDAOImplBean();

        Civility civilityCasPossible[] = {Civility.HOMME, Civility.FEMME};
        Faker faker = new Faker();

        try{

//            for (int i=0;i<=20;i++){


//                Adresse adresse =  new Adresse(12,"rue",31000,"Oran");
                Adresse adresse =  new Adresse(faker.number().randomDigit(),faker.address().streetAddress(),faker.number().numberBetween(5,5),faker.address().city());
                ComptePatient compte = new ComptePatient(faker.phoneNumber().cellPhone(),String.valueOf(faker.number().randomDigit()));
                DossierMedical dossierMedical = new DossierMedical(faker.date().birthday());


                Patient patient1 = new Patient(faker.business().creditCardNumber()
                        ,faker.name().lastName()
                        ,faker.name().firstName()
                        ,faker.date().birthday()
                        ,faker.address().country()
                        , getRandomCivilityCas(civilityCasPossible)
                        ,faker.phoneNumber().cellPhone()
                        ,faker.name().firstName()+"@esi-sba.dz"
                        ,adresse
                        ,compte,dossierMedical);


                compte.setPatient(patient1);
                dossierMedical.setPatient(patient1);



                iPatientDAOLocal.create(patient1);
//            }


           /* Service service1 = new Service("Service1");
            iServiceDAOLocal.create(service1);


            Medecin medecin1 = new Medecin("MAHMOUD","Ali",dateFormat.parse("1965-06-24"),"Oran","Généraliste",Civility.HOMME,"a.a@a.com","000002",service1);
            iMedecinDAOLocal.create(medecin1);*/

        }catch(Exception e){
            e.printStackTrace();

        }finally {

        }
    }


    private static Civility getRandomCivilityCas(Civility civilityCasPossible[]) {
        return civilityCasPossible[(int) (Math.random() * civilityCasPossible.length)];
    }

}
