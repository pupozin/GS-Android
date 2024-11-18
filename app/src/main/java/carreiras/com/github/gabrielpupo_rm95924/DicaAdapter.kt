package carreiras.com.github.gabrielpupo_rm95924

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DicaAdapter(private val listaDicas: List<Dica>) : RecyclerView.Adapter<DicaAdapter.DicaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = listaDicas[position]
        holder.tvTitulo.text = dica.titulo
        holder.tvDescricao.text = dica.descricao

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Mais detalhes: ${dica.descricao}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaDicas.size

    class DicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)
    }
}