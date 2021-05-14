package br.com.segundotrab.apppizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public static void inserir(Pizza pizza, Context context){
        ContentValues valores = new ContentValues();
       valores.put("nome", pizza.nome );
        valores.put("endereco", pizza.endereco );
        valores.put("sabor", pizza.sabor );
        valores.put("telefone", pizza.getTelefone() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("pizza", null, valores);
    }

    public static void editar(Pizza pizza, Context context){
        ContentValues valores = new ContentValues();
        valores.put("nome", pizza.nome );
        valores.put("endereco", pizza.endereco);
        valores.put("sabor", pizza.sabor );
        valores.put("telefone", pizza.getTelefone() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("pizza", valores, " id = " + pizza.id , null );
    }

    public static void excluir(int id, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("pizza", " id = " + id , null);
    }

    public static List<Pizza> getPizzas(Context context){
        List<Pizza> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nome, endereco, telefone, sabor FROM pizza ORDER BY nome", null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Pizza pizza = new Pizza();
                pizza.id = cursor.getInt( 0);
                pizza.nome = cursor.getString(1);
                pizza.endereco = cursor.getString(2);
                pizza.setTelefone( cursor.getInt(3) );
                pizza.sabor = cursor.getString(4);

                lista.add( pizza);
            }while( cursor.moveToNext() );
        }
        return lista;
    }

    public static Pizza getPizzaById(Context context, int id){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nome, endereco, telefone, sabor FROM pizza WHERE id = " + id, null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            Pizza pizza = new Pizza();
            pizza.id = cursor.getInt( 0);
            pizza.nome = cursor.getString(1);
            pizza.endereco = cursor.getString(2);
            pizza.setTelefone( cursor.getInt(3) );
            pizza.sabor = cursor.getString(4);
            return pizza;
        }else{
            return null;
        }
    }



}
