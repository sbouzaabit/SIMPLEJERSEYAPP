package cap.bouygues.model;

/**
 * Created by sbouzaab on 14/09/2016.
 */

import javax.persistence.*;

@Entity
//@Table(name = "person")
//@NamedQueries( { @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
//@NamedQuery(name = "Person.findPerson", query = "SELECT p FROM Person p where p.name=:name and p.age=:age")})
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String email;


    @Column
    private String numTele;

    public Long getId() {
        return id;
    }

    public void setId(Long personId) {
        this.id = personId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTele() {
        return numTele;
    }

    public void setNumTele(String numTele) {
        this.numTele = numTele;
    }

}
