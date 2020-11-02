import Data.Data;
import UI.RenderUI;

import java.io.IOException;

class Main {
    public static void main(String args[]) throws IOException {
        new RenderUI();
        Data data = new Data();
        data.getData();
    }

}
