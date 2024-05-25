import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Scanner;

class Friend extends Thread {
    private String name;
    private ArrayList<String> sentences;

    public Friend(String name, ArrayList<String> sentences) {
        this.name = name;
        this.sentences = sentences;
    }

    @Override
    public void run() {
        for (String sentence : sentences) {
            synchronized (System.out) {
                System.out.println(name + ": " + sentence);
                if(sentence.contains("bye") || sentence.contains("Bye")){
                    this.interrupt();
                }
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second between each sentence
            } catch (InterruptedException e) {
                System.out.println(this.name + " Left the chat");
            }
        }
    }
}

public class Conversation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> friend1Sentences = new ArrayList<>();
        ArrayList<String> friend2Sentences = new ArrayList<>();
        ArrayList<String> friend3Sentences = new ArrayList<>();
        boolean friend1Left = false;
        boolean friend2Left = false;
        boolean friend3Left = false;

        String tempString;

        int i = 0;
        while (!(friend1Left & friend2Left & friend3Left)){
            if(!friend1Left) {
                System.out.print("Friend 1, Enter sentence " + (i + 1) + ":");
                tempString = scanner.nextLine();
                friend1Sentences.add(tempString);
                if(tempString.contains("bye") || tempString.contains("Bye")){
                    friend1Left = true;
                }
            }
            if(!friend2Left) {
                System.out.print("Friend 2, Enter sentence " + (i + 1) + ":");
                tempString = scanner.nextLine();
                friend2Sentences.add(tempString);
                if(tempString.contains("bye") || tempString.contains("Bye")){
                    friend2Left = true;
                }
            }
            if(!friend3Left) {
                System.out.print("Friend 3, Enter sentence " + (i + 1) + ":");
                tempString = scanner.nextLine();
                friend3Sentences.add(tempString);
                if(tempString.contains("bye") || tempString.contains("Bye")){
                    friend3Left = true;
                }
            }
            i++;
        }

        Friend friend1 = new Friend("Bob", friend1Sentences);
        Friend friend2 = new Friend("Missy", friend2Sentences);
        Friend friend3 = new Friend("Sheldon", friend3Sentences);


        friend1.start();
        friend2.start();
        friend3.start();


        try {
            System.out.println("test 4");

            friend1.join();
            friend2.join();
            friend3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of conversation.");
    }
}
