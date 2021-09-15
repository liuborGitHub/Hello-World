import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author admin
 * @date 2021/8/20
 */
@Data
public class TeacherArchivesDTO {
	/**
	 * 老师id
	 */
	private Long teacherId;
	/**
	 * 转化率
	 */
	private BigDecimal transformRate;

	/**
	 * 老师姓名
	 */
	private String teacherName;

	/**
	 * 教师昵称
	 */
	private String nickName;

	/**
	 * 性别 1 男 2 女
	 */
	private Integer sex;

	/**
	 * 头像
	 */
	private String headPic;

	/**
	 * 个人宣传视频
	 */
	private String vlog;

	/**
	 * 学历
	 */
	private String edu;

	/**
	 * 业务职场
	 */
	private String region;

	/**
	 * 所在省
	 */
	private String province;

	/**
	 * 所在市
	 */
	private String city;

	/**
	 * 生日
	 */
	private LocalDateTime birthday;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 教学教龄
	 */
	private String experience;

	/**
	 * 毕业学校
	 */
	private String school;

	/**
	 * 是否显示毕业学校：1:是，0：否
	 */
	private Boolean showSchool;

	/**
	 * 所学专业
	 */
	private String major;

	/**
	 * 学历URL
	 */
	private String eduFile;

	/**
	 * 身份证照片
	 */
	private String idcardFile;

	/**
	 * 老师人脸采集的照片
	 */
	private String livingPic;

	/**
	 * 身份证号
	 */
	private String idcard;

	/**
	 * 教师性格
	 */
	private String character;

	/**
	 * 教师爱好
	 */
	private String interest;

	/**
	 * 教学经历
	 */
	private String education;

	/**
	 * 可授课年龄
	 */
	private String teachingAge;

	/**
	 * 获奖情况
	 */
	private String winning;

	/**
	 * 教学成果
	 */
	private String succeed;

	/**
	 * 教学理念
	 */
	private String philosophy;

	/**
	 * 个人作品
	 */
	private String personalWorks;

	/**
	 * 已出版作品
	 */
	private String publication;

	/**
	 * 教学风格
	 */
	private String style;

	/**
	 * 教学科目(废弃，改为teaching_subjects字段)
	 */
	private String specialty;

	/**
	 * 授课语种
	 */
	private String teachLanguage;

	/**
	 * 教学口音
	 */
	private String teachAccent;

	/**
	 * 资格证书
	 */
	private String certificate;

	/**
	 * 是否可教授海外学员1:是，2:否
	 */
	private Boolean isTeachSea;

	/**
	 * 教学督导
	 */
	private Integer teachSupervise;

	/**
	 * 实习教练
	 */
	private Integer practiceCoach;

	/**
	 * 老师评价
	 */
	private String teacherEvaluate;

	/**
	 * 院校类别
	 */
	private String colleges;

	/**
	 * 老师标签
	 */
	private String tag;

	/**
	 * 在校状态(1:已毕业；2:未毕业)
	 */
	private Boolean inSchoolStatus;

	/**
	 * 可约课程 授课类型 1:1v1试听课 2:1v1正式课  3:1v1考级课  4:班课考级课  5:班课试听课  6:班课正式课 7:班课赛事课 8:班课专题课
	 */
	private String lessonType;

	/**
	 * 上课设备
	 */
	private String equipment;

	/**
	 * teacher_applicat表主键id
	 */
	private Integer teacherApplyId;

	/**
	 * 分配教管时间
	 */
	private LocalDateTime dispatchDate;

	/**
	 * 毕业时间
	 */
	private LocalDateTime graduationDate;

	/**
	 * 入职时间
	 */
	private LocalDateTime joinTime;

	/**
	 * 是否返聘：1：是；0：否
	 */
	private Boolean backJoin;

	private String dtype;

	/**
	 * 上次计算类型
	 */
	private Integer calculateType;

	/**
	 * 教师质量分数
	 */
	private BigDecimal score;

	/**
	 * 老师标签: 1 - 考级老师 2 - 全职试听 3 - 海外授课 4 - 新师优选 5 - 竞赛老师 6 - 专题老师 7 - 新生优享 8-新锐老师 9-优选老师
	 */
	private String teacherTag;

	/**
	 * 员工类型 0：全职，1：兼职，2：专职
	 */
	private Integer teacherType;

	/**
	 * 专职老师等级
	 */
	private Integer pLevel;

	/**
	 * 专职老师转兼职老师  1 是
	 */
	private Integer noSpecific;

	/**
	 * 收藏数
	 */
	private Integer collections;

	/**
	 * 家长评分
	 */
	private BigDecimal avgScore;

	/**
	 * 30天课量
	 */
	private Integer numOfCourses;

	/**
	 * 用户喜欢数
	 */
	private Integer userLikeNum;

	/**
	 * 授课难度，多个逗号分隔（S5,S6,S7,S8,S9,S10,S11,S12）
	 */
	private String teachDifficult;

	/**
	 * 新授课科目,越靠前,比重越高
	 */
	private String teachingSubjects;

	/**
	 * 新授课语种及熟练度
	 */
	private String teachLanguages;

	private String password;

	/**
	 * 校区id
	 */
	private Long teamId;
	/**
	 * 校区名称
	 */
	private String teamName;

	private Integer splitTag;

	public BigDecimal getScoreZero(){
		if (this.score == null){
			return BigDecimal.ZERO;
		}
		return this.score;
	}
}
