package models;

public class Persona {
    private String Name;
    private String LastName;
    private String Email;
    private String Cargo;
    private int Salario;
    private int Edad;

    public Persona() {
    }

    public Persona(String name, String lastName, String email, String cargo, int salario, int edad) {
        Name = name;
        LastName = lastName;
        Email = email;
        Cargo = cargo;
        Salario = salario;
        Edad = edad;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}

