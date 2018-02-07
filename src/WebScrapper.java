import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScrapper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused) {
        String[] total = urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ");
        int totalnum = total.length;
        System.out.println(totalnum);

        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        hamlet.replaceAll("Prince","1");
        hamlet.replaceAll("[^1]","");
        System.out.println(hamlet.length());
    }
}
