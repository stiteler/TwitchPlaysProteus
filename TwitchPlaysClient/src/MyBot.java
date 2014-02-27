import org.jibble.pircbot.*;

public class MyBot extends PircBot {
	
	private static String currentMessage;
	private static String lastMessage;
	private static String currentSender;
	private static String lastSender;
	private int repeatCount = 0;
	
	public MyBot() {
		this.setName("SteazGaming");
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		System.out.println("Message is: " + message + " " + "Sender is: " + sender);
		currentSender = sender;
		currentMessage = message;
	}
	
	public String getMessage() {
		
		if(currentMessage == lastMessage && lastSender == currentSender) {
			repeatCount++;
			System.out.println(repeatCount);
		} else {
			repeatCount = 0;
			System.out.println("repeat Count: " + repeatCount);
		}
			
		if(repeatCount > 5) {
			currentMessage = "";
		}
		
		lastMessage = currentMessage;
		lastSender = currentSender;
		
		return currentMessage;
	}
}
