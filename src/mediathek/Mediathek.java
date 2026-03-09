package mediathek;

import java.util.Scanner;

public class Mediathek {
	public static void main(String[] args) {
	    DigitalMedia[] digitalMedia = createFilmGames();
	    Newsletter[] news = createNews();
	    int[] playMinutes = new int[10];   
	    int playMinutesCount = 0;          
	    Scanner scan = new Scanner(System.in);
	    while (true) {
	        printMenu();
	        int choice = scanInt(0, 6, scan);
	        playMinutesCount = doActivity(choice, digitalMedia, news, scan, playMinutes, playMinutesCount);
	        if (playMinutesCount == -1) {
	            System.out.println("See you next time!");
	            break;
	        }
	    }
	}

	public static DigitalMedia[] createFilmGames() { // parts generated with AI
		DigitalMedia[] digitalMedia = new DigitalMedia[5];
		digitalMedia[0] = new Film("Inception", "SciFi", 148, "A thief enters people's dreams.");
        digitalMedia[1] = new Film("Interstellar", "SciFi", 169, "Astronauts travel through a wormhole.");
        digitalMedia[2] = new Game("Zelda - Breath of the Wild", "Adventure", 3000, new String[]{"Nintendo Switch"});
        digitalMedia[3] = new Game("Elden Ring", "RPG", 3600, new String[]{"PC", "PS5"});
        digitalMedia[4] = new Film("The Dark Knight", "Action", 152, "Batman fights the Joker.");
        return digitalMedia;
	}

	public static Newsletter[] createNews() { // parts generated with AI
		Newsletter[] newsletters = new Newsletter[3];
		newsletters[0] = new Newsletter("Tech Weekly", "New AI trends on the rise.", 1);
        newsletters[1] = new Newsletter("Gaming News", "Release of the new blockbuster coming soon.", 2);
        newsletters[2] = new Newsletter("Science Journal", "Breakthrough in quantum physics.", 3);
        return newsletters;
	}

	public static void printAllMedia(DigitalMedia[] digitalMedias, Newsletter[] news) {
		int lastPos = printDigitalMedia(digitalMedias, "Game"); // condition empty = show all
		printNews(news, lastPos);
	}

	public static void printMenu() {
		System.out.println("-------------Your-Selection-------------");
		System.out.println("(1) -- Digital Media Selection");
		System.out.println("(2) -- Newsletter Selection");
		System.out.println("(3) -- Show all content");
	    System.out.println("(4) -- Show total play minutes");
	    System.out.println("(5) -- Show max play minutes");
	    System.out.println("(0) -- Exit");
	}

	public static void digitalMediaMenu() { 
		System.out.println("(1) --> Rate");
		System.out.println("(2) --> Show rating");
		System.out.println("(3) --> Show number of ratings");
		System.out.println("(4) --> Play");
		System.out.println("(5) --> Search (films only!)");
		System.out.println("(6) --> Show info");
		System.out.println("(0) --> Back");
	}

	public static void rate(DigitalMedia media, Scanner scan) {
	    System.out.printf("How would you rate '%s' from 1-5: ", media.getTitle());
	    try {
	        int rating = scanInt(1, 5, scan); // range check handled by scanInt
	        media.rate(rating);
	        System.out.println("Rating added!");
	    } catch (Exception e) {
	        System.out.println("Error: max ratings reached."); // thrown when already 5 ratings
	    }
	}

	public static String getDigitalMediaClassName(DigitalMedia m) {
		return m.getClass().getSimpleName();
	}

	public static int printDigitalMedia(DigitalMedia[] digitalMedias, String condition) {
		int lastPos = 0;
		for (int i = 0; i < digitalMedias.length; i++) {
			// condition filters by class name, empty string = show all
			if (digitalMedias[i].getClass().getSimpleName().equals(condition) || condition.equals("")) {
			    System.out.printf("----------%s---------\n", getDigitalMediaClassName(digitalMedias[i]));
			    if (digitalMedias[i] != null) {
			        System.out.printf("(%d) --> %s\n", i + 1, digitalMedias[i].getTitle());
			        lastPos = i;
			    } else {
			        lastPos = i;
			        break;
			    }
			}
		}
		return lastPos; // used so newsletter numbering continues from here
	}

	public static void printNews(Newsletter[] news, int startCountPos) {
		for (int idx = 0; idx < news.length; idx++) {
			System.out.println("----------News---------");
			if (news[idx] != null) {
				System.out.printf("(%d)--> %s\n", idx + startCountPos + 2, news[idx].getTitle()); // +2 so numbering starts at 1
			} else {
				break;
			}
		}
	}

	public static int scanInt(int min, int max, Scanner scan) { // single place for input validation
		System.out.println("");
	    int choice = -1;
	    while (choice < min || choice > max) {
	        System.out.print("Your input: ");
	        try {
	            choice = scan.nextInt();
	            if (choice < min || choice > max) {
	                System.out.println("Please enter a number between " + min + " and " + max + ".");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input!");
	            scan.nextLine();
	        }
	    }
	    scan.nextLine(); // clear line break
	    System.out.println("");
	    return choice;
	}

	public static int chooseActivityDigital(Scanner scan, DigitalMedia[] media, int[] playMinutes, int playMinutesCount) {
	    int choice = scanInt(0, 6, scan);

	    switch (choice) {
	    // null checks in each case are redundant but safe
	    case 1:
	        printDigitalMedia(media, "");
	        System.out.println("Which media do you want to rate: ");
	        int i = scanInt(0, media.length - 1, scan);
	        if (media[i] != null) {
	            rate(media[i], scan);
	        } else {
	            System.out.println("Invalid input");
	        }
	        break;

	    case 2:
	        printDigitalMedia(media, "");
	        System.out.println("Which media's rating do you want to see?");
	        int a = scanInt(0, media.length - 1, scan);
	        if (media[a] != null) {
	            System.out.println("Average rating: " + media[a].getAvgRating());
	        } else {
	            System.out.println("Invalid input");
	        }
	        break;

	    case 3:
	        printDigitalMedia(media, "");
	        System.out.println("Which media's number of ratings do you want to see?");
	        int b = scanInt(0, media.length - 1, scan);
	        if (media[b] != null) {
	            System.out.println("Number of ratings: " + media[b].getNumberOfRatings());
	        } else {
	            System.out.println("Invalid input");
	        }
	        break;

	    case 4:
	        printDigitalMedia(media, "");
	        System.out.println("What do you want to play?");
	        int c = scanInt(1, media.length, scan);
	        if (media[c - 1] != null) {
	            playMinutesCount = playMedia(media[c - 1], playMinutes, playMinutesCount); // -1 because array index
	        } else {
	            System.out.println("Invalid input");
	        }
	        break;

	    case 5:
	        printDigitalMedia(media, "Film"); // only show films
	        System.out.println("Which film do you want to search?");
	        int d = scanInt(1, media.length, scan);
	        if (media[d - 1] instanceof Film) {
	            System.out.print("Keyword: ");
	            String keyword = scan.nextLine();
	            ((Film) media[d - 1]).searchFor(keyword); // cast needed here
	        } else {
	            System.out.println("Search only available for films!");
	        }
	        break;

	    case 6:
	        getInfo(media);
	        break;

	    case 0:
	        return 0;
	    }

	    return playMinutesCount;
	}

	public static int doActivity(int choice, DigitalMedia[] digMedia, Newsletter[] news, Scanner scan, int[] playMinutes, int playMinutesCount) {
	    switch (choice) {
	        case 1:
	            digitalMediaMenu();
	            playMinutesCount = chooseActivityDigital(scan, digMedia, playMinutes, playMinutesCount);
	            break;
	        case 2:
	            chooseActivityNewsletter(scan, news);
	            break;
	        case 3:
	            printAllMedia(digMedia, news);
	            break;
	        case 4:
	            getSumPlayMinutes(playMinutes, playMinutesCount);
	            break;
	        case 5:
	            getMaxMinutes(playMinutes, playMinutesCount);
	            break;
	        case 0:
	            return -1;
	    }
	    return playMinutesCount;
	}

	public static int playMedia(DigitalMedia media, int[] playMinutes, int playMinutesCount) {
	    if (playMinutesCount >= playMinutes.length) { // array full
	        System.out.println("Maximum entries reached!");
	        return playMinutesCount;
	    }
	    playMinutes[playMinutesCount] = media.getPlayMinutes();
	    playMinutesCount++;
	    System.out.printf("'%s' is now playing! (%d minutes added)\n", media.getTitle(), media.getPlayMinutes());
	    return playMinutesCount;
	}

	public static void getSumPlayMinutes(int[] playMinutes, int count) {
	    int sum = 0;
	    for (int i = 0; i < count; i++) {
	        sum += playMinutes[i];
	    }
	    System.out.println("Total play minutes: " + sum + " minutes");
	}

	public static void getMaxMinutes(int[] playMinutes, int count) {
	    if (count == 0) {
	        System.out.println("No media played yet.");
	        return;
	    }
	    int max = playMinutes[0];
	    for (int i = 1; i < count; i++) {
	        if (playMinutes[i] > max) {
	            max = playMinutes[i]; // always keep the higher value
	        }
	    }
	    System.out.println("Maximum minutes: " + max);
	}

	public static void chooseActivityNewsletter(Scanner scan, Newsletter[] news) {
	    printNews(news, -1); // -1 because +2 is added later
	    System.out.println("Which newsletter?");
	    int idx = scanInt(1, news.length, scan);
	    Newsletter selected = news[idx - 1];

	    System.out.println("(1) --> Read");
	    System.out.println("(2) --> Search by keyword");
	    int action = scanInt(1, 2, scan);

	    switch (action) {
	        case 1:
	            selected.read();
	            break;
	        case 2:
	            System.out.print("Keyword: ");
	            String keyword = scan.nextLine();
	            selected.searchFor(keyword);
	            break;
	    }
	}

	public static void getInfo(DigitalMedia[] media) {
	    for (int i = 0; i < media.length; i++) {
	        if (media[i] != null) {
	            System.out.println("------------------------------");
	            media[i].getInfo();
	        }
	    }
	}
}