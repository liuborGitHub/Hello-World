package utils;

import lombok.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liubor
 * @date 2021/9/15 5:06 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prize {
	private int id;//奖品id
	private String prize_name;//奖品名称
	private int prize_amount;//奖品（剩余）数量
	private Double prize_weight;//奖品权重

	/**
	 * 根据Math.random()产生一个double型的随机数，判断每个奖品出现的概率
	 *
	 * @param prizes
	 * @return random：奖品列表prizes中的序列（prizes中的第random个就是抽中的奖品）
	 */
	public static int getPrizeIndex(List<Prize> prizes) {
		int random = -1;
		try {
			//计算总权重
			double sumWeight = 0;
			for (Prize p : prizes) {
				sumWeight += p.getPrize_weight();
			}

			//产生随机数
			double randomNumber;
			randomNumber = Math.random();

			//根据随机数在所有奖品分布的区域并确定所抽奖品
			double d1 = 0;
			double d2 = 0;
			for (int i = 0; i < prizes.size(); i++) {
				d2 += prizes.get(i).getPrize_weight() / sumWeight;
				if (i == 0) {
					d1 = 0;
				} else {
					d1 += prizes.get(i - 1).getPrize_weight() / sumWeight;
				}
				if (randomNumber >= d1 && randomNumber <= d2) {
					random = i;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("生成抽奖随机数出错，出错原因：" + e.getMessage());
		}
		return random;
	}

	public static void main(String[] agrs) {
		int[] result = new int[4];
		List<Prize> prizes = new ArrayList<>();

		Prize p1 = new Prize();
		p1.setPrize_name("范冰冰海报");
		p1.setPrize_weight(33.33);//奖品的权重设置成1
		prizes.add(p1);

		Prize p2 = new Prize();
		p2.setPrize_name("上海紫园1号别墅");
		p2.setPrize_weight(33.33);//奖品的权重设置成2
		prizes.add(p2);

		Prize p3 = new Prize();
		p3.setPrize_name("奥迪a9");
		p3.setPrize_weight(33.33);//奖品的权重设置成3
		prizes.add(p3);

		System.out.println("抽奖开始");
		for (int i = 0; i < 4; i++)// 打印100个测试概率的准确性
		{
			int selected = getPrizeIndex(prizes);
			System.out.println(prizes.get(selected));
			result[selected]++;
		}
		System.out.println("抽奖结束");
		System.out.println("每种奖品抽到的数量为：");
		System.out.println("一等奖：" + result[0]);
		System.out.println("二等奖：" + result[1]);
		System.out.println("三等奖：" + result[2]);
	}
}
