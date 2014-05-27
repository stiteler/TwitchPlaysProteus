import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;


public class Controller {
	private static String twitchOAuth = "getThisFromTwitch";
	private static ProteusRobot protBot;
	
	public static void main(String[] args) throws InterruptedException {
		protBot = new ProteusRobot();
		
		MyBot bot = new MyBot();
		
		bot.setVerbose(true);
		
		try {
			bot.connect("irc.twitch.tv", 6667, twitchOAuth);			
			bot.joinChannel("#channelToWatch");
		} catch (NickAlreadyInUseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
		
		while(true) {
			String message = bot.getMessage();
			if(message == "") {
				protBot.idle();
			} else {
				chatEvent(message);
			}
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	

	public static void chatEvent(String chatEvent) throws InterruptedException {
		if(chatEvent == null || chatEvent == "") {
			protBot.idle();
			return;
		}else if(chatEvent.length() > 200) {
			return;
		}
		
		char firstLetter = chatEvent.charAt(0);
		
		if(firstLetter == 'f' || firstLetter == 'F') {
			protBot.moveForward();
		} else if(firstLetter == 'l' || firstLetter == 'L') {
			protBot.turnLeft();
		} else if(firstLetter == 'r' || firstLetter == 'R') {
			protBot.turnRight();
		} else if(firstLetter == 'b' || firstLetter == 'B') {
			protBot.moveBackwards();
		} else if(firstLetter == 's' || firstLetter == 'S') {
			protBot.stop();
		}
	}
	
}
