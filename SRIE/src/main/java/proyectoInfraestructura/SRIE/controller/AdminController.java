package proyectoInfraestructura.SRIE.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import proyectoInfraestructura.SRIE.model.Admin;
import proyectoInfraestructura.SRIE.model.Users;
import proyectoInfraestructura.SRIE.model.dto.AdminDTO;
import proyectoInfraestructura.SRIE.model.dto.LoginDTO;
import proyectoInfraestructura.SRIE.model.dto.UsersDTO;
import proyectoInfraestructura.SRIE.service.AdminService;
import proyectoInfraestructura.SRIE.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;
    //private UsersService uService;

    @GetMapping("/allAdmins")
    public ResponseEntity<?> showAllAdm()
    {
        List<Admin> admins = service.findAllAdm();
        if(admins==null)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(admins);
        }

    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> showAllUs()
    {
        List<Users> users = service.findAllUs();
        if(users==null)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(users);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AdminDTO admin, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (service.add(admin) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está registrado o faltan campos obligatorios");
        }
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id)
    {
        Admin admin = service.getById(id.intValue());
        if(admin==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro un Administrador con ese Id");
        }
        else {
            return ResponseEntity.ok(admin);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Integer id,@Valid @RequestBody AdminDTO admin)
    {
//        Admin admin1 = service.getById(id.intValue());
//        if(admin1==null)
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro un Administrador con ese Id");
//        }
//        service.update(admin);
//        return ResponseEntity.ok("Actualizado correctamente");

        if (service.update(admin) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        if (service.delete(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO login) {
        if (service.login(login) == false) {
            return ResponseEntity.ok(false);

        }
        return ResponseEntity.ok(true);

    }

}
