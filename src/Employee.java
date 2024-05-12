import java.io.*;

public class Employee implements Serializable {
    private String name ;
    private String Id;
    static File file = new File("employees.ser");


    public Employee(String name ,String Id){
        this.Id = Id;
        this.name = name;
    }

    public static void main(String[] args) {
        writeObjects();
        readObject();
    }
    public static void writeObjects(){
        Employee e1 = new Employee("Abbas" , "1010105");
        Employee e2 = new Employee("Kashem" , "20200105");
        Employee e3 = new Employee("Kuddus" , "5050105");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(e1);
            objectOutputStream.writeObject(e2);
            objectOutputStream.writeObject(e3);
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readObject() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Employee e1Read = (Employee) objectInputStream.readObject();
            Employee e2Read = (Employee) objectInputStream.readObject();
            Employee e3Read = (Employee) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Object 1: Name:"+e1Read.getName() + " ID:" + e1Read.getId());
            System.out.println("Object 2: Name:"+e2Read.getName() + " ID:" + e2Read.getId());
            System.out.println("Object 3: Name:"+e3Read.getName() + " ID:" + e3Read.getId());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}