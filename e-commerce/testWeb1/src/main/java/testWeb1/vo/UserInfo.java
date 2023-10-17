package testWeb1.vo;

import java.util.Date;

/**
 * user information class
 */
public class UserInfo {
    private int userId; 
    private String username; 
    private String password; 
    private String password1; 
    private String favor; 
    private String gender; 
    private String description; 
    private String profession;    
    private int robotid;//

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRobotid() {
		return robotid;
	}

	public void setRobotid(int robotid) {
		this.robotid = robotid;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


}
