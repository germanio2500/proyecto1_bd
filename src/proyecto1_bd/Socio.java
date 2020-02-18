/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_bd;

/**
 *
 * @author lv1013
 */
public class Socio {
    
    private int id;
    
    private String nombre;

    private String direccion;
    private String age;

    public Socio() {
    }

    public Socio(int id, String nombre, String direccion, String age) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.age=age;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
