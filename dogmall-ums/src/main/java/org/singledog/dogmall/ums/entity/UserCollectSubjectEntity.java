package org.singledog.dogmall.ums.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 关注活动表
 * 
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Data
@TableName("ums_user_collect_subject")
public class UserCollectSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 活动id
	 */
	private Long subjectId;
	/**
	 * 活动名称
	 */
	private String subjectName;
	/**
	 * 活动默认图片
	 */
	private String subjectImage;
	/**
	 * 活动链接
	 */
	private String subjectUrl;
	/**
	 * 关注时间
	 */
	private Date createTime;

}
