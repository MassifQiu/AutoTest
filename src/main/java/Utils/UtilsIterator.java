package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by qiuwei on 2017/1/4.
 */
public class UtilsIterator implements Iterator<Object []> {
    private int rowNum;
    private int colNum;
    private int curRowNum;
    private String columnName[];

    Workbook book07;
    Workbook book03;
    Sheet sheet07;
    Sheet sheet03;
    private String filePath  = "TestData/";

    public UtilsIterator(String fileName , String sheetName) throws IOException {
        String fileName1 = filePath+fileName;
        //xls,xlsx
        redaExcel03(fileName1,sheetName);
    }

    public void redaExcel03(String fileName,String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        book03 = new HSSFWorkbook(fileInputStream);
        sheet03 = book03.getSheet(sheetName);
        Row row = sheet03.getRow(0);
        rowNum = sheet03.getPhysicalNumberOfRows();
        colNum = row.getPhysicalNumberOfCells();

        columnName = new String[colNum];
        int count = 0;
        Iterator<Cell> heads = row.cellIterator();
        while (heads.hasNext()){
            Cell cell = heads.next();
            cell.setCellType(Cell.CELL_TYPE_STRING);
            columnName[count] = cell.getStringCellValue();
            System.out.println(columnName[count]);
            count++;
        }
        this.curRowNum++;
    }

    public Object[][] readExcel03(String fileName,String sheetName){
        //从excel里面取数据，最后返回Object[][]

        return null;
    }


    public boolean hasNext() {
        if (rowNum == 0 || this.curRowNum >= rowNum){
            return false;
        }else {
            return true;
        }
    }

    public Object[] next() {
        HashMap<String,Object> map = new HashMap<String, Object>();
        Object temp ;
        Row row = sheet03.getRow(curRowNum);
        for (int i = 0;i<colNum;i++){
            row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
            temp = row.getCell(i).getStringCellValue();
            map.put(columnName[i],temp);
        }
        this.curRowNum++;

        Object object[] = new Object[1];
        object[0] = map;
        return object;
    }

    public void remove() {
    }

    public static void main(String[] args) throws IOException {
        UtilsIterator utils = new UtilsIterator("testcase.xls","login");
        Object[] objects;
        while (utils.hasNext()){
            objects = utils.next();
        }
    }
}
