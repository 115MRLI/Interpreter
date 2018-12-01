package printer.test.interpreter;

public class Language {
    private int pic;
    private String language;

    public Language(int pic, String language) {
        this.pic = pic;
        this.language = language;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Language{" +
                "pic=" + pic +
                ", language='" + language + '\'' +
                '}';
    }
}
