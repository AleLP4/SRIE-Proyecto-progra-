package proyectoInfraestructura.SRIE.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbUsers")
public class Users {

    private String name,email,career,password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Users(String name, String email, String career, String password) {
        this.name = name;
        this.email = email;
        this.career = career;
        this.password = password;
    }

    public Users() {
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}