import lombok.Builder;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author admin
 * @date 2021/8/19
 */
@Builder
public class Test {

	private int a;
	private String c;
	private Boolean d;
	private Float f;


	public static void main(String[] args) {
		/*List<String> list = asList("Hello", "World","1");
		List<String> list1 = asList("Hello1", "World1");

		// List<String> collect = list.stream().map(e -> e.split("")).flatMap(e-> Stream.of(e)).distinct().collect(Collectors.toList());

		List<String> collect = list.stream().flatMap(e ->
				Stream.of(e.split(""))
		).distinct().collect(Collectors.toList());
		System.out.println(collect.toString());


		System.out.println(list.contains(String.valueOf(1)));

		Test s = Test.builder().c("s").a(1).d(false).f(0.1f).build();
		System.out.println(s);*/

		List<TeacherArchivesDTO> list = new ArrayList<>();
		TeacherArchivesDTO dto = new TeacherArchivesDTO();
		dto.setScore(new BigDecimal("5"));
		dto.setTeamName("高兴老师");
		dto.setTeacherId(4128063L);
		list.add(dto);

		TeacherArchivesDTO dto1 = new TeacherArchivesDTO();
		dto1.setScore(new BigDecimal("5"));
		dto1.setTeamName("沈导师-2020");
		dto1.setTeacherId(111111395L);
		list.add(dto1);


		TeacherArchivesDTO dto2 = new TeacherArchivesDTO();
		dto2.setScore(new BigDecimal("1.89"));
		dto2.setTeamName("杨班课6");
		dto2.setTeacherId(4133149L);
		list.add(dto2);
		Optional<TeacherArchivesDTO> first = list.stream().sorted(Comparator.comparing(TeacherArchivesDTO::getScore).reversed()
				.thenComparing(TeacherArchivesDTO::getTeacherId)).findFirst();
		System.out.println(first.get());

	}


//	public static String FormatDate(Long dateStr, String format) {
//		DateTime dateTime = new DateTime(dateStr * 1000L);
//		return dateTime.toString(format);
//	}
}
