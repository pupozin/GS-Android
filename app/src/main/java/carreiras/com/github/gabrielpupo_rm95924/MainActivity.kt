package carreiras.com.github.gabrielpupo_rm95924

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dicaAdapter: DicaAdapter
    private lateinit var searchView: SearchView
    private val listaDicas = mutableListOf(
        Dica("Desligue aparelhos que não estão em uso", "Aparelhos eletrônicos consomem energia mesmo em modo de espera. Desconecte quando não for usar."),
        Dica("Use lâmpadas LED", "Lâmpadas LED consomem até 80% menos energia que as lâmpadas incandescentes."),
        Dica("Aproveite a luz natural", "Abra as cortinas e janelas para maximizar a luz natural e reduzir o uso de energia elétrica."),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        dicaAdapter = DicaAdapter(listaDicas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dicaAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = listaDicas.filter {
                    it.titulo.contains(newText ?: "", ignoreCase = true) ||
                            it.descricao.contains(newText ?: "", ignoreCase = true)
                }
                dicaAdapter = DicaAdapter(filteredList)
                recyclerView.adapter = dicaAdapter
                return true
            }
        })
    }
}