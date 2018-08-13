package service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateless
public class PrincipalServiceImpl implements PrincipalService {

    private final Map<String, String> countryMap = new HashMap<>();

    @PostConstruct
    public void initializeCountryWineList() {
        // countryMap is HashMap
        this.countryMap.put("Australia", "Sauvignon Blanc");
        this.countryMap.put("Australia", "Grenache");
        this.countryMap.put("France", "Gewurztraminer");
        this.countryMap.put("France", "Bordeaux");
    }

    @PreDestroy
    public void destroyWineList() {
        this.countryMap.clear();
    }

    @AroundInvoke
    public Object TimerLog(final InvocationContext ctx) throws Exception {
        final String beanClassName = ctx.getClass().getName();
        final String businessMethodName = ctx.getMethod().getName();
        final String target = ctx.getTarget().toString();
        final long startTime = System.currentTimeMillis();
        System.out.println("Invoking " + target);
        try {
            return ctx.proceed();
        } finally {
            System.out.println("Exiting " + target);
            final long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Business method " + businessMethodName + " in " + beanClassName + " takes " + totalTime + " ms to execute");
        }
    }

    @Override
    public boolean validar(final String texto) {
        System.out.println(this.countryMap);
        return false;
    }

}
