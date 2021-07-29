package sg.edu.rp.c346.id20011806.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;
    ImageView ivGender;

    public CustomAdapter( Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvPhone = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvPhone.setText(currentItem.getPhoneNum() + "");
        if (currentItem.getGender() == 'F') {
            //ivGender.setImageResource(R.drawable.male);
            Picasso.get().load("https://image.shutterstock.com/image-vector/cute-pretty-young-curly-girl-600w-1927719200.jpg").into(ivGender);
        } else {
            //ivGender.setImageResource(R.drawable.female);
            Picasso.get().load("https://image.shutterstock.com/image-vector/cute-kid-teen-boy-show-600w-1509139481.jpg").into(ivGender);
        }
        return rowView;
    }
}
