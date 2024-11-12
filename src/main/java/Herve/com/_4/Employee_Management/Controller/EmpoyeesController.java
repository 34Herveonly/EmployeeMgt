package Herve.com._4.Employee_Management.Controller;

import Herve.com._4.Employee_Management.Exception.ResourceNotFoundExceptions;
import Herve.com._4.Employee_Management.Model.Employees;
import Herve.com._4.Employee_Management.Repository.EmplooyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/34/Employees")

public class EmpoyeesController {

@Autowired
EmplooyeeRepository emplooyeeRepository;

    // get Employees RestFul API

@GetMapping
public List<Employees> getAllEmployees() {
    return emplooyeeRepository.findAll();
}

 // Insert Employees in Database RestFul API

@PostMapping
public Employees setEmployee(@RequestBody Employees employee) {
    return emplooyeeRepository.save(employee);
}

    // Get Employee By Id RestFul API

@GetMapping("{id}")
public ResponseEntity<Employees> getEmployeeById(@PathVariable long id) {
    Employees employee = emplooyeeRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundExceptions("There's No Employee at id"+id));

    return ResponseEntity.ok(employee);
}

    // Update Employees RestFul API

@PutMapping("{id}")
public ResponseEntity<Employees> updateEmployee(@PathVariable long id,@RequestBody Employees employeeDetails) {
Employees updateEmployee= emplooyeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundExceptions("There Exist No Employee with Id:"+id));

updateEmployee.setFirstname(employeeDetails.getFirstname());
updateEmployee.setLastname(employeeDetails.getLastname());
updateEmployee.setAge(employeeDetails.getAge());
updateEmployee.setEmail(employeeDetails.getEmail());

emplooyeeRepository.save(updateEmployee);

return ResponseEntity.ok(updateEmployee);
 }

 // Delete Employees RestFul API

 @DeleteMapping("{id}")
 public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {

    Employees deleteEmployee=emplooyeeRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundExceptions("Employee At Id: "+id+"Was Deleted Successfully"));

    emplooyeeRepository.delete(deleteEmployee);
return ResponseEntity.ok(HttpStatus.NO_CONTENT);

 }


}
