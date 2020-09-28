package com.srs.dao.impl;

import java.util.ListIterator;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.IStudentDAO;
import com.srs.domain.Student;

/***
 * 
 * @ClassName:  StudentDAOImpl   
 * @Description:StudentDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:41:44      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class StudentDAOImpl extends BaseDAOImpl<Student> implements IStudentDAO {

	@Override
	public void initialize() {
		Student  s1,s2,s3;
		s1 = new Student("张三","202001001","数学","学士");
		s2 = new Student("李四","202001002","计算机科学与技术","学士");
		s3 = new Student("王五","202001003","计算机科学与技术","学士");
		listObject.add(s1);
		listObject.add(s2);
		listObject.add(s3);	
	}

	@Override
	public Student getByName(String name) {
		ListIterator<Student> iterator  =listObject.listIterator();
		Student student  =null;
		while(iterator.hasNext()) {
			student = iterator.next();
			if(name.equals(student.getName())) 
				break;
		}
		return student;
	}

}
