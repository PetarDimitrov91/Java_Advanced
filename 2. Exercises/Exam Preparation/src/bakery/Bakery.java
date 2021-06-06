package bakery;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private final String name;
    private int capacity;


    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    List<Employee> employeesData = new ArrayList<>(capacity);

    public void add(Employee employee) {
        if (employeesData.size() < capacity) {
            this.employeesData.add(employee);
        }
    }

    public void remove(String name) {
        employeesData.removeIf(employee -> employee.getName().equals(name));

    }

    public Employee getEmployee(String name) {
        for (Employee employee : employeesData) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee GetOldestEmployee() {
        int age = 0;
        Employee oldestEmployee = null;
        for (Employee employee : employeesData) {
            int currentEmployeeAge = employee.getAge();
            if (age < currentEmployeeAge) {
                age = currentEmployeeAge;
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public int getCount() {
        return employeesData.size();
    }


  // public String toString() {
  //     if (employeesData.isEmpty()) {
  //         return null;
  //     }
  //     return String.format(
  //
  // }


    public void report() {
        System.out.printf("Employees working at Bakery %s:%n", this.name);
        for (Employee employee : employeesData) {
            System.out.println("Employee: " + employee);
        }
    }
}
