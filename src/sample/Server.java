package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws IOException {
        //Creating socket and setting port to 8000
        ServerSocket sSocket = new ServerSocket(8000);
        //Setting socket to look for inputs
        Socket socketListen = sSocket.accept();
        //Setting up input and output for server
        DataInputStream clientInput = new DataInputStream(socketListen.getInputStream());
        DataOutputStream serverOutput = new DataOutputStream(socketListen.getOutputStream());
        //Thread
        new Thread(() ->{
            try {
                /*While true it takes the input from the client puts it into a string and returns
                 * a specific msg based on the entered String then sends it back to the Client*/
                while (true) {
                    String msg = clientInput.readUTF();
                    System.out.println(msg);
                    String temp = returnMessage(msg);
                    System.out.println(temp);
                    serverOutput.writeUTF(temp);
                }
            } catch (Exception e) {

            }

        }).start();
    }

    //Function for figuring out what the server Should output
    public static String returnMessage(String msg) {
        if (msg.equals("!Help")) {
            return "-----------------------------------------------" + "\n" +
                    "!Rules - Access Game Rules" + "\n" +
                    "!Information - Information on the developers" + "\n" +
                    "-----------------------------------------------";

        } else if (msg.equals("!Information")) {
            return "-----------------------------------------------" + "\n" +
                    "People Who Worked on the Project" + "\n" +
                    "Saenthuran Vignarjah" + "\n" +
                    "Nirojan Arunakirinathan" + "\n" +
                    "Mayur Bhai" + "\n" +
                    "Vethuson Amit" + "\n" +
                    "Vashist Patel" + "\n" +
                    "-----------------------------------------------";


        } else if (msg.equals("!Rules")) {
            return "-----------------------------------------------"+"\n"+
                    "Cards Can Only Be Placed If They Have the Same Number/Colour"+"\n"+
                    "Or Are of the +4 & Colour Change"+"\n"+
                    "+2 & +4 Cannot be Stacked"+"\n"+
                    "After a +4/Colour Change is Placed, the Placer Can Choose What "+"\n"+
                    "Colour They Want"+"\n"+
                    "Skip Cards Skip the Next Players Turn"+"\n"+
                    "Reverse Cards Reverse the Order"+"\n"+
                    "In Order to Win One Player Must Have No More Cards Left"+"\n"+
                    "If Deck Runs out Deck Will Shuffle a New Deck & Remove Any"+"\n"+
                    "Cards That are in Players Hand";

        } else {
            return "Please Enter a Proper Command or Use !Help to get Started";
        }
    }
}
