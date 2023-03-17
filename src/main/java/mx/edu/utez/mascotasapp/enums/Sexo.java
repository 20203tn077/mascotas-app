package mx.edu.utez.mascotasapp.enums;

public enum Sexo {
    MALE("M"), FEMALE("F");

    private String sex;

    Sexo(final String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
