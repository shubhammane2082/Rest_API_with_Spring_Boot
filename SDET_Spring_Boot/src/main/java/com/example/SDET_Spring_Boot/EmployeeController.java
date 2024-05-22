package com.example.SDET_Spring_Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController() {
        this.service = new EmployeeService();
    }

    @GetMapping("/getAllusers")
    public List<EmployeeModel> getUsers() {
        List<EmployeeModel> allusers = service.getAllusers();
        return allusers;
    }
    @PostMapping("/saveList")
    public String saveList(@RequestBody EmployeeModel model) {
        String result = service.saveEmployee(model);
        return result;
    }

    @DeleteMapping("/deleteUsers/{id}")
    public String deleteEmployee(@PathVariable int id) {
        String result = service.deleteEmployeeById(id);
        return result;
    }
    @PutMapping("/updateUser/{id}")
    public String updateUser(@RequestBody EmployeeModel model, @PathVariable int id)
    {
        String result = service.updateService(model, id);
        return result;
    }
}
