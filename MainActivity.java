package com.example.ratingplaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.ratingplaces.model.HPlaces;
import com.example.ratingplaces.adapter.ListAdapter;

import java.util.ArrayList;

import static com.example.ratingplaces.adapter.ListAdapter.PREF_FILE;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<HPlaces> list = new ArrayList<>();


    private String names[] = {"البترا", "قلعة البحرين - مرفأ قديم وعاصمة دلمون", "جيميلة", "الحجر (مدائن صالح)", "المواقع الأثرية في جزيرة مروي",
            "مملكة الحضر", "مدينة فاس القديمة", "مدينة شبام القديمة وسورها", "مدينة تونس القديمة", "أرض اللبان", "قلعة الزبارة",
            "وادي الحيتان", "قصور وادان وشنقيط وتيشيت وولاتة القديمة", "بعلبك", "مواقع تادرارت أكاكوس الصخرية", "كنيسة المهد"};

    private String descriptions[] = {
            "مدينة أثرية وتاريخية تشتهر بعمارتها المنحوتة بالصخور ونظام قنوات جر المياه القديمة. اُطلق عليها قديما اسم \"سلع\". كا سُميت بـ \"المدينة الوردية\" نسبة لألوان صخورها الملتوية.",
            "بنيت هذه القلعة من قبل حكام عرب محليين في القرن الرابع عشر الميلادي على مباني تعود لفترات مختلفة وتتكون من أربعة أبراج دائرية في كل زاوية برج وبعض الغرف الخاصة بالذخيرة والغرف الخاصة بالجند.",
            "جميلة أو سويكول تقع على ارتفاع 900 م فوق سطح البحر، وتحتوي على ساحات وهياكل وكنائس وأقواس ومنازل على الطراز الروماني.",
            "كانت عاصمة مملكة الأنباط الجنوبية في شمال الجزيرة العربية والحجر اسم ديار ثمود. الموقع يضم مقابر ضخمة، تعود إلى القرن الأول ق. م. كما يشتمل على حوالي 50 نقشاً تعود لتلك الفترة، وعدداً من رسوم الكهوف.",
            "كانت مروي العاصمة الشمالية لمملكة نبتة - مروي، امتد عمرها من العام 800 ق. م - 350 م، وقد كشفت الأبحاث الأثرية أدلة تعود لحقبة نبتة.",
            "\"مهددة بالخطر منذ العام 2015. مهددة بالخطر منذ العام 2015.\n" +
                    "كان سكان الحضر وثنيين يعبدون آلهة عدة منها اللات وشمش، أطلق الحضريون كلمة (شمش) ليعنوا بها الحقيقة المطلقة، ونعتوا الشمس بالإله الأكبر وقد تخيلوه على هيئة كهل عاقل كما توضح رسومهم على أقواس واسكفات في المعبد الكبير\"",
            "تأسّست في القرن التاسع وبها أقدم جامعة في العالم. كان عصرها الذهبي في القرنَيْن الثالث عشر والرابع عشر تحت حكم المرينيّين، أصبحت عاصمة بدلاً من مراكش. وتحتوي على على عدد من المباني والينابيع.",
            "تعود مباني المدينة إلى القرن السادس عشر الميلادي وتعد إحدى أقدم النماذج للتنظيم المدني الدقيق المرتكز على مبدأ البناء المرتفع حيث أنها تحتوي على مباني برجية شاهقة منبثقة من الصخور.",
            "اعتبرت تونس في فترة حكم المهديين والحفصيين منذ القرن الثاني عشر ولغاية السادس عشر إحدى أهم مدن العالم الإسلامي. وتتضمن 700 موقع من قصور ومساجد وأضرحة ومدارس وموارد مياه.",
            "تتواجد أشجار اللبان في وادي دوكة، وتتميز المنطقة بوجود آثار محيطة بها. حيث كانت تجارة اللبان مزدهرة خلال قرون عدة باعتبارها إحدى النشاطات التجارية في العالم القديم.",
            "شُيّدت القلعة عام 1938 في موقع مدينة أثرية كانت مركزاً للتجارة في أواخر القرن الثامن عشر وبداية التاسع عشر الميلادي. حُوّلت القلعة إلى متحف به مقتنيات أثريّة من محيط المدينة.",
            "يقع الوادي في صحراء مصر الغربية ويتضمّن بقايا أحفورية متحجّرة عن فصيلة الحيتان القديمة والمنقرضة. وهي تمثل تطور الحيتان من ثدييات برية إلى بحرية.",
            "يعود تأسيسها إلى القرنين الحادي عشر والثاني عشر، وهي تتميز بوجود العديد من المواقع فكل منزل فيها يحتوي على صحن دار وهي متقاربة تتميز بأزقتها الضيقة، تحيط بمسجد له مئذنة مربّعة.",
            "عُرفت المدينة حينما كانت العبادة للثالوث الإلهي، بمدينة الشمس في العصر الهيلنستي. وحافظت على دورها الديني. كما أنها تعتبر من أهم آثار الهندسة الرومانيّة الإمبراطورية.",
            "عبارة عن مرتفع صخري به آلاف الرسوم الصخرية المختلفة تمثل أشكال حيوانية ونباتية وأساليب الحياة في فترات مختلفة، يعود أقدمها إلى 21 ألف عام ق. م. تقريبًا، ويقدر أحدثها بأنه يعود إلى القرن الأول ميلادي.",
            "يؤمن المسيحيون على أنها مكان ولادة يسوع المسيح. وبنيت عام 339 م. كما يشمل الموقع كنائس وأديرة يونانية ولاتينية وأرثوذوكسية وفرنسيسكان وأرمن، وكذلك أجراسا وحدائق متنوعة."
    };

    private String countries[] = {
            "الأردن",
            "البحرين",
            "الجزائر",
            "السعودية",
            "السودان",
            "العراق",
            "المغرب",
            "اليمن",
            "تونس",
            "عمان",
            "قطر",
            "مصر",
            "موريتانيا",
            "لبنان",
            " ليبيا",
            " فلسطين"
    };

    private int images[] = {
            R.drawable.img_1 , R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4,
            R.drawable.img_5, R.drawable.img_6,
            R.drawable.img_7, R.drawable.img_8,
            R.drawable.img_9, R.drawable.img_10,
            R.drawable.img_11, R.drawable.img_12,
            R.drawable.img_13, R.drawable.img_14,
            R.drawable.img_15, R.drawable.img_16
    };

    private int length = names.length;
    private int store_rating[] = new int[length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewer);
       // SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

        HPlaces places[] = new HPlaces[names.length];
        int i = 0;
        while (i < names.length){
            places[i] = new HPlaces(names[i],countries[i],descriptions[i],images[i]);
           // places[i].setRate(sharedPreferences.getInt(places[i].gethPlaceName(),0));
            list.add(places[i]);
            i++;
        }
/*
        HPlaces place1 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place2 = new HPlaces(names[2],descriptions[2],images[3]);
        HPlaces place3 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place4 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place5 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place6 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place7 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place8 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place9 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place10 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place11 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place12 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place13 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place14 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place15 = new HPlaces(names[1],descriptions[1],images[1]);
        HPlaces place16 = new HPlaces(names[1],descriptions[1],images[1]);

 */

        listAdapter = new ListAdapter(list,this);
        listView.setAdapter(listAdapter);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int i = 0;
        while (i < names.length) {
            store_rating[i] = list.get(i).getRate();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int i = 0;
        while (i < names.length){
            list.get(i).setRate(store_rating[i]);
        }
    }
}