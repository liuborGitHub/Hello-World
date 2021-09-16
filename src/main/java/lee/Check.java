package lee;

import lee.domain.Record;
import lee.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubor
 * @date 2021/9/15 11:38 上午
 */
public class Check {

	public static boolean joinCheck() {
		List<Record> thisDayRecords = new ArrayList<>();
		int thisDayJoinNum = thisDayRecords.size();
		if (!CheckUtil.isPositiveForInt(thisDayJoinNum)) {
			//
			init();
			return true;
		}
		User user = User.queryThisDayData();
		Integer surplusNum = user.getSurplusNum();
		if (CheckUtil.isPositiveForInt(thisDayJoinNum)){
			return true;
		}
		return false;
	}

	public static void init() {
		User.insert();
	}

}
