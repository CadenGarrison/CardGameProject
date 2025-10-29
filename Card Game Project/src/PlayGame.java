import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame
	{
		static int knowsGame;
		static int player1Play;
		static int player2Play;
		static Card topCard;
		static Scanner userIntInput = new Scanner(System.in);
		static ArrayList<Card>player1 = new ArrayList<Card>();
		static ArrayList<Card>player2 = new ArrayList<Card>();


		public static void main(String[] args)
			{
				
								Deck.fillDeck();
				Deck.shuffle();
				dealHands();
				introduction();
				

			}
		
		public static void introduction()
		{
			System.out.println("Welcome to Dumbol! Do you know how to play? (1) Yes (2) No");
			knowsGame = userIntInput.nextInt();
			if (knowsGame == 1)
				{
					playGame();
				}
			else if (knowsGame == 2)
				{
					System.out.println("The object of the game is to reduce the value of the cards in your hand to five or below");
					System.out.println("Ace counts for one, all the way up to King, which counts for thirteen.");
					System.out.println("Cards may be laid down independently, in doubles or triples, or in sequences.");
					System.out.println("Sequences must be of the same suit. A sequence of five is known as a dumbol.");
					System.out.println("As soon as you reach five or below, you may lay down your hand to show the other competitors.");
					System.out.println("Be careful! Even if you have five, another player may have even less...");
					playGame();
					
				}
		}
		public static void playGame()
		{
			
			System.out.println("The dealer turned up a " + Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit() + ".");
			topCard = Deck.deck.get(0);
			Deck.deck.remove(0);
			
			System.out.println("Player 1, your hand is:");
			for (int i=0; i<player1.size(); i++)
				{
					System.out.println(i+1 + ". " + player1.get(i).getRank() + " of " + player1.get(i).getSuit());
				}
			
			System.out.println("What would you like to play? Type the number corresponding to the card.");
			player1Play = userIntInput.nextInt();
			player1Play --;
			topCard = player1.get(player1Play);
			player1.remove(player1Play);
		
			
			System.out.println("Player 2, your hand is:");
			for (int i=0; i<player2.size(); i++)
				{
					System.out.println(i+1 + ". " + player2.get(i).getRank() + " of " + player2.get(i).getSuit());
				}
			
			
		}
		
		public static void dealHands()
		{
			for (int i = 0; i< 5; i++)
				{
					player1.add(Deck.deck.get(0));
					Deck.deck.remove(0);
					player2.add(Deck.deck.get(0));
					Deck.deck.remove(0);
					
				}
		}

	}
