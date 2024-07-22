package com.ust.jpastreamer.controller;

import com.ust.jpastreamer.dto.FilterData;
import com.ust.jpastreamer.model.Employee;
import com.ust.jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/addall")
            public List<Employee> addEmployees(@RequestBody List<Employee> employeeList){
        return employeeService.addEmployees(employeeList);

    }
    @GetMapping("/bycity")
    public Map<String, List<Employee>> getEmployeeByCity(){
        return employeeService.groupEmployeeByCity();
    }

    @GetMapping("/byeducation")
    public Map<String, List<Employee>> getEmployeeByEducation(){
        return employeeService.groupEmployeeByEducation();
    }

    @GetMapping("/byage")
    public  List<Employee> getByAge(@RequestParam int min, @RequestParam int max){
        return employeeService.employeesInAge(min,max);
    }

    @GetMapping("/bygender/{gender}")
    public  String  getByAge(@PathVariable("gender") String gender){
        long count = employeeService.employeesByGender(gender);
        return ""+gender+": "+count;
    }
    @GetMapping("/byyear/{year}")
    public  String getByYear(@PathVariable int year){
        long count = employeeService.employeesByYear(year);
        return ""+year+": "+count;
    }
    @GetMapping("/genderbyyear/{year}")
    public  Map<String,Long> getByGenderAndYear(@PathVariable int year){
        return employeeService.getEmployeeByGenderAndYear(year);
    }
    @GetMapping("/filter")
    public List<Employee> filter(@RequestParam(value = "year",required = false) Integer year,
                             @RequestParam(value = "experience",required = false) Integer experience,
                                @RequestParam("education") String education,
                                @RequestParam("gender") String gender)
    {
        FilterData filterData = new FilterData(year,experience,education,gender);
        return employeeService.filter(filterData) ;
    }


}
