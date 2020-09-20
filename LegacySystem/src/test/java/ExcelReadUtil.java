import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class ExcelReadUtil {

    public static HashMap<String, ArrayList<ArrayList<String>>> readExcel(File file, int ignoreRow) {
        if (file.getName().toLowerCase().endsWith(".xlsx")) {
            return readExcelForXlsx(file, ignoreRow);
        }

        return null;
    }
    /**
     * 读取Excel xlsx后缀名文件数据
     *
     * @param file
     */
    private static HashMap<String, ArrayList<ArrayList<String>>> readExcelForXlsx(File file, int ignoreRow) {
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<>();
        if (!file.exists()) {
            return null;
        }
        int rowSize = 0;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            XSSFWorkbook workbook = null;
            try {
                workbook = new XSSFWorkbook(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            XSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

                ArrayList<ArrayList<String>> lists = new ArrayList<>();
                for (int rowIndex = ignoreRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    XSSFRow row = sheet.getRow(rowIndex);
                    if (null == row) {
                        continue;
                    }

                    int tempRowSize = row.getLastCellNum() + 1;
                    if (tempRowSize > rowSize) {
                        rowSize = tempRowSize;
                    }

                    ArrayList<String> list = new ArrayList<>();
                    int col = 0;

                    for (int colIndex = 0; colIndex <= row.getLastCellNum(); colIndex++) {
                        cell = row.getCell(colIndex);
                        String value = "";
                        if (cell != null) {
                            CellType cellType = cell.getCellType();

                            switch (cellType) {
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        value = String.valueOf(cell.getDateCellValue());
                                    } else {
                                        value = String.valueOf(new DecimalFormat("0").format(cell.getNumericCellValue()));
                                    }
                                    break;
                                case STRING:
                                    value = String.valueOf(cell.getStringCellValue());
                                    break;
                                case FORMULA:
                                    value = String.valueOf(cell.getCellFormula());
                                    break;
                                case BLANK:
                                    value = "";
                                    break;
                                case BOOLEAN:
                                    value = String.valueOf(cell.getBooleanCellValue());
                                    break;
                                case ERROR:
                                    value = String.valueOf(cell.getErrorCellValue());
                                    break;
                                default:
                                    value = "";
                            }
                            if (value.length()>0) {
                                list.add(value);
                            } else {
                                col++;
                            }
                        }
                    }
                    if (col == row.getRowNum()) {
                        continue;
                    }
                    if (list.size() > 0) {
                        lists.add(list);
                    }
                }

                map.put("sheet" + sheetIndex, lists);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}