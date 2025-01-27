package classes;

public class Book {

    private static final int MAX_PAGES = 4000;
    private final String title;
    private int pages;
    private boolean hardcover;
    private int currentPage;


    public Book(String title, int pages, boolean hardcover) {
        this(title, pages, hardcover, 0);
    }

    public Book(String title, int pages, boolean hardcover, int currentPages) {
        this.title = title;
        this.pages = pages;
        if (pages > MAX_PAGES) {
            this.pages = MAX_PAGES;
        }
        this.hardcover = hardcover;
        this.currentPage = currentPages;
        if (currentPage > this.pages) {
            currentPage = pages;
        }
    }

    public void turnPage() {
        currentPage += 1;
        if (currentPage > pages) {
            currentPage = pages;
        }
    }

    public void turnPage(int numPages) {
        currentPage += numPages;
        if (currentPage > pages) {
            currentPage = pages;
        }
    }

    public static int getMaxPages() {
        return MAX_PAGES;
    }

    @Override
    public String toString() {
        return "Book: title - " + this.title + ", pages - " + this.pages + ", hardcover - " + this.hardcover;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book other = (Book) o;
            return this.title.equals(other.title) &&
                    this.pages == other.pages &&
                    this.hardcover == other.hardcover;
        }
        return false;
    }
}
