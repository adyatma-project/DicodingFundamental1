package id.ac.untad.githubuserapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailUser extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_EXTRA = "key_extra";

    private TextView tvname;
    private TextView tvcompany;
    private CircleImageView avatar;
    private TextView tvrepository;
    private TextView tvfollowers;
    private TextView tvfollowing;
    private TextView tvusername;
    private TextView tvlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_userd);
        tvname = findViewById(R.id.tv_nama);
        tvcompany = findViewById(R.id.tv_company);
        avatar = findViewById(R.id.img_user);
        tvrepository = findViewById(R.id.repo);
        tvfollowers = findViewById(R.id.follower);
        tvfollowing = findViewById(R.id.following);
        tvusername = findViewById(R.id.tv_username);
        tvlocation = findViewById(R.id.tv_location);

        ImageView IcBack = findViewById(R.id.ic_back);
        IcBack.setOnClickListener(this);

        UserModel text = getIntent().getParcelableExtra("KEY_EXTRA");

        String name = text.getNama();
        String company = text.getCompany();
        String repository = text.getRepository();
        String followers = text.getFollowers();
        String following = text.getFollowing();
        String username = text.getUsername();
        String location = text.getLocation();
        tvname.setText(name);
        tvcompany.setText(company);
        tvrepository.setText(repository);
        tvfollowers.setText(followers);
        tvfollowing.setText(following);
        tvusername.setText(username);
        tvlocation.setText(location);
        avatar.setImageResource(text.getAvatar());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_back:
                Intent moveIntent = new Intent(DetailUser.this, MainActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}