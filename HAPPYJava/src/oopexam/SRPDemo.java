package oopexam;


class Calculator {
    public double calculateSalary(Employee employee) {
        return employee.getSalary() * 1000;
    }
}
class SaveEmployee{
    public void saveEmployee(Employee employee){
        System.out.println(employee.getName()+"사원정보를 DB에 저장");
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}


    public class SRPDemo {
        public static void main(String[] args) {
            Employee employee = new Employee("kang", "hr", 200000000);

            Calculator calculator = new Calculator();
            double calculated = calculator.calculateSalary(employee);
            System.out.println("계산된 금액:" + calculated);

            SaveEmployee saveEmployee = new SaveEmployee();
            saveEmployee.saveEmployee(employee);

        }
    }