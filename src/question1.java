import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class question1 {
    private static String data_dir = "data/io.txt";
    public static void main(String[] args) {
        write();
        read();

    }
    public static void write(){
        int temp;
        Scanner sc = new Scanner(System.in);

        try {
            File dataFile = new File(data_dir);
            if (dataFile.createNewFile()) {
                System.out.println("File created: " + dataFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter dataFileWriter = new FileWriter(data_dir);

            System.out.print("Enter a number: ");
            temp = sc.nextInt();
            while (temp >= 0){
                dataFileWriter.write(temp + "\n");
                System.out.print("Enter a number: ");
                temp = sc.nextInt();
            }

            dataFileWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void read(){
        int sum = 0,counter = 0,temp;
        try {
            File dataFile = new File(data_dir);
            Scanner sc = new Scanner(dataFile);

            while (sc.hasNext()){
                temp = sc.nextInt();
                sum+=temp;
                counter++;
            }
            System.out.println("SUM=" + sum);
            System.out.println("AVERAGE= "+sum/counter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
