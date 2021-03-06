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
            if(input.equals("bye"))
                break;
            System.out.println("The text has been received...");
	    StringBuilder ans=new StringBuilder();
            ans.append(input);
            ans.reverse();
            System.out.println("Sending the result...");
            dos.writeUTF(ans.toString());
        }
    }
}
