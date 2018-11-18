package ros.rosbank;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MenAdapter extends ArrayAdapter<Men> {

    private LayoutInflater inflater;
    private int layout;

    private List<Men> states;

    public MenAdapter(Context context, int resource, List<Men> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        if (Referals.oddev++ % 2 == 1) view.setBackgroundColor(0xfff0f0f0);

        TextView idView = (TextView) view.findViewById(R.id.idid);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView profitView = (TextView) view.findViewById(R.id.profit);

        Men state = states.get(position);

        nameView.setText(state.getName());
        profitView.setText(""+state.getProfit()+" $");
        idView.setText(state.getId());

        return view;
    }
}