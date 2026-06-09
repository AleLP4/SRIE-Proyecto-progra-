package proyectoInfraestructura.SRIE.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbAdmin")
public class Admin {

    private String name,email,password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Admin(String name, String email,String password) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}