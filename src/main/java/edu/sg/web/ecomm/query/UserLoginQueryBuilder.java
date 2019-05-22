package edu.sg.web.ecomm.query;

public class UserLoginQueryBuilder {

  public String buildQuery(UserLoginSearchCriteria criteria) {
    final String first = "select * from UserLogin ";
    final StringBuilder sql = new StringBuilder(first);
    sql.append("where 1 = 1 ");
    if (criteria.getUsername() != null) {
      sql.append("and username = '").append(criteria.getUsername()).append("'");
    }
    if (criteria.getAge() > 0) {
      sql.append("and age = ").append(criteria.getAge());
    }
    return sql.toString();
  }

}
