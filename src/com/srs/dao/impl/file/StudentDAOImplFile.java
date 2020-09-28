package com.srs.dao.impl.file;

import java.io.File;
import java.util.ListIterator;
import java.util.Scanner;

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
public class StudentDAOImplFile extends BaseDAOImpl<Student> implements IStudentDAO {

	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Students.dat"));
			while(bin.hasNext()) {
				String id = bin.next();
				String name = bin.next();
				String major = bin.next();
				String degree = bin.next();
				Student student = new Student(id,name,major,degree);
				listObject.add(student);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bin.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
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
