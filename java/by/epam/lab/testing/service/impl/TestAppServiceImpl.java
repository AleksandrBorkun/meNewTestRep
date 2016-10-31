package by.epam.lab.testing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.lab.testing.dao.exception.DAOException;
import by.epam.lab.testing.dao.factory.DAOFactory;
import by.epam.lab.testing.service.TestAppService;
import by.epam.lab.testing.service.exception.ServiceException;

public class TestAppServiceImpl implements TestAppService {


	@Override
	public List<String> showTestList(String subjectId) throws ServiceException {
				
		List<String> testList = new ArrayList<>();
		
		if (subjectId == null) {
			throw new ServiceException("Please write a correct name of subject");
		}
		else if(subjectId.equals("") ||subjectId.equals(" ")){
			throw new ServiceException("Please write a correct name of subject");
			
		}
		testList.clear();
		try {
			testList = DAOFactory.getInstance().getTestApp().getTestListBySubject(subjectId);
	
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}

		if (testList != null) {
			return testList;
		} else {
			return null;
		}
	}

	@Override
	public List<String> showSubject() throws ServiceException {
		
		List<String> subjList = new ArrayList<>();
		
		subjList.clear();
		try {
			subjList = DAOFactory.getInstance().getTestApp().getSubjectList();

		
			if (subjList != null) {
				return subjList;
			} else {
				return null;
			}
		} catch (DAOException e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Object[][] goTesting(String subjectId) throws ServiceException {

		List<Integer> answer = new ArrayList<>();
		List<String> list = new ArrayList<>();
		Object obj [][] = new Object[1][2];
		
		int choise;

		answer.clear();
		list.clear();
		try {

			answer = DAOFactory.getInstance().getTestApp().chekTestResult(subjectId);
			list = DAOFactory.getInstance().getTestApp().getTestListBySubject(subjectId);

			
			
			obj[0][0] = answer;
			obj[0][1] = list;
			
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}


		return obj;
	}

}
