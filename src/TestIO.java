import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class TestIO {
	
	public static void main(String[] args) {
		//testcreateFile();
		//testWriteFile();
		testReadFile();
	}
	
	
	public static void testcreateFile(){
		File file = new File("D:\\test\\test.txt");
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdir();
			}
			try {
				file.createNewFile();
			} catch (Exception e) {
				System.out.println("�����ļ�ʧ��");
			}
	}
	
	public static void testWriteFile(){
		File file = new File("D:\\test\\test.txt");
		OutputStream out  = null;
		try {
			out =  new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String info = new String("hello");
		
		try {
			out.write(info.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String testReadFile(){
		InputStream in = null;
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File file =  new File("D:\\test\\test.txt");
					InputStream	in = new FileInputStream(file);
					byte[] b = new byte[1024];
					int a = in.read(b);
					System.out.println("�߳�һ��ȡ��"+ new String(b));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File file =  new File("D:\\test\\test.txt");
					InputStream	in = new FileInputStream(file);
					byte[] b = new byte[1024];
					int a = in.read(b);
					System.out.println("�̶߳���ȡ��"+ new String(b));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File file =  new File("D:\\test\\test.txt");
					InputStream	in = new FileInputStream(file);
					byte[] b = new byte[1024];
					int a = in.read(b);
					System.out.println("�߳�����ȡ��"+ new String(b));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File file =  new File("D:\\test\\test.txt");
					InputStream	in = new FileInputStream(file);
					byte[] b = new byte[1024];
					int a = in.read(b);
					System.out.println("�߳��Ķ�ȡ��"+ new String(b));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread5 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File file =  new File("D:\\test\\test.txt");
					InputStream	in = new FileInputStream(file);
					byte[] b = new byte[1024];
					int a = in.read(b);
					System.out.println("�߳�5��ȡ��"+ new String(b));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
//		try {
//			while((temp = in.read()) != -1){
//				
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		return "";
	}
	
}
