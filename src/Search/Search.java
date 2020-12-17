package Search;

import java.util.ArrayList;

public class  Search<T> {
    private final ArrayList<T> result;
    private final ArrayList<Answer> cauTraLoi;


//    private void implementationSearch(String text) {
//        this.result.clear();
//        for(T item: this.searchArrayList) {
//            String resource = item.toString().toLowerCase();
//            if(resource.indexOf(text.toLowerCase()) != -1){
//                this.result.add(item);
//                this.chiSoHienThi.add(resource.indexOf(text.toLowerCase()));
//                this.cauTraLoi.add(item.toString().substring(0,item.toString().indexOf(" ",50)-1)+"...");
//            }
//        }
//    }

    public Search(ArrayList<T> searchArrayList , String text){
        this.result = new ArrayList<>();
        this.cauTraLoi = new ArrayList<>();
        int i = 0;
        for(T item: searchArrayList) {
            String resource = item.toString().toLowerCase();
            if(resource.contains(text.toLowerCase())){
                this.result.add(item);
                Answer a = new Answer((item.toString().substring(0,item.toString().indexOf(" ",50)-1)+"..."), i , resource.indexOf(text.toLowerCase()));
                this.cauTraLoi.add(a);
                i++;
            }
        }
        java.util.Collections.sort(this.cauTraLoi ,  new Answer() );
    }

    public ArrayList<T> getResult() {
//        this.implementationSearch(text);
        return result;
    }

//    public ArrayList<Integer> getChiSoHienThi() {
//        return chiSoHienThi;
//    }

//    public ArrayList<Answer> getCauTraLoi() {
//        return cauTraLoi;
//    }

}






