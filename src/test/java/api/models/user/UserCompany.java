package api.models.user;

import java.util.Objects;

public class UserCompany {
    private String name;
    private String catchPhrase;
    private String bs;

    public UserCompany(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public UserCompany() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompany that = (UserCompany) o;
        return Objects.equals(name, that.name) && Objects.equals(catchPhrase, that.catchPhrase)
                && Objects.equals(bs, that.bs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
