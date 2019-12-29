package Test;

import Handler.PropertiesHandler;

public class Main {


//    @EJB
//    IPatientDAOLocal  iPatientDAOLocal =new PatientDAOImplBean();
//    @EJB
//    IMedecinDAOLocal iMedecinDAOLocal;
//    @EJB
//    IServiceDAOLocal iServiceDAOLocal ;





    public static void  main(String args[]) {


//        SMTPController smtpController =new SMTPController();
//
//
//        smtpController.send();
//
//        ResourceBundle bundle = ResourceBundle.getBundle("messages");
//        System.out.println(bundle.getString("activation_code"));
try {


//    Properties defaultProperties = new Properties();
//    defaultProperties.load(new FileInputStream("messeges_fr.properties"));

//    Properties properties = new Properties(defaultProperties);


//    defaultProperties.load(Test.Main.class.getClassLoader().getResourceAsStream("messeges_fr.properties));
//
//    System.out.println(defaultProperties.getProperty("activation_code"));

    System.out.println(PropertiesHandler.getProperty(Main.class,"messeges_fr.properties","activation_code"));

//    Properties defaultProperties = new Properties();
//    defaultProperties.load(new FileInputStream("messeges_fr.properties"));

//    Properties properties = new Properties(defaultProperties);

//    properties.load(new FileInputStream("messeges_fr.properties"));



//    System.out.println(defaultProperties.getProperty("activation_code"));

}catch (Exception e){

}
    }
}
