package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Task> taskList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects) {
        super(context, resource, objects);
            parent_context = context;
            layout_id = resource;
            taskList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View cnovertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvID = rowView.findViewById(R.id.tvID);
        TextView tvDesc = rowView.findViewById(R.id.tvDesc);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        Task currentItem = taskList.get(position);

        tvID.setText(Integer.toString(currentItem.getId()));
        tvDesc.setText(currentItem.getDescription());
        tvDate.setText(currentItem.getDate());

        return rowView;
    }
}
