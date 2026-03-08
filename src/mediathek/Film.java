package mediathek;

public class Film extends DigitalMedia implements SearchInterface {
	
	private int movieLen;
	private String description;
	
	public Film(String title, String genre,int movieLen, String description) {
		super(title, genre);
		this.movieLen = movieLen;
		this.description = description;
	}
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Filmlänge: "+movieLen);
		System.out.println("Beschreibung: "+description);
	}
	@Override
	public int getPlayMinutes() {
		return movieLen;
	}
	@Override
	public boolean searchFor(String keyword) {
		if(description.contains(keyword)) {
			System.out.printf("Das Wort %s kommt in dem Film %s vor\n",keyword,super.getTitle() );
			return true;
		}
	return false;
	}
}
