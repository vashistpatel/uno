package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.*;
import java.net.Socket;

public class clientClass {
    public static Socket socket;
    static {
        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static OutputStream outSp;
    static {
        try {
            outSp = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DataOutputStream dataOutSp = new DataOutputStream(outSp);
    public static InputStream inSP;
    static {
        try {
            inSP = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DataInputStream dataInSp = new DataInputStream(inSP);
    public clientClass() throws IOException {
    }
    public  static void sendMessages(TextField text1, TextArea textArea) throws IOException {
        try {
            String msg = text1.getText();
            System.out.println(msg);
            dataOutSp.writeUTF(msg);
            dataOutSp.flush();
            msg = dataInSp.readUTF();
            textArea.appendText( msg+'\n');
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}