package models;

public class NewEventModel {
    private String descripcion;
    private String email;
    private String fecha;
    private String frecuencia;
    private boolean aceptado;

    private String nombreInvitado;
    private String telefonoInvitado;
    private String generoInvitado;
    private int diaNacimientoInvitado;
    private String mesNacimientoInvitado;
    private int añoNacimientoInvitado;
    private String direccionInvitado;
    private boolean condicionesInvitado;

    public NewEventModel(String descripcion, String email, String fecha, String frecuencia, boolean aceptado) {
        this.descripcion = descripcion;
        this.email = email;
        this.fecha = fecha;
        this.frecuencia = frecuencia;
        this.aceptado = aceptado;
    }

    public NewEventModel(String nombreInvitado, String telefonoInvitado, String generoInvitado, int diaNacimientoInvitado, 
                         String mesNacimientoInvitado, int añoNacimientoInvitado, String direccionInvitado, boolean condicionesInvitado) {
        this.nombreInvitado = nombreInvitado;
        this.telefonoInvitado = telefonoInvitado;
        this.generoInvitado = generoInvitado;
        this.diaNacimientoInvitado = diaNacimientoInvitado;
        this.mesNacimientoInvitado = mesNacimientoInvitado;
        this.añoNacimientoInvitado = añoNacimientoInvitado;
        this.direccionInvitado = direccionInvitado;
        this.condicionesInvitado = condicionesInvitado;
    }

    public String getDescription() { return descripcion; }
    public String getEmail() { return email; }
    public String getDate() { return fecha; }
    public String getFrequency() { return frecuencia; }
    public boolean isAgreed() { return aceptado; }

    public String getGuestName() { return nombreInvitado; }
    public String getGuestPhoneNumber() { return telefonoInvitado; }
    public String getGuestGender() { return generoInvitado; }
    public int getGuestDOBDay() { return diaNacimientoInvitado; }
    public String getGuestDOBMonth() { return mesNacimientoInvitado; }
    public int getGuestDOBYear() { return añoNacimientoInvitado; }
    public String getGuestAddress() { return direccionInvitado; }
    public boolean isGuestConditions() { return condicionesInvitado; }
}
