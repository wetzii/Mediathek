package mediathek;

public abstract class DigitalMedia {

    private String title;
    private String genre;
    private int[] ratingArray;
    private int countRating;

    public DigitalMedia(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.ratingArray = new int[5];
        this.countRating = 0;
    }

    public void rate(int rating) {

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Bewertung muss zwischen 1 und 5 sein!");
        }

        if (countRating >= ratingArray.length) {
            throw new IllegalStateException("Maximal 5 Bewertungen erlaubt!");
        }

        ratingArray[countRating] = rating;
        countRating++;
    }

    public double getAvgRating() {

        if (countRating == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < countRating; i++) {
            sum += ratingArray[i];
        }

        return (double) sum / countRating;
    }

    public int getNumberOfRatings() {
        return countRating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void getInfo() {
        System.out.println("Titel: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Durchschnittliches Rating: " + getAvgRating());
        System.out.println("Anzahl Ratings: " + countRating);
    }

    public abstract int getPlayMinutes();
}