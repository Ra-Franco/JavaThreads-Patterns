package ZZIjdbc.test;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.repository.ProducerRepositoryRowSet;
import ZZIjdbc.service.ProducerServiceRowSet;

import java.util.List;

public class ConnectionFactoryTest02 {
    public static void main(String[] args) {

        Producer producer = Producer.builder().id(14).name("TESTE").build();
        ProducerServiceRowSet.updateCachedRowSet(producer);
//        List<Producer> producerList = ProducerServiceRowSet.findByNameJdbcRowSet("");
//        System.out.println(producerList);
    }
}
