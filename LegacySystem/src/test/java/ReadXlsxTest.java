
import Service.EmptyClass;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadXlsxTest {

    public static void main(String[] args) {
        String test = null;
        try {
            test = new EmptyClass().getClass().getClassLoader().getResource("./excel/order.xlsx").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        testExcelRead(test);
    }

    public static void testExcelRead(String excelFilePath){
        HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);
        if(excelReadMap != null){
            ArrayList<ArrayList<String>> target = excelReadMap.get(
                    excelReadMap.keySet().iterator().next()
            );
            for(List<String> row : target){
                for(String col : row){
                    System.out.print(col+" ");
                }
                System.out.println();
            }
        }
    }
}
