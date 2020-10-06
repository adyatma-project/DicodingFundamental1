package id.ac.untad.githubuserapplication1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UserAdapter useradapter;
    String[] dataName;
    String[] dataCompany;
    String[] dataUsername;
    String[] dataRepository;
    String[] followers;
    String[] following;
    String[] datalocation;
    TypedArray dataAvatar;
    ArrayList<UserModel> usermodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useradapter = new UserAdapter(this);
        ListView listview = findViewById(R.id.list_user);
        listview.setAdapter(useradapter);
        prepare();
        addItem();


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserModel film = (UserModel) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailUser.class);
                intent.putExtra("KEY_EXTRA", usermodel.get(position));
                startActivity(intent);
            }
        });
    }


    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataCompany = getResources().getStringArray(R.array.company);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataUsername = getResources().getStringArray(R.array.username);
        dataRepository = getResources().getStringArray(R.array.repository);
        followers = getResources().getStringArray(R.array.followers);
        following = getResources().getStringArray(R.array.following);
        datalocation = getResources().getStringArray(R.array.location);
    }

    private void addItem() {
        usermodel = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            UserModel user = new UserModel();
            user.setAvatar(dataAvatar.getResourceId(i, -1));
            user.setNama(dataName[i]);
            user.setCompany(dataCompany[i]);
            user.setUsername(dataUsername[i]);
            user.setRepository(dataRepository[i]);
            user.setFollowers(followers[i]);
            user.setFollowing(following[i]);
            user.setLocation(datalocation[i]);
            usermodel.add(user);
        }
        useradapter.setUsers(usermodel);
    }
}