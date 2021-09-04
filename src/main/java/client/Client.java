package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 25757);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String number;
            while (true) {
                //Вводим число
                System.out.println("Enter the number or 'end' for break");
                number = scanner.nextLine();
                if ("end".equals(number)) break;
                //Отправляем число на сервер
                out.println(number);
                //Получаем ответ от сервера и выводим на экран
                System.out.println("Fibonacci " + number + " :" + in.readLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}