package utils;

import java.util.Objects;

/**
 * @author liubor
 * @date 2021/9/15 4:28 下午
 */
public class CheckUtil {
	public static boolean isPositiveForInt(Integer value) {
		return Objects.nonNull(value) && value > 0;
	}

	public static boolean isPositiveForIntIncludeZero(Integer value) {
		return Objects.nonNull(value) && value >= 0;
	}

	public static boolean isPositiveForLong(Long value) {
		return Objects.nonNull(value) && value > 0L;
	}

	public static boolean isPositiveForLongIncludeZero(Long value) {
		return Objects.nonNull(value) && value >= 0L;
	}
}
