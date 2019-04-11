package android.example.androidapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.example.androidapp.R;
import android.example.androidapp.model.Contact;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactListAdpater extends ArrayAdapter<Contact> {

    private Context context;
    private int resourceId;
    private List<Contact> contacts;

    public ContactListAdpater(Context context, int resourceId, List<Contact> contacts){
        super(context, resourceId, contacts);
        this.context = context;
        this.resourceId = resourceId;
        this.contacts = contacts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view
                =  ((Activity)context).getLayoutInflater()
                        .inflate(resourceId, parent, false);
        TextView idTextView = view.findViewById(R.id.idTV);
        TextView nameTextView = view.findViewById(R.id.nameTV);
        TextView emailTextView = view.findViewById(R.id.emailTV);
        TextView mobileTextView = view.findViewById(R.id.mobileTV);

        Contact contact = contacts.get(position);

        idTextView.setText(contact.getId() + "");
        nameTextView.setText(contact.getName());
        emailTextView.setText(contact.getEmail());
        mobileTextView.setText(contact.getMobileNo());

        return view;
    }
}
