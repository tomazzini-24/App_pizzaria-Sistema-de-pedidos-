package br.com.segundotrab.apppizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 4;
    private static final String NOME = "DiskPizza";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

   @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS pizza ( " +
                "     id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                "     nome TEXT NOT NULL ," +
                "     telefone INTEGER," +
                "     endereco TEXT NOT NULL," +
                "     sabor INTEGER NOT NULL  ) "  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        if( i == 2 && i1 == 3){
//            db.execSQL("ALTER TABLE filme ADD COLUMN diretor TEXT ");
//        }
//
//        if( i == 1 && i1 == 3){
//            db.execSQL("ALTER TABLE filme ADD COLUMN diretor TEXT ");
//            db.execSQL("ALTER TABLE filme ADD COLUMN premios TEXT ");
//        }
    }
}
