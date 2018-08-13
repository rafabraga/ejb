package mbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.PrincipalService;

@ViewScoped
@ManagedBean(name = "principal")
public class PrincipalMBean {

    @EJB
    private PrincipalService principalService;

    public void testar() {
        System.out.println("Funcionou! - " + this.principalService.validar("abc"));
    }

}
