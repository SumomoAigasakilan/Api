package sumomo.aigasaki.api;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePelicula2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        //Mostrar boton volver a la pesta;a anterior
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Enlazamos los objetos
        TextView descripcion2=findViewById(R.id.txt_descripcion);
        ImageView portada=findViewById(R.id.portada);
        ImageView poster=findViewById(R.id.poster);
        TextView puntuacion=findViewById(R.id.txtpuntuacion);
        TextView fecha=findViewById(R.id.txtfecha);

        //Obtenemos datos enviados
        String dataTitle=getIntent().getExtras().getString("titulo");
        String dataDescripcion=getIntent().getExtras().getString("descripcion");
        String urlImagen= getIntent().getExtras().getString("portada");
        String urlPoster=getIntent().getExtras().getString("poster");
        String dataFecha=getIntent().getExtras().getString("fecha");
        Double dataPuntuacion=getIntent().getExtras().getDouble("puntuacion");


        //colocamos la imagen en el formando donde este colocado, que cargara la variable que trae los datos del Adaptador,
        //la colocamos en el imagenView que asociamos al elemento
        Glide.
                with(this) .
                load(urlImagen).
                centerCrop() .
                into(portada);

        Glide.
                with(this) .
                load(urlPoster).
                centerCrop() .
                into(poster);

        //colocamos el nombre de la pelicula al toolBar
        toolBarLayout.setTitle(dataTitle);
        //Establecemos los valores obtenidos a los TextView
        descripcion2.setText(dataDescripcion);

        puntuacion.setText("puntuacion:" + dataPuntuacion);
        fecha.setText(String.valueOf("Fecha lanzamiento: " + dataFecha));

    }
}