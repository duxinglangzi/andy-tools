package junitTest;

import com.andy.common.https.LocalHttpClient;
import junit.framework.TestCase;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * <p>ClassName: 测试钉钉 开发文档 接口是否可用等等  </p>
 * <p>Description: </p>
 * <p>@author wuqiong  2018/1/10 10:58 </p>
 */
public class DingtalkToken extends TestCase {

    public static final String corpid = "...";
    public static final String corpsecret = "...";
    public static final String accessToken = "744f9e4196363957ba1692d0f3f06717";

    //1、获取token
    public void test_get_token() {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://oapi.dingtalk.com/gettoken")
                .addParameter("corpid", corpid)
                .addParameter("corpsecret", corpsecret)
                .build();
        try {
            HttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = httpResponse.getEntity();
                String str = EntityUtils.toString(entity);
                System.out.println(str);
                //{"errcode":0,"access_token":"11","errmsg":"ok","expires_in":7200}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2、获取部门列表
    public void test_get_scopes(){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://oapi.dingtalk.com/department/list")
                .addParameter("access_token", accessToken)
                .addParameter("id", "1")
                .build();
        try {
            HttpResponse response = LocalHttpClient.execute(httpUriRequest);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
                /**
                 * 只是 把自己部门拿出来了，
                 *  {"createDeptGroup":true,"name":"专家系统研发部","id":57649362,"autoAddUser":true,"parentid":57591434}
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //3、获取部门员工列表 支持分页获取，
    public void test_get_scopes_userlist(){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://oapi.dingtalk.com/user/simplelist")
                .addParameter("access_token", accessToken)
                .addParameter("department_id", "57649362") //测试获取砖家系统员工
                .addParameter("offset", "0")
                .addParameter("size", "100")
                .build();
        try {
            HttpResponse response = LocalHttpClient.execute(httpUriRequest);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
                //todo 显示用户列表内容
                //{"errcode":0,"hasMore":false,"errmsg":"ok","userlist":[{"name":"23","userid":"01496540072099"},{"name":"51","userid":"01496417101885"},
                // {"name":"1634","userid":"0250680129591357"},{"name":"134","userid":"096309366621026443"},{"name":"15","userid":"01496458593051"}]}
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }


}
