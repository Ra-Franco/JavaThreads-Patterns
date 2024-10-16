package ZZIjdbc.test;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.repository.ProducerRepository;
import ZZIjdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().id(14).name("snk").build();
//        ProducerService.save(producer);
//        ProducerService.delete(2);

//        ProducerService.update(producer);

//        List<Producer> producerList = ProducerRepository.findAll();
//        List<Producer> producerList = ProducerRepository.findByName("S");
//        System.out.println(producerList);

//        ProducerService.showProducerMetaData();
//        ProducerService.showDriverMetadata();
//        ProducerService.showTypeScrollWorking();
//        List<Producer> list = ProducerService.findByNameAndUpdateToUpperCase("Mad");
//        System.out.println(list);

//        System.out.println(ProducerService.findByNameAndInsertWhenNotFound("Kimi no Nawa"));
//        ProducerService.findByNameAndDelete("a");
//        System.out.println(ProducerService.findByNamePreparedStatement("S"));

//          ProducerService.updatePreparedStatement(producer);

        List<Producer> list = ProducerService.findByNameCallableStatement("snk");
        System.out.println(list);
    }

}
