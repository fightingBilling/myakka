import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(2000);
			Socket client = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream ps = new PrintStream(client.getOutputStream());
			String msg;
			// 如果输入流不为空,将接受到的信息打印到相应的文本框中并反馈回收到的信息
			while ((msg = br.readLine()) != null) {
				System.out.println("服务器端收到：" + msg + "\n");
				ps.println(msg);
				if (msg.equals("quit")) {
					System.out.println("客户端“2000”已退出！" + "\n");
					System.out.println("服务器程序将退出！");
					break;
				}
			}
			ps.close();
			br.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null)
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
