package com.example.t5_2;

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

    String[] fruitNames = {
            "Orange", "Cherry", "Banana", "Apple", "Kiwi", "Pear",
            "Strawberry", "Lemon", "Peach", "Apricot", "Mango"
    };

    String[] calories = {
            "47 Calories", "50 Calories", "89 Calories", "52 Calories", "61 Calories", "57 Calories",
            "33 Calories", "29 Calories", "39 Calories", "48 Calories", "60 Calories"
    };

    int[] fruitIcons = {
            R.drawable.ic_orange, R.drawable.ic_cherry, R.drawable.ic_banana,
            R.drawable.ic_apple, R.drawable.ic_kiwi, R.drawable.ic_pear,
            R.drawable.ic_strawberry, R.drawable.ic_lemon, R.drawable.ic_peach,
            R.drawable.ic_apricot, R.drawable.ic_mango
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.fruitListView);

        FruitListAdapter adapter = new FruitListAdapter(this, fruitNames, calories, fruitIcons);
        listView.setAdapter(adapter);
    }

    class FruitListAdapter extends ArrayAdapter<String> {

        Context context;
        String[] names;
        String[] cals;
        int[] icons;
        LayoutInflater inflater;

        FruitListAdapter(Context context, String[] names, String[] cals, int[] icons) {
            super(context, R.layout.list_item_fruit, names);
            this.context = context;
            this.names = names;
            this.cals = cals;
            this.icons = icons;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item_fruit, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.iconView = convertView.findViewById(R.id.imageViewFruitIcon);
                viewHolder.nameText = convertView.findViewById(R.id.textViewFruitName);
                viewHolder.calorieText = convertView.findViewById(R.id.textViewCalories);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.iconView.setImageResource(icons[position]);
            viewHolder.nameText.setText(names[position]);
            viewHolder.calorieText.setText(cals[position]);

            return convertView;
        }

        private class ViewHolder {
            ImageView iconView;
            TextView nameText;
            TextView calorieText;
        }
    }
}