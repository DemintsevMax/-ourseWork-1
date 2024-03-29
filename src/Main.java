ppublic class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Снежная Жанна", 1, 65_000);
        employees[1] = new Employee("Смирнов Сергей", 3, 100_000);
        employees[2] = new Employee("Иванов Иван", 2, 89_000);
        employees[3] = new Employee("Молев Дима", 4, 56_000);
        employees[4] = new Employee("Мусаев Мухаммед Ибрагим оглы", 1, 65_000);
        employees[5] = new Employee("Снежков Алексей", 2, 77_000);
        employees[6] = new Employee("Кабаева Алина", 4, 93_000);
        employees[7] = new Employee("Медведев Дима", 2, 68_000);
        employees[8] = new Employee("Пушкин Александр", 1, 98_000);
        employees[9] = new Employee("Святая Вероника", 3, 112_000);

        printAllEmployeesData(employees);
        System.out.println("Сумма затрат на ЗП: " + calculateTotalSalaryExpenses(employees));
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary(employees));
        System.out.println("Вычисление средней ЗП:  "
                + calculateAverageSalary(employees));
        printFullNamesOfEmployees(employees);


    }

    public static void printAllEmployeesData(Employee[] employees) { // Метод для печати данных всех сотрудников.
        for (Employee empl : employees) {
            System.out.println(empl);
        }
    }

    // Метод для расчета общих затрат на зарплату.
    public static double calculateTotalSalaryExpenses(Employee[] employees) {
        double totalSalary = 0;
        // Цикл для прохода по массиву сотрудников.
        for (Employee empl : employees) {
            totalSalary += empl.getSalary();
        }
        return totalSalary;
    }

    // Метод для поиска сотрудника с минимальной зарплатой.
    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        int minSalaryEmployee = employees[0].getId();
        double minSalary = employees[0].getSalary();
        for (Employee empl : employees) {
            if (empl.getSalary() < minSalary) {
                minSalary = empl.getSalary();
                minSalaryEmployee = empl.getId();
            }
        }
        return employees[minSalaryEmployee - 1];
    }

    // Метод для поиска сотрудника с максимальной зарплатой.
    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalaryEmployee = employees[0].getId();
        double maxSalary = employees[0].getSalary();
        for (Employee empl : employees) {
            if (empl.getSalary() > maxSalary) {
                maxSalary = empl.getSalary();
                maxSalaryEmployee = empl.getId();
            }
        }
        return employees[maxSalaryEmployee - 1];
    }

    // Метод для расчета средней зарплаты.
    public static double calculateAverageSalary(Employee[] employees) {
        double totalSalary = calculateTotalSalaryExpenses(employees);
        int totalEmployees = employees.length;
        return totalSalary / totalEmployees;
    }

    // Метод для печати полных имен всех сотрудников.
    public static void printFullNamesOfEmployees(Employee[] employees) {
        for (Employee empl : employees) {
            System.out.println(empl.getFullName());
        }
    }
}
