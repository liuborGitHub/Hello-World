package lee;

/**
 * @author liubor
 * @date 2021/9/14 6:07 下午
 */
public class Calculate {

	/**
	 * @description: 奖品办理奖品总发放量
	 * @author: liubor
	 * @date : 2021/9/14 18:20
	 * @params: [awardId]
	 */
	public Integer getHandleAwardSendNum(Integer awardId) {
		// real_time_synchronization_success 这个表可以查办理类的成功记录
		return 1;
	}

	public Boolean isLimit(Integer awardId){
		// 从redis中获取奖品总上限
		return Boolean.TRUE;
	}

	public int userJoinNum() {
		return 1;
	}

	public Integer userFirstJoin() {
		// 三个字球
		// 随机数,看落到那个区域,然后提取出id

		return 12;
	}

	//	第二次参与
	// 1.感恩套餐赠30元话费 是否办理过
	// 2.特惠月包赠20元/30元话费 是否办理过
	public Integer userSecondJoin() {
		//	第二次参与
		// 1.感恩套餐赠30元话费 是否办理过
		// 2.特惠月包赠20元/30元话费 是否办理过
		// 3.以上均办理过,按概率取奖品
		return 1;
	}


}
