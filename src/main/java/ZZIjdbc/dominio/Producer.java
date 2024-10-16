package ZZIjdbc.dominio;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class Producer {
    Integer id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producer producer)) return false;
        return Objects.equals(id, producer.id) && Objects.equals(name, producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
