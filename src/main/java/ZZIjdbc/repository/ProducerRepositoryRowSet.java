package ZZIjdbc.repository;

import ZZIjdbc.conn.ConectionFactory;
import ZZIjdbc.dominio.Producer;
import ZZIjdbc.listener.CustomerRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM producer WHERE name like CONCAT('%',?,'%')";
        List<Producer> producers = new ArrayList<>();
        try(CachedRowSet crs = ConectionFactory.getCachedRowSet()) {
            crs.addRowSetListener(new CustomerRowSetListener());
            crs.setCommand(sql);
            crs.setString(1, name);
            crs.execute();
            while (crs.next()) {
                Producer producer = Producer.builder()
                        .id(crs.getInt("id"))
                        .name(crs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

//    public static void updateJdbcRowSet(Producer producer){
//        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s'  WHERE (`id` = '%d');";
//        List<Producer> producers = new ArrayList<>();
//        try(JdbcRowSet jrs = ConectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

/*
    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE (`id` = ?    );";
        List<Producer> producers = new ArrayList<>();
        try(JdbcRowSet jrs = ConectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomerRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if(!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/

    public static void updateCachedRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try(CachedRowSet crs = ConectionFactory.getCachedRowSet();
        Connection conn = ConectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(conn);
            if(!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
