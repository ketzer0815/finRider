package de.elsholz.finrider;

import com.example.android.animationsdemo.R;

import de.elsholz.finrider.screenslider.ScreenSlideActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private class MainMenuItem {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public MainMenuItem(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

    /**
     * The collection gets instantiated in onCreate(android.os.Bundle)
     * because the MainMenuItem constructor needs access to android.content.res.Resources
     */
    private static MainMenuItem[] mMainMenuItems;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainMenuItems = new MainMenuItem[]{
                new MainMenuItem(R.string.title_screen_slide, ScreenSlideActivity.class)
        };

        setListAdapter(new ArrayAdapter<MainMenuItem>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mMainMenuItems));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mMainMenuItems[position].activityClass));
    }
}
