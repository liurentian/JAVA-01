
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author RenTian Liu
 * @version 1.0
 * @date 2021-04-11 11:10
 */
public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8083);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
        while (true) {
            final Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                service(socket);
            });
        }

    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(5);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio3";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
