package by.epam.lab.testing.service;

import java.util.List;

import by.epam.lab.testing.service.exception.ServiceException;

public interface TestAppService {

	public List<String> showTestList(String subjectID) throws ServiceException;

	public List<String> showSubject() throws ServiceException;

	public Object[][] goTesting(String subjectId) throws ServiceException;

}
