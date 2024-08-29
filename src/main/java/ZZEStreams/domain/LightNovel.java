package ZZEStreams.domain;

import java.util.Objects;

public class LightNovel {
    private String title;
    private double price;
    private Category category;

    public LightNovel(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public LightNovel(String title, double price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LightNovel that)) return false;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTitle());
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {return category;}

    @Override
    public String toString() {
        return "LightNovel{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
