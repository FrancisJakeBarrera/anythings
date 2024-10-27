package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Person foundManager = findPersonByName(persons, manager);
        Person foundEmployee = findPersonByName(persons, employee);

        if (!(foundManager instanceof Manager)) {
            throw new ClassCastException(manager + " is not a manager");
        }
        if (!(foundEmployee instanceof Employee)) {
            throw new ClassCastException(employee + " is not an employee");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary increase must be non-negative");
        }

        ((Manager) foundManager).giveRaise((Employee) foundEmployee, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Person foundDeveloper = findPersonByName(persons, developer);
        Person foundManager = findPersonByName(persons, manager);

        if (!(foundDeveloper instanceof Developer)) {
            throw new ClassCastException(developer + " is not a developer");
        }
        if (!(foundManager instanceof Manager)) {
            throw new ClassCastException(manager + " is not a manager");
        }

        ((Developer) foundDeveloper).setProjectManager((Manager) foundManager);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
    Person foundCustomer = findPersonByName(persons, customer);
    Person foundEmployee = findPersonByName(persons, employee);

        if (!(foundCustomer instanceof Customer)) {
        throw new ClassCastException(customer + " is not a customer");
    }
        if (!(foundEmployee instanceof Employee)) {
        throw new ClassCastException(employee + " is not an employee");
    }

        return ((Customer) foundCustomer).speak((Employee) foundEmployee);
}

private static Person findPersonByName(List<Person> persons, String name) {
    for (Person person : persons) {
        if (person.getName().equals(name)) {
            return person;
        }
    }
    throw new NoSuchElementException(name + " does not exist");
}
}
