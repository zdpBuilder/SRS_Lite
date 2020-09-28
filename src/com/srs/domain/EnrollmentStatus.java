package com.srs.domain;

/***
 * 
 * @ClassName:  EnrollmentStatus   
 * @Description:Carry out system message processing 
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:26:16      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public enum EnrollmentStatus {

	//枚举量
	SUCCESS("注册成功"),SECTIONFULL("注册失败：已满员"),PREREQ("注册失败，前驱课程未修"),ENROLLED("注册失败，已经注册");
	
	//实例变量
	private final String value;
	
	private EnrollmentStatus(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
