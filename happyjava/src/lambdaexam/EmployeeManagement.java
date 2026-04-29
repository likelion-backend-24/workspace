package lambdaexam;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getter 메소드들
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d원", name, department, salary);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("김철수", "개발팀", 5000000),
                new Employee("이영희", "마케팅팀", 4500000),
                new Employee("박민수", "개발팀", 5500000),
                new Employee("정수진", "인사팀", 4000000),
                new Employee("최영수", "개발팀", 6000000)
        );

        // 1. 부서별 평균 급여 계산
//        부서별로 묶어볼 수 있을 까요?
        Map<String, List<Employee>> deptMap = new HashMap<>();
        for(Employee employee : employees) {
            String deptName = employee.getDepartment();
            if(!deptMap.containsKey(deptName)) {
                deptMap.put(deptName, new ArrayList<>());
            }
//            List<Employee> deptEmp =  deptMap.get(deptName);
//            deptEmp.add(employee);
            deptMap.get(deptName).add(employee);
        }

//        평균계산
        for(String deptName :deptMap.keySet()){
            List<Employee> deptEmpList = deptMap.get(deptName);

            int sum = 0;
            for(Employee employee : deptEmpList){
                sum += employee.getSalary();
            }

            double avgSalary = sum/deptEmpList.size();

            System.out.printf("%s : %.0f 원 \n", deptName, avgSalary );
        }



//
//
//
//
//        Map<String, Double> avgSalaryByDept = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.averagingInt(Employee::getSalary)
//                ));
//
//        System.out.println("=== 부서별 평균 급여 ===");
//        avgSalaryByDept.forEach((dept, avgSalary) ->
//                System.out.printf("%s: %.0f원%n", dept, avgSalary));
//
//        // 2. 급여가 500만원 이상인 개발팀 직원 찾기
        System.out.println("\n=== 급여 500만원 이상 개발팀 직원 ===");

        for(Employee employee : employees) {
            if(employee.getSalary()>=5000000 && "개발팀".equals(employee.getDepartment())) {
                System.out.println(employee);
            }
        }



//        System.out.println("\n=== 급여 500만원 이상 개발팀 직원 ===");
//        employees.stream()
//                .filter(emp -> emp.getDepartment().equals("개발팀"))
//                .filter(emp -> emp.getSalary() >= 5000000)
//                .forEach(System.out::println);
//
//        // 3. 전체 직원을 급여 순으로 정렬
        System.out.println("\n=== 급여 순 정렬 (내림차순) ===");

        List<Employee> sortedEmpList = new ArrayList<Employee>(employees);

//        Collections.sort(sortedEmpList, new  Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return Integer.compare(o1.getSalary(), o2.getSalary());
//            }
//        });

        Collections.sort(sortedEmpList, (o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary()));

        for(Employee employee : sortedEmpList){
            System.out.println(employee);
        }





//        employees.stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
//                .forEach(System.out::println);
//
        // 4. 가장 높은 급여 찾기

        int maxSalary = 0;
        for(Employee employee : employees){
            if(employee.getSalary()>maxSalary){
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("\n최고 급여: " + maxSalary + "원");


//        Optional<Integer> maxSalary = employees.stream()
//                .map(Employee::getSalary)
//                .max(Integer::compareTo);
//
//        maxSalary.ifPresent(salary ->
//                System.out.println("\n최고 급여: " + salary + "원"));
    }
}