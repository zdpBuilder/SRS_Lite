package com.srs.dao.impl.db;

import java.util.List;
import java.util.Map;

import com.srs.dao.IProfessorDAO;
import com.srs.dao.IScheduledCourseDAO;
import com.srs.dao.ITeachingAssignmentDAO;
import com.srs.domain.Professor;
import com.srs.domain.ScheduledCourse;
import com.srs.utils.JDBC;
import com.srs.utils.EmptyUtils;

/**
 * 
 * @ClassName:  TeachingAssignmentDAOImpl   
 * @Description: TeachingAssignmentDAO implements  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:41:58      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class TeachingAssignmentDAOImplDB implements ITeachingAssignmentDAO {

	@Override
	public void initialize(IProfessorDAO professorDAO, IScheduledCourseDAO scheduledCourseDAO) {

		List<Map<String,Object>> resultSet = null;
		try {
			resultSet = JDBC.QueryBySQL("select * from teaching_assignments");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 for (Map<String, Object> map : resultSet) {
				String pid = (String) map.get("pid");
				String calssNo = (String) map.get("calss_no");

				ScheduledCourse scheduledCourse = scheduledCourseDAO.getByID(calssNo);
				for (Professor professor : professorDAO.getAllListStoreData()) {
					if(pid.equals(professor.getID()))
						scheduledCourse.setInstructor(professor);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

}
