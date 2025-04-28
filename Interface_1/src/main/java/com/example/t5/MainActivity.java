package com.example.t5; // Replace with your package name

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] androidNames = {
            "Android Cupcake",
            "Android Donut",
            "Android Eclair",
            "Android Froyo",
            "Android Gingerbread",
            "Android Honeycomb"
    };

    String[] versions = {
            "Version: 1.5",
            "Version: 1.6",
            "Version: 2.0",
            "Version: 2.2",
            "Version: 2.3",
            "Version: 3.0"
    };

    int[] icons = {
            R.drawable.ic1,
            R.drawable.ic2,
            R.drawable.ic3,
            R.drawable.ic4,
            R.drawable.ic5,
            R.drawable.ic6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.androidVersionsList);

        CustomListAdapter adapter = new CustomListAdapter(this, androidNames, versions, icons);
        listView.setAdapter(adapter);
    }

    class CustomListAdapter extends ArrayAdapter<String> {

        Context context;
        String[] names;
        String[] versions;
        int[] icons;
        LayoutInflater inflater;

        CustomListAdapter(Context context, String[] names, String[] versions, int[] icons) {
            super(context, R.layout.list_item, names);
            this.context = context;
            this.names = names;
            this.versions = versions;
            this.icons = icons;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.iconView = convertView.findViewById(R.id.imageViewIcon);
                viewHolder.nameText = convertView.findViewById(R.id.textViewName);
                viewHolder.versionText = convertView.findViewById(R.id.textViewVersion);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.iconView.setImageResource(icons[position]);
            viewHolder.nameText.setText(names[position]);
            viewHolder.versionText.setText(versions[position]);

            return convertView;
        }

        private class ViewHolder {
            ImageView iconView;
            TextView nameText;
            TextView versionText;
        }
    }
}