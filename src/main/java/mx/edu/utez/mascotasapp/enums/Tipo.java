package mx.edu.utez.mascotasapp.enums;

public enum Tipo {
    DOG("Perro"), CAT("Gato");
    private String type;

    Tipo(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
