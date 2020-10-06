package id.ac.untad.githubuserapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserModel> users = new ArrayList<>();

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        UserModel user = (UserModel) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvname;
        private TextView tvcompany;
        private ImageView avatar;
        private TextView tvrepository;
        private TextView tvfollowers;
        private TextView tvfollowing;
        private TextView tvusername;
        private TextView tvlocation;

        ViewHolder(View view) {
            tvname = view.findViewById(R.id.tv_nama);
            tvcompany = view.findViewById(R.id.tv_company);
            avatar = view.findViewById(R.id.img_photo);
            tvrepository = view.findViewById(R.id.repo);
            tvfollowers = view.findViewById(R.id.follower);
            tvfollowing = view.findViewById(R.id.following);
            tvusername = view.findViewById(R.id.tv_username);
            tvlocation = view.findViewById(R.id.tv_location);
        }

        void bind(UserModel user) {
            tvname.setText(user.getNama());
            tvcompany.setText(user.getCompany());
            avatar.setImageResource(user.getAvatar());
        }
    }
}