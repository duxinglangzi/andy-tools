package com.andy.common.es;

import java.io.Serializable;

/**
 * <p>Description: ES读取数据单独对象类,所有模型对象必须继承此类,防止子类  </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * @author wuqiong  2017年6月7日
 */
public class EsDataModel implements Serializable {

	public static final long serialVersionUID = -7712804689429138276L;
	
	protected String _index; //标记 当前数据出自哪个索引

	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	
}
