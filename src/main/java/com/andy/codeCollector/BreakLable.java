package com.andy.codeCollector;

/**
 * <p>Description: 测试for循环 break lable,continue lable 功能 </p>
 * @author wuqiong  2018年1月19日
 */
public class BreakLable {
	
	/**
	 * 方法描述: java 标签操作
	 * @author wuqiong 2018年1月19日 下午5:44:52
	 */
	public static void main(String[] args) {
		/**
		 *  众所周知, break 只能跳出当前，如果遇到 多层循环，需要在内层循环一次性跳出至最外层循环，
		 *	可以使用 标签的方式, 在最外层 需要跳出的地方设置一个 跳出点(lable) ,内层循环如条件满足即可跳出指定位置 
		 */
		String[] stringArrays = { "a", "b", "c" };
		lable: {
			for (int i = 0; i < stringArrays.length; i++) {
				for (int j = 0; j < 5; j++) {
					System.out.println("---中层---");
					for (int m = 0; m < 3; m++) {
						System.out.println("--------最里层 : " + m);
						if (m == 1) {
							break lable;
						}
					}
				}
				System.out.println("最外层 : " + i);
			}
		}
		
		
		// -------- 华丽的分割线-------------
		
		/**
		 * 同样道理，continue 也基本实用 跳出多层循环至指定地点的操作
		 */
		tag: for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				for (int j = 0; j < 5; j++) {
					if (j > i) {
						System.out.println();
						continue tag;
					}
					System.out.print(" " + (i * j));
				}
			}
		}
		
	}

}
