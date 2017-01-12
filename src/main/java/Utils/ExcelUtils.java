package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiuwei on 2016/12/29.
 */
public class ExcelUtils implements Iterator<Object[]> {
    private Sheet sheet03;
    private Sheet sheet07;

    private final String filePath = "TestData/";
    private String excelVersion;
    private String[] columnnName;

    private int colNum;
    private int rowNum;
    private int curRowNo;


    public ExcelUtils(String fileName, String sheetName, int caseID) throws IOException {
        getExcelData(fileName,sheetName,caseID);
    }

    public ExcelUtils(String fileName, String sheetName) {
        String fileName1 = filePath + fileName;//TestData/testcase.xls
        try {
            // 判断Excel版本
            if (fileName1.endsWith(".xlsx")) {
                excelVersion = "07";
                readExcel07(fileName1, sheetName);
            } else {
                excelVersion = "03";
                readExcel03(fileName1, sheetName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    1、I/O流读取excel文件
    2、创建工作簿workbook
    3、获取workbook中的sheet个数
    4、获取sheet中的row
    5、获取row中的cell
    6、辨别cell中数据类型 
    7、解析出cell中数据
    8、关闭I/O流
    */

    public void getExcelData(String fileName, String sheetName, String tittleName, int caseID) throws IOException {
        //相当于双击Excel图标
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //根据sheetName获取sheet
        Sheet sheet = workbook.getSheet(sheetName);
        //获取sheet中的第一行
        Row tittles = sheet.getRow(0);
        //获取第一行的列数
        int colNum = tittles.getPhysicalNumberOfCells();
        //根据迭代器获取每行数据
        Iterator<Cell> heads = tittles.cellIterator();
        //定义一个String类型的数组
        columnnName = new String[colNum];
        //String[] columnName1 = new String[10];
        //获取与指定tittle的单元格数据
        int col = 0;
        for (int i = 0; i < colNum; i++) {
            String tittle = tittles.getCell(i).toString();
            if (tittle.equals(tittleName)) {
                col = i;
                break;
            }
        }

        //列名数组的游标
        int count = 0;
        //遍历每一列
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnnName[count] = cell.getStringCellValue();
            //System.out.println(columnName[count]);
            //System.out.println();
            count++;
        }


        System.out.println(sheet.getRow(caseID).getCell(col).toString());
        //关闭文件流
        fileIntputStream.close();
    }

    public void getExcelData(String fileName, String sheetName, int caseID) throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        //相当于双击Excel图标
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //根据sheetName获取sheet
        Sheet sheet = workbook.getSheet(sheetName);
        //获取sheet中的第一行
        Row tittles = sheet.getRow(0);
        //根据迭代器获取每行数据
        Iterator<Cell> heads = tittles.cellIterator();
        String key;
        String value;
        while (heads.hasNext()) {
            Cell keycell = heads.next();
            keycell.setCellType(Cell.CELL_TYPE_STRING);
            key = keycell.getStringCellValue();
            //sheet.getRow(caseID).getCell(keycell.getColumnIndex());

            Cell valueCell = sheet.getRow(caseID).getCell(keycell.getColumnIndex());
            valueCell.setCellType(Cell.CELL_TYPE_STRING);
            value = valueCell.getStringCellValue();

            map.put(key, value);
        }
    }

    public HashMap<Integer, HashMap<String, String>> getExcelData(String fileName, String sheetName) throws IOException {
        HashMap<Integer, HashMap<String, String>> map = new HashMap<Integer, HashMap<String, String>>();
        String key;
        String value ;

        //相当于双击Excel图标
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //根据sheetName获取sheet
        sheet03 = workbook.getSheet(sheetName);
        //获取sheet中的第一行
        Row tittles = sheet03.getRow(0);
        //获取列数
         colNum = tittles.getPhysicalNumberOfCells();
        //获取行数
        rowNum = sheet03.getPhysicalNumberOfRows();
        //根据行数循环，取value值
        for (int i = 1 ; i<rowNum ; i++){
            HashMap<String, String> stringHashMap = new HashMap<String, String>();
            //根据列循环取key值
            for (int j = 1 ; j<colNum ; j++){
                Cell keycell = tittles.getCell(j);
                keycell.setCellType(Cell.CELL_TYPE_STRING);
                key = keycell.getStringCellValue();

                Cell valueCell = sheet03.getRow(i).getCell(keycell.getColumnIndex());
                valueCell.setCellType(Cell.CELL_TYPE_STRING);
                value = valueCell.getStringCellValue();
                stringHashMap.put(key,value);
            }
            map.put(i,stringHashMap);
        }
        return map;
    }

    public void readExcel07(String fileName, String sheetName) throws Exception {
        FileInputStream fileIntputStream = new FileInputStream(fileName );
        XSSFWorkbook book07 = new XSSFWorkbook(fileIntputStream);
        sheet07 = book07.getSheet(sheetName);
        rowNum = sheet07.getPhysicalNumberOfRows();

        Row row = sheet07.getRow(0);
        colNum = row.getPhysicalNumberOfCells();
        Iterator<Cell> heads = row.cellIterator();

        columnnName = new String[row.getPhysicalNumberOfCells()];
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnnName[count] = cell.getRichStringCellValue().toString();
            count++;
        }
        this.curRowNo++;
    }

    public void readExcel03(String fileName, String sheetName) throws Exception {
        FileInputStream fileIntputStream = new FileInputStream(fileName);
        Workbook book03 = new HSSFWorkbook(fileIntputStream);
        sheet03 = book03.getSheet(sheetName);
        rowNum = sheet03.getPhysicalNumberOfRows();

        Row row = sheet03.getRow(0);
        colNum = row.getPhysicalNumberOfCells();
        Iterator<Cell> heads = row.cellIterator();

        columnnName = new String[colNum];
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnnName[count] = cell.getRichStringCellValue().toString();
            count++;
        }
        this.curRowNo++;
    }

    public boolean hasNext() {
        if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
            return false;
        } else
            return true;
    }

    public Object[] next() {
        Map<String, Object> map = new HashMap<String, Object>();
        Object temp;

        if (excelVersion.equals("07")) {
            Row row = sheet07.getRow(curRowNo);
            for (int i = 0; i < colNum; i++) {
                temp = "";
                row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                if (row.getCell(i) != null) {
                    switch (row.getCell(i).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            temp = row.getCell(i).getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            temp = row.getCell(i).getStringCellValue();
                            break;
                        default:
                            break;
                    }
                }
                map.put(this.columnnName[i], temp);
            }
        } else {
            Row row = sheet03.getRow(curRowNo);
            for (int i = 0; i < colNum; i++) {
                row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                temp = "";
                if (row.getCell(i) != null) {
                    switch (row.getCell(i).getCellType()) {
                        case Cell.CELL_TYPE_BLANK:
                            temp = "";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            temp = row.getCell(i).getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            temp = row.getCell(i).getStringCellValue();
                            break;
                        default:
                            break;
                    }
                }
                map.put(this.columnnName[i], temp);
            }
        }

        Object r[] = new Object[1];
        r[0] = map;
        this.curRowNo++;
        return r;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove unsupported.");
    }

    public static void main(String[] args) throws IOException {
        //获取Excel中的数据存放在map中
        ExcelUtils excelUtils = new ExcelUtils("testcase","login",1);
        //excelUtils.getExcelData("testcase", "login", "userName", 1);
        //HashMap<String , String > map;
        //map = excelUtils.getExcelData("testcase", "login", 1);
        //System.out.println(map);

        //使用map中的数据
        //System.out.println(map.get("login_user"));
        //System.out.println(map.get("login_password"));

        HashMap<Integer,HashMap<String,String>> mapTwo;
        mapTwo = excelUtils.getExcelData("testcase","login");
        mapTwo = excelUtils.getExcelData("testcase","login");
        System.out.println(mapTwo);
        System.out.println(mapTwo.get(3).get("login_user"));
    }
}
