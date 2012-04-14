package ttu.rakarh1.backend.model.service;

import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.web.forms.LoginForm;

public interface LoginService
{

	int getActionResult();

	int getUserById(int loggedUserId);

	Object getErrors();

	User authUser(LoginForm loginForm);

	
}
