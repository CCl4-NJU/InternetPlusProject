package Service.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriteUtil {

    public static int writeExcel(File file, ArrayList<String> content){
        if(file .getName().toLowerCase().endsWith(".xlsx")){
            return writeExcelFroXlsx(file, content);
        }

        return 0;
    }

    public static int writeExcelFroXlsx(File file, ArrayList<String> content){
        if(!file.exists()){
            return 0;
        }
        try{
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);

            FileOutputStream out = new FileOutputStream(file);
            row = sheet.createRow((short) (sheet.getLastRowNum()+1));
            for(int i=0;i<content.size();i++){
                row.createCell(i).setCellValue(content.get(i));
            }

            out.flush();
            workbook.write(out);
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return 1;
    }
}
