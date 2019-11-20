package hfut.sch.bean;

public class UserVo {
    private UserForMybatis user;

    public UserForMybatis getUser() {
        return user;
    }

    public void setUser(UserForMybatis user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "user=" + user +
                '}';
    }
}
