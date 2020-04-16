package androidbootcamp.net;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Integer[] Animals = new Integer[]{R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla, R.drawable.panda, R.drawable.panther, R.drawable.polar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = findViewById(R.id.GridView);
        final ImageView pic = findViewById(R.id.imgLarge);
        int[] animals = new int[0];
        grid.setAdapter(new ImageAdapter(this, animals));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Selected Species" + (position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[position]);
            }
        });
    }
}
class ImageAdapter extends BaseAdapter{
private Context context;
    private int[] Animals;

    ImageAdapter(Context C, int[] animals) {
        context = C;
        Animals = animals;
    }

    @Override
    public int getCount() {
        return Animals.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView pic = new ImageView(context);
        pic.setImageResource(Animals[position]);
        pic.setScaleType(ImageView.ScaleType.FIT_XY);
        pic.setLayoutParams(new GridView.LayoutParams(330,300));
        return pic;
    }
}
