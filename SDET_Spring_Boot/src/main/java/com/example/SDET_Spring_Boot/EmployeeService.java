package com.example.SDET_Spring_Boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService
{
    public static List<EmployeeModel> employeeModelList;
    public EmployeeService() {
        employeeModelList=new ArrayList<>();

        employeeModelList.add(new EmployeeModel(1, "sanju", "kerala"));
        employeeModelList.add(new EmployeeModel(2, "Riyan", "Aasam"));
        employeeModelList.add(new EmployeeModel(3, "Dhurav", "UP"));
    }
    public List<EmployeeModel> getAllusers()
    {
        return employeeModelList;
    }

    public String saveEmployee(EmployeeModel model)
    {
        employeeModelList.add(model);
        return "employee added to list";
    }

    public String deleteEmployeeById(int id)
    {
        Optional<EmployeeModel> deleteEmployee = employeeModelList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

        if(deleteEmployee.isPresent())
        {
            employeeModelList.remove(deleteEmployee.get());
            return "employee Deleted Sucessfully...";
        }
        else{
            return "Employee Not found...";
        }
    }

    public String updateService(EmployeeModel model, int id)
    {
        Optional<EmployeeModel> updateEmployee = employeeModelList.stream()
                                                 .filter(e -> e.getId() == id)
                                                 .findFirst();
        if(updateEmployee.isPresent())
        {
            employeeModelList.add(model);
            return "Employee Updated sucessfully...";
        }
        else{
            return  "Employee Not Updated...";
        }
    }
}
