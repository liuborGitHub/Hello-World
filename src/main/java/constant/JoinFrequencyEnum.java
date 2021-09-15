package constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author liubor
 * @date 2021/9/15 4:48 下午
 */
@Getter
@AllArgsConstructor
public enum JoinFrequencyEnum {
	FIRST(1, "第一次"),
	SECOND(2, "第二次"),
	THIRD(3, "第三次"),
	Fourth(4, "第四次"),
	FOURTH_ABOVE(5, "4次以上");
	private int code;
	private String desc;

	public static JoinFrequencyEnum getEnum(Integer code) {
		return Arrays.stream(JoinFrequencyEnum.class.getEnumConstants()).filter(p -> p.getCode() == code).findFirst().get();
	}

}
