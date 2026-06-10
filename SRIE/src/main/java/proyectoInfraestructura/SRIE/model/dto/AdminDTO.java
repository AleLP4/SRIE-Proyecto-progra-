package proyectoInfraestructura.SRIE.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AdminDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @Email(message = "El correo es inválido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,20}$",
            message = "La contraseña debe tener al menos una mayúscula, un número, un carácter especial y mínimo 8 caracteres"
    )
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
