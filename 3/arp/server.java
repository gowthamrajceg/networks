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
            String str = dis.readUTF();
	    String result;
	    String ip[]={"165.165.80.80","165.165.79.1"};
	    String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"};
	    for(int i=0;i<ip.length;i++)
		{
			if(str.equals(ip[i]))
			{				
            			System.out.println("Sending the result...");
            			dos.writeUTF(mac[i]+'\n');
			}
		}
        }
    }
}
