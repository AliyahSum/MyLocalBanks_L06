package sg.edu.rp.c346.id22015529.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedDBS ;
    TextView tvTranslatedOCBC ;
    TextView tvTranslatedUOB ;
    String wordClicked = "" ;
    String favouriteBank = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedDBS = findViewById(R.id.textViewDBS) ;
        tvTranslatedOCBC = findViewById(R.id.textViewOCBC) ;
        tvTranslatedUOB = findViewById(R.id.textViewUOB) ;

        registerForContextMenu(tvTranslatedDBS) ;
        registerForContextMenu(tvTranslatedOCBC) ;
        registerForContextMenu(tvTranslatedUOB) ;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu) ;
        return true ;
    }

    //website & phone
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo) ;

        if (v == tvTranslatedDBS) {
            wordClicked = "dbs" ;
        }
        else if (v == tvTranslatedOCBC) {
            wordClicked = "ocbc" ;
        }
        else if (v == tvTranslatedUOB) {
            wordClicked = "uob" ;
        }

        menu.add(0, 0, 0, "Website") ;
        menu.add(0, 1, 1, "Contact the bank") ;
        menu.add(0, 2, 2, "Favourite") ;
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //dbs website & contact
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg")) ;
                startActivity(intentView) ;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18001111111")) ;
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                favouriteBank = "dbs" ;
            }
        }

        //ocbc website & contact
        else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com")) ;
                startActivity(intentView) ;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18003633333")) ;
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                favouriteBank = "ocbc" ;
            }
        }

        //uob website & contact
        else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg")) ;
                startActivity(intentView) ;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"18002222121")) ;
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                favouriteBank = "uob" ;
            }
        }
        return super.onContextItemSelected(item) ;
    }

    //translation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId() ;

        if (id == R.id.englishSelection) {
            tvTranslatedDBS.setText("DBS") ;
            tvTranslatedOCBC.setText("OCBC") ;
            tvTranslatedUOB.setText("UOB") ;
            return true ;
        }
        else if (id == R.id.chineseSelection) {
            tvTranslatedDBS.setText("星展银行") ;
            tvTranslatedOCBC.setText("华侨银行") ;
            tvTranslatedUOB.setText("大华银行") ;
            return true ;
        }
        else {
            tvTranslatedDBS.setText("Error translation") ;
            tvTranslatedOCBC.setText("Error translation") ;
            tvTranslatedUOB.setText("Error translation") ;
        }

        return super.onOptionsItemSelected(item) ;
    }
}