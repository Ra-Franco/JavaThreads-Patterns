package XSerializable.domain;

public class Turma {
    private String turma;

    public Turma(String turma) {
        this.turma = turma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "turma='" + turma + '\'' +
                '}';
    }
}
