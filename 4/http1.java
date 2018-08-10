import java.io.*;
import java.net.*;
public class http1
{
	public static void main(String args[])throws IOException
	{
		ServerSocket server=new ServerSocket(3513);
		System.out.println("Listening");
		while(true)
		{
			String Line;
			Socket clientSocket=server.accept();
			InputStreamReader isr=new InputStreamReader(clientSocket.getInputStream());
			BufferedReader reader=new BufferedReader(isr);
			Line=reader.readLine();
			while(!Line.isEmpty())
			{
				System.out.println(Line);
				Line=reader.readLine();
			}
		}
	}
}
