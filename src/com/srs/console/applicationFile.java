package com.srs.console;

import com.srs.dao.ICourseDAO;
import com.srs.dao.IProfessorDAO;
import com.srs.dao.IScheduledCourseDAO;
import com.srs.dao.IStudentDAO;
import com.srs.dao.ITeachingAssignmentDAO;
import com.srs.dao.impl.file.CourseDAOImplFile;
import com.srs.dao.impl.file.ProfessorDAOImplFile;
import com.srs.dao.impl.file.ScheduledCourseDAOImplFile;
import com.srs.dao.impl.file.StudentDAOImplFile;
import com.srs.dao.impl.file.TeachingAssignmentDAOImplFile;
import com.srs.domain.EnrollmentStatus;
import com.srs.domain.Professor;
import com.srs.domain.ScheduledCourse;
import com.srs.domain.Student;

/***
 * 
 * @ClassName:  applicationFile   
 * @Description:Application Portal   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:07:17      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class applicationFile {

	/***
	 * 
	 * @Title: main   
	 * @Description: this is the main entry for this application  
	 * @param: @param args      
	 * @return: void      
	 * @throws
	 */
	public static void main(String[] args) {
	
		//Initialized professors data
		IProfessorDAO professorDAO = new ProfessorDAOImplFile();
		professorDAO.initialize();
		System.out.println("============教授=============");
		for (Professor  entry : professorDAO.getAllListStoreData())
			System.out.println(entry);
		//Initialized student data
		IStudentDAO studentDAO = new StudentDAOImplFile();
		studentDAO.initialize();
		System.out.println("============学生=============");
		for (Student  entry : studentDAO.getAllListStoreData())
			System.out.println(entry);
		//Initialized course data
		ICourseDAO courseDAO = new CourseDAOImplFile();
		courseDAO.initialize();
		//Initialized scheduleCourse data
		IScheduledCourseDAO scheduledCourseDAO = new ScheduledCourseDAOImplFile();
		scheduledCourseDAO.initialize(courseDAO);
		//Arrange teachers
		ITeachingAssignmentDAO tAssignmentDAO = new TeachingAssignmentDAOImplFile();
		tAssignmentDAO.initialize(professorDAO, scheduledCourseDAO);
		//Show Courses
		System.out.println("=============开出的课程==============");
		for(ScheduledCourse entry:scheduledCourseDAO.getAllMapStoreData())
			System.out.println(entry);
		
		System.out.println();
		
		//Student register for the courses
		EnrollmentStatus status;
		System.out.println("学生 张三 试图注册 CS201-1");
		status = scheduledCourseDAO.getByID("CS201-1").enroll(studentDAO.getByName("张三"));
		System.out.println(status.value());
		
		System.out.println("学生 王五 试图注册 CS201-1");
		status = scheduledCourseDAO.getByID("CS201-1").enroll(studentDAO.getByName("王五"));
		System.out.println(status.value());
	}
}
