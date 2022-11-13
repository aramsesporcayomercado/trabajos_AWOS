package mx.edu.utez.personal4b.estudiante;

import mx.edu.utez.personal4b.materias.BeanMaterias;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class BeanEstudiante {

    private String matricula;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String curp;
    private int calificaciones;

    private BeanMaterias materias;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int calificaciones) {
        this.calificaciones = calificaciones;
    }

    public BeanMaterias getMaterias() {
        return materias;
    }

    public void setMaterias(BeanMaterias materias) {
        this.materias = materias;
    }
}
