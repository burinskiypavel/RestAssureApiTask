import models.Player;
import models.Team;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataForTests {

    @DataProvider
    public Iterator<Object[]> dataForPlayerPost(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new Player().withId(4).withFirstName("testFirstName4").withLastName("testLastName4").withAge(40)});
        list.add(new Object[]{new Player().withId(5).withFirstName("testFirstName5").withLastName("testLastName5").withAge(50)});
        list.add(new Object[]{new Player().withId(6).withFirstName("testFirstName6").withLastName("testLastName6").withAge(60)});
        return list.iterator();
    }

    @DataProvider
    public Object[][] dataForGetPlayerById(){
        return new Object[][]{
                {1, "Tom", "Cruz"},
                {2, "Sam", "Jonson"},
                {3, "Jordan", "TTT"}
        };
    }

    @DataProvider
    public Object[] dataForDelete(){
        return new Object[]{
                4, 5, 6
        };
    }

    @DataProvider
    public Iterator<Object[]> dataForTeamsPost(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new Team().withId(4).withName("testName4")});
        list.add(new Object[]{new Team().withId(5).withName("testFirstName5")});
        list.add(new Object[]{new Team().withId(6).withName("testFirstName6")});
        return list.iterator();
    }

//    @DataProvider
//    public Object[][] dataForTeamsPost2(){
//        return new Object[][]{
//                {4, "testName4"},
//                {5, "testName5"},
//                {6, "testName6"}
//        };
//    }

    @DataProvider
    public Object[][] dataForGetTeamById(){
        return new Object[][]{
                {1, "Eagles"},
                {2, "Bulls"},
                {3, "Wolves"}
        };
    }
}
