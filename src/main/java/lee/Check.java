package lee;

import lee.domain.Record;
import lee.domain.User;
import org.omg.CosNaming.BindingIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubor
 * @date 2021/9/15 11:38 上午
 */
public class Check {

	public static void test(){
		List<Record> thisDayRecords = new ArrayList<>();
		int thisDayJoinNum = thisDayRecords.size();
		init();


	}

	public static void init(){
		User.insert();
	}

}
