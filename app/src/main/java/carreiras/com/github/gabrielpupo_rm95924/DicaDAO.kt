package carreiras.com.github.gabrielpupo_rm95924

import android.content.Context

class DicaDAO(context: Context) {
    private val dbHelper = DicaDbHelper(context)

    fun getAllDicas(): List<Dica> {
        val listaDicas = mutableListOf<Dica>()
        val db = dbHelper.readableDatabase

        val query = "SELECT * FROM ${DicaDbHelper.TABLE_DICAS}"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DicaDbHelper.COLUMN_ID))
                val titulo = cursor.getString(cursor.getColumnIndexOrThrow(DicaDbHelper.COLUMN_TITULO))
                val descricao = cursor.getString(cursor.getColumnIndexOrThrow(DicaDbHelper.COLUMN_DESCRICAO))
                listaDicas.add(Dica(id, titulo, descricao))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaDicas
    }
}
