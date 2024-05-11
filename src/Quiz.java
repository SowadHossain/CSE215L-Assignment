import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Quiz {
    private static String fileDir = "data/quiz_data.txt";
    private static Map<Integer,Integer> mp = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        printData();
        highestMarksObtain();

    }
    public static void printData(){
        int id,score;
        try {
            File dataFile = new File(fileDir);
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNext()){
                id = sc.nextInt();
                score = sc.nextInt();
                mp.put(id,score);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> e : mp.entrySet()){
            System.out.println("ID: " + e.getKey() + " marks: " + e.getValue());
        }
    }
    public static void highestMarksObtain(){
        int maxValue = 0, maxKey = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()){
            if(maxValue < e.getValue()){
                maxKey = e.getKey();
                maxValue = e.getValue();
            }
        }
        System.out.println("Highest mark obtained by ID :" + maxKey);

    }
}
