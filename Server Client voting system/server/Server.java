import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

public class Server
{
	public static void main( String[] args )
	{
		if(args.length < 2){
			throw new IllegalArgumentException("Must have at least Two options to vote for");
		}

		String[] voters = new String[args.length];
		for (int i=0; i<args.length; i++) {
			voters[i] = args[i];
		}

		Integer[] votes = new Integer[args.length];
		for (int i=0; i<votes.length; i++){
			votes[i] =0;
		}

		try(ServerSocket serverSocket = new ServerSocket(7777)) {
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("client connected");


				BufferedReader br =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String option = br.readLine();
				System.out.println(option);

				if(option.equals("Vote")) {

					String v_option = br.readLine();
					System.out.println(v_option);

					for (int i=0;i<args.length;i++) {
							if (args[i].equals(v_option)) {
									votes[i] += 1;
									System.out.println(votes[i]);
									break;
							}
					}
				}
				if(option.equals("Show")) {
					// BufferedReader brs =  new BufferedReader(new InputStreamReader(System.in));
					// PrintStream ps = new PrintStream(socket.getOutputStream());
					//
					//  for(int i =0; i<votes.length; i++){
					// 	Integer show_votes = (votes[1]);
					// 	System.out.println(show_votes);
					// 	ps.println(votes);
					//  }

				}
			}


			} catch(IOException e) {
					System.out.println("Server exception " + e.getMessage());
			}
	}
}
