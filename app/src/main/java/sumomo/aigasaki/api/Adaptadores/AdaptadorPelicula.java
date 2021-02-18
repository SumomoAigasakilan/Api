package sumomo.aigasaki.api.Adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import sumomo.aigasaki.api.R;
import sumomo.aigasaki.api.modelo.Pelicula;

public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.ViewHolder> {

    //Propiedad
    private ArrayList<Pelicula> peliculas;


    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }



    public AdaptadorPelicula(ArrayList<Pelicula> peliculas){
    this.peliculas=peliculas;
    }

    //equivalente al MainActivity
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView portada;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.txtTitulo);
            portada= itemView.findViewById(R.id.ivImagen);

            //titulo.setText();

        }
    }

    @NonNull
    @Override
    //
    public AdaptadorPelicula.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creamos una lista la que tendra el dise;o de cada item
        //pasamos esa lista como argumento a la clase view holder
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula,parent,false);

        //retorna instancia de la clase personalizada
        return new ViewHolder(vista);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPelicula.ViewHolder holder, int position) {
        //Establecemos las acciones que se realizara y tambien se establecen los valores a los objetos
       Pelicula pelicula= peliculas.get(position);

        Log.i("URL",pelicula.getBackdrop_path());


        Glide
                .with(holder.itemView)
                .load(pelicula.getBackdrop_path())
                .centerCrop()
                .into(holder.portada);
        holder.titulo.setText(pelicula.getOriginal_title());
    }


}
