import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TestTimer{
	
	Timer timer = null;
	
	
	
	public static void main(String[] args) {
		new TestTimer(3);
	}
	
	public TestTimer(int second){
		timer = new Timer();
		timer.schedule(new TestTimeTask(), second*1000,second*1000);
	}
	
	class TestTimeTask extends TimerTask{

		@Override
		public void run() {
			System.out.println("This is" + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
			//timer.cancel();
		}
		
	}
}
