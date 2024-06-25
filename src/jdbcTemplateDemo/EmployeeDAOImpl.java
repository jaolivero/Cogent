package jdbcTemplateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void insert(Employee employee) {
        String sql = "INSERT INTO employee" + "(ID, Name, AGE) values(?,?,?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getAge());
    }

    @Override
    public void save(Employee employee) {
        insert(employee);
    }


    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id =?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public void updateById(int id, Employee employee) {
        String sql = "UPDATE employee SET name = ?, age = ? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "Delete FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
