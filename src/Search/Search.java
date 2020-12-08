package Search;

import java.util.ArrayList;

public class  Search<T> {
    private ArrayList<T> result;
    private ArrayList<Answer> cauTraLoi;


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

    public Search(ArrayList<T> searchArrayList,int type , String text){
        this.result = new ArrayList<T>();
        int i = 0;
        for(T item: searchArrayList) {
            String resource = item.toString().toLowerCase();
            if(resource.indexOf(text.toLowerCase()) != -1){
                this.result.add(item);
                Answer a = new Answer((item.toString().substring(0,item.toString().indexOf(" ",50)-1)+"..."), type, i , resource.indexOf(text.toLowerCase()));
                this.cauTraLoi.add(a);
                i++;
            }
        }
    }

    public ArrayList<T> getResult(String text) {
//        this.implementationSearch(text);
        return result;
    }

//    public ArrayList<Integer> getChiSoHienThi() {
//        return chiSoHienThi;
//    }

    public ArrayList<Answer> getCauTraLoi() {
        return cauTraLoi;
    }

}






