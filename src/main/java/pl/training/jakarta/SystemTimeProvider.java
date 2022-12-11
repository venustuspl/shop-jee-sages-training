package pl.training.jakarta;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.LocalDateTime;

@Startup
@Singleton
public class SystemTimeProvider implements TimeProvider {

    @Lock(LockType.READ)
    @Override
    public LocalDateTime getDataTime() {
        return LocalDateTime.now();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.printf("%s: postConstruct%n", getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.printf("%s: preDestroy%n", getClass().getSimpleName());
    }

}
