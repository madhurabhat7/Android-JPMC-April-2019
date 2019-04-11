package android.example.androidapp;

import android.content.Intent;
import android.example.androidapp.adapters.ContactListAdpater;
import android.example.androidapp.model.Contact;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);

        final List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Anil", "anil@abc.com", "9800000"));
        contacts.add(new Contact(2, "Virat", "virat@abc.com", "9800001"));
        contacts.add(new Contact(3, "Amol", "amol@abc.com", "9800002"));
        contacts.add(new Contact(4, "Steve", "steve@abc.com", "9800003"));

        ListView listView = findViewById(R.id.contactsListView);
        ContactListAdpater adapter
                = new ContactListAdpater(this, R.layout.contact_row_layout, contacts);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                                View view, int position, long id) {
                Contact contact = contacts.get(position);
                String mobileNo = contact.getMobileNo();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + mobileNo));
                startActivity(intent);

                return true;
            }
        });
    }
}
