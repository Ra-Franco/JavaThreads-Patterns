package ZZIjdbc.test;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("TOei").build();
        Producer producer2 = Producer.builder().name("White tox").build();
        Producer producer3 = Producer.builder().name("Ghilbie").build();
        ProducerService.saveTransaction(List.of(producer3, producer2, producer));
    }
}
