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
    private lateinit var dicaDAO: DicaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dicaDAO = DicaDAO(this)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        val listaDicas = dicaDAO.getAllDicas()
        dicaAdapter = DicaAdapter(listaDicas)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dicaAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = dicaDAO.getAllDicas().filter {
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