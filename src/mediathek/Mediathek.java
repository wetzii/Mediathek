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
	    int choice = scanInt(1, 5, scan);
	    playMinutesCount = doActivity(choice, digitalMedia, news, scan, playMinutes, playMinutesCount);
	    }
	}
	public static DigitalMedia[] createFilmGames() { //Teile der Methode sind mit KI generiert
		DigitalMedia[] digitalMedia = new DigitalMedia[5];
		digitalMedia[0] = new Film("Inception", "SciFi", 148, "Ein Dieb dringt in Traeume ein.");
        digitalMedia[1] = new Film("Interstellar", "SciFi", 169, "Astronauten reisen durch ein Wurmloch.");
        digitalMedia[2] = new Game("Zelda - Breath of the Wild", "Adventure", 3000, new String[]{"Nintendo Switch"});
        digitalMedia[3] = new Game("Elden Ring", "RPG", 3600, new String[]{"PC", "PS5"});
        digitalMedia[4] = new Film("The Dark Knight", "Action", 152, "Batman kaempft gegen den Joker.");
        return digitalMedia;
	}
	public static Newsletter[] createNews() { //Teile der Methode sind mit KI generiert
		
		Newsletter[] newsletters = new Newsletter[3];
		newsletters[0] = new Newsletter("Tech Weekly", "Neue KI-Trends auf dem Vormarsch.", 1);
        newsletters[1] = new Newsletter("Gaming News", "Release des neuen Blockbusters steht bevor.", 2);
        newsletters[2] = new Newsletter("Science Journal", "Durchbruch in der Quantenphysik.", 3);
        //
        return newsletters;
	}
	public static void printAllMedien(DigitalMedia[] digitalMedias, Newsletter[] news) {
		int lastPos = printDigitalMedia(digitalMedias, "Game"); //Condition bleinbt in diesen Fall leer
		printNews(news, lastPos);
		
	}
	public static void printMenu() {
		System.out.println("-------------Deine-Auswahl-------------");
		System.out.println("(1) -- Digitale Medien Auswahl");
		System.out.println("(2) -- Auswahl für Bücher");
		System.out.println("(3) -- Gesamte Inhalte ausgeben");
	    System.out.println("(4) -- Gesamt-Spielminuten ausgeben");
	    System.out.println("(5) -- Maximale Spielminuten ausgeben");
	}
	public static void digitalMediaMenu() { 
		System.out.println("(1) --> Bewerten");
		System.out.println("(2) --> Bewertung ausgeben");
		System.out.println("(3) --> Anzahl Bewertung ausgeben ");
		System.out.println("(4) --> Abspielen");
		System.out.println("(5) --> Suchen nach (nur bei Film!)");
		
		
	}
	public static void rate(DigitalMedia media, Scanner scan) {
	    System.out.printf("Wie möchtest du '%s' von 1-5 bewerten: ", media.getTitle());
	    try {
	        int rating = scanInt(1, 5, scan); // Bereich überprüfung
	        media.rate(rating);
	        System.out.println("Bewertung wurde hinzugefügt!");
	    } catch (Exception e) {
	        System.out.println("Fehler"); // wenn bereits 5 Ratings
	    }
	}
	
	public static String getDigitalMediaClassName(DigitalMedia m) {
		return m.getClass().getSimpleName();
	}
	public static int printDigitalMedia(DigitalMedia[] digitalMedias, String condition) {
		int lastPos = 0;
		
		for(int i = 0; i < digitalMedias.length; i++) { 
			if(digitalMedias[i].getClass().getSimpleName().equals(condition) || condition.equals("")) { //Condition ist da damit man sieht ob es jetzt Film oder Game ist das überprüft es mit dem Klassennamen
			System.out.printf("----------%s---------\n",getDigitalMediaClassName(digitalMedias[i]));
			
			if(digitalMedias[i] != null ) {
			System.out.printf("(%d) --> %s\n",i+1, digitalMedias[i].getTitle(),digitalMedias[i].getClass().getSimpleName()); 
			lastPos = i;
			}else {
				lastPos = i;
				break;
			}
			}
		}
		return lastPos; //Das nehmen wir damit wir erknnen können ab wann die Nummerrung bei News startet
	}
	
	public static void printNews(Newsletter[] news, int startCpuntPos) {
		
		for (int idx = 0; idx < news.length; idx++) { //Startet die Nummerirung bei startCountPos kann 0 sein aber zb auch den Endwert von der Nummerirung bei  printDigitalMedia
			System.out.println("----------News---------");
			if(news[idx] != null) {
				System.out.printf("(%d)--> %s\n", idx+ startCpuntPos +2, news[idx].getTitle()); // +2 Weil es so quasi 2 mal bei Null startet ich aber bei 1 möchte
				}else {
					break;
				}

			}
	}
	public static int scanInt(int min, int max, Scanner scan) { //Meine Scanner MEthode hilft damit ich nur einmal fehler überprufung machen muss 
		System.out.println("");
	    int choice = -1; 

	    while (choice < min || choice > max) {
	        System.out.print("Deine Eingabe: ");

	        try {
	            choice = scan.nextInt();

	            if (choice < min || choice > max) {
	                System.out.println("Bitte eine Zahl zwischen " + min + " und " + max + " eingeben.");
	            }
	        } catch (Exception e) {
	            System.out.println("Ungültige Eingabe!");
	            scan.nextLine(); 
	        }
	    }

	    scan.nextLine(); // Zeilenumbruch entfernen
	    System.out.println("");
	    return choice;
	}
	public static int chooseActityDigital(Scanner scan, DigitalMedia[] media, int[] playMinutes, int playMinutesCount) {
	int choice = scanInt(1, 5, scan); //Das ist die Auswahl von allen Möglichen Funktionen mit Digital Media

	//MUss dringend noch abgetrennt werden 
	switch (choice) {
	//Bei Cases ist das IF sehr oft redudant ist aber wichtig damit der chek erfolgt ob es eh nicht null ist
	case 1: 
		printDigitalMedia(media, "");
		System.out.println("Welche Digitale Medie möchtest du bewerten: ");
		int i = scanInt(0, media.length, scan);
		
		if(media[i] != null) {
			rate(media[i], scan);
		}else {
			System.out.println("Ungültige Eingabe");
		}
		break;
	
	case 2:
		printDigitalMedia(media, "");
		System.out.println("Von welcher Medie möchtest du die Bewertungen wissen!");
		int a = scanInt(0, media.length, scan);
		if(media[a] != null) {
			System.out.println("Durchscnittliche Bewertung: "+media[a].getAvgRating());
			media[a].getAvgRating();
		}else {
			System.out.println("Ungültige Eingabe");
		}
		break;
	case 3:
		printDigitalMedia(media, "");
		System.out.println("Von welcher Medie möchtest du die Anzahl der Bewrtungen wissen!");
		int b = scanInt(0, media.length, scan);
		if(media[b] != null) {
			System.out.println("Durchscnittliche Bewertung: "+media[b].getNumberOfRatings());
		}else {
			System.out.println("Ungültige Eingabe");
		}
		break;
		
	case 4:
	    printDigitalMedia(media, "");
	    System.out.println("Was möchtest du abspielen?");
	    int c = scanInt(1, media.length, scan);
	    if (media[c - 1] != null) {
	        playMinutesCount = playMedia(media[c - 1], playMinutes, playMinutesCount); //-1 weil Array
	    } else {
	        System.out.println("Ungültige Eingabe");
	    }
	    break;

	case 5:
	    printDigitalMedia(media, "Film"); //Nur Digitale Medien ausgeben die nach dem Bauplan Film sind
	    System.out.println("Welchen Film möchtest du durchsuchen?");
	    int d = scanInt(1, media.length, scan);
	    if (media[d - 1] instanceof Film) {   //Nur wenn es im Fim ist
	        System.out.print("Keyword: ");
	        String keyword = scan.nextLine();
	        ((Film) media[d - 1]).searchFor(keyword); //Casten
	    } else {
	        System.out.println("Suche nur bei Filmen möglich!");
	    }
	    break;
		}
		
	return playMinutesCount;
		
	}
	public static int doActivity(int choice, DigitalMedia[] digMedia, Newsletter[] news, Scanner scan, int[] playMinutes, int playMinutesCount) {
	    switch (choice) {
	        case 1:
	            digitalMediaMenu();
	            playMinutesCount = chooseActityDigital(scan, digMedia, playMinutes, playMinutesCount);
	            break;
	        case 2:
	            chooseActivityNewsletter(scan, news);
	            break;
	        
	        case 3: 
	        	printAllMedien(digMedia, news);
	        	break;
	        case 4:
	            getSumPlayMinutes(playMinutes, playMinutesCount);
	            break;
	        case 5:
	            getMaxMinutes(playMinutes, playMinutesCount);
	            break;
	    }
	    return playMinutesCount;
	}

	public static int playMedia(DigitalMedia media, int[] playMinutes, int playMinutesCount) {
	    if (playMinutesCount >= playMinutes.length) { //Wenn alles voll ist
	        System.out.println("Maximale enträge sind erreicht!");
	        return playMinutesCount;
	    }
	    playMinutes[playMinutesCount] = media.getPlayMinutes();
	    playMinutesCount++;
	    System.out.printf("'%s' wird abgespielt! (%d Minuten hinzugefügt)\n",media.getTitle(), media.getPlayMinutes());
	    return playMinutesCount;
	}
	
	public static void getSumPlayMinutes(int[] playMinutes, int count) {
	    int sum = 0;
	    for (int i = 0; i < count; i++) {
	        sum += playMinutes[i];
	    }
	    System.out.println("Gesamt-Spielminuten: " + sum + " Minuten");
	}
	
	public static void getMaxMinutes(int[] playMinutes, int count) {
	    if (count == 0) {
	        System.out.println("Noch keine Medien abgespielt.");
	        return;
	    }
	    int max = playMinutes[0]; 
	    for (int i = 1; i < count; i++) { 
	        if (playMinutes[i] > max) {
	        	max = playMinutes[i];  //So überschreib so quasi immer die Höhere zahl
	        
	        }
	    }
	    System.out.println("Maximale Minuten: " + max);
	}
	public static void chooseActivityNewsletter(Scanner scan, Newsletter[] news) {
	    printNews(news, 0);
	    System.out.println("Welchen Newsletter?");
	    int idx = scanInt(1, news.length, scan);
	    Newsletter selected = news[idx - 1];

	    System.out.println("(1) --> Lesen");
	    System.out.println("(2) --> Suchen nach Keyword");
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
}
