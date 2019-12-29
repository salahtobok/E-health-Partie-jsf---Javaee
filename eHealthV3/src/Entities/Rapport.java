package Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Rapport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRapport;

    @Column(name = "attachement",length=16777210)
    private byte[] attachement;

    @NotNull
    private String type;

    @Column(name = "date_rapport")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRapport;

    @ManyToOne
    @JoinColumn(name = "idOperation")
    private Operation operation;


    //-----------Constructor--------

    public Rapport() { }



    public Rapport(byte[] attachement, @NotNull String type, Date dateRapport, Operation operation) {
        this.attachement = attachement;
        this.type = type;
        this.dateRapport = dateRapport;
        this.operation = operation;
    }

    //-----------Gettet & Setter--------


    public int getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(int idRapport) {
        this.idRapport = idRapport;
    }

    public byte[] getAttachement() {
        return attachement;
    }

    public void setAttachement(byte[] attachement) {
        this.attachement = attachement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateRapport() {
        return dateRapport;
    }

    public void setDateRapport(Date dateRapport) {
        this.dateRapport = dateRapport;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
