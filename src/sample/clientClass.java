package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.*;
import java.net.Socket;


public class clientClass {

    //Creating socket and setting port to 8000 to connect to server
    //Try and catch is used to make sure the socket is successfully is created
    //and connected.
    public static Socket socket;
    static {
        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Creating OutputStream for sockets.
    //Try and catch is used to make sure the output stream is created
    //successfully and connects with sockets.
    public static OutputStream outSp;
    static {
        try {
            outSp = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Creating InputStream for sockets.
    //Try and catch is used to make sure the input stream is created
    //successfully and connects with sockets.
    public static InputStream inSP;
    static {
        try {
            inSP = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setup data input and output streams to push data/messages to the server
    //and input data/messages from the server.
    public static DataOutputStream dataOutSp = new DataOutputStream(outSp);
    public static DataInputStream dataInSp = new DataInputStream(inSP);


    //sendMessages is a method that send messages to the server and receives
    //the message back from the server. Takes in two parameter, the text that
    //the user enter and the text field box where the server will output.
    public  static void sendMessages(TextField text1, TextArea textArea) throws IOException {
        try {
            String msg = text1.getText(); //Get message from text field
            //Sends the message to the server and flushes the output stream
            dataOutSp.writeUTF(msg);
            dataOutSp.flush();
            //Reads the message sent from the server
            msg = dataInSp.readUTF();
            //Outputs it to the text field
            textArea.appendText( msg+'\n');
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}