package growby.asistencia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcaciones")
public class Marcacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marcacion;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private LocalDateTime fechaHoraEntrada;

    private LocalDateTime fechaHoraSalida;

    // Getters y setters, constructors, etc.
    
    public Marcacion() {
		super();
	}

	public Marcacion(Long id_marcacion, Empleado empleado, LocalDateTime fechaHoraEntrada,
			LocalDateTime fechaHoraSalida) {
		super();
		this.id_marcacion = id_marcacion;
		this.empleado = empleado;
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Long getId_marcacion() {
		return id_marcacion;
	}

	public void setId_marcacion(Long id_marcacion) {
		this.id_marcacion = id_marcacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDateTime getFechaHoraEntrada() {
		return fechaHoraEntrada;
	}

	public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
		this.fechaHoraEntrada = fechaHoraEntrada;
	}

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
}
