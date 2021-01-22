package IO;

import java.io.*;

public class IOObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(
                        new BufferedOutputStream(byteArrayOutputStream)
                );

        objectOutputStream.writeObject(new Employee("jack ma",400));
        objectOutputStream.flush();

        byte[] bytes = byteArrayOutputStream.toByteArray();

        ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new BufferedInputStream(
                                new ByteArrayInputStream(bytes)
                        )
                );

        Employee employee = (Employee) objectInputStream.readObject();
        System.out.println(employee.toString());
    }
}

class Employee implements Serializable{
    private transient String name; //该数据不需要序列化
    private double salary;

    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
