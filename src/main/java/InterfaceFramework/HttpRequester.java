package InterfaceFramework;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by qiuwei on 2017/1/11.
 */
public class HttpRequester {


    public String doGet(String url) throws IOException {
        //创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get请求方法
        HttpGet httpGet = new HttpGet(url);
        //执行请求，获取response
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        String access_token = null;
        if (statusCode == 200) {
            HttpEntity httpEntity = response.getEntity();
            //org.json
            JSONObject jsonObject = new JSONObject(EntityUtils.toString(httpEntity));

            //区分http请求异常与业务错误
            if (jsonObject.has("access_token")) {
                access_token = jsonObject.get("access_token").toString();
                System.out.println("access_token为:" + jsonObject.get("access_token"));
            } else {
                System.out.println("获取失败：错误信息为" + jsonObject.get("errmsg"));
                return null;
            }
        } else {
            System.out.println("请求失败，状态码为:" + statusCode + response.getStatusLine().getReasonPhrase());
        }
        return access_token;
    }

    public static void main(String[] args) throws IOException {
        HttpRequester requester = new HttpRequester();
        String access_token = requester.doGet("https://api.weixin.qq.com" +
                "/cgi-bin/token" +
                "?grant_type=client_credential" +
                "&appid=wx17b22d8fa02d4c00" +
                "&secret=71003eb6deda64b9722bdeec6c0c7364");


        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        jsonObject1.put("type","click");
        jsonObject1.put("name","今日歌曲");
        jsonObject1.put("key","V1001_TODAY_MUSIC");

        jsonObject2.put("type","view");
        jsonObject2.put("name","搜索");
        jsonObject2.put("url","http://www.soso.com/");

        jsonArray.put(jsonObject1);
        jsonArray.put(jsonObject2);

        jsonObject.put("button",jsonArray);
        //firstMap.put("button",jsonArray);
        System.out.printf(jsonObject.toString());


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token);

        //json数据放入post请求
        //1、将json数据放入StringEntity
        //2、post.setEntity()
        StringEntity entity = new StringEntity(jsonObject.toString(),"UTF-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse response = httpClient.execute(post);


        if (response.getStatusLine().getStatusCode() == 200){
            System.out.println("创建自定义菜单成功");
            JSONObject jsonObject3 = new JSONObject(EntityUtils.toString(response.getEntity()));
            System.out.println(jsonObject3.get("errcode"));
            System.out.println(jsonObject3.get("errmsg"));
        }
    }
}
