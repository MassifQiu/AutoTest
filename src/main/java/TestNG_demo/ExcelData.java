package TestNG_demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExcelData implements Iterator<Object[]> {

    private Workbook book = null;
    private Sheet sheet = null;
    private int rowNum = 0;
    private int curRowNo = 0;
    protected String filePath = "testData/";
    private String fileName = "testcase";
    private int colNum = 0;
    private String[] columnName;

    public ExcelData(){

    }

    public ExcelData(String SheetName) {
        try {
            FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
            //创建工作薄
            this.book = new HSSFWorkbook(fileIntputStream);
            this.sheet = book.getSheet(SheetName);
            this.rowNum = sheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public boolean hasNext() {
        if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
            return false;
        } else
            return true;
    }


    public Object[] next() {
        int count = 0;
        Iterator<Cell> heads = sheet.getRow(0).cellIterator();
        while(heads.hasNext()){
            Cell cell = heads.next();
            columnName[count] = cell.getStringCellValue().toString();
            count++;
        }
        Object r[] = new Object[1];
        r[0] = columnName;
        this.curRowNo++;
        return r;
    }


    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }
}

