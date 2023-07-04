package app.vit.imgtextsteganosoftware;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import app.vit.imgtextsteganosoftware.activities.decrypt.DecryptActivity;
import app.vit.imgtextsteganosoftware.activities.encrypt.EncryptActivity;
import app.vit.imgtextsteganosoftware.activities.encrypt.EncryptImageActivity;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  LinearLayout encrypt,decrypt,encryptImg;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    encrypt =findViewById(R.id.encodeButton);
    decrypt =findViewById(R.id.decodeButton);
    encryptImg =findViewById(R.id.encodeImageButton);
    encryptImg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, EncryptImageActivity.class);
        startActivity(intent);
      }
    });

    encrypt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, EncryptActivity.class);
        startActivity(intent);
      }
    });
    decrypt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DecryptActivity.class);
        startActivity(intent);
      }
    });

    //initToolbar();
  }

public boolean onCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
  getMenuInflater().inflate(R.menu.menu, menu);
  return true;
}

  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_name) {
      Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
      i.putExtra("check", "true");
      startActivity(i);

      Log.d("I", "In fb button");
      return true;

    }
    else if(id==R.id.send)
    {
      Intent intent = new Intent(Intent.ACTION_SEND);
      intent.setType("text/html");
      intent.putExtra(Intent.EXTRA_EMAIL, "friend@gmail.com");
      intent.putExtra(Intent.EXTRA_SUBJECT, "Encrypted Image");
      intent.putExtra(Intent.EXTRA_TEXT, "Decrypt the image to get secret message");
      startActivity(Intent.createChooser(intent, "Send Email"));
    }
    return true;
  }
}
