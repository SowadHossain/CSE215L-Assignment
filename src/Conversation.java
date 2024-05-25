import java.util.Scanner;

class Friend extends Thread {
    private String name;
    private String[] sentences;

    public Friend(String name, String[] sentences) {
        this.name = name;
        this.sentences = sentences;
    }

    @Override
    public void run() {
        for (String sentence : sentences) {
            synchronized (System.out) {
                System.out.println(name + ": " + sentence);
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second between each sentence
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Conversation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friend1Sentences = new String[3];
        String[] friend2Sentences = new String[3];
        String[] friend3Sentences = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Friend 1, Enter sentence " + (i + 1) + ":");
            friend1Sentences[i] = scanner.nextLine();
            System.out.print("Friend 2, Enter sentence " + (i + 1) + ":");
            friend2Sentences[i] = scanner.nextLine();
            System.out.print("Friend 3, Enter sentence " + (i + 1) + ":");
            friend3Sentences[i] = scanner.nextLine();
        }

        Friend friend1 = new Friend("Bob", friend1Sentences);
        Friend friend2 = new Friend("Missy", friend2Sentences);
        Friend friend3 = new Friend("Sheldon", friend3Sentences);



        friend1.start();
        friend2.start();
        friend3.start();

        try {
            friend1.join();
            friend2.join();
            friend3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of conversation.");
    }
}
