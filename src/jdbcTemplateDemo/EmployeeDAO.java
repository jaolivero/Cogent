package jdbcTemplateDemo;

import java.util.List;

public interface EmployeeDAO {
    public void insert(Employee employee);
    public void save(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();
    void updateById(int id, Employee employee);
    void deleteById(int id);
}
