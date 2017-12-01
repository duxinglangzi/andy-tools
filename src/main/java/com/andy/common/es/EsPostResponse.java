package com.andy.common.es;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: es 获取数据对象类 </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * @author wuqiong  2017年6月7日
 */
public class EsPostResponse implements Serializable{

	private static final long serialVersionUID = 4301764792851589447L;
	
	private Long total;		//数据总条数
	private List<? extends EsDataModel> dataList;	//获取数据模型集合
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<? extends EsDataModel> getDataList() {
		return dataList;
	}
	public void setDataList(List<? extends EsDataModel> dataList) {
		this.dataList = dataList;
	}
	
}
