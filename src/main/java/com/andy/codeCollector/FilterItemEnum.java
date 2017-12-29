package com.andy.codeCollector;


/**
 * <p>ClassName:CheckFilterItems.java </p>
 * <p>Description: 校验过滤条件类 的传值是否有误 </p>
 * <p>Company:雅座在线（北京）科技发展有限公司 </p>
 * @author wuqiong  2016年7月14日
 */
public enum FilterItemEnum {

    orpt_ubase_age{		//会员年龄
        public String[] operates(){  return new String[]{"EQ","IN"};}
        //1=18岁以下|2=18-20岁|3=21-25岁|4=26-30岁|5=31-35|6=36-40|7=41-45岁|8=46-50岁|9=51-55岁|10=56-60岁|11=60岁以上
        public String[] operateValues(){return new String[]{"1","2","3","4","5","6","7","8","9","10","11"};}
        public String[] aggregations(){return new String[]{};}
    },
    orpt_ubase_birthday_mm{	//生日月份
        public String[] operates(){  return new String[]{"EQ","IN"};}
        //1=1月|2=2月|3=3月|4=4月|5=5月|6=6月|7=7月|8=8月|9=9月|10=10月|11=11月|12=12月
        public String[] operateValues(){return new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};}
        public String[] aggregations(){return new String[]{};}
    },
    orpt_ubase_constellation{	//星座
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"摩羯座","白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","水瓶座","双鱼座"};}
    },
    orpt_ubase_consume_level{		//消费水平
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"高","中","低"};}//高=高|中=中|低=低
    },
    orpt_ubase_occupation{		//职业
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"白领","大学生"};}//白领=白领|大学生=大学生
    },
    orpt_ubase_have_baby{		//是否有小孩
        public String[] operates(){  return new String[]{"EQ"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"0","1"};}//0=无|1=有
    },
    orpt_tshop_trade_date{		//交易日期
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_tshop_date_type{		//交易日期类型
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"1","2"};}//1=工作日|2=节假日
    },
    orpt_tshop_trade_hour{		//交易时段
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        //0=0点|1=1点|2=2点|3=3点|4=4点|5=5点|6=6点|7=7点|8=8点|9=9点|10=10点|11=11点|12=12点|13=13点|14=14点|15=15点|16=16点|17=17点|18=18点|19=19点|20=20点|21=21点|22=22点|23=23点
        public String[] operateValues(){return new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};}
    },
    orpt_tshop_city_level{		//城市等级
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"1","2","3","4"};}//1=一线城市|2=二线城市|3=三线城市|4=四线城市
    },
    orpt_camp_gmt_start{		//活动开始时间
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_camp_gmt_end{		//活动结束时间
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_camp_camp_date{		//核销日期
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_camp_date_type{		//核销日期类型
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"1","2"};}//1=工作日|2=节假日
    },
    orpt_camp_camp_hour{		//核销活动时段
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};}
    },
    orpt_camp_shop_id{		//核销门店ID
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },

    orpt_camp_prov_name{		//核销省份名称
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_umct_trade_cycle{		//交易周期
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"7","30","60","90","180","999999"};}
    },
    orpt_umct_trade_date{		//最近交易日期
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_camp_city_level{		//核销城市等级
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{};}
        public String[] operateValues(){return new String[]{"1","2","3","4"};}
    },

    orpt_umct_trade_amt{		//交易金额
        public String[] operates(){  return new String[]{"GT","LTEQ","BETWEEN","GTEQ","LT"};}
        public String[] aggregations(){return new String[]{"SUM"};}
        public String[] operateValues(){return new String[]{};}
    },
    orpt_user_id_cnt{		//会员数量
        public String[] operates(){  return new String[]{"EQ","IN"};}
        public String[] aggregations(){return new String[]{"COUNT_DISTINCT"};}
        public String[] operateValues(){return new String[]{};}
    };

    public static FilterItemEnum instanceOf(String value){
        for(FilterItemEnum items:FilterItemEnum.values()){
            if(items.toString().equalsIgnoreCase(value))return items;
        }
        return null;
    }

    static final long max = Long.MAX_VALUE;//取最大值
    static final long min = Long.MIN_VALUE;//取最小值

    /**
     * 方法描述: 标签 可使用操作符 数组
     * @return String[]
     * @author wuqiong 2016年7月15日  下午3:02:07
     */
    public String[] operates(){
        throw new AbstractMethodError();
    }

    /**
     * 方法描述:标签 可取值 数组,不存在则任意取值,不做限制
     * @return String[]
     * @author wuqiong 2016年7月15日  下午3:04:21
     */
    public String[] operateValues(){
        throw new AbstractMethodError();
    }
    /**
     * 方法描述:标签 可使用的 聚合函数,不存在则任意取值,不做限制
     * @return String[]
     * @author wuqiong 2016年7月15日  下午3:06:15
     */
    public String[] aggregations(){
        throw new AbstractMethodError();
    }

}