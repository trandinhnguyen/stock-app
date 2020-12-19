package Search;

import java.util.ArrayList;

public class Search<T> {
    private final ArrayList<T> result;
    private final ArrayList<T> searchArrayList;


    private void implementationSearch(String text) {
        this.result.clear();
        for (T item : this.searchArrayList) {
            String resource = item.toString().toLowerCase();
            if (resource.contains(text.toLowerCase())) {
                this.result.add(item);
            }
        }
    }

    public Search(ArrayList<T> searchArrayList) {
        this.searchArrayList = searchArrayList;
        this.result = new ArrayList<>();
    }

    public ArrayList<T> getResult(String text) {
        this.implementationSearch(text);
        return this.result;
    }

}






