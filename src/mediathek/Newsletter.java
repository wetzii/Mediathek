package mediathek;

public class Newsletter implements SearchInterface {

    private String title;
    private String news;
    private int number;

    public Newsletter(String title, String news, int number) {
        this.title = title;
        this.news = news;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void read() {
        System.out.println("Newsletter #" + number);
        System.out.println(news);
	}
    @Override
    public void searchFor(String keyword) {
		if(news.contains(keyword)) {
			System.out.printf("The word '%s' is included in the Newsletter %s\n",keyword, title );
		}else {
			System.out.printf("The word '%s' is not included in the Newsletter %s\n",  keyword, getTitle());
		}

	}
}