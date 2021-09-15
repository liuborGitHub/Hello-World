package lee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubor
 * @date 2021/9/15 11:48 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String mobile;
	private Integer surplusNum;


	public static void insert() {
		// 初始化的num = activity 默认次数
	}

	public static User queryThisDayData() {
		return new User();
	}
}
