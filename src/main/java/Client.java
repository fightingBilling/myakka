import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("192.168.39.122", 2000);
			// 从服务端接受的数据
			BufferedReader br1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// 从客户端输出的数据
			PrintStream ps = new PrintStream(client.getOutputStream());
			ps.println("hello --->");
			String resp = br1.readLine();
			if (resp != null)
				System.out.println(resp);
			ps.println("quit");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null)
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
