package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;

public class ProductRepository {
    JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        new ProductValidator().validateProduct(productName, price);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> createInsertStatement(con, productName, price, stock), keyHolder);
        Number id = keyHolder.getKey();
        if (id == null) {
            throw new IllegalStateException("Error while getting back generated id!");
        }
        return id.longValue();
    }

    private PreparedStatement createInsertStatement(Connection connection, String productName, int price, int stock) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "insert into products (product_name,price,stock) values (?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, productName);
        ps.setInt(2, price);
        ps.setInt(3, stock);
        return ps;
    }


    public Product findProductById(long id) {
        return jdbcTemplate.queryForObject("select * from products where id=?", this::readProduct, id);
    }

    private Product readProduct(ResultSet rs, int i) throws SQLException {
        return new Product(rs.getInt("id"),
                rs.getString("product_name"),
                rs.getInt("price"),
                rs.getInt("stock"));
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("update products set stock=stock-? where id=?", amount, id);
    }
}
