import java.io.*;

public class demo04_inputZJIO {

    public static void readFileByBytes(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        try {
           //InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
            ///BufferedReader bufferedReader = new BufferedReader(read);
            int tempByte;
            //一次读一个字节，每次读8位，直到最后没有数据返回-1跳出循环
            String readline;
            //while ((readline = bufferedReader.readLine()) != null) {
            //    System.out.println(readline);
            //}
            while((tempByte = in.read()) != -1)
            {
                System.out.write(tempByte);
                System.out.flush();
            }


            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.toString()+"出错了！");
            //System.out.println("出错了！"+e);
            return;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        demo04_inputZJIO.readFileByBytes("abc.txt");
    }

}