package com.andy.common.https;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.andy.common.es.EsDataModel;
import com.andy.common.es.EsPostResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: ES 数据组装 </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * @author wuqiong  2017年6月7日
 */
public class EsResponseHandler {
	
	private static final Log log = LogFactory.getLog(EsResponseHandler.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static EsPostResponse createEsResponseHandler(final HttpResponse response, final Class<? extends EsDataModel> clazz){
		if(response == null) return null;
		EsPostResponse esResponse = new EsPostResponse();
		try {
			int status = response.getStatusLine().getStatusCode();
	        if (status >= 200 && status < 300) {
	            HttpEntity entity = response.getEntity();
	            String entityString = EntityUtils.toString(entity);
	            if(StringUtils.isBlank(entityString))return null;
	            JSONObject firstHits= JSON.parseObject(entityString).getJSONObject("hits");
	            esResponse.setTotal(firstHits.getLong("total"));
	            JSONArray array =firstHits.getJSONArray("hits");
	            if(array==null || array.size()<1)return esResponse;
	            List<Object> dataList=new ArrayList<Object>();
	            ParserConfig config= ParserConfig.getGlobalInstance();
	            config.setAsmEnable(false);
	            for(int i=0,size=array.size();i<size;i++){
	            	dataList.add(TypeUtils.cast(array.getJSONObject(i).getJSONObject("_source"),clazz, config));
	            }
	            esResponse.setDataList((List)dataList);
	        }else{
	        	log.info("访问ES 无法获取数据,createEsResponseHandler_err_className: "+clazz.getName());
	        	return null;
	        }
		} catch (ParseException | IOException e) {
			log.info("解析ES 读取数据出错,createEsResponseHandler_Exception_Message:"+e.getMessage(),e);
			log.error("解析ES 读取数据出错,createEsResponseHandler_Exception_Message:"+e.getMessage(),e);
			return null;
		}
		return esResponse;
	}
}
