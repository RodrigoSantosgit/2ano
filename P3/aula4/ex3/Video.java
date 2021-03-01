package aula4.ex3;

public class Video {

private static int nextID = 0;
	
	private int id, totalRating, numRates;
	private String title, category, age;
	private boolean available;
	private double rating;
	
	public Video(String title, String category, String age) {
		nextID++;
		this.id = nextID;
		this.title = title;
		this.category = category;
		this.age = age;
		this.available = true;
		this.totalRating = 0;
		this.rating = 0;
		this.numRates = 0;
	}
	
	public int getTotalRating() {
		return totalRating;
	}
	
	public void addRating(int r) {
		numRates++;
		totalRating += r;
		rating = totalRating / numRates;
	}
	
	public double getRating() {
		return rating;
	}
	
	public int getId() {
		return id;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Video [id = " + id + ", title = " + title + ", category = " + category + ", age = " + age + "]";
	}
}
