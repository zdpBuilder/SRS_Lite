package com.srs.dao.impl.file;

import java.io.File;
import java.util.Scanner;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.ICourseDAO;
import com.srs.dao.IScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  ScheduledCourseDAOImpl   
 * @Description: ScheduledCourseDAO implements
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:51      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ScheduledCourseDAOImplFile extends BaseDAOImpl<ScheduledCourse> implements IScheduledCourseDAO {
	
	@Override
	public void initialize(ICourseDAO courseDAO) {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Calsses.dat"));
			while(bin.hasNext()) {
				String courseNumber = bin.next();
				int classNo = bin.nextInt();
				String dayOfWeek = bin.next();
				String timeOfDay = bin.next();
				String room = bin.next();
				int seatingCapacity = bin.nextInt();
				Course course = courseDAO.getByCourseNo(courseNumber);
				ScheduledCourse scheduledCourse = new ScheduledCourse(classNo, dayOfWeek, timeOfDay, course, room, seatingCapacity);
				mapObject.put(scheduledCourse.getFullScheduleCourseNo(),scheduledCourse);
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
	public ScheduledCourse getByID(String id) {
		
		return mapObject.get(id);
	}

}
