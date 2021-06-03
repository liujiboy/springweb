package cn.cqu.edu.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class User {
	    @Id
	    private String userId;
	    private String name;
	    private Integer age;
	    private Date createTime = new Date();
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
	    

}
