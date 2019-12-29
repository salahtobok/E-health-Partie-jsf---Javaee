package Test;

import DAO.Local.IMedecinDAOLocal;
import DAO.Local.IPatientDAOLocal;
import DAO.Local.IServiceDAOLocal;
import Entities.*;
import Entities.Embeddable.Adresse;
import Enumeration.Civility;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "Test.MainServlet", urlPatterns = "/Test.MainServlet")
public class MainServlet extends HttpServlet {



    @EJB
    IPatientDAOLocal iPatientDAOLocal ;
    @EJB
    IMedecinDAOLocal iMedecinDAOLocal;
    @EJB
    IServiceDAOLocal iServiceDAOLocal ;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();

        try{

           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

           Adresse adresse =  new Adresse(12,"rue",31000,"Oran");
           ComptePatient compte = new ComptePatient("000001","abcd12345");
           DossierMedical dossierMedical = new DossierMedical(new Date());


            Patient patient1 = new Patient("BL2406","LAMRI","Brahim",dateFormat.parse("1995-06-24"),"Oran"
                                            ,Civility.HOMME,"00000001","b.lamri@esi-sba.dz",adresse
                                            ,compte,dossierMedical);
            iPatientDAOLocal.create(patient1);

           /* Service service1 = new Service("Service1");
            iServiceDAOLocal.create(service1);


            Medecin medecin1 = new Medecin("MAHMOUD","Ali",dateFormat.parse("1965-06-24"),"Oran","Généraliste",Civility.HOMME,"a.a@a.com","000002",service1);
            iMedecinDAOLocal.create(medecin1);*/


            out.println("<html>" +
                    "<head></head>" +
                    "<body> <p> Le patient "+patient1.getNom() +"</p>"+
                    "<p> Le medecin "+"</p> "+
                     "<p> le service"+"</p>"+
                    "</body>" +
                    "</html>");



        }catch(Exception e){
            e.printStackTrace();

        }finally {

            out.close();
        }


    }
}
