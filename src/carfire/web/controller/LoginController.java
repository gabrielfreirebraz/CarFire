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

	public String checkLogin() {

		if (this.validar()) {
			if (login.consultar()) {

				// Redirecionar para próxima tela
				return "public/listCars.jsf";
			}
		}

		return null;
	}

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

	public Login getLogin() {
		return login;
	}

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
