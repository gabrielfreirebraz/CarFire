package carfire.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import carfire.web.model.Login;

@ManagedBean(name = "loginController")
@RequestScoped

public class LoginController {

	public Login login;

	public LoginController() {
		this.login = new Login();
	}

	/**
	 * 
	 * @return
	 */
	public String checkLogin() {
		if (this.validar()) {
			if (login.consultar()) {
				return "public/passo1.jsf";
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	private boolean validar() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (login.getEmail().isEmpty() || login.getSenha().isEmpty()) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Digite o email no formato nome@exemplo.com.", ""));

			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Digite a senha da sua conta do CarFire.", ""));

			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * 
	 * @param login
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	
	
//	public void logout() {
//
//		user = null;
//
//	}
//
//	public boolean isLoggedIn() {
//
//		return user != null;
//
//	}
//
//	@Produces
//	@LoggedIn
//	User getCurrentUser() {
//
//		return user;
//
//	}

}
