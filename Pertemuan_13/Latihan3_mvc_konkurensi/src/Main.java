import controller.UserController;
import model.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import model.UserMapper;
import view.UserPdf;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserPdf pdf = new UserPdf();

        UserView view = new UserView();
        new UserController(view, mapper, pdf);

        view.setVisible(true);
    }
}
