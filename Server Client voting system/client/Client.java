import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main( String[] args )
	{
		if (args[0].equals("Vote")){
			if (args.length > 2){
				throw new IllegalArgumentException("You can only vote for one option");
			}else{
				System.out.println("accepted");
			}
		}else if (args[0].equals("Show")){
			if(args.length > 1){
				throw new IllegalArgumentException("There should be no other argumets after Show");
			}else{
				System.out.println("accepted");
			}
		}else{
			throw new IllegalArgumentException("Vote and Show commands are the only accepted commands");
		}
		try (Socket socket = new Socket("localhost", 7777)) {

			if (args[0].equals("Vote")){
				BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
				PrintStream ps = new PrintStream(socket.getOutputStream());
				BufferedReader brs = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String option = (args[0]);
				ps.println(option);

				String v_option = (args[1]);
				ps.println(v_option);
			}
			if (args[0].equals("Show")){
				// PrintStream ps = new PrintStream(socket.getOutputStream());
				// BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//
				// String option = (args[0]);
				// ps.println(option);
				//
				// Integer votes = br.read();
				// System.out.println(votes);
			}


		} catch (IOException e) {
				System.out.println("Client Error: " + e.getMessage());

		}
	}
}
