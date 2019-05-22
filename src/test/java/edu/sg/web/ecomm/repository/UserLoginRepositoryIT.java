package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserLogin;
import edu.sg.web.ecomm.support.ContextIT;
import java.util.List;
import java.util.Optional;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextIT
@Rollback
public class UserLoginRepositoryIT {

  @Autowired
  private UserLoginRepository repository;

  @Test
  public void testFindAll() {
    List<UserLogin> users = repository.findAll();
    for (UserLogin user : users) {
      System.out.println("username = " + user.getUsername());
    }
  }

  @Test
  public void testFindByPassword() {
    Optional<UserLogin> user = repository.findByPassword("1234");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }

  @Test
  public void testFindByName() {
    Optional<UserLogin> user = repository.findByUsername("thi123");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }

}
