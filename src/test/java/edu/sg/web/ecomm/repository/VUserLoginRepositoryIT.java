package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.VUserLogin;
import edu.sg.web.ecomm.support.ContextIT;
import java.util.Optional;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextIT
@Rollback
public class VUserLoginRepositoryIT {

  @Autowired
  private VUserLoginRepository repository;

  @Test
  public void test() {
    Optional<VUserLogin> user = repository.findById(1L);
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }
}
