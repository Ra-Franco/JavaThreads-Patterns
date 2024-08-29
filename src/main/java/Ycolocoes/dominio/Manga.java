package Ycolocoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> {
    private Long id;
    private String titulo;
    private double preco;
    private int quantidade;

    public Manga(Long id, String titulo, double preco) {
        Objects.requireNonNull(id, "Id não pode ser null");
        Objects.requireNonNull(titulo, "Titulo não pode ser null");
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
    }

    public Manga(Long id, String titulo, double preco, int quantidade) {
        this(id, titulo, preco);
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manga manga)) return false;
        return Objects.equals(getId(), manga.getId()) && Objects.equals(getTitulo(), manga.getTitulo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo());
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public int compareTo(Manga o) {
//        if (this.id < o.id) {
//            return -1;
//        }
//        if (this.id.equals(o.getId())) {
//            return 0;
//        } else {
//            return 1;
//        }

        return this.titulo.compareTo(o.getTitulo());
//       return Double.valueOf(preco).compareTo(Double.valueOf(o.getPreco()));
//        return Double.compare(preco, o.getPreco());
//        return this.id.compareTo(o.getId());
    }
}
