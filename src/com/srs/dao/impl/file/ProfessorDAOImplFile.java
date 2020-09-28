package com.srs.dao.impl.file;

import java.io.File;
import java.util.ListIterator;
import java.util.Scanner;

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
public class ProfessorDAOImplFile extends BaseDAOImpl<Professor> implements IProfessorDAO{
	
	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Professors.dat"));
			while(bin.hasNext()) {
				String name = bin.next();
				String pin = bin.next();
				String tilte = bin.next();
				String department = bin.next();
				Professor professor = new Professor(name, pin, tilte,department);
				listObject.add(professor);
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
