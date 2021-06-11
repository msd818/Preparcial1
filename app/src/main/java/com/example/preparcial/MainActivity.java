package com.example.preparcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.List;

import id.ionbit.ionalert.IonAlert;
import models.Persona;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtCargo;
    private EditText txtSalario;
    private EditText txtEdad;
    private Button btnSalarioMayor;
    private Button btnSalarioMenor;
    private Button btnAgregarPersona;
    private Button btnPersonaMenor;
    private Button btnPersonaMayor;
    private Button btnInfoPersona;
    private Button btnSalarioPromedio;
    public List<Persona> listaPersonas= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView();

        btnSalarioMayor.setOnClickListener(this);
        btnSalarioMenor.setOnClickListener(this);
        btnAgregarPersona.setOnClickListener(this);
        btnPersonaMenor.setOnClickListener(this);
        btnPersonaMayor.setOnClickListener(this);
        btnInfoPersona.setOnClickListener(this);
        btnSalarioPromedio.setOnClickListener(this);
    }

    public void setContentView(){
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        txtCargo = findViewById(R.id.txtCargo);
        txtSalario = findViewById(R.id.txtSalario);
        txtEdad = findViewById(R.id.txtEdad);
        btnSalarioMayor = findViewById(R.id.btnSalarioMayor);
        btnSalarioMenor = findViewById(R.id.btnSalarioMenor);
        btnAgregarPersona = findViewById(R.id.btnAgregarPersona);
        btnPersonaMenor = findViewById(R.id.btnPersonaMenor);
        btnPersonaMayor = findViewById(R.id.btnPersonaMayor);
        btnInfoPersona = findViewById(R.id.btnInfoPersona);
        btnSalarioPromedio = findViewById(R.id.btnSalarioPromedio);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAgregarPersona){
            String Name = txtName.getText().toString();
            String LastName = txtLastName.getText().toString();
            String Email = txtEmail.getText().toString();
            String Cargo = txtCargo.getText().toString();
            int Salario = Integer.parseInt(txtSalario.getText().toString());
            int Edad = Integer.parseInt(txtEdad.getText().toString());

            CrearPersona(Name,LastName,Email,Cargo,Salario,Edad);
        }

        else if(v.getId() == R.id.btnPersonaMenor){

            int vMenor= 999999999;
            String nombrePersona= "";
            String edadPersona = "";

            for (int i=0; i<this.listaPersonas.size(); i++){
                if(this.listaPersonas.get(i).getEdad() < vMenor){
                    vMenor = this.listaPersonas.get(i).getEdad();
                    nombrePersona   = this.listaPersonas.get(i).getName()+ " "+ this.listaPersonas.get(i).getLastName()
                    +" con "+this.listaPersonas.get(i).getEdad()+ " años";

                }
            }
            new IonAlert(this, IonAlert.WARNING_TYPE)
                    .setTitleText("LA PERSONA MENOR ES")
                    .setContentText(nombrePersona)
                    .setConfirmText("OK")
                    .show();

        }

        else if(v.getId() == R.id.btnPersonaMayor){
            int vMayor= 0;
            String nombrePersona= "";
            String edadPersona = "";

            for (int i=0; i<this.listaPersonas.size(); i++){
                if(this.listaPersonas.get(i).getEdad() > vMayor){
                    vMayor = this.listaPersonas.get(i).getEdad();
                    nombrePersona = this.listaPersonas.get(i).getName()+ " "+ this.listaPersonas.get(i).getLastName()
                            +" con "+this.listaPersonas.get(i).getEdad()+ " años";

                }
            }
            new IonAlert(this, IonAlert.WARNING_TYPE)
                    .setTitleText("LA PERSONA MAYOR ES")
                    .setContentText(nombrePersona)
                    .setConfirmText("OK")
                    .show();
        }

        else if(v.getId() == R.id.btnSalarioMenor){

            int vMenor= 999999999;
            String nombrePersona= "";

            for (int i=0; i<this.listaPersonas.size(); i++){
                if(this.listaPersonas.get(i).getSalario() < vMenor){
                    vMenor = this.listaPersonas.get(i).getSalario();
                    nombrePersona = this.listaPersonas.get(i).getName()+ " "+ this.listaPersonas.get(i).getLastName()
                            +" con "+this.listaPersonas.get(i).getSalario()+ " salario";

                }
            }
            new IonAlert(this, IonAlert.WARNING_TYPE)
                    .setTitleText("LA PERSONA CON MENOR SALARIO ES")
                    .setContentText(nombrePersona)
                    .setConfirmText("OK")
                    .show();

        }

        else if(v.getId() == R.id.btnSalarioMayor){

            int vMayor= 0;
            String nombrePersona= "";

            for (int i=0; i<this.listaPersonas.size(); i++){
                if(this.listaPersonas.get(i).getSalario() > vMayor){
                    vMayor = this.listaPersonas.get(i).getSalario();
                    nombrePersona = this.listaPersonas.get(i).getName()+ " "+ this.listaPersonas.get(i).getLastName()
                            +" con "+this.listaPersonas.get(i).getSalario()+ " salario";

                }
            }
            new IonAlert(this, IonAlert.WARNING_TYPE)
                    .setTitleText("LA PERSONA CON MAYOR SALARIO ES")
                    .setContentText(nombrePersona)
                    .setConfirmText("OK")
                    .show();


        }

        else if(v.getId() == R.id.btnSalarioPromedio){
            int sumaSueldos=0;
            double promedio = 0.0;
            String vSueldo="";

            for (int i=0; i<this.listaPersonas.size(); i++){
                sumaSueldos= sumaSueldos + this.listaPersonas.get(i).getSalario();
                
            }

            promedio= (sumaSueldos/this.listaPersonas.size());

            new IonAlert(this, IonAlert.WARNING_TYPE)
                    .setTitleText("EL PROMEDIO DE LOS SALARIOS ES")
                    .setContentText(""+promedio+"")
                    .setConfirmText("OK")
                    .show();

        }


    }

    private void CrearPersona(String Name,String LastName, String Email, String Cargo, int Salario, int Edad){
        if(Name.equals("")){
            //CustomToastView.makeErrorToast(this,"Error al validar el nombre",R.layout.custom_toast).show();
            //new IonAlert(this, IonAlert.ERROR_TYPE).setTitleText("Error no se ha podido crear la persona...!").setContentText("Verifique todos los campos!").show();
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo NOMBRE!")
                    .show();
            return;
        }else if(LastName.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo APELLIDO!")
                    .show();
            return;
        }else if(Email.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo CORREO!")
                    .show();
            return;
        }else if(Cargo.equals("")){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo CARGO!")
                    .show();
            return;
        }else if(Salario==0){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo SALARIO!")
                    .show();
            return;
        }else if(Edad ==0){
            new IonAlert(this, IonAlert.ERROR_TYPE)
                    .setTitleText("Error al crear la PERSONA...!")
                    .setContentText("Verifique el campo EDAD!")
                    .show();
            return;
        }else{
            Persona persona = new Persona(Name,LastName,Email,Cargo,Salario,Edad);

            this.listaPersonas.add(persona);

            new IonAlert(this, IonAlert.SUCCESS_TYPE)
                    .setTitleText("PERFECTO!")
                    .setContentText("Se agrego una PERSONA!")
                    .show();
        }

        txtName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        txtEdad.setText("");


    }





}