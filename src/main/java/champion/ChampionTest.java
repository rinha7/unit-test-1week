package champion;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp(){        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스","탑");
        Champion jungleChamp = new Champion("리신","정글");
        Champion midChamp = new Champion("르블랑","미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    @Test
    public void givenCollectionWhenEmptyCorrect(){
        List<String> emptyList = new ArrayList<String>();
        assertThat(emptyList, empty());
    }

    @Test
    public void notNUllCheck(){
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    @Test
    public void stringChecker(){
        String sampleString = "Player Focus";
        String startStirng = "Player";
        String endString = "Focus";
        assertThat(sampleString, is(endsWith(endString)));
    }
    @Test
    public void floatChecker(){
        assertThat(3.14, closeTo(3, 0.2));
    }
    @Test
    public void referrenceChecker(){
        assertThat(championList.get(2),anything());
    }
    @Test
    public void countfiveChecker(){
        assertThat(championList.size(),is(5));
        assertThat(championList, Matchers.<Champion>hasSize(5));
    }
    @Test
    public void supportChampChecker(){
        Champion supportChamp = new Champion("타릭","바텀");
        assertThat("타릭",is(supportChamp.getName()));
        assertThat("타릭",equalTo(supportChamp.getName()));
    }
    @Test
    public void positionChecker(){
        assertThat(championList.get(0), Matchers.<Champion>hasProperty("position"));
        assertThat(championList.get(0),Matchers.<Champion>hasProperty("position",equalTo("정글")));
    }
    @Test
    public void haveChampChecker(){
        List<String> champnames = Arrays.asList("루시안","애쉬","렉사이","갈리오","모르가나","블라디");

        assertThat(champnames.get(0),hasToString("루시안"));
    }
    @Test
    public void topisDarius(){
        Optional<Champion> filteredChampion = championList.stream().filter(c->c.getPosition().equals("탑")).findFirst();

        String champname = filteredChampion.get().getName();
        assertThat("다리우스",is(champname));
    }
}
