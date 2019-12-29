package Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FicheMedical implements Serializable {

     /*-----------------
     Declaration
    ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFicheMedical ;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "date_Creataion")
    private Date dateCreation;

    @Column(name = "attachement",length=16777210)
    private byte[] attachement;

    @NotNull
    @Column(name = "detail")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "idDossierMedical")
    private DossierMedical dossierMedical ;


    /*------------
   Getters & Setters
   -------------*/

    public int getIdFicheMedical() {
        return idFicheMedical;
    }

    public void setIdFicheMedical(int idFicheMedical) {
        this.idFicheMedical = idFicheMedical;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public byte[] getAttachement() {
        return attachement;
    }

    public void setAttachement(byte[] attachement) {
        this.attachement = attachement;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }



/*------------
    Constructeur
    -------------*/

    public FicheMedical(Date dateCreation, DossierMedical dossierMedical) {
        this.dateCreation = dateCreation;
        this.dossierMedical = dossierMedical;
    }

    public FicheMedical() {
    }
}
