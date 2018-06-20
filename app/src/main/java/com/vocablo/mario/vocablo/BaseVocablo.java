package com.vocablo.mario.vocablo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseVocablo extends SQLiteOpenHelper {
    //declaración del método base
    BaseVocablo(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "VOCABLO", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Creación de toda la base de datos en SQLite
        db.execSQL("CREATE TABLE VOCABLO (" +
                "claveInstituto INTEGER Constraint PK_claveInstitucionVocablo Primary Key Autoincrement, " +
                "domicilio text not null," +
                "codigoPostal INTEGER not null," +
                "Telefono TEXT Constraint DF_telefonoVocablo Default '00-000-00-00000' Constraint UK_telefonoVocablo Unique)");

        //Inserta los datos de la sucursal de Vocablo
        ContentValues valores = new ContentValues();
        //Inserción de los datos al contenedor
        valores.put("claveInstituto", "Colima");
        valores.put("domicilio", "Calzada Galván Sur #225 Col. San Pablo Colima, Col.");
        valores.put("codigoPostal", 28060);
        valores.put("Telefono", "(312)312-47-44");
        //Inserción a la tabla Vocablo
        this.getWritableDatabase().insert("VOCABLO", null, valores);

        db.execSQL("Create table Alumno(" +
                "MembresiaAlumno TEXT not null Constraint PK_numMembreAlumno Primary Key, " +
                "Nombre TEXT not null," +
                "Password TEXT not null," +
                "apellidoPaterno TEXT not null, " +
                "apellidoMaterno TEXT not null," +
                "Telefono TEXT Constraint DF_telefonoAlumno Default '00-000-00-00000', " +
                "Correo TEXT not null Constraint UK_correoAlumno Unique," +
                "Domicilio TEXT," +
                "HorasAsistidas INTEGER not null Constraint DF_horasAsistidasAlumno Default 0 Constraint CK_defaultAlumno check (HorasAsistidas between 0 and 320)," +
                "FechaNac TEXT not null," +
                "FechaIngreso TEXT," +
                "Genero TEXT not null Constraint CK_generoAlumno Check (Genero in ('m','f')), " +
                "NivelIngles TEXT not null)");

        db.execSQL("Create Table alumnoVocablo (" +
                "ClaveVocablo INTEGER not null," +
                "MembresiaAlumno TEXT not null," +
                "Constraint FK_claveVocabloAlumnoVocablo Foreign Key (ClaveVocablo) References Vocablo (claveInstituto)," +
                "Constraint FK_membresiaAlumnoAlumnoVocablo Foreign Key (MembresiaAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Maestro( " +
                "NumeroCuenta TEXT not null Constraint PK_numeroCuentaMaestro Primary Key,"+
                "Password TEXT not null," +
                "ClaveVocablo INTEGER not null,"+
                "RFC TEXT not null Constraint UK_RFCMaestro unique Constraint CK_rfcMaestro Check (RFC like('[A-Z][A-Z][A-Z][A-Z]-[0-9][0-9][0-9][0-9][0-9][0-9]')),"+
                "Nombre TEXT not null, "+
                "apellidoPaterno TEXT not null,"+
                "apellidoMaterno TEXT not null,"+
                "Telefono TEXT Constraint DF_telefonoMaestro default '00-000-00-00000' Constraint UK_telefonoMaestro unique,"+
                "Correo TEXT not null Constraint UK_correoMaestro Unique, "+
                "FechaNac TEXT not null,"+
                "FechaIngreso TEXT," +
                "Carrera TEXT not null," +
                "NumCedula TEXT not null Constraint UK_numCedulaMaestro Unique, " +
                "Genero TEXT not null Constraint CK_generoMaestro check (Genero in ('m','f')), "+
                "nivelEstudio TEXT not null,"+
                "Estado INTEGER Constraint DF_estadoMaestro Default '0' Constraint CK_estadoMaestro Check (Estado in ('0', '1')),"+
                "Constraint FK_claveVocabloMaestro Foreign Key (ClaveVocablo) References Vocablo (claveInstituto)) ");

        db.execSQL("Create table Diagnostico (" +
                "Clave INTEGER not null Constraint PK_ClaveDiagnostico Primary Key Autoincrement," +
                "claveVocablo INTEGER not null," +
                "Nombre TEXT not null," +
                "apellidoPaterno TEXT not null," +
                "apellidoMaterno TEXT not null," +
                "Telefono TEXT Constraint DF_telefonoUsuario Default '00-000-00-00000'," +
                "Correo TEXT not null Constraint UK_correoDiagnostico Unique," +
                "NivelAlcanzado TEXT not null," +
                "FechaRealizacion TEXT not null," +
                "Constraint FK_claveVocabloDiagnostico Foreign Key (claveVocablo) References Vocablo (claveInstituto))");

        db.execSQL("Create Table Critica (" +
                "claveCritica INTEGER not null Constraint PK_claveCritica Primary Key Autoincrement," +
                "claveAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Critica TEXT not null," +
                "Constraint FK_membresiaCritica Foreign Key (claveAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Pagos (" +
                "clavePago INTEGER not null Constraint PK_clavePagos Primary Key Autoincrement," +
                "claveAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Monto INTEGER  not null Constraint CK_montoPagos Check (Monto >= 0)," +
                "Constraint FK_claveAlumnoPagos Foreign Key (claveAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Cita(" +
                "claveCita INTEGER not null Constraint PK_claveCita Primary Key Autoincrement," +
                "membresiaDocente TEXT," +
                "membresiaAlumno TEXT not null," +
                "fecha TEXT not null," +
                "hora TEXT not null," +
                "Asistencia INTEGER not null Constraint DF_estadoAsistencia Default '1' Constraint CK_estadoAsistencia Check (Asistencia in('1', '2', '3', '4'))," +
                "Constraint FK_membresiaDocenteCita Foreign Key (membresiaDocente) References Maestro (NumeroCuenta)," +
                "Constraint FK_membresiaAlumnoCita Foreign Key (membresiaAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Evaluacion(" +
                "claveEvaluacion INTEGER not null Constraint PK_claveEvaluacion Primary Key Autoincrement," +
                "claveAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Evaluacion INTEGER not null Constraint CK_calificacionEvaluacion Check (Evaluacion between 0 and 100)," +
                "claveDocente TEXT not null," +
                "Constraint FK_membresiaAlumnoEvaluacion Foreign Key (claveAlumno) References Alumno (MembresiaAlumno)," +
                "Constraint FK_membresiaDoceneteEvaluacion Foreign Key (claveDocente) References Maestro (NumeroCuenta))");

        db.execSQL("Create Table Administrativo (" +
                "membresiaAdministrativo TEXT not null Constraint PK_membresiaAdministrativo Primary Key," +
                "Password TEXT not null," +
                "claveVocablo INTEGER not null," +
                "RFC TEXT not null Constraint UK_RFCAdministrativo Unique Constraint CK_rfcAdministrativo Check (RFC like('[A-Z][A-Z][A-Z][A-Z]-[0-9][0-9][0-9][0-9][0-9][0-9]'))," +
                "Nombre TEXT not null," +
                "apellidoPaterno TEXT not null," +
                "apellidoMaterno TEXT not null," +
                "FechaIngreso TEXT," +
                "FechaNacimiento TEXT," +
                "Genero TEXT not null Constraint CK_generoMaestro check (Genero in ('m','f')), "+
                "Telefono TEXT Constraint DF_telefonoAdministrativo default '00-000-00-00000'," +
                "Correo TEXT Constraint UK_correoAdministrativo Unique not null," +
                "Estado INTEGER not null Constraint DF_estadoAdministrativo Default '0' Constraint CK_estadoAdministrativo Check (Estado in ('0', '1'))," +
                "Constraint FK_claveVocabloAdministrativo Foreign Key (claveVocablo) references Vocablo (claveInstituto))");

        //Inserta los datos del administrador
        ContentValues Admin = new ContentValues();
        //Inserción de los datos al contenedor
        Admin.put("membresiaAdministrativo", "123456");
        Admin.put("claveVocablo", 1);
        Admin.put("RFC", "QWER-123456");
        Admin.put("Nombre", "Mario Josue");
        Admin.put("apellidoPaterno", "Del Toro");
        Admin.put("apellidoMaterno", "Morales");
        Admin.put("FechaIngreso", "02/06/2018");
        Admin.put("FechaNacimiento", "01/09/1997");
        Admin.put("Genero", "m");
        Admin.put("Telefono", "312-154-4836");
        Admin.put("Correo", "15460644@itcolima.edu.mx");
        Admin.put("Estado", "0");
        //Inserción a la tabla Administrativo
        this.getWritableDatabase().insert("Administrativo", null, Admin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //Método que se ejecuta si se actualiza la base de datos en una nueva versión.
    }

    public void abrirBD(){
        //Método que permite abrir la Base de Datos para Insertar datos
        this.getWritableDatabase();
    }

    public void cerrarBD(){
        //Método que permite cerrar la Base de Datos para que no se use más
        this.close();
    }

    //Método que permite insertar registros en la tabla alumno
    public void insertarAlumno(String membresia, String pas, String voc, String nombre, String apePat, String apeMat, String tel, String correo, String domicilio, String FecNac, String Genero, String ingles) {
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos del estudiante
        ContentValues Alumno = new ContentValues();
        //Inserción de los datos al contenedor
        Alumno.put("MembresiaAlumno", membresia);
        Alumno.put("Password", pas);
        Alumno.put("Nombre", nombre);
        Alumno.put("apellidoPaterno", apePat);
        Alumno.put("apellidoMaterno", apeMat);
        Alumno.put("Telefono", tel);
        Alumno.put("Correo", correo);
        Alumno.put("Domicilio", domicilio);
        Alumno.put("HorasAsistidas", 0);
        Alumno.put("FechaNac", FecNac);
        Alumno.put("FechaIngreso", fecha);
        Alumno.put("Genero", Genero);
        Alumno.put("NivelIngles", ingles);
        //Inserción a la tabla alumno
        this.getWritableDatabase().insert("Alumno", null, Alumno);

        //Inserta los datos del estudiante en la tabla detalle
        ContentValues AlumnoVoc = new ContentValues();
        //Inserción de los datos al contenedor
        AlumnoVoc.put("ClaveVocablo", voc);
        AlumnoVoc.put("MembresiaAlumno", membresia);
        //Inserción a la tabla alumnoVocablo
        this.getWritableDatabase().insert("alumnoVocablo", null, AlumnoVoc);

    }

    //Método que permite insertar registros en la tabla Administrador
    public void  insertarAdmin (String mem, String pas, String gen, int voc, String rfc, String nom, String apP, String apM, String FecNac, String tel, String cor){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos del administrativo
        ContentValues Admin = new ContentValues();
        //Inserción de los datos al contenedor
        Admin.put("membresiaAdministrativo", mem);
        Admin.put("Password", pas);
        Admin.put("claveVocablo", voc);
        Admin.put("RFC", rfc);
        Admin.put("Nombre", nom);
        Admin.put("apellidoPaterno", apP);
        Admin.put("apellidoMaterno", apM);
        Admin.put("FechaIngreso", fecha);
        Admin.put("FechaNacimiento", FecNac);
        Admin.put("Telefono", tel);
        Admin.put("Genero", gen);
        Admin.put("Correo", cor);
        Admin.put("Estado", 0);
        //Inserción a la tabla Administrativo
        this.getWritableDatabase().insert("Administrativo", null, Admin);
    }

    //Método que permite insertar un nuevo profesor
    public void insertarMaestro (String mem, String pas, String nivel, String numC, String car, String gen, String voc, String rfc, String nom, String apP, String apM, String FecNac, String tel, String cor){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos del profesor
        ContentValues Maestro = new ContentValues();
        //Inserción de los datos al contenedor
        Maestro.put("NumeroCuenta", mem);
        Maestro.put("Password", pas);
        Maestro.put("ClaveVocablo", voc);
        Maestro.put("RFC", rfc);
        Maestro.put("Nombre", nom);
        Maestro.put("apellidoPaterno", apP);
        Maestro.put("apellidoMaterno", apM);
        Maestro.put("FechaIngreso", fecha);
        Maestro.put("FechaNac", FecNac);
        Maestro.put("Telefono", tel);
        Maestro.put("Genero", gen);
        Maestro.put("Carrera", car);
        Maestro.put("NumCedula", numC);
        Maestro.put("nivelEstudio", nivel);
        Maestro.put("Correo", cor);
        Maestro.put("Estado", 0);
        //Inserción a la tabla Maestro
        this.getWritableDatabase().insert("Maestro", null, Maestro);
    }

    //Método que ingresa un dato a la tabla diagnóstico
    public void insertarDiagnostico(String voc, String nom, String apP, String apM, String tel, String cor, String nivel){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos del Diagnostico
        ContentValues Diagnostico = new ContentValues();
        //Inserción de los datos al contenedor
        Diagnostico.put("claveVocablo", voc);
        Diagnostico.put("Nombre", nom);
        Diagnostico.put("apellidoPaterno", apP);
        Diagnostico.put("apellidoMaterno", apM);
        Diagnostico.put("Telefono", tel);
        Diagnostico.put("Correo", cor);
        Diagnostico.put("NivelAlcanzado", nivel);
        Diagnostico.put("FechaRealizacion", fecha);
        //Inserción a la tabla Diagnostico
        this.getWritableDatabase().insert("Diagnostico", null, Diagnostico);
    }

    //Método que ingresa la critica a su correspondiente tabla
    public void insertarCritica(String mem, String crit){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos de la Crítica
        ContentValues critica = new ContentValues();
        //Inserción de los datos al contenedor
        critica.put("claveAlumno", mem);
        critica.put("Fecha", fecha);
        critica.put("Critica", crit);
        //Inserción a la tabla Critica
        this.getWritableDatabase().insert("Critica", null, critica);
    }

    //Método que ingresa el pago realizado a su correspondiente tabla
    public void insertarPago(String mem, int monto){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos del pago
        ContentValues pago = new ContentValues();
        //Inserción de los datos al contenedor
        pago.put("claveAlumno", mem);
        pago.put("Fecha", fecha);
        pago.put("Monto", monto);
        //Inserción a la tabla Pagos
        this.getWritableDatabase().insert("Pagos", null, pago);
    }

    //Método que ingresa la cita realizada a su correspondiente tabla
    public void ingresarCita(String mem, String fecha, String hora){
        //Inserta los datos de la cita
        ContentValues cita = new ContentValues();
        //Inserción de los datos al contenedor
        cita.put("membresiaAlumno", mem);
        cita.put("fecha", fecha);
        cita.put("hora", hora);
        //Inserción a la tabla Cita
        this.getWritableDatabase().insert("Cita", null, cita);
    }

    public void ingresarEvaluacion( String mem, int cal, String doc){
        //Obtiene la fecha del sistema
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        //Convierte la fecha en un formato reconocible
        String fecha = dateFormat.format(date);

        //Inserta los datos de la evaluación
        ContentValues evalu = new ContentValues();
        //Inserción de los datos al contenedor
        evalu.put("claveAlumno", mem);
        evalu.put("Fecha", fecha);
        evalu.put("Evaluacion", cal);
        evalu.put("claveDocente", doc);
        //Inserción a la tabla Evaluacion
        this.getWritableDatabase().insert("Evaluacion", null, evalu);
    }

    public void existenciaMembresía (String membresia){

    }
}
