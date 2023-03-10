package com.erudio.javaspringerudio.data.vo.v2;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

public class PersonVOV2 implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  private Date birthday;

  public PersonVOV2() {
  }

  public PersonVOV2(Long id, String firstName, String lastName, String address, String gender, Date birthday) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.gender = gender;
    this.birthday = birthday;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof PersonVOV2)) {
      return false;
    }
    PersonVOV2 personVOV2 = (PersonVOV2) o;
    return Objects.equals(id, personVOV2.id) && Objects.equals(firstName, personVOV2.firstName)
        && Objects.equals(lastName, personVOV2.lastName) && Objects.equals(address, personVOV2.address)
        && Objects.equals(gender, personVOV2.gender) && Objects.equals(birthday, personVOV2.birthday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address, gender, birthday);
  }

}
