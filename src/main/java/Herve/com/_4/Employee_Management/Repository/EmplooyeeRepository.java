package Herve.com._4.Employee_Management.Repository;

import Herve.com._4.Employee_Management.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplooyeeRepository extends JpaRepository<Employees,Long> {

}
