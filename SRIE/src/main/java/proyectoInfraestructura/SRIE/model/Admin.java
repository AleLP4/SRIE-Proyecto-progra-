package proyectoInfraestructura.SRIE.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbAdmin")
public class Admin {

    private String name,mail,password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Admin(String name, String mail,String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public Admin() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
