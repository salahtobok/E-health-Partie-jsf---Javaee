package Entities;

import Enumeration.Periode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.*;

@Entity
public class Questionnaire implements Serializable {

      /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestionnaire;


    @Column(name = "date_questionnaire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateQuestionnaire;

    @NotNull
    @Enumerated
    private Periode periode ;


    @ManyToOne
    @JoinColumn(name = "idOperation")
    private Operation operation;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "questionnaire"  ,  orphanRemoval = true)
    private Set<Question> lesQuestions = new HashSet<>();



      /*------------
    Getters & Setters
    -------------*/

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public Date getDateQuestionnaire() {
        return dateQuestionnaire;
    }

    public void setDateQuestionnaire(Date dateQuestionnaire) {
        this.dateQuestionnaire = dateQuestionnaire;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Set<Question> getLesQuestions() {
        return lesQuestions;
    }

    public void setLesQuestions(Set<Question> lesQuestions) {
        this.lesQuestions = lesQuestions;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    /*------------
    Constructeur
    -------------*/

    public Questionnaire() {
    }

    public Questionnaire(Date dateQuestionnaire) {
        this.dateQuestionnaire = dateQuestionnaire;
    }
}

