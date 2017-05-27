package scott.noa.com.cry.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;

import scott.noa.com.cry.R;
import scott.noa.com.cry.databinding.ActivityFilterBinding;

/**
 * Created by noalabs on 2017/5/27.
 */

public class FilterActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private ActivityFilterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getIntent().getStringExtra("type");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(type);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter);

        prefs = getSharedPreferences(type, Context.MODE_PRIVATE);

        binding.filterName.setText(prefs.getString("name",type));
        binding.seekbar.setProgress(prefs.getInt("rssi",100));
        binding.seekvalue.setText("-"+String.valueOf(prefs.getInt("rssi",100)));
        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.seekvalue.setText(String.valueOf("-"+progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        setValue();
        finish();
        return super.onSupportNavigateUp();
    }

    private void setValue(){
        SharedPreferences.Editor editor =prefs.edit();
        editor.putString("name",binding.filterName.getText().toString().trim());
        editor.putInt("rssi",binding.seekbar.getProgress());
        editor.commit();
    }

    @Override
    protected void onStop() {
        setValue();
        super.onStop();
    }
}
