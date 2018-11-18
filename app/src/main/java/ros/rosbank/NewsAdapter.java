package ros.rosbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<OneNews> {

    private LayoutInflater inflater;
    private int layout;
    private List<OneNews> news;

    public NewsAdapter(Context context, int resource, List<OneNews> news) {
        super(context, resource, news);
        this.news = news;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.iconNews);
        TextView nameView = (TextView) view.findViewById(R.id.header);
        TextView capitalView = (TextView) view.findViewById(R.id.shortInfo);

        OneNews one = news.get(position);

        flagView.setImageResource(one.getIconResource());
        nameView.setText(one.getHeader());
        capitalView.setText(one.getShortInfo());

        return view;
    }
}
