package com.minorius.smilaguide;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.minorius.smilaguide.adapter.CategoryAdapter;
import com.minorius.smilaguide.adapter.pojo.CategoryItem;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_recycler_main)        RecyclerView recyclerView;
    @BindView(R.id.id_edit_text_main_ip)    EditText editText;
    @BindView(R.id.id_btn_main_apply)       Button button;

    //public static String BASE_REST_URL = "http://37.139.166.8:8080/";
    public static String BASE_REST_URL;

    private SharedPreferences preferences;
    public static final String APP_PREFERENCES = "subsettings";
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new CategoryAdapter(initCategoryList(), this));

        preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        preferences = this.getPreferences(Context.MODE_PRIVATE);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams. SOFT_INPUT_STATE_ALWAYS_HIDDEN );

        setBASE_REST_URL(preferences.getString("IP", "http://0.0.0.0:8080"));

        if (preferences.getString("IP", "http://0.0.0.0:8080").equals("http://0.0.0.0:8080")){
            Snackbar.make(button, "Вкажіть адресу сервера", Snackbar.LENGTH_SHORT).show();
        }else {
            Snackbar.make(button, preferences.getString("IP", "http://0.0.0.0:8080"), Snackbar.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.id_btn_main_apply)
    public void onClick(){
        editor = preferences.edit();
        editor.putString("IP", "http://"+editText.getText().toString()+":8080");
        editor.apply();
        setBASE_REST_URL("http://"+editText.getText().toString()+":8080");
        Toast.makeText(getApplicationContext(), "Збережено", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<CategoryItem> initCategoryList(){
        ArrayList<CategoryItem> list = new ArrayList<>();
        list.add(new CategoryItem("category_bus", "Транспорт"));
        list.add(new CategoryItem("category_relax", "Відпочинок"));

        list.add(new CategoryItem("category_weather", "Погода"));
        list.add(new CategoryItem("category_news", "Новини"));

        //list.add(new CategoryItem("category_shop", "Магазини"));
        list.add(new CategoryItem("category_terminal", "Термінали"));
        list.add(new CategoryItem("category_tv", "McLaut TV"));

        list.add(new CategoryItem("category_buy", "Куплю"));
        list.add(new CategoryItem("category_sell", "Продам"));

        return list;
    }


    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }


    public String getBASE_REST_URL() {
        return BASE_REST_URL;
    }

    public void setBASE_REST_URL(String BASE_REST_URL) {
        MainActivity.BASE_REST_URL = BASE_REST_URL;
    }
}
