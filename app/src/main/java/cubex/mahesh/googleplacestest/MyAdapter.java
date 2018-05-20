package cubex.mahesh.googleplacestest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    MainActivity mActivity ;
    ArrayList<Place> list;

    MyAdapter(MainActivity mActivity, ArrayList<Place> list)
    {
            this.mActivity = mActivity;
            this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,
                        View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        View v = inflater.inflate(R.layout.indiview,null);

        TextView tv1 = v.findViewById(R.id.tv1);
        TextView tv2 = v.findViewById(R.id.tv2);

        tv1.setText(list.get(position).getName());
        tv2.setText(list.get(position).getVicinity());

        return v;
    }
}
