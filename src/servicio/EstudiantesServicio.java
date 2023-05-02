/*
Para esto vamos a tener que crear un objeto de tipo Estudiante, sus atributos van a ser nombre
y nota (representando la nota obtenida en el final). 
La escuela consta con tan solo 8 estudiantes, por lo que deberemos crear los 8 estudiantes
con sus respectivas notas.




na vez creado los estudiantes deberemos guardar los estudiantes en un arreglo de objetos tipo Estudiante,
usando ese arreglo tenemos que realizar las dos tareas que nos ha pedido la escuela.
Calcular y mostrar el promedio de notas de todo el curso
Retornar otro arreglo con los nombre de los alumnos que recibieron una nota mayor al promedio del curso
Por último, deberemos mostrar todos los estudiantes con una nota mayor al promedio.
Nota: para crear un vector de objetos la definición es la siguiente:
Objeto nombreVector[] = new Objeto[];


 */
package servicio;

import entidad.Estudiante;
import java.util.Scanner;

/**
 *
 * @author Alejandro Caro
 */
public class EstudiantesServicio {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    
    public void crearEstudiantes( Estudiante estudiantes[]){
        
        for(int i=0;i<estudiantes.length; i++){
            System.out.println("Ingrese el nombre del estudiante."+(i+1));
            String nombre = sc.next();
            System.out.println("Ingrese la nota del estudiante."+(i+1));
            double nota = sc.nextDouble();
            
            estudiantes[i] = new Estudiante(nombre, nota);
        }
    }
    
    public void mostrarEstudiantes(Estudiante estudiantes[]){
        for(int i=0;i<estudiantes.length;i++){
            System.out.println("Nombre Del alumno"+(i+1)+": "+estudiantes[i].getNombre()+". Nota: "+estudiantes[i].getNota());
        }
    }

//    Calcular y mostrar el promedio de notas de todo el curso
//Retornar otro arreglo con los nombre de los alumnos que recibieron una nota mayor al promedio del curso
    
    public double mostrarPromedio(Estudiante estudiantes[]) {
        int notasSumadas = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            notasSumadas += estudiantes[i].getNota();
        }
        double promedio = (double) notasSumadas / estudiantes.length;
        return promedio;
    }
    
public String[] alumnosMayorPromedio(Estudiante estudiantes[]){
    double promedio = mostrarPromedio(estudiantes);
    int dimension = 0;
    for(int i = 0 ; i < estudiantes.length; i++){
        if(estudiantes[i].getNota() > promedio){
            dimension++;
        }
    }
    String[] nombresAlumnos = new String[dimension];
    int cont = 0;
    
    // Agregar los nombres al arreglo
    for(int i = 0; i < estudiantes.length; i++){
        if(estudiantes[i].getNota() > promedio){
            nombresAlumnos[cont] = estudiantes[i].getNombre();
            cont++;
        }
    }
    return nombresAlumnos;
}
    
    //deberemos mostrar todos los estudiantes con una nota mayor al promedio
    
  public void mostrarAlumnosMayorPromedio(Estudiante estudiantes[]){
    double promedio = mostrarPromedio(estudiantes);
    System.out.println("Alumnos que tienen una nota mayor al promedio:");
    for(int i = 0; i < estudiantes.length; i++){
        if(estudiantes[i].getNota() > promedio){
            System.out.println(estudiantes[i].getNombre());
        }
    }
}
    
}
