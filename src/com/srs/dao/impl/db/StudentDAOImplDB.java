package com.srs.dao.impl.db;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.IStudentDAO;
import com.srs.domain.Student;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/***
 * 
 * @ClassName:  StudentDAOImpl   
 * @Description:StudentDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:41:44      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class StudentDAOImplDB extends BaseDAOImpl<Student> implements IStudentDAO {
	
	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 resultSet = JDBC.QueryBySQL("select * from student");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 for (Map<String, Object> map : resultSet) {
				String id = (String) map.get("id");
				String name = (String) map.get("name");
				String major = (String) map.get("major");
				String degree = (String) map.get("degree");
				Student student = new Student(id,name,major,degree);
				listObject.add(student);
			 }
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
