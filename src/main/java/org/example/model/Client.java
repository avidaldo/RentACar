package org.example.model;

public class Client extends Entity{

    private String dni;
    private String name;
    private String surname;

    public Client(Long id, String dni, String name, String surname) {
        super(id);
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public Client(String dni, String name, String surname) {
        super();
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.getId() + " " + name + " " + surname;
    }
}
