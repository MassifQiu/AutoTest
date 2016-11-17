package TestNG_demo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by qiuwei on 2016/11/14.
 */
public class ReadExcel  {

    public final String filePath = "TestData/";
    private int rowNum = 0;
    private int colNum = 0;
    private int curRowNo = 0;
    private Sheet sheet;
    String[] columnName;
    private String fileName;
    private String sheetName;

    /*
        1、I/O流读取excel文件。
        2、创建工作簿workbook
        3、获取workbook中的sheet个数
        4、获取sheet中的row，
        5、获取row中的cell
        6、辨别cell中数据类型 
        7、解析出cell中数据
        8、接收cell的数据
        9、关闭I/O流
     */

    public ReadExcel(String fileName, String sheetName) {
        super();
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    /**
     * TODO 读取Excel中的数据
     *
     * @param fileName
     * @author qiuwei
     * @dateTime 2016/11/14 12:56
     */
    public void getExcelData(String fileName, String sheetName) throws IOException {
        //实例化文件
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //获取sheet数目
        int numSheet = workbook.getNumberOfSheets();

        sheet = workbook.getSheet(sheetName);
        rowNum = sheet.getPhysicalNumberOfRows();

        Row tittles = sheet.getRow(0);
        int colNum = tittles.getPhysicalNumberOfCells();
        Iterator<Cell> heads = tittles.cellIterator();

        String[] columnName = new String[colNum];
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnName[count] = cell.getRichStringCellValue().toString();
            System.out.println(columnName[count].toString());
            count++;
        }
        this.curRowNo++;
        //对sheet进行循环
        //for (int i = 0; i < numSheet; i++) {
        //    //实例化一个sheet对象
        //    Sheet sheet = workbook.getSheetAt(i);
        //    //获取sheet中的行数
        //    int numRow = sheet.getPhysicalNumberOfRows();
        //    System.out.println(numRow);

        //    for (Row row : sheet) {
        //        //获取每一行的单元格数目
        //        int numCell = row.getPhysicalNumberOfCells();
        //        System.out.println(numCell);
        //
        //        for (Cell cell : row) {
        //            //根据不同的cell类型，获取cell中的数据
        //            switch (cell.getCellType()) {
        //                //字符串类型
        //                case HSSFCell.CELL_TYPE_STRING:
        //                    System.out.println(cell.getRichStringCellValue().toString());
        //                    break;
        //                //数字类型
        //                case HSSFCell.CELL_TYPE_NUMERIC:
        //                    System.out.println(cell.getNumericCellValue());
        //                    break;
        //                //格式化类型
        //                case HSSFCell.CELL_TYPE_FORMULA:
        //                    System.out.println("CELL_TYPE_FORMULA");
        //                    break;
        //                //布尔类型
        //                case HSSFCell.CELL_TYPE_BOOLEAN:
        //                    System.out.println("CELL_TYPE_BOOLEAN");
        //                    break;
        //                //error 类型
        //                case HSSFCell.CELL_TYPE_ERROR:
        //                    System.out.println("CELL_TYPE_ERROR");
        //                    break;
        //
        //                default:
        //                    break;
        //            }
        //        }
        //    }
        //}


        fileIntputStream.close();
    }

    /**
     * TODO 根据用例ID跟列名获取相对应的单元格数据
     *
     * @param fileName   EXCEL文件名
     * @param sheetName  sheet名称
     * @param tittleName 列名
     * @param caseID     用例ID
     * @return
     * @author qiuwei
     * @dateTime 2016/11/14 12:57
     */
    public void getExcelData(String fileName, String sheetName, String tittleName, int caseID) throws IOException {
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //根据sheetName获取sheet
        Sheet sheet = workbook.getSheet(sheetName);
        //获取sheet中的第一行
        Row tittles = sheet.getRow(0);
        //获取第一行的列数
        int colNum = tittles.getPhysicalNumberOfCells();
        //根据迭代器获取美行数据
        Iterator<Cell> heads = tittles.cellIterator();
        //定义一个String类型的数组
        columnName = new String[(tittles.getPhysicalNumberOfCells())];
        //String[] columnName1 = new String[10];
        int count = 0;
        //遍历每一列
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnName[count] = cell.getStringCellValue().toString();
            System.out.println(columnName[count]);
            System.out.println();
            count++;
        }

        //获取与指定tittle的单元格数据
        int col = 0;
        for (int i = 0; i < colNum; i++) {
            String tittle = tittles.getCell(i).toString();
            if (tittle.equals(tittleName)) {
                col = i;
                break;
            }
        }

        System.out.println(sheet.getRow(caseID).getCell(col).toString());
        //关闭文件流
        fileIntputStream.close();
    }

    public Object[][] getExcelData() throws IOException {
        //POI去读取excle的数据
        //分为workbook，sheet，row，cell(根据你的row以及你需要拿数据的列)
        //创建文件I／O流
        FileInputStream fileIntputStream = new FileInputStream(filePath + fileName + ".xls");
        //创建工作薄
        //XSSF: 对应的是07以上的版本，或者说是后缀名为：.xlsx的文件
        //HSSF: 对应的是07一下的版本，或者说是后缀名为：.xls的文件
        Workbook workbook = new HSSFWorkbook(fileIntputStream);
        //获取具S体操作的sheet
        Sheet sheet = workbook.getSheet(sheetName);
        //获取标题行
        Row tittlesRow = sheet.getRow(0);

        //获取sheet的行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        //获取sheet的列数
        int colNum = tittlesRow.getPhysicalNumberOfCells();

        //定义HashMap的二维数组，多行1列的二维HashMap
        HashMap<String, String>[][] testdata = new HashMap[rowNum - 1][1];

        if (rowNum > 1) {
            for (int i = 0; i < rowNum - 1; i++) {
                //每一行的HashMap进行初始化，<String,String>
                testdata[i][0] = new HashMap<String, String>();
            }
        } else {
            System.out.println("excel中没有数据");
            return null;
        }


        Iterator<Cell> heads = tittlesRow.cellIterator();
        //列名数组，以及数组的长度
        String[] columnName = new String[(tittlesRow.getPhysicalNumberOfCells())];

        //通过迭代器的遍历，将列名的值存放入列名数组columnName
        int count = 0;
        while (heads.hasNext()) {
            Cell cell = heads.next();
            columnName[count] = cell.getStringCellValue().toString();
            count++;
        }

        //循环行数
        for (int i = 1; i < rowNum; i++) {
            //循环列数，依次将 <列名:value(第i行)>放入HashMap的二维数组
            for (int j = 0; j < colNum; j++) {
                String cellValue = sheet.getRow(i).getCell(j).toString();
                testdata[i - 1][0].put(columnName[j], cellValue);
            }
        }

        return testdata;
    }

    //public boolean hasNext() {
    //    if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
    //        return false;
    //    } else
    //        return true;
    //}
    //
    //public Object[] next() {
    //    Map<String, Object> s = new HashMap<String, Object>();
    //    Object temp;
    //    Row row = sheet.getRow(curRowNo);
    //    for (int i = 0; i < colNum; i++) {
    //        temp = "";
    //        if (row.getCell(i) != null) {
    //            switch (row.getCell(i).getCellType()) {
    //                case Cell.CELL_TYPE_BLANK:
    //                    temp = "";
    //                    break;
    //                case Cell.CELL_TYPE_NUMERIC:
    //                    temp = row.getCell(i).getNumericCellValue();
    //                    break;
    //                case Cell.CELL_TYPE_STRING:
    //                    temp = row.getCell(i).getRichStringCellValue().toString();
    //                    break;
    //                default:
    //                    break;
    //            }
    //        }
    //        s.put(this.columnName[i], temp);
    //    }
    //    Object r[] = new Object[1];
    //    r[0] = s;
    //    this.curRowNo++;
    //    return r;
    //}
    //
    //public void remove() {
    //    throw new UnsupportedOperationException("remove unsupported.");
    //}


    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel("testcase", "login");
        //test.getExcelData("testcase");

        //HashMap<String ,String > testdata = test.getExcelData("testcase","Login",1);
        //System.out.println(testdata.get("login_user"));
        //System.out.println(testdata.get("login_password"));
    }

}
