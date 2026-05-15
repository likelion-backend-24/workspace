package oopexam;
class Calculator{
    //    급여계산
    public double calculateSalary(Employee employee) {
//       급여를 계산하는 로직!!
        return employee.getSalary() * 1000;
    }
}

class SaveEmployee{
    //    db 저장
    public void saveEmployee(Employee employee) {
//        DB에 저장하는 로직 실행
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

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }


}
public class SRPDemo {
    public static void main(String[] args) {
        Employee employee = new Employee("kang","hr",20000000);

        Calculator calculator = new Calculator();
        //급여를 계산하겠다.
        calculator.calculateSalary(employee);

        SaveEmployee saveEmployee = new SaveEmployee();
        saveEmployee.saveEmployee(employee);

//        이렇게 봤을 때..  해당 객체가 가진 책임이 하나인가요??

    }
}
