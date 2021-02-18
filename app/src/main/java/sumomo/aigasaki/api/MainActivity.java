package sumomo.aigasaki.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import sumomo.aigasaki.api.Adaptadores.AdaptadorPelicula;
import sumomo.aigasaki.api.modelo.Pelicula;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView reciclerView= findViewById(R.id.recicler);
        
        LinearLayoutManager manager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        //establecemos la orientacion del recicler
        reciclerView.setLayoutManager(manager);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=145d71637c36f2863c16bfb154c5046c&language=en-US&page=1";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    //la peticion ocurrio con exito

                    try {
                        JSONArray results = response.getJSONArray("results");

                        ArrayList<Pelicula> listaTemporal= new ArrayList<Pelicula>();

                        for (int a = 0; a < results.length(); a++) {

                            JSONObject itemPelicula = results.getJSONObject(a);
                            Pelicula pelicula = new Pelicula(
                                    itemPelicula.getString("original_title"),
                                    itemPelicula.getString("backdrop_path"),
                                    itemPelicula.getString("overview"),
                                    itemPelicula.getString("release_date"),
                                    itemPelicula.getDouble("vote_average")
                            );

                            listaTemporal.add(pelicula);
                        }

                        AdaptadorPelicula adapter= new AdaptadorPelicula(listaTemporal);

                        reciclerView.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    //algo salio mal
                });
        queue.add(request);

    }
}
