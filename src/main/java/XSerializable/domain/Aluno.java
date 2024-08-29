package XSerializable.domain;

import java.io.*;

public class Aluno implements Serializable {

    @Serial
    private static final long serialVersionUID = -5527484162919712473L;

    private Long id;
    private String nome;
    private transient String senha;
    private static final String NOME_ESCOLA = "TESTE ESCOLA";
    private transient Turma turma;

    public Aluno(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeUTF(turma.getTurma());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            String nomeTurma = ois.readUTF();
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", Turma ='" + turma + '\'' +
                '}';
    }
}
