package mx.shellcore.android.navigationdrawer2;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import mx.shellcore.android.navigationdrawer2.fragments.ContentFragment;

public class MainActivity extends AppCompatActivity {

    // Components
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializeComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void inicializeComponents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationDrawerItemSelectedListener());

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private class NavigationDrawerItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(!(menuItem.isChecked()));
            drawerLayout.closeDrawers();

            switch (menuItem.getItemId()) {
                case R.id.inbox:
                    Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT)
                            .show();
                    ContentFragment fragment = new ContentFragment();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, fragment);
                    fragmentTransaction.commit();

                    return true;
                case R.id.starred:
                    Toast.makeText(getApplicationContext(), "Starred Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                case R.id.sent_email:
                    Toast.makeText(getApplicationContext(), "Sent email Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                case R.id.drafts:
                    Toast.makeText(getApplicationContext(), "Drafts Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                case R.id.allmail:
                    Toast.makeText(getApplicationContext(), "All mails Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                case R.id.trash:
                    Toast.makeText(getApplicationContext(), "Trash Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                case R.id.spam:
                    Toast.makeText(getApplicationContext(), "Spam Selected", Toast.LENGTH_SHORT)
                            .show();
                    return true;
                default:
                    Toast.makeText(getApplicationContext(), "Somethings wrong!", Toast.LENGTH_SHORT)
                            .show();
                    return true;
            }
        }
    }
}
