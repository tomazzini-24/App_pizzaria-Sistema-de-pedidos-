package br.com.segundotrab.apppizza;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import br.com.segundotrab.appPizza.R;

public class AdapterPizza extends BaseAdapter {

    private List<Pizza> pizzaList;
    private Context context;
    private LayoutInflater inflater;

    public AdapterPizza(Context context, List<Pizza> listaPizzas){
        this.pizzaList = listaPizzas;
        this.context = context;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int i) {
        return pizzaList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return pizzaList.get(i).id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ItemSuporte item;

        if( convertView == null){
            convertView = inflater.inflate(R.layout.layout_listagem, null);

            item = new ItemSuporte();
            item.tvNome = convertView.findViewById(R.id.tvListaNome);
            item.tvEndereco = convertView.findViewById(R.id.tvListaEndereco);
            item.tvSabor = convertView.findViewById(R.id.tvListaSabor);
            item.tvTelefone = convertView.findViewById(R.id.tvListaTelefone);
            item.layout = convertView.findViewById(R.id.llFundoLista);
            convertView.setTag( item );
        }else {
            item = (ItemSuporte) convertView.getTag();
        }

        Pizza pizza = pizzaList.get(i);
        item.tvNome.setText(  pizza.nome );
        item.tvEndereco.setText(  pizza.endereco );
        item.tvSabor.setText( pizza.sabor );
        item.tvTelefone.setText(  String.valueOf( pizza.getTelefone() ) );

        if( i % 2 == 0 ){
            item.layout.setBackgroundColor(Color.rgb(230, 230, 230));
        }else {
            item.layout.setBackgroundColor( Color.WHITE );
        }
        return convertView;
    }

    private class ItemSuporte{
        TextView tvNome, tvSabor, tvEndereco, tvTelefone;
        LinearLayout layout;
    }


}
