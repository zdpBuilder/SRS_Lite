package com.srs.dao.impl.db;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.IProfessorDAO;
import com.srs.domain.Professor;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/**
 * 
 * @ClassName:  ProfessorDAOImpl   
 * @Description:ProfessorDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:32      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ProfessorDAOImplDB extends BaseDAOImpl<Professor> implements IProfessorDAO {

	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 
			 resultSet = JDBC.QueryBySQL("select * from faculty");
			 if(EmptyUtils.objectIsEmpty(resultSet))
				 return;
			 for (Map<String, Object> map : resultSet) {
					String name = (String) map.get("name");
					String pin = (String) map.get("pid");
					String tilte = (String) map.get("title");
					String department = (String) map.get("dept");
					Professor professor = new Professor(name, pin, tilte,department);
					listObject.add(professor);
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Professor getByPID(String pid) {
		ListIterator<Professor> iterator = listObject.listIterator();
		Professor professor = null;
		while (iterator.hasNext()) {
			professor = iterator.next();
			if (pid.equals(professor.getID()))
				break;
		}
		return professor;
	}

}
