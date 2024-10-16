package ZZIjdbc.repository;

import ZZIjdbc.conn.ConectionFactory;
import ZZIjdbc.dominio.Producer;
import com.mysql.cj.protocol.x.XProtocolDecoder;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO `producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows);
            log.info("Database rows affected {}", rows);
        } catch (SQLException e) {
            log.error("Error while triyng to insert producer '{}'", producer.getName(), e);
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows);
            log.info("Delete database rows affected {}", rows);
        } catch (SQLException e) {
            log.error("Error while triyng to insert producer '{}'", id, e);
            throw new RuntimeException(e);
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s'  WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows);
            log.info("Update database rows affected {}", rows);
        } catch (SQLException e) {
            log.error("Error while triyng to update producer '{}'", producer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementUpdate(conn, producer)) {
            int rows = ps.executeUpdate();
            System.out.println(rows);
            log.info("Update database rows affected {}", rows);
        } catch (SQLException e) {
            log.error("Error while triyng to update producer '{}'", producer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createdPreparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ?  WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,producer.getName());
        ps.setInt(2,producer.getId());
        return ps;
    }

    public static List<Producer> findAll() {
        List<Producer> producers = new ArrayList<>();
        return findByName("");
//        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer`";
//        try (Connection conn = ConectionFactory.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Producer producer = Producer.builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .build();
//                producers.add(producer);
//            }
//        } catch (SQLException e) {
//            log.error("Error while triyng to find all producers", e);
//            throw new RuntimeException(e);
//        }
//        return producers;
    }
    public static List<Producer> findByName(String name) {
        List<Producer> producers = new ArrayList<>();
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer` where `name` like '%%%s%%';".formatted(name);
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void showProducerMetadata() {
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer`";
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            System.out.println("Columns count: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Table name: " + rsmd.getTableName(i));
                System.out.println("Column name: " + rsmd.getColumnName(i));
                System.out.println("Column size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("Column Type: " + rsmd.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
    }

    public static void showDriverMetadata() {
        try (Connection conn = ConectionFactory.getConnection()) {
           DatabaseMetaData dbmd = conn.getMetaData();
           if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
               System.out.println("Supports TYPE_FORWARD_ONLY");
               if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                   System.out.println("and supports CONCUR_UPDATABLE");
               }
           }
           if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
               System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
               if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                   System.out.println("and supports CONCUR_UPDATABLE");
               }
           }
           if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
               System.out.println("Supports TYPE_SCROLL_SENSITIVE");
               if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                   System.out.println("and supports CONCUR_UPDATABLE");
               }
           }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer`";
        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Last row" + rs.last());
            System.out.println("row number " + rs.getRow());
            System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            System.out.println("First row" + rs.first());
            System.out.println("row number " + rs.getRow());
            System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            System.out.println("Row Absolute " + rs.absolute(2));
            System.out.println("row number " + rs.getRow());
            System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            System.out.println("Row relative" + rs.relative(-1));
            System.out.println("row number " + rs.getRow());
            System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            System.out.println("is last" + rs.isLast());
            System.out.println("row number " + rs.getRow());

            System.out.println("is first" + rs.isFirst());
            System.out.println("row number " + rs.getRow());

            System.out.println("is last" + rs.isLast());
            while (rs.previous()){
                System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }

    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        List<Producer> producers = new ArrayList<>();
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer` where `name` like '%%%s%%';".formatted(name);

        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
//                rs.cancelRowUpdates();
                rs.updateRow();
                producers.add(getProducer(rs));
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        List<Producer> producers = new ArrayList<>();
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer` where `name` like '%%%s%%';".formatted(name);

        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return producers;
            insertNewProducer(name, rs);
            producers.add(getProducer(rs));
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        String sql = "SELECT `id`, `name` FROM `anime_store`.`producer` where `name` like '%%%s%%';".formatted(name);

        try (Connection conn = ConectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                System.out.println("Deleting by name: " + rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
        rs.beforeFirst();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.next();
        Producer producer = Producer.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
        return producer;
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        List<Producer> producers = new ArrayList<>();
        String sql = "SELECT * FROM producer WHERE name like CONCAT('%',?,'%')";
        try (Connection conn = ConectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn, sql, name);
             ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        return ps;
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        List<Producer> producers = new ArrayList<>();
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        try (Connection conn = ConectionFactory.getConnection();
             PreparedStatement ps = createdCallableStatement(conn, sql, name);
             ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while triyng to find all producers", e);
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void saveTransaction(List<Producer> producers) {
        try (Connection conn = ConectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? )";
        boolean shouldRollback = false;
        for (Producer p : producers){
            try( PreparedStatement ps = conn.prepareStatement(sql) ){
                log.info("Saving producer '{}'", p.getName());
                ps.setString(1, p.getName());
                ps.execute();
            } catch (SQLException e){
                e.printStackTrace();
                shouldRollback = true;
            }
        }
        if (shouldRollback) conn.rollback();
    }

    private static CallableStatement createdCallableStatement(Connection conn, String sql, String name) throws SQLException {
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1,name);
        return cs;
    }
}
