package singleton;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Startup
@Singleton
public class ContadorSingleton {

    private int contador = 0;

    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void contar(final Timer timer) {
        final String timerInfo = (String) timer.getInfo();
        System.out.println(timerInfo);
        System.out.println("Contador em: " + this.contador++);
    }

}
