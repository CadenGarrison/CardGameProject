import java.util.Scanner;

import java.util.ArrayList;

public class PlayGame
	{
		static int knowsGame;
		static int numCardsSeq;
		static int p1GoOut;
		static int p2GoOut;
		static int sequence;
		static int player1Play;
		static int player2Play;
		static int player1Value = 0;
		static int player2Value = 0;
		static int firstSeqCard;
		static int correctError1;
		static int correctError2;
		static int secSeqCard;
		static int thirdSeqCard;
		static int fourthSeqCard;
		static int fifthSeqCard;
		static boolean isPlaying = true;
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
				while (isPlaying = true)
					{
				playGame();
				playGame2();
				checkForOut();
					}
				

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
					System.out.println("Ace counts for one, all the way up to King, which counts for thirteen. Your cards will be dealt automatically");
					System.out.println("Cards may be laid down independently, in doubles or triples, or in sequences.");
					System.out.println("Sequences must be of the same suit. A sequence of five is known as a dumbol.");
					System.out.println("As soon as you reach five or below, you may lay down your hand to show the other competitors.");
					System.out.println("Be careful! Even if you have five, another player may have even less...");
					System.out.println("The dealer turned up a " + Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit() + ".");
					topCard = Deck.deck.get(0);
					Deck.deck.remove(0);
					
					
				}
		}
		public static void playGame()
		{
			
			
			
			System.out.println("Player 1, your hand is:");
			for (int i=0; i<player1.size(); i++)
				{
					System.out.println(i+1 + ". " + player1.get(i).getRank() + " of " + player1.get(i).getSuit());
				}
			
			System.out.println("What would you like to play? Type the number corresponding to the card. If multiple cards, type 7.");
			player1Play = userIntInput.nextInt();
			if (player1Play > 5)
				{
					sequences1();
				}
			else {
			player1Play --;
			topCard = player1.get(player1Play);
			player1.remove(player1Play);
			System.out.println("The top card is now a " + topCard.getRank() + " of " + topCard.getSuit() + ".");
			player1.add(Deck.deck.get(0));
			}
			
		}
		
		public static void playGame2()
		{
			System.out.println("Player 2, your hand is:");
			for (int i=0; i<player2.size(); i++)
				{
					System.out.println(i+1 + ". " + player2.get(i).getRank() + " of " + player2.get(i).getSuit());
				}
			
			System.out.println("What would you like to play? Type the number corresponding to the card. If multiple cards, type 7.");
			player2Play = userIntInput.nextInt();
			if (player2Play > 5)
				{
					sequences2();
				}
			else {
			player2Play --;
			topCard = player2.get(player2Play);
			player2.remove(player2Play);
			System.out.println("The top card is now a " + topCard.getRank() + " of " + topCard.getSuit() + ".");
			player2.add(Deck.deck.get(0));
			}
		}
		
		public static void sequences1()
		{
			System.out.println("How many cards would you like to play together?");
			numCardsSeq = userIntInput.nextInt();
			for (int i = 0; i < numCardsSeq; i++)
				{
					switch (i)
					{
						case 0:
							System.out.println("What is card " + (i+1) + "?");
							firstSeqCard = userIntInput.nextInt();
							topCard = player1.get(firstSeqCard-1);
							player1.remove(firstSeqCard-1);
							break;
						case 1:
							for (int a=0; a<player1.size(); a++)
								{
									System.out.println(a+1 + ". " + player1.get(a).getRank() + " of " + player1.get(a).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							secSeqCard = userIntInput.nextInt();
							if (player1.get(secSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player1.get(secSeqCard-1);
							player1.remove(secSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError1 = userIntInput.nextInt();
									if (correctError1 == 1)
										{
											sequences1();
										}
									else
										{
											playGame2();
										}
								}
							break;
						case 2:
							for (int b=0; b<player1.size(); b++)
								{
									System.out.println(b+1 + ". " + player1.get(b).getRank() + " of " + player1.get(b).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							thirdSeqCard = userIntInput.nextInt();
							if (player1.get(thirdSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player1.get(thirdSeqCard-1);
							player1.remove(thirdSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError1 = userIntInput.nextInt();
									if (correctError1 == 1)
										{
											sequences1();
										}
									else
										{
											playGame2();
										}
								}
							break;
						case 3:
							for (int c=0; c<player1.size(); c++)
								{
									System.out.println(c+1 + ". " + player1.get(c).getRank() + " of " + player1.get(c).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							fourthSeqCard = userIntInput.nextInt();
							if (player1.get(fourthSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player1.get(fourthSeqCard-1);
							player1.remove(fourthSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError1 = userIntInput.nextInt();
									if (correctError1 == 1)
										{
											sequences1();
										}
									else
										{
											playGame2();
										}
								}
							break;
						case 4:
							for (int d=0; d<player1.size(); d++)
								{
									System.out.println(d+1 + ". " + player1.get(d).getRank() + " of " + player1.get(d).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							fifthSeqCard = userIntInput.nextInt();
							if (player1.get(fifthSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player1.get(fifthSeqCard-1);
							player1.remove(fifthSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError1 = userIntInput.nextInt();
									if (correctError1 == 1)
										{
											sequences1();
										}
									else
										{
											playGame2();
										}
								}
							break;
							
					}
					playGame2();
					
					// AT SOME POINT WE NEED TO VERIFY THAT THE RANKS OF THE SEQUENCE CARDS MATCH
					// ALSO WE NEED TO CODE SEQUENCES LIKE DUMBOLS
					
				}
			
			
			
		}
		
		public static void sequences2()
		{
			System.out.println("How many cards would you like to play together?");
			numCardsSeq = userIntInput.nextInt();
			for (int i = 0; i < numCardsSeq; i++)
				{
					switch (i)
					{
						case 0:
							System.out.println("What is card " + (i+1) + "?");
							firstSeqCard = userIntInput.nextInt();
							topCard = player2.get(firstSeqCard-1);
							player2.remove(firstSeqCard-1);
							break;
						case 1:
							for (int a=0; a<player2.size(); a++)
								{
									System.out.println(a+1 + ". " + player2.get(a).getRank() + " of " + player2.get(a).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							secSeqCard = userIntInput.nextInt();
							if (player2.get(secSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player2.get(secSeqCard-1);
							player2.remove(secSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError2 = userIntInput.nextInt();
									if (correctError2 == 1)
										{
											sequences2();
										}
									else
										{
											playGame();
										}
								}
							break;
						case 2:
							for (int b=0; b<player2.size(); i++)
								{
									System.out.println(b+1 + ". " + player2.get(b).getRank() + " of " + player2.get(b).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							thirdSeqCard = userIntInput.nextInt();
							if (player2.get(thirdSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player2.get(thirdSeqCard-1);
							player2.remove(thirdSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError2 = userIntInput.nextInt();
									if (correctError2 == 1)
										{
											sequences2();
										}
									else
										{
											playGame();
										}
								}
							break;
						case 3:
							for (int c=0; c<player2.size(); c++)
								{
									System.out.println(c+1 + ". " + player2.get(c).getRank() + " of " + player2.get(c).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							fourthSeqCard = userIntInput.nextInt();
							if (player2.get(fourthSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player2.get(fourthSeqCard-1);
							player2.remove(fourthSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError2 = userIntInput.nextInt();
									if (correctError2 == 1)
										{
											sequences2();
										}
									else
										{
											playGame();
										}
								}
							break;
						case 4:
							for (int d=0; d<player2.size(); d++)
								{
									System.out.println(d+1 + ". " + player2.get(d).getRank() + " of " + player2.get(d).getSuit());
								}
							System.out.println("What is card " + (i+1) + "?");
							fifthSeqCard = userIntInput.nextInt();
							if (player2.get(fifthSeqCard-1).getRank().equals(topCard.getRank()))
								{
							topCard = player2.get(fifthSeqCard-1);
							player2.remove(fifthSeqCard-1);
								}
							else 
								{
									System.out.println("Bad boy. The ranks of the cards must match.");
									System.out.println("You played a " + topCard.getRank() + " of " + topCard.getSuit() + ". Do you wish to add another card? (1) Yes (2) No");
									correctError2 = userIntInput.nextInt();
									if (correctError2 == 1)
										{
											sequences2();
										}
									else
										{
											playGame();
										}
								}
							break;	
							
					}
					
					playGame();
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
		
		public static void checkForOut()
		{
			for (int i=0; i<player1.size(); i++)
				{
					player1Value += player1.get(i).getValue();
					player2Value += player2.get(i).getValue();
				}
			if (player1Value <= 5)
				{
					System.out.println("Player 1, would you like to go out with " + player1Value + "? (1) Yes (2) No");
					p1GoOut = userIntInput.nextInt();
						if (p1GoOut == 1)
							{
								isPlaying = false;
								System.out.println("Player 1 has gone out with " + player1Value + "!");
								System.out.println("The value of Player 2's hand is " + player2Value + ".");
								if (player2Value <= player1Value)
									{
											System.out.println("So Player 2 wins! What a squish!");
											System.exit(0);
									}
								else
									{
										System.out.println("Player 1 is victorious!");
										System.exit(0);
									}
							}
						else
							{
								isPlaying = true;
							}
				}
			if (player2Value <= 5)
				{
					System.out.println("Player 2, would you like to go out with " + player2Value + "? (1) Yes (2) No");
					p2GoOut = userIntInput.nextInt();
						if (p2GoOut == 1)
							{
								isPlaying = false;
								System.out.println("Player 2 has gone out with " + player2Value + "!");
								System.out.println("The value of Player 1's hand is " + player1Value + ".");
								if (player1Value <= player2Value)
									{
											System.out.println("So Player 1 wins! What a squish!");
											System.exit(0);
									}
								else
									{
										System.out.println("Player 2 is victorious!");
										System.exit(0);
									}
							}
						else
							{
								isPlaying = true;
							}
			
				}
		}

	}
