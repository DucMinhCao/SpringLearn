package com.springlearn.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static List<UserRecord> userRecordList = new ArrayList<UserRecord>();
	
	static {
		userRecordList.add(new UserRecord(1752013, "Cao Minh Duc", "1752013@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752014, "Cao Minh Tri", "1752014@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752015, "Lu Ngoc Chi Cuong", "1752015@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752016, "Dau Phuc Duc", "1752016@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752017, "Vong Khai My", "1752017@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752018, "Luu Pham Manh Ha", "1752018@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752019, "Ngo Thanh Truc", "1752019@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752020, "Mai Bao Tran", "1752020@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752021, "Ngo Chanh Duc", "1752021@student.hcmus.edu.vn"));
		userRecordList.add(new UserRecord(1752022, "Cao Van Huan", "1752022@student.hcmus.edu.vn"));
	}

	public List<com.springlearn.user.UserRecord> getAllUserRecord() {
		return userRecordList;
	}

	public void addUserRecord(com.springlearn.user.UserRecord userRecord) {
		userRecordList.add(userRecord);
	}

	public void deleteUserRecord(int id) {
		// TODO Auto-generated method stub
		for (UserRecord userRecord : userRecordList) {
			if (userRecord.getId() == id) {
				userRecordList.remove(userRecord);
				return;
			}
		}
	}

	public void updateUserRecord(com.springlearn.user.UserRecord userRecord, int id) {
		for (UserRecord tempUserRecord : userRecordList) {
			if (tempUserRecord.getId() == id) {
				userRecordList.set(userRecordList.indexOf(tempUserRecord), userRecord);
				return;
			}
		}
	}

	public UserRecord getUserRecordById(int id) {
		for (UserRecord userRecord : userRecordList) {
			if (userRecord.getId() == id) {
				return userRecord;
			}
		}
		return null;
	}
	
	
}
