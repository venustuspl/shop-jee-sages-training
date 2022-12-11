package pl.training.jakarta;

import javax.ejb.Remote;
import java.time.LocalDateTime;

@Remote
public interface TimeProvider {

    LocalDateTime getDataTime();

}
