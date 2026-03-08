package mediathek;

public class Game extends DigitalMedia {
	
	private int estimatedTime;
	private String[] possibleConsoles;
	
	public Game(String title, String genre,int estimatedTime, String[] possibleConsoles) {
		super(title, genre);
		this.estimatedTime = estimatedTime;
		this.possibleConsoles = possibleConsoles;
	}
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Vorhergesehene Spielzeit in (min): "+estimatedTime);
		
		if(possibleConsoles[0] != null) {
		
			System.out.println("Mögliche Consolen: ");
		for(int i = 0; i < possibleConsoles.length;i++) {
			System.out.println(possibleConsoles[i] + " ");
			}
		}
		
	}
	@Override
	public int getPlayMinutes() {
		return estimatedTime;
	}
}
