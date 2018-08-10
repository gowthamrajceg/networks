import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
 
public class client
{
    public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 3000;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket(ip, port);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while (true)
        {
            System.out.print("Enter the string to be reversed...");
            String inp = sc.nextLine();
            if (inp.equals("bye"))
                break;
            dos.writeUTF(inp);
            String ans = dis.readUTF();
            System.out.println("Answer=" + ans);
        }
    }
}
