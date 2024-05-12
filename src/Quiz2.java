import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Quiz2 {
    private static String fileDir = "data/quiz_data.txt";
    private static ArrayList list = new ArrayList<MyPair>();

    public static void main(String[] args) {
        printData();
        highestMarksObtain();
    }
    public static void printData(){
        int score;
        String id;
        //MyPair temp = new MyPair();
        try {
            File dataFile = new File(fileDir);
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNext()){
                id = sc.next();
                score = sc.nextInt();
                list.add(new MyPair(id,score));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Object m : list){
            MyPair mp = (MyPair) m;
            System.out.println("ID: " + mp.key() + " Marks: "+ mp.value());
        }
    }
    public static void highestMarksObtain(){
        int maxValue = 0;
        String maxKey = null;
        for (Object o : list){
            MyPair mp = (MyPair) o;
            if(maxValue < mp.value()){
                maxKey = mp.key();
                maxValue = mp.value();
            }
        }
        System.out.println("Highest mark obtained by ID :" + maxKey);

    }
}
class MyPair
{
    private String key;
    private int value;

    public MyPair() {}
    public MyPair(String aKey, int aValue)
    {
        key   = aKey;
        value = aValue;
    }

    public String key()   { return key; }
    public int value() { return value; }
}
