package api.models.user;

import java.util.List;
import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;
    private String website;
    private UserCompany company;

    public User(Integer id, String name, String username, String email, UserAddress address, String phone, String website, UserCompany company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(username, user.username)
                && Objects.equals(email, user.email) && Objects.equals(address, user.address)
                && Objects.equals(phone, user.phone) && Objects.equals(website, user.website)
                && Objects.equals(company, user.company);
    }

    public static User getUserFromList(List<User> users, Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public UserCompany getCompany() {
        return company;
    }

    public void setCompany(UserCompany company) {
        this.company = company;
    }
}
