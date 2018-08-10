import java.net.*;
public class DSender{
	public static void main(String[] args)throws Exception{

		DatagramSocket ds = new DatagramSocket();
		//catch(SocketException c){
		//System.out.println(c);
		//}
		
		String s = "Hi there";
		//try{
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		//}
		//catch(UnknownHostException e){
		//	System.out.println(e);
		//}
		
		DatagramPacket dp = new DatagramPacket(s.getBytes(),s.length(),ip,3000);
		//try{
		ds.send(dp);
		//}
		//catch(IOException i){
		//System.out.println(i);
		//}
		ds.close();
	}
}
