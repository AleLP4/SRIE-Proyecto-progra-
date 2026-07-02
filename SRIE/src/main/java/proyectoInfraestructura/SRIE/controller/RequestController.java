package proyectoInfraestructura.SRIE.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import proyectoInfraestructura.SRIE.model.Request;
import proyectoInfraestructura.SRIE.model.dto.RequestDTO;
import proyectoInfraestructura.SRIE.service.RequestService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/request")
@CrossOrigin(origins = "*")
@RestController
public class RequestController {

    @Autowired
    private RequestService service;

    @GetMapping("/all")
    public ResponseEntity<?> showAll() {

        List<Request> requests = service.findAll();

        if (requests == null || requests.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(requests);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody RequestDTO request, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

        Request newRequest = service.add(request);

        if (newRequest == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar la solicitud");
        }

        return ResponseEntity.ok("Solicitud registrada exitosamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Integer id)
    {
        if(service.deleteById(id).equals("Exito!"))
        {
            return ResponseEntity.ok().body("Exito!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro esa solicitud");
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RequestDTO request,@PathVariable Integer id,BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

        Request newRequest = service.update(request,id);

        if (newRequest == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la solicitud");
        }

        return ResponseEntity.ok("Solicitud actualizada exitosamente");
    }

}



