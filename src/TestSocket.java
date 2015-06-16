import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TestSocket {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new SocketThread(i));
			thread.start();
			
		}
//		String host = "192.168.24.199";
//		int  port  = 8899;
//		try {
//			Socket client = new Socket(host, port);
//			client.setKeepAlive(true);
//			client.setOOBInline(true);
//			client.setSoTimeout(40000);
//			
//			Writer write = new OutputStreamWriter(client.getOutputStream());
//			
//			//Scanner input = new Scanner(System.in);
//			//String str = input.next();
//			
//			String str = "Hi,No.1";
//			write.write(str);
//			write.flush();
//			
//			write.close();
//			client.close();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}

class SocketThread implements Runnable{
	
	int i = 0;
	public SocketThread(int i){
		super();
		this.i = i;
	}
	
	@Override
	public void run() {
		String host = "10.240.130.36";
		int  port  = 8899;
		try {
			Socket client = new Socket(host, port);
			client.setKeepAlive(true);
			client.setOOBInline(true);
			client.setSoTimeout(40000);
			
			Writer write = new OutputStreamWriter(client.getOutputStream());
			
			//Scanner input = new Scanner(System.in);
			//String str = input.next();
			//System.out.println(i);
			String str = "Hi,No."+i;
			write.write(str);
			write.flush();
			
			write.close();
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
