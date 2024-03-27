public class Employee {
    private static int  counter = 1;
    private int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary){
        this.id = counter;
        counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

}
