package com.vocablo.mario.vocablo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseVocablo extends SQLiteOpenHelper {
    public BaseVocablo(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "VOCABLO", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE VOCABLO (" +
                "claveInstituto INTEGER Constraint PK_claveInstitucionVocablo Primary Key, " +
                "domicilio text not null," +
                "Telefono INTEGER Constraint DF_telefonoVocablo Default '00-000-00-00000' Constraint UK_telefonoVocablo Unique)");

        db.execSQL("Create table Alumno(" +
                "MembresiaAlumno TEXT not null, " +
                "Nombre TEXT not null," +
                "apellidoPaterno TEXT not null, " +
                "apellidoMaterno TEXT not null," +
                "Telefono TEXT Constraint DF_telefonoAlumno Default '00-000-00-00000', " +
                "Correo TEXT not null Constraint UK_correoAlumno Unique," +
                "Domicilio TEXT," +
                "HorasAsistidas INTEGER not null Constraint DF_horasAsistidasAlumno Default 0 Constraint CK_defaultAlumno check (HorasAsistidas between 0 and 320)," +
                "FechaNac TEXT not null," +
                "FechaIngreso TEXT," +
                "Genero TEXT not null Constraint CK_generoAlumno Check (Genero in ('m','f')), " +
                "NivelIngles TEXT not null," +
                "Constraint PK_numMembreAlumno Primary Key (MembresiaAlumno))");

        db.execSQL("Create Table alumnoVocablo (" +
                "ClaveVocablo INTEGER not null," +
                "MembresiaAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Constraint FK_claveVocabloAlumnoVocablo Foreign Key (ClaveVocablo) References Vocablo (claveInstituto)," +
                "Constraint FK_membresiaAlumnoAlumnoVocablo Foreign Key (MembresiaAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Maestro( " +
                "NumeroCuenta TEXT not null,"+
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
                "Constraint PK_numeroCuentaMaestro Primary Key (NumeroCuenta), " +
                "Constraint FK_claveVocabloMaestro Foreign Key (ClaveVocablo) References Vocablo (claveInstituto)) ");

        db.execSQL("Create table Diagnostico (" +
                "Clave INTEGER not null," +
                "claveVocablo INTEGER not null," +
                "Nombre TEXT not null," +
                "apellidoPaterno TEXT not null," +
                "apellidoMaterno TEXT not null," +
                "Telefono TEXT Constraint DF_telefonoUsuario Default '00-000-00-00000'," +
                "Correo TEXT not null Constraint UK_correoDiagnostico Unique," +
                "NivelAlcanzado TEXT not null," +
                "FechaRealizacion TEXT," +
                "Constraint PK_claveDiagnostico Primary Key (Clave)," +
                "Constraint FK_claveVocabloDiagnostico Foreign Key (claveVocablo) References Vocablo (claveInstituto))");

        db.execSQL("Create Table Critica (" +
                "claveCritica INTEGER not null Constraint PK_claveCritica Primary Key," +
                "claveAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Critica TEXT not null," +
                "Constraint FK_membresiaCritica Foreign Key (claveAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Pagos (" +
                "clavePago INTEGER not null," +
                "claveAlumno TEXT not null," +
                "Fecha TEXT not null," +
                "Monto INTEGER  not null Constraint CK_montoPagos Check (Monto >= 0)," +
                "FormaPago INTEGER not null Constraint CK_formaPagoPagos Check (FormaPago in ('0','1'))," +
                "Concepto TEXT not null," +
                "Constraint PK_clavePagos Primary Key (clavePago)," +
                "Constraint FK_claveAlumnoPagos Foreign Key (claveAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Cita(" +
                "claveCita INTEGER not null," +
                "membresiaDocente TEXT not null," +
                "membresiaAlumno TEXT not null," +
                "fechaHora TEXT not null," +
                "Asistencia INTEGER not null Constraint DF_estadoAsistencia Default '1' Constraint CK_estadoAsistencia Check (Asistencia in('1', '2', '3', '4'))," +
                "Constraint PK_claveCita Primary Key (claveCita)," +
                "Constraint FK_membresiaDocenteCita Foreign Key (membresiaDocente) References Maestro (NumeroCuenta)," +
                "Constraint FK_membresiaAlumnoCita Foreign Key (membresiaAlumno) References Alumno (MembresiaAlumno))");

        db.execSQL("Create table Evaluacion(" +
                "claveEvaluacion INTEGER not null," +
                "claveAlumno TEXT not null," +
                "Nivel TEXT not null," +
                "Fecha TEXT not null," +
                "Evaluacion INTEGER not null Constraint CK_calificacionEvaluacion Check (Evaluacion between 0 and 100)," +
                "claveDocente TEXT not null," +
                "Constraint PK_claveEvaluacion Primary Key (claveEvaluacion)," +
                "Constraint FK_membresiaAlumnoEvaluacion Foreign Key (claveAlumno) References Alumno (MembresiaAlumno)," +
                "Constraint FK_membresiaDoceneteEvaluacion Foreign Key (claveDocente) References Maestro (NumeroCuenta))");

        db.execSQL("Create Table Administrativo (" +
                "membresiaAdministrativo TEXT not null Constraint PK_membresiaAdministrativo Primary Key," +
                "claveVocablo INTEGER not null," +
                "RFC TEXT not null Constraint UK_RFCAdministrativo Unique Constraint CK_rfcAdministrativo Check (RFC like('[A-Z][A-Z][A-Z][A-Z]-[0-9][0-9][0-9][0-9][0-9][0-9]'))," +
                "Nombre TEXT not null," +
                "apellidoPaterno TEXT not null," +
                "apellidoMaterno TEXT not null," +
                "FechaIngreso TEXT," +
                "Telefono TEXT Constraint DF_telefonoAdministrativo default '00-000-00-00000'," +
                "Correo TEXT Constraint UK_correoAdministrativo Unique not null," +
                "Estado INTEGER not null Constraint DF_estadoAdministrativo Default '0' Constraint CK_estadoAdministrativo Check (Estado in ('0', '1'))," +
                "Constraint FK_claveVocabloAdministrativo Foreign Key (claveVocablo) references Vocablo (claveInstituto))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
