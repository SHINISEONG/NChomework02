package model;

public class UserVO {
	///field
	private String userName;
	private String sex;
	private String birthDay;
	private String jobs;
	private String cellNum;
	private String addr;
	
	
	
	///constructor
	public UserVO(){
	}

	
	///method
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay; 
	}
	
	public void setBirthDay(String birthYear, String birthMonth, String birthDate) {
		String birthDay =birthYear +"/"+ birthMonth +"/"+ birthDate;
		this.birthDay = birthDay; 
	}



	public String getJobs() {
		return jobs;
	}



	public void setJobs(String jobs) {
		this.jobs = jobs;
	}



	public String getCellNum() {
		return cellNum;
	}



	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}
	
	public void setCellNum(String cellCountryCode, String cellMidNum, String cellLastNum) {
		String cellNum = cellCountryCode + "-" + cellMidNum + "-" + cellLastNum;
		this.cellNum = cellNum;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	

	public void setAllInfo(String userName, String sex, String birthDay, String jobs, String cellNum, String addr) {
		this.setUserName(userName);
		this.setSex(sex);
		this.setBirthDay(birthDay);
		this.setJobs(jobs);
		this.setCellNum(cellNum);
		this.setAddr(addr);
	}

	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", sex=" + sex + ", birthDay=" + birthDay + ", jobs=" + jobs
				+ ", cellNum=" + cellNum + ", addr=" + addr +  "]";
	}
	
	
	
	
}
