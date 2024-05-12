package adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafio3_firebase.R;
import com.example.desafio3_firebase.RecursoActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import model.Recurso;

public class RecursoAdapter extends FirebaseRecyclerAdapter<Recurso,RecursoAdapter.Viewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecursoAdapter(@NonNull FirebaseRecyclerOptions<Recurso> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Viewholder holder, int i, @NonNull Recurso recurso) {
        holder.titulo.setText("");
        holder.id.setText("");
        holder.tipo.setText("");

        holder.titulo.setText(recurso.getTitulo());
        holder.id.setText("ID: " + recurso.getId());
        holder.tipo.setText("Tipo de recurso: " + recurso.getTipo());
        Picasso.get().load(recurso.getImagen()).into(holder.imagenRecurso);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el contexto
                Context context = holder.itemView.getContext();
                // Obtener el ID del recurso
                String resourceId = String.valueOf(recurso.getId());
                String titulo = recurso.getTitulo();
                String urlImagen = recurso.getImagen();
                String descripcion = recurso.getDescripcion();
                String enlace = recurso.getEnlace();
                String tipo = recurso.getTipo();
                // Crear un Intent para iniciar la actividad RecursoActivity
                Intent intent = new Intent(context, RecursoActivity.class);
                // Agregar el ID del recurso como un extra en el Intent
                intent.putExtra("idRecurso", resourceId);
                intent.putExtra("titulo",titulo);
                intent.putExtra("urlImagen",urlImagen);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("enlace",enlace);
                intent.putExtra("tipo",tipo);
                // Iniciar la actividad RecursoActivity
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_single_recurso,parent,false);

        return new Viewholder(v);
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView id,titulo,tipo;
        ImageView imagenRecurso;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.lblTItuloSingleRecurso);
            id=itemView.findViewById(R.id.lblIdSingleRecurso);
            tipo=itemView.findViewById(R.id.lblTipoSingleRecurso);
            imagenRecurso= itemView.findViewById(R.id.imagenRecursos);
        }
    }
}

