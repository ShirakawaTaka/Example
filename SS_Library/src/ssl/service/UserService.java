package ssl.service;

import ssl.dao.UserDAO;
import ssl.dto.UserDTO;

public class UserService
{
	public boolean joinUser(UserDTO joinuser)
	{
		UserDAO dao = UserDAO.getinstance();
		boolean temp = dao.joinUser(joinuser);
		return temp;
	}

	public UserDTO loginUser(String email, String pass)
	{
		UserDAO dao = UserDAO.getinstance();
		int result = dao.loginCheck(email, pass);
		if(result == 1)
		{
			return dao.getOneUser(email);
		}
		else return null;
	}

	public UserDTO modifyUser(UserDTO dto, int user_no)
	{
		UserDAO dao = UserDAO.getinstance();
		int result = 0;
		result = dao.modifyUser(dto, user_no);
		if(result == 1) return dao.getOneUser(dto.getEmail());
		return null;
	}	
}
