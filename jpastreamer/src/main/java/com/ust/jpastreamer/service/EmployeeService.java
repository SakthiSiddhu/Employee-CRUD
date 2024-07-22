package com.ust.jpastreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.jpastreamer.dto.FilterData;
import com.ust.jpastreamer.model.Employee;
import com.ust.jpastreamer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public List<Employee> addEmployees(List<Employee> employeeList){
        return employeeRepository.saveAll(employeeList);

    }


    public Map<String, List<Employee>> groupEmployeeByCity(){

       return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));

    }



    public List<Employee> employeesInAge(int min,int max){
         return jpaStreamer.stream(Employee.class).filter(
                 e->e.getAge()>=min && e.getAge()<=max
         ).collect(Collectors.toList());
    }




    public long employeesByGender(String gender){
        return jpaStreamer.stream(Employee.class).filter(
                e->e.getGender().equalsIgnoreCase(gender))
                .count();
    }



    public Long employeesByYear(int year){
       return  jpaStreamer.stream(Employee.class)
                .filter(e->e.getJoiningYear()==year)
                .count();
    }

    public Map<String,Long> getEmployeeByGenderAndYear(int year){
        Map<String,Long>  result = new LinkedHashMap<>();

       long maleCount =  jpaStreamer.stream(Employee.class).filter(
               e->e.getJoiningYear()==year
               )
               .filter(e->e.getGender().equalsIgnoreCase("male"))
               .count();

        long femaleCount =  jpaStreamer.stream(Employee.class)
                .filter(e->e.getJoiningYear()==year)
                .filter(e->e.getGender().equalsIgnoreCase("female"))
                .count();
        result.put("male",maleCount);
        result.put("female",femaleCount);
        return  result;
    }


    public Map<String, List<Employee>> groupEmployeeByEducation() {
        return jpaStreamer.stream(Employee.class).collect
                (Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> filter(FilterData filterData) {
        List<Employee> employeeList = new ArrayList<>();
        if(filterData.getEducation()!=null){
           employeeList =  jpaStreamer.stream(Employee.class)
                    .filter(e->e.getEducation().equalsIgnoreCase(filterData.getEducation()))
                    .collect(Collectors.toList());

        }
       if(filterData.getYear()!=null){
              employeeList = employeeList.stream()
                      .filter(e->e.getJoiningYear() == filterData.getYear())
                      .collect(Collectors.toList());

        }

        if(filterData.getExperience()!=null){
            employeeList = employeeList.stream()
                    .filter(e->e.getExperienceInCurrentDomain()==filterData.getExperience())
                    .collect(Collectors.toList());

        }

        if(filterData.getGender()!=null){
            employeeList = employeeList.stream()
                    .filter(e->e.getGender().equalsIgnoreCase(filterData.getGender()))
                    .collect(Collectors.toList());

        }
        return  employeeList;

    }
}
