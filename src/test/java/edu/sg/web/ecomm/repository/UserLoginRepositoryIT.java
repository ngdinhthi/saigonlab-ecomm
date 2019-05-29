package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserLogin;
import java.util.List;
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
@ContextConfiguration(locations = { "classpath:spring-config-test.xml" })
@Rollback
public class UserLoginRepositoryIT {

  @Autowired
  private UserLoginRepository repository;

  @Test
  public void testFindByPassword() {
    Optional<UserLogin> user = repository.findByPasswordAndUsername("1234", "nam123");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
    System.out.println("username = " + user.get().getUsername());
  }

  @Test
  public void testFindByName() {
    Optional<UserLogin> user = repository.findByUsername("thi123");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }

  @Test
  public void testFindAll() {
    List<UserLogin> users = repository.findAll();
    for (UserLogin user : users) {
      System.out.println("username = " + user.getUsername());
    }
  }

  @Test
  public void testCreate() {
    final UserLogin userLogin = new UserLogin();
    userLogin.setUsername("thi123");
    userLogin.setActive(true);
    UserLogin updatedUserLogin = repository.save(userLogin);

    System.out.println("Before update User Id = " + userLogin.getId());
    System.out.println("After update User Id = " + updatedUserLogin.getId());
  }

  @Test
  public void testUpdate() {
    Optional<UserLogin> userLogin = repository.findByUsername("thi123");
    userLogin.ifPresent(user -> user.setActive(false));
    Optional<UserLogin> updatedUserLogin = userLogin.map(repository::save);

    System.out.println("Before update User Id = " + userLogin.get().isActive());
    System.out.println("After update User Id = " + updatedUserLogin.get().isActive());
  }

  @Test
  public void testDelete() {
    Optional<UserLogin> userLogin = repository.findByUsername("thi123");
    userLogin.ifPresent(repository::delete);
  }

}
