package lee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubor
 * @date 2021/9/15 11:40 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
	private String mobile;
	private int type;
	private Integer rewardId;

}
