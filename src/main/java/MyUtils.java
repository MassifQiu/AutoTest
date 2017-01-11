import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import org.testng.Assert;


/**
 * Func 函数库 记录常用函数
 *
 * @author 邱卫武
 */
public class MyUtils {
    private static ReportUtils report = new ReportUtils();

    /**
     * 根据时间日期生成一个唯一的数字字符串
     *
     * @param
     */
    public static String getUniNum() {
        return DateFormatUtils.format(new Date(), "yyMMddHHmmss") + MyUtils.getRandomNum(2);
    }

    /**
     * 处理反馈信息中的数字
     *
     * @param msg
     * @return
     */
    public static String getIDNum(String msg) {
        msg = msg.replace("：", ":");
        String[] str = msg.split(":");
        return str[str.length - 1].trim();
    }

    /**
     * 处理信息中的信息，过滤汉字
     *
     * @param msg
     * @return
     */
    public static String getNumber(String msg) {
        String str = msg.replaceAll("(\\s[\u4E00-\u9FA5]+)|([\u4E00-\u9FA5]+\\s)", "");
        return str;
    }

    /**
     * String类型数字转换成Double类型数字
     *
     * @param str
     * @return
     */
    public static double strNum2Double(String str) {
        if (MyUtils.isNumber(str) == false) {
            report.warn("[" + str + "]不是数字，返回0");
            return 0;
        }
        return NumberUtils.createDouble(str);
    }

    /**
     * String类型数字转换成Integer类型数字
     *
     * @param str
     * @return
     */
    public static Integer strNum2int(String str) {
        if (str == null || str.equals("")) {
            return -1;
        }
        return NumberUtils.createInteger(str);
    }

    /**
     * 时间点
     *
     * @return 返回当前时间点 单位毫秒
     */
    public static long timeTag() {
        return System.currentTimeMillis();
    }

    /**
     * 获取外包费用
     *
     * @param quality
     * @param volume
     * @return
     */
    public static double oscFreight(double quality, double volume) {
        double qua;
        double vol = 100 * volume;

        if (0 < quality && quality <= 100) {
            qua = 0.95 * quality;
        }
        if (101 <= quality && quality <= 200) {
            qua = 0.65 * quality;
        }
        if (201 <= quality && quality <= 600) {
            qua = 0.55 * quality;
        } else {
            qua = 0.45 * quality;
        }

        if (qua > 30 || vol > 30) {
            if (qua < vol) {
                return vol;
            } else {
                return qua;
            }
        } else {
            return 30.00;
        }

    }

    /**
     * 获取当前项目的物理路径
     *
     * @return
     */
    public static String getThisProjectDir() {
        return System.getProperty("user.dir") + "\\";
    }

    /**
     * 关闭所有页面
     */
    public static void closeAllBrowsers(int type) {
        // # 1 => FireFox
        // # 2 => Chrome
        // # 3 => IE
        Runtime runTime = Runtime.getRuntime();
        try {
            runTime.exec("tskill downloadfile");
            runTime.exec("tskill savefile");
            switch (type) {
                case 1:
                    runTime.exec("tskill firefox");
                    break;
                case 2:
                    runTime.exec("tskill chrome*");
                    break;
                case 3:
                    runTime.exec("tskill iexplore");
                    runTime.exec("tskill IEDriverServer");
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成日期字符串
     *
     * @param
     *
     * @return 今天日期
     * @comment 如：nowDate("yyyyMMddHHmmss")
     */
    public static String getNowTime(final String yyyyMMddHHmmss) {
        return DateFormatUtils.format(new Date(), yyyyMMddHHmmss);
    }

    /**
     * 生成明天日期字符串
     *
     * @param datePattern
     *            日期串格式
     * @return 明天日期
     * @comment 如：tomorrowDate("yyyyMMddHHmmss")
     */
    public static String getTomorrowDate(final String datePattern) {
        Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
        cal.add(Calendar.DAY_OF_MONTH, +1);// 取当前日期的后一天.
        return DateFormatUtils.format(cal.getTime(), datePattern);
    }

    /**
     * 获取计算机位数
     *
     * @return 返回32还是64
     */
    public static String getPCBit() {
        return System.getProperty("sun.arch.data.model");
    }

    //
    // /**
    // * 根据时间日期生成一个唯一的数字字符串
    // * @param args
    // */
    // public static String millisecond() {
    // return (String)System.currentTimeMillis();
    // }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 判断字符串是否为手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断字符串中是否含有特殊字符
     *
     * @param str
     * @return
     */
    public static boolean containsSpecial(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);

        return m.find();
    }

    /**
     * 判断sub在str中出现的位置
     *
     * @param str
     * @param subStr
     * @return
     * @return
     */
    public static ArrayList<Integer> strLocation(String str, String subStr) {
        int index = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while ((index = str.indexOf(subStr, index)) != -1) {
            index += subStr.length();
            list.add(index);
        }
        return list;
    }

    /**
     * 判断字符串中是否存在汉字
     *
     * @param str
     * @return
     */
    public static boolean containsCh(String str) {
        int count = 0;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);

        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                count = count + 1;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断Email是否正确
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }

    /**
     * 判断“_”是否在用户名的第一位或最后一位
     *
     * @param str
     * @return
     */
    public static boolean isUnderline(String str) {
        boolean tf = false;
        ArrayList<Integer> list = MyUtils.strLocation(str, "_");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1 || list.get(i) == str.length()) {
                tf = true;
            } else {
                tf = false;
            }
        }
        return tf;
    }

    /**
     * 两个String类型断言
     *
     * @param actual
     * @param expected
     */
    public static void checkEquals(String actual, String expected) {
        report.log("---------------------------------------------");
        report.log("预期结果为：" + expected);
        report.log("实际结果为：" + actual);
        Assert.assertEquals(actual, expected);
        report.log("---------------------------------------------");
    }

    /**
     * 对有小数的数四舍五入取整
     *
     *
     * @createTime 2014年9月3日 下午3:22:39
     * @param dblNum
     * @return 返回四舍五入后的整数
     */
    public static double getRInt(double dblNum) {
        return (int) Math.rint(dblNum);
    }

    /**
     * 对有小数做四舍五入2位小数处理
     *
     *
     * @createTime 2014年9月3日 下午3:22:39
     * @param dblNum
     * @return 返回四舍五入后的整数
     */
    public static double getRound2Point(double dblNum) {
        BigDecimal bg = new BigDecimal(dblNum);
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 生成三个字符的汉字
     *
     * @return
     */
    public static String random() {
        Random ran = new Random();
        int delta = 0x9fa5 - 0x4e00 + 1;

        char a = (char) (0x4e00 + ran.nextInt(delta));
        char b = (char) (0x4e00 + ran.nextInt(delta));
        char c = (char) (0x4e00 + ran.nextInt(delta));

        return a + "" + b + "" + c;
    }

    /**
     * 生成3位英文字母
     *
     * @return
     */
    public static String english() {
        String str = "";
        for (int i = 0; i < 3; i++) {
            str = str + (char) (Math.random() * 26 + 'A');
        }
        return str;
    }

    /**
     * 字符串第一个字符为我想要的字符
     *
     *
     * @createTime 2014年10月10日 上午11:36:59
     *
     * @param myString
     *            需要增加的字符串
     * @param wantChar
     *            想要的第一位字符
     * @return 返回第一位一定有wantChar的myString串
     */
    public static String stringFirstCharIs(String myString, String wantChar) {
        if (myString == null || myString.equals("")) {
            return wantChar;
        }
        if (String.valueOf(myString.charAt(0)).equals(wantChar)) {
            return myString;
        } else {
            return wantChar + myString;
        }
    }

    /**
     * 字符串最后一个字符为我想要的字符
     *
     *
     * @createTime 2014年10月10日 上午11:36:59
     *
     * @param myString
     *            需要增加的字符串
     * @param wantChar
     *            想要的最后一位字符
     * @return 返回最后一位一定有wantChar的myString串
     */
    public static String stringLastedCharIs(String myString, String wantChar) {
        if (myString == null || myString.equals("")) {
            return wantChar;
        }
        if (String.valueOf(myString.charAt(myString.length() - 1)).equals(wantChar)) {
            return myString;
        } else {
            return myString + wantChar;
        }
    }

    /**
     * 翻译：如 武汉卡行 -->武汉平台
     *
     *
     * @createTime 2014年10月23日 下午4:34:27
     *
     * @param kxName
     *            需要翻译的名词，如"武汉卡行"
     * @return 翻译成 xx平台
     */
    public static String kx_to_pt(String kxName) {
        String str = kxName.replace("联盟", "");
        str = str.replace("卡行", "平台");
        return str;
    }

    /**
     * 获取Excel中某列的所有数据
     *
     * @param excelPath
     * @return
     */

    //public static List<String> excelData(String excelPath, String sheetName, String titleName) {
    //	report.log("==================================================");
    //	report.log("获取Excel中[" + titleName + "]列的数据");
    //
    //	List<String> columnList = new ArrayList<String>();
    //	try {
    //		OPCPackage pkg = OPCPackage.open(excelPath);
    //		XSSFWorkbook book = new XSSFWorkbook(pkg);
    //		Sheet sheet = book.getSheet(sheetName);
    //		int col = 0;
    //		Row titles = sheet.getRow(0);
    //		for (int i = 0; i < titles.getPhysicalNumberOfCells(); i++) {
    //			String title = titles.getCell(i).toString();
    //			if (title.equals(titleName)) {
    //				col = i;
    //				break;
    //			} else {
    //				continue;
    //			}
    //		}
    //		if (col == -1) {
    //			report.error("Excel中未找到【" + titleName + "】字段");
    //		} else {
    //			report.log("【" + titleName + "】在第【" + col + "】列");
    //		}
    //
    //		// 将获取到的值全都存入columnList中
    //		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
    //			columnList.add(i, sheet.getCellComment(i, col).toString());
    //		}
    //	} catch (Exception e) {
    //		e.printStackTrace();
    //	}
    //	return columnList;
    //}

    /**
     * 判断pile中是否包含driver之外的字符串
     *
     * @param pile 桩
     * @param driver 驱动
     * @return
     */
    public static boolean containsString(String pile, String... driver) {
        report.log("==================================================");
        report.log("判断" + pile + "中是否包含driver之外的字符串");

        for (int i = 0; i < driver.length; i++) {
            pile = pile.replaceAll(driver[i], "");
        }

        if (pile.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串转换成double，若Str为""，则返回0
     *
     * @param str
     * @return
     */
    public static double strDouble(String str) {
        if (str.equals("")) {
            return 0;
        } else {
            return Double.parseDouble(str);
        }
    }

    /**
     * double转换成String，若
     *
     * @param flo
     * @return
     */
    public static String doubleStr(double flo) {
        if (flo == 0) {
            return "";
        } else {
            return String.valueOf(flo);
        }
    }

    /**
     * 获取本地IP地址
     *
     *
     * @createTime 2014年12月23日 上午11:17:02
     *
     * @return
     */
    public static String getIPAddress() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (address == null) {
            report.error("未能成功获取IP地址！");
            return null;
        }
        String ip = address.getHostAddress().toString().replace(".", "#");
        String[] ipall = ip.split("#");
        String ret_ip = "";
        for (String ippoi : ipall)
            ret_ip = ret_ip + MyUtils.right("000" + ippoi, 3);
        return ret_ip;
    }

    /**
     * 字符串转换为double
     *
     * @param str
     *            转变的字符串
     * @return
     */
    public static double stringDouble(String str) {
        double msg = 0;
        if (str != null && str.equals("") == false && str.equals("null") == false) {
            try {
                msg = Double.parseDouble(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            report.log("字符串无法转换！");
        }
        return msg;
    }

    public static String getRandomNum(int bitNum) {
        Random r = new Random();
        String rndNum = "";
        for (int i = 1; i <= bitNum; i++)
            rndNum = rndNum + r.nextInt(10);
        return rndNum;
    }

    /**
     * 生成一个手机号
     *
     * @return
     */
    public static String telNo() {
        Random random = new Random();
        return "189" + random.nextInt(100000000);
    }

    /**
     * 字符串从右取取几个
     *
     *
     * @createTime 2015年1月27日 上午11:49:44
     *
     * @param str
     *            原字符串
     * @param num
     *            几个
     * @return
     */
    public static String right(String str, int num) {
        return str.substring(str.length() - num, str.length());
    }

    /**
     * 得到加密后的字符，显示成 *，只留开头和最后一个字符
     *
     * 如：abc112233，加密完为：a*******3
     *
     *
     * @createTime 2015年2月5日 下午4:07:03
     *
     * @param str
     *            需要加密的字符串
     * @return 加密后的结果
     */
    public static String getEncryptedCode(String str) {
        int len = str.length();
        String newStr = str.substring(0, 1);
        for (int i = 1; i < len - 1; i++)
            newStr = newStr + "*";
        newStr = newStr + str.substring(len - 1, len);
        return newStr;
    }
}

