package ros.rosbank;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity {
    private Intent intent1;
    TextView bar;
    private ActionBar toolbar;
    private List<OneNews> news = new ArrayList();

    ListView newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.newsactionbar);
        toolbar = getSupportActionBar();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationNews);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationNews);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        news.add(new OneNews("Rosbank Tech.Madness!","Marketing",
                "Today our hackathon Rosbank Tech.Madness starts!","Уже сегодня стартует наш хакатон Rosbank Tech.Madness! ⚡ 16-18 ноября на площадке Deworkacy пройдёт хакатон Росбанка: 100 лучших разработчиков от 20 команд устроят настоящий brain battle и будут разрабатывать прототипы финтех-продуктов. Наблюдать за этим событием можно будет в режиме online. Присоединяйтесь! Встречаемся сегодня вечером в Stories нашего Instagram-профиля instagram.com/rosbank_team/ #rosbank #росбанк #societegenerale #smartrosbank #rosbanktechmadness",
                R.drawable.hack));
        news.add(new OneNews("Будущее это вы!","Marketing","Международная финансовая группа Societe Generale представила новую бренд-платформу.",
                "Международная финансовая группа Societe Generale представила новую бренд-платформу. Новый слоган «Будущее – это вы» отражает нацеленность банка на устойчивое развитие, работу во благо клиентов, экономики и общества в целом. Он лучше всего описывает нашу общую миссию – поддерживать каждого, кто хочет позитивно влиять на будущее, заставляя планету вращаться. Мы стремимся создать лучшие условия для своих клиентов, поддерживать их проекты на каждом этапе и быть честным, надежным партнером, с которым можно изменить мир в лучшую сторону! Группа присутствует в 67 странах мира и является важным финансовым институтом для Европы, Африки и России. Societe Generale – инновационная компания, развивающая цифровые технологии, которые позволят перевести отношения с клиентами и взаимодействие между сотрудниками на новый уровень. В России Группа представлена Росбанком, Русфинанс Банком, ДельтаКредит Банк, компаниями Société Générale Insurance и ALD Automotive. #TheFutureIsYou #БудущееЭтоВы #societegenerale #sgrussia #росбанк\"",
                R.drawable.news));
        news.add(new OneNews("Друзья, хотите космическую новость?!","Business","Во Вселенной банковских продуктов появился настоящий супергерой — карта Росбанка",
                "Друзья, хотите космическую новость? Во Вселенной банковских продуктов появился настоящий супергерой — карта Росбанка #МожноВСЁ! Расплачиваясь ей, вы сможете получать ощутимую выгоду в виде Cashback — до 10% на выбранные категории и 1% на остальные покупки, или Travel-бонусы на путешествия. С ней и правда можно все: выбирать, какие бонусы получать, свободно переключаться между ними, менять категории Cashback, единовременно подключить Cashback или Travel-бонусы к 1 дебетовой и 1 кредитной карте. Это ли не суперсила? Подробнее о карте по ссылке: https://goo.gl/9nLLkC #можноВСЕ #росбанк #rosbank #sgrussia #societegenerale\n",
                R.drawable.cityjpg));
        news.add(new OneNews("Деньги на любой случай","Marketing","Поддержим ваши планы! Зимняя резина, новый смартфон, шопинг, неожиданная поездка",
                "Поддержим ваши планы! Зимняя резина, новый смартфон, шопинг, неожиданная поездка? Есть масса ситуаций, когда наличные нужны здесь и сейчас. Мы не будем тратить ваше время и одобрим кредитную заявку в срок от 15 минут. Дату ежемесячного платежа выберете сами. Ведь так комфортнее? Оставьте заявку на кредит наличными «Просто деньги» на нашем сайте: https://goo.gl/rzsv4N #росбанк #rosbank #rosbankteam #rosbanksg #sgrussia #societegenerale\n",
                R.drawable.buy));

        newsList = (ListView) findViewById(R.id.NewsList);
        NewsAdapter stateAdapter = new NewsAdapter(this, R.layout.onenews_layout, news);
        newsList.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                OneNews selectedState = (OneNews) parent.getItemAtPosition(position);

                NewsContentActivity.news = selectedState;

                Intent newsInfo = new Intent(News.this, NewsContentActivity.class);
                startActivity(newsInfo);
            }
        };
        newsList.setOnItemClickListener(itemListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mylink:
                    toolbar.setTitle("My link");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    bar.setText("My Link");
                    intent1 = new Intent(News.this, MainActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.referals:
                    toolbar.setTitle("Referals");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    intent1 = new Intent(News.this, Referals.class);
                    startActivity(intent1);
                    return true;
                case R.id.news:
                    toolbar.setTitle("News");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    //intent1 = new Intent(News.this, News.class);
                    //startActivity(intent1);
                    return true;
                case R.id.docs:
                    toolbar.setTitle("Documents");
                    bar = (TextView)findViewById(R.id.action_bar_title);
                    intent1 = new Intent(News.this, Documents.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };
}
