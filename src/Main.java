public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Снежная Жанна", 1, 65_000);
        employees[1] = new Employee("Смирнов Сергей", 3, 100_000);
        employees[2] = new Employee("Иванов Иван", 2, 89_000);
        employees[3] = new Employee("Молев Дима", 4, 56_000);
        employees[4] = new Employee("Мусаев Мухаммед Ибрагим оглы", 5, 65_000);
        employees[5] = new Employee("Снежков Алексей", 5, 77_000);
        employees[6] = new Employee("Кабаева Алина", 4, 93_000);
        employees[7] = new Employee("Медведев Дима", 2, 68_000);
        employees[8] = new Employee("Пушкин Александр", 1, 98_000);
        employees[9] = new Employee("Святая Вероника", 3, 112_000);

        printAllEmployeesData();
        System.out.println(" ");
        System.out.println("Сумма затрат на ЗП: " + calculateTotalSalaryExpenses());
        System.out.println(" ");
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary().getFullName());
        System.out.println(" ");
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary().getFullName());
        System.out.println(" ");
        System.out.println("Вычисление средней ЗП:  " + calculateAverageSalary());
        System.out.println(" ");
        printFullNamesOfEmployees();
        System.out.println(" ");
        System.out.println("Индексируем зарплату");
        indexAllSalary(10);
        printAllEmployeesData();
        System.out.println(" ");
        System.out.println("Сотрудник с минимальной зарплатой в отделе: " + minimumSalaryByDepartment(2));
        System.out.println(" ");
        System.out.println("Сотрудник с максимальной зарплатой в отделе: " + maximumSalaryByDepartment(4));
        System.out.println(" ");
        System.out.println("Средняя зарплата по отделу " + calculateAverageSalaryDepartment(5));
        System.out.println(" ");
        System.out.println("Сумма ЗП на отдел: " + calculateTotalSalaryInDepartment(2));
        System.out.println(" ");
        System.out.println("Индексируем зарплату по отделу ");
        indexAllSalaryInDepartment(15, 3);
        printEmployeeInDepartment(3);
        System.out.println(" ");
        printEmployeesWithSalaryBelow(98_888);
        System.out.println(" ");
        printEmployeesWithSalaryAbove(98_888);


    }

    public static void printAllEmployeesData() { // Метод для печати данных всех сотрудников.
        for (Employee empl : employees) {
            System.out.println(empl);
        }
    }

    // Метод для расчета общих затрат на зарплату.
    public static double calculateTotalSalaryExpenses() {
        double totalSalary = 0;
        // Цикл для прохода по массиву сотрудников.
        for (Employee empl : employees) {
            totalSalary += empl.getSalary();
        }
        return totalSalary;
    }

    // Метод для поиска сотрудника с минимальной зарплатой.
    public static Employee findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        double minSalary = employees[0].getSalary();
        for (Employee empl : employees) {
            if (empl.getSalary() < minSalary) {
                minSalary = empl.getSalary();
                minSalaryEmployee = empl;
            }
        }
        return minSalaryEmployee;
    }

    // Метод для поиска сотрудника с максимальной зарплатой.
    public static Employee findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        double maxSalary = employees[0].getSalary();
        for (Employee empl : employees) {
            if (empl.getSalary() > maxSalary) {
                maxSalary = empl.getSalary();
                maxSalaryEmployee = empl;
            }
        }
        return maxSalaryEmployee;
    }

    // Метод для расчета средней зарплаты.
    public static double calculateAverageSalary() {
        double totalSalary = calculateTotalSalaryExpenses();
        int totalEmployees = employees.length;
        if (totalEmployees == 0) {
            return 0;
        }
        return totalSalary / totalEmployees;
    }

    // Метод для печати полных имен всех сотрудников.
    public static void printFullNamesOfEmployees() {
        for (Employee empl : employees) {
            System.out.println(empl.getFullName());
        }
    }

    public static Employee minimumSalaryByDepartment(int department) {
        Employee minSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee empl : employees) {
            if (empl.getDepartment() == department && empl.getSalary() < minSalary) {
                minSalary = empl.getSalary();
                minSalaryEmployee = empl;

            }
        }
        return minSalaryEmployee;
    }

    public static Employee maximumSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee empl : employees) {
            if (empl.getDepartment() == department && empl.getSalary() > maxSalary) {
                maxSalary = empl.getSalary();
                maxSalaryEmployee = empl;

            }
        }
        return maxSalaryEmployee;
    }

    // Метод для индексации зарплаты на процент
    public static void indexAllSalary(double percent) {
        for (Employee empl : employees) {
            double currentSalary = empl.getSalary();
            double indexSalary = currentSalary * percent / 100 + currentSalary;
            empl.setSalary(indexSalary);
        }

    }

    // Метод для вычисления всей зарплаты на отдел
    public static double calculateTotalSalaryInDepartment(int department) {
        double totalSalary = 0;
        for (Employee empl : employees) {
            if (empl.getDepartment() == department) {
                totalSalary += empl.getSalary();
            }

        }
        return totalSalary;
    }

    public static double calculateAverageSalaryDepartment(int department) {
        double totalSalary = 0;
        int counter = 0;

        for (Employee empl : employees) {
            if (empl.getDepartment() == department) {
                totalSalary += empl.getSalary();
                counter++;
            }
        }
        if (counter == 0) {
            return 0;
        }
        return totalSalary / counter;
    }

    public static void indexAllSalaryInDepartment(double percent, int department) {
        for (Employee empl : employees) {
            if (empl.getDepartment() == department) {
                double indexSalary = empl.getSalary() * (1 + percent / 100);
                empl.setSalary(indexSalary);
            }
        }
    }

    public static void printEmployeeInDepartment(int department) {
        for (Employee empl : employees) {
            if (empl.getDepartment() == department) {
                System.out.println(empl.getId() + " Ф.И.О " + empl.getFullName() + " " + empl.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryBelow(double number) {
        for (Employee empl : employees) {
            if (empl.getSalary() < number) {
                System.out.println(empl.getId() + " " + empl.getFullName() + " " + empl.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryAbove(double number) {
        for (Employee empl : employees) {
            if (empl.getSalary() > number) {
                System.out.println(empl.getId() + " " + empl.getFullName() + " " + empl.getSalary());
            }
        }
    }
}



