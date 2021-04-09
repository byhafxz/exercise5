import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		
		try {
				int portNo = 5555;
				serverSocket = new ServerSocket(portNo);
				
				String text = "";
				
				System.out.println("Choose the English text you wish to Korean:");
				System.out.println("1. Good Morning");
				System.out.println("2. Good Night");
				System.out.println("3. How are you?");
				System.out.println("4. Thank you");
				System.out.println("5. Goodbye");
				System.out.println("6. What's up?");
				System.out.println("");
				
				
				Scanner readText = new Scanner(System.in); 
				
				System.out.println("Please input choose:");
				int respon;
				respon = readText.nextInt();
				readText.close();
				
				switch(respon)
				{
				case 1:
					text = "좋은 아침 ";
					break;
					
				case 2:
					text = "안녕히 주무세요 ";
					break;
					
				case 3:
					text = "어떻게 지내세요?";
					break;
					
				case 4:
					text = "감사합니다";
					break;
					
				case 5:
					text = "안녕";
					break;
					
				case 6:	
					text = "뭐야?";
					break;
					
					default:
						text = "Your choice of anwser is not in the list.";
				}
				
				while(true) {
					Socket clientSocket = serverSocket.accept();
					DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
					
					outputStream.writeUTF("In Korean it's: " + text);
					clientSocket.close();
				}
			} catch (IOException ioe) {
				if (serverSocket != null)
					serverSocket.close();
				
				ioe.printStackTrace();
			}
		}
		}