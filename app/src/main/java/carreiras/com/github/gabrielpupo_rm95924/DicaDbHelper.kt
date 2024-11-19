package carreiras.com.github.gabrielpupo_rm95924

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DicaDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = """
            CREATE TABLE $TABLE_DICAS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITULO TEXT NOT NULL,
                $COLUMN_DESCRICAO TEXT NOT NULL
            )
        """
        db.execSQL(CREATE_TABLE)

        db.execSQL("INSERT INTO $TABLE_DICAS ($COLUMN_TITULO, $COLUMN_DESCRICAO) VALUES ('Desligue aparelhos que não estão em uso', 'Aparelhos eletrônicos consomem energia mesmo em modo de espera. Desconecte quando não for usar.')")
        db.execSQL("INSERT INTO $TABLE_DICAS ($COLUMN_TITULO, $COLUMN_DESCRICAO) VALUES ('Use lâmpadas LED', 'Lâmpadas LED consomem até 80% menos energia que as lâmpadas incandescentes.')")
        db.execSQL("INSERT INTO $TABLE_DICAS ($COLUMN_TITULO, $COLUMN_DESCRICAO) VALUES ('Aproveite a luz natural', 'Abra as cortinas e janelas para maximizar a luz natural e reduzir o uso de energia elétrica.')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DICAS")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "dicas.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_DICAS = "dicas"
        const val COLUMN_ID = "id"
        const val COLUMN_TITULO = "titulo"
        const val COLUMN_DESCRICAO = "descricao"
    }
}
