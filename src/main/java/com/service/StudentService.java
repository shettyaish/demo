package com.service;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();
	public String storeStudentInfo(Student student) {
		if (studentDao.storeStuentRecord(student)) {
			return "Student Record store successfully";
		}else {
			return "Student didn't store";
		}
	}
}
