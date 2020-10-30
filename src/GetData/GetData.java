package GetData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
// test JSoup
public class GetData {
    public GetData() throws IOException {

        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        System.out.println(doc.title());

    }
}
