package ar.edu.ites.demorecyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ites.demorecyclerview.models.Producto;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Producto> _dataset;

    public Adapter(List<Producto> dataset) {
        _dataset = dataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView txtId, txtNombre, txtMarca, txtPrecio;
        private final ImageView imgFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtId = itemView.findViewById(R.id.txtId);
            this.txtNombre = itemView.findViewById(R.id.txtNombre);
            this.txtMarca = itemView.findViewById(R.id.txtMarca);
            this.txtPrecio = itemView.findViewById(R.id.txtPrecio);
            this.imgFoto = itemView.findViewById(R.id.imgFoto);

            // definir click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clic en ITEM " + txtId.getText() + " - " + txtNombre.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public TextView getTxtId() {
            return txtId;
        }

        public TextView getTxtNombre() {
            return txtNombre;
        }

        public TextView getTxtPrecio() {
            return txtPrecio;
        }

        public TextView getTxtMarca() {
            return txtMarca;
        }

        public ImageView getImgFoto() {
            return imgFoto;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTxtId().setText(String.valueOf(_dataset.get(position).getId()));
        holder.getTxtNombre().setText(_dataset.get(position).getNombre());
        holder.getTxtMarca().setText(_dataset.get(position).getMarca());
        holder.getTxtPrecio().setText("$"+String.valueOf(_dataset.get(position).getPrecio()));

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.getImgFoto());
    }

    @Override
    public int getItemCount() {
        return _dataset.size();
    }
}
