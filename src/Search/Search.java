package Search;

import java.util.ArrayList;

public class  Search<T> {
    private ArrayList<T> searchArrayList;
    private ArrayList<T> result;

    private void implementationSearch(String text) {
        for(T item: this.searchArrayList) {
            String resource = item.toString();

            if(resource.contains(text)) this.result.add(item);
        }
    }

    public Search(ArrayList<T> searchArrayList){
        this.result = new ArrayList<T>();
        this.searchArrayList = searchArrayList;
    }

    public ArrayList<T> getResult(String text) {
        this.implementationSearch(text);
        return result;
    }
}






