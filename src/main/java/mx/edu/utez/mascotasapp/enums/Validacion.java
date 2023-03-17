package mx.edu.utez.mascotasapp.enums;

public enum Validacion {
    PENDANT("Pendiente"), VALIDATED("Validado"), REFUSED("Rechazado");
    private String validation;

    Validacion(final String validation) {
        this.validation = validation;
    }

    public String getValidation() {
        return validation;
    }
}
