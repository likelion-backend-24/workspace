package jdbc02;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into users(name,email) values(?,?)";
       return jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from users where id = ?";


        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);

//        return jdbcTemplate.queryForObject(
//          sql,(rs,rowNum) ->{
//              User user = new User();
//              user.setId(rs.getLong("id"));
//              user.setName(rs.getString("name"));
//              user.setEmail(rs.getString("email"));
//              user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
//              return user;
//          },
//          id
//        );
    }

    @Override
    public void updateUser(User user) {
        String sql = "update users set name=?,email=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from users where id=?";
        jdbcTemplate.update(sql, id);

    }
}
