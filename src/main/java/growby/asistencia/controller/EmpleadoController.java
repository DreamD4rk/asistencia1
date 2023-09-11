package growby.asistencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import growby.asistencia.model.Empleado;
import growby.asistencia.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;
	
	@Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
	
	@GetMapping("/listar")
    public List<Empleado> getAllEmpleados() {
        return empleadoService.Listar();
    }
	
	@GetMapping("listarId/{id_empleado}")
    public Optional<Empleado> getEmpleadoById(@PathVariable Long id_empleado) {
        return empleadoService.ListarId(id_empleado);
    }
	
	@PostMapping("/agregar")
    public Empleado addEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.Registrar(empleado);
    }
	
	@PutMapping("/editar/{id_empleado}")
    public Empleado updateEmpleado(@PathVariable Long id_empleado, @RequestBody Empleado empleado) {
        return empleadoService.Actualizar(id_empleado, empleado);
    }
	
	@DeleteMapping("/eliminar/{id_empleado}")
    public void deleteEmpleado(@PathVariable Long id_empleado) {
        empleadoService.DeleteUserById(id_empleado);
    }
	
}