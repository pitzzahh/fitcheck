package tech.araopj.fitcheck.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import tech.araopj.fitcheck.R;
import tech.araopj.fitcheck.db.DataService;
import tech.araopj.fitcheck.db.Database;
import tech.araopj.fitcheck.mvvm.model.Gender;
import tech.araopj.fitcheck.mvvm.model.UserDAO;
import tech.araopj.fitcheck.mvvm.model.UserProfile;

public class MainActivity extends AppCompatActivity {

    private static final DataService<UserProfile> service = new DataService<>(new UserDAO());

    public MainActivity() {
        Database.builder()
                .url(getFilesDir().getPath() + "/test")
                .username("testUser")
                .password("testPass")
                .build()
                .setDataSource();
        service.create(new UserProfile(
                "Peter",
                (byte) 20,
                170,
                50,
                Gender.MALE
        ));
    }

    public static DataService<UserProfile> getService() {
        return service;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView result = findViewById(R.id.result);
        for (UserProfile userProfile : service.read()) {
            result.setText(userProfile.getName());
        }
        setContentView(R.layout.activity_main);
    }
}