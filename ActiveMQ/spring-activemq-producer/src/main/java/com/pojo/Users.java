package com.pojo;

import java.io.Serializable;

public class Users implements Serializable {

	private long userid;
	private String username;
	private String useremail;
	private int userage;

	public Users(long userid, String username, String useremail, int userage) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userage = userage;
	}

	public Users() {
		super();
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getUserage() {
		return userage;
	}

	public void setUserage(int userage) {
		this.userage = userage;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", userage="
				+ userage + "]";
	}
	
}
