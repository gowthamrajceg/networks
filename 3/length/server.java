import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
public class server
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while (true)
        {
            String input = dis.readUTF();
            int result=input.length();
            System.out.println("Sending the result...");
            dos.writeUTF(Integer.toString(result));
        }
    }
}
