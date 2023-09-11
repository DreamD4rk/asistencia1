package growby.asistencia.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import growby.asistencia.model.Empleado;
import growby.asistencia.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	public Empleado Registrar(Empleado empleado) {
		return empleadoRepository.saveAndFlush(empleado);
	}
	
	public List<Empleado> Listar(){
		return (List<Empleado>) empleadoRepository.findAll();
	}
	
	public Optional<Empleado> ListarId(Long id_empleado){
		return empleadoRepository.findById(id_empleado);
	}
	
	public Empleado Actualizar(Long id_empleado, Empleado empleado) {
		Empleado existingEmpleado = empleadoRepository.findById(id_empleado).orElse(null);
		if (existingEmpleado != null) {
			existingEmpleado.setPassword(empleado.getPassword());
            existingEmpleado.setEsAdmin(false);
            return empleadoRepository.save(existingEmpleado);
		}
		return null;
	}
	
	public void DeleteUserById(Long id_empleado) {
		empleadoRepository.deleteById(id_empleado);
	}
}