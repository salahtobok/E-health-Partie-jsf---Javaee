package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Question implements Serializable {


    /*-----------------
    Declaration
   ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    private String Contenu;

    @ManyToOne
    @JoinColumn(name = "idQuestionnaire")
    private Questionnaire questionnaire ;

     /*------------
    Getters & Setters
    -------------*/

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    /*------------
    Constructeur
    -------------*/

    public Question() {
    }

    public Question(@NotNull String contenu, Questionnaire questionnaire) {
        Contenu = contenu;
        this.questionnaire = questionnaire;
    }
}
