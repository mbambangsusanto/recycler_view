package id.recycler_view.recycleviewmovie.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import id.recycler_view.recycleviewmovie.R;
import id.recycler_view.recycleviewmovie.model.Result;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "string_extra";
    String title;
    String tanggal;
    String overview;
    String image;
    String rating;
    ImageView imgDetail,imgRating;
    TextView txtTitle, txtDetail, txtRating, txtTgl;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txt_judul);
        txtDetail = findViewById(R.id.txt_deskripsi);
        imgDetail = findViewById(R.id.img_movie);
        txtTgl = findViewById(R.id.txt_tgl);
        txtRating = findViewById(R.id.txt_rating);
        imgRating = findViewById(R.id.img_rating);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        rating = result.getVoteAverage().toString();
        tanggal = result.getReleaseDate();
        image = result.getPosterPath();

        txtTitle.setText(title);
        txtDetail.setText(overview);
        txtRating.setText(rating);
        txtTgl.setText(tanggal);

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}