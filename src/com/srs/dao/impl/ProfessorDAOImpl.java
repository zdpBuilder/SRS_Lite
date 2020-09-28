package com.srs.dao.impl;

import java.util.ListIterator;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.IProfessorDAO;
import com.srs.domain.Professor;

/**
 * 
 * @ClassName:  ProfessorDAOImpl   
 * @Description:ProfessorDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:32      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ProfessorDAOImpl extends BaseDAOImpl<Professor> implements IProfessorDAO{

	 
	
	@Override
	public void initialize() {
		Professor  p1,p2,p3;
		p1 = new Professor("董永","123401","副教授","计算机科学与技术");
		p2 = new Professor("赵云","123402","教授","计算机科学与技术");
		p3 = new Professor("郭天","123403","教授","数学");
		listObject.add(p1);
		listObject.add(p2);
		listObject.add(p3);
	}

	@Override
	public Professor getByPID(String pid) {
		ListIterator<Professor> iterator  =listObject.listIterator();
		Professor professor  =null;
		while(iterator.hasNext()) {
			professor = iterator.next();
			if(pid.equals(professor.getID())) 
				break;
		}
		return professor;
	}
}
